using StreetFighter.dominio;
using StreetFighter.Dominio;
using System;
using System.Activities.Statements;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        const string CaminhoArquivo = @"C:\Users\Arthur\Documents\Projeto Crescer\GitHub\crescer-2016-2\src\modulo-05-C#-prt1\listaPersonagens.csv";
        public List<Personagem> ListaPersonagens { get; private set; }

        public PersonagemRepositorio()
        {
            this.ListaPersonagens = new List<Personagem>();
            this.ListaPersonagens = ListarPersonagens(null);
        }

        public Personagem GetPersonagemById(int id)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["StreetFighter"]
                                    .ConnectionString;

            Personagem result = new Personagem();

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Id =" + id;

                var command = new SqlCommand(sql, connection);
                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    Personagem personagem = ConverterReaderToPersonagem(reader);
                    result = personagem;
                }

                connection.Close();
            }

            return result;
        }
        public List<Personagem> GetPersonagemByNome(string nome)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["StreetFighter"]
                                    .ConnectionString;

            List<Personagem> result = new List<Personagem>();

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "";

                if (nome == null)
                    sql = "SELECT * FROM Personagem";
                else
                    sql = $"SELECT * FROM Personagem WHERE Nome LIKE '%" + nome + "%'";

                var command = new SqlCommand(sql, connection);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Personagem personagem = ConverterReaderToPersonagem(reader);
                    result.Add(personagem);
                }

                connection.Close();
            }

            return result;
        }

        private Personagem ConverterReaderToPersonagem(SqlDataReader reader)
        {
            int idRow = Convert.ToInt32(reader["Id"]);
            string nomeRow = reader["Nome"].ToString();
            DateTime dataNascimentoRow = Convert.ToDateTime(reader["DataNascimento"]);
            int alturaRow = Convert.ToInt32(reader["Altura"]);
            decimal pesoRow = Convert.ToDecimal(reader["Peso"]);
            string origenRow = reader["Origen"].ToString();
            string golpesEspeciaisRow = reader["GolpesEspeciais"].ToString();
            bool personagemOcultoRow = Convert.ToBoolean(reader["PersonagemOculto"]);
            string imagemRow = reader["Imagem"].ToString();

            var personagem = new Personagem(
                    id: idRow,
                    nome: nomeRow,
                    dataNascimento: dataNascimentoRow,
                    altura: alturaRow,
                    peso: pesoRow,
                    origem: origenRow,
                    golpesEspeciais: golpesEspeciaisRow,
                    personagemOculto: personagemOcultoRow,
                    imagem: imagemRow
                );
            return personagem;
        }



        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            return GetPersonagemByNome(filtroNome);
            
        }
        public void IncluirPersonagem(Personagem personagem)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["StreetFighter"]
                                    .ConnectionString;

            Personagem result = new Personagem();

            if (RegraDeNegocio(personagem))
            {
                using (var transaction = new System.Transactions.TransactionScope(TransactionScopeOption.Required))
                using (var connection = new SqlConnection(connectionString))
                {
                    try
                    {

                        connection.Open();
                        string sql = "";
                        var parameters = new List<SqlParameter>();

                        if (personagem.Id > 0)
                        {
                            sql = $"UPDATE Personagem SET Nome=@param_nome, DataNascimento=@param_data, Altura=@param_altura, Peso=@param_peso, Origen=@param_origem, GolpesEspeciais=@param_golpes, PesonagemOculto=@param_personagemOculto, Imagem=@param_imagem  WHERE Id = @param_id";
                            parameters.Add(new SqlParameter("param_id", personagem.Id));
                            parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                            parameters.Add(new SqlParameter("param_data", personagem.DataNascimento));
                            parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                            parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                            parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                            parameters.Add(new SqlParameter("param_golpes", personagem.GolpesEspeciais));
                            parameters.Add(new SqlParameter("param_personagemOculto", personagem.PersonagemOculto));
                            parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                            // Aplicar o resto dos parâmetros 
                        }
                        else
                        {
                            sql = $"INSERT INTO Personagem(Nome, DataNascimento, Altura, Peso, Origen, GolpesEspeciais, PersonagemOculto, Imagem) VALUES(@param_nome, @param_data, @param_altura, @param_peso, @param_origem, @param_golpes, @param_personagemOculto, @param_imagem); ";

                            parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                            parameters.Add(new SqlParameter("param_data", personagem.DataNascimento));
                            parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                            parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                            parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                            parameters.Add(new SqlParameter("param_golpes", personagem.GolpesEspeciais));
                            parameters.Add(new SqlParameter("param_personagemOculto", personagem.PersonagemOculto));
                            parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                        }
                        var command = new SqlCommand(sql, connection);
                        foreach (SqlParameter param in parameters)
                        {
                            command.Parameters.Add(param);
                        }
                        command.ExecuteNonQuery();
                        transaction.Complete();
                    }
                    catch
                    {
                        Console.Write("Deu ruim. Erro ao cadastrar!"); // Melhorar isso
                    }
                    finally
                    {
                        connection.Close();
                    }
                }
            }
        }

        public void EditarPersonagem(Personagem personagem)
        {

            var propriedades = GerarPersonagemEmString(personagem);

            for (int i = 0; i < ListaPersonagens.Count; i++)
            {
                if (ListaPersonagens[i].Nome.Equals(personagem.Nome))
                {
                    ExcluiDaListaDePersonagem(ListaPersonagens[i]);
                    ListaPersonagens.Insert(i, personagem);
                    IncluirPersonagem(personagem);
                }
            }

        }
        
        public void ExcluirPersonagem(Personagem personagem)
        {
            List<string> listaString = new List<string>();

            ExcluiDaListaDePersonagem(personagem);

            foreach (Personagem personagemDaVez in ListaPersonagens)
            {
                listaString.Add(GerarPersonagemEmString(personagemDaVez));
            }
            File.WriteAllLines(CaminhoArquivo, listaString);
        }

        public Personagem BuscarPersonagemPorNome(string nome)
        {
            List<Personagem> listaDePersonagens = ListarPersonagens(null);
            foreach (Personagem personagem in listaDePersonagens)
            {
                if (personagem.Nome.Equals(nome))
                {
                    return personagem;
                }
            }
            return null;
        }

        public void ExcluiDaListaDePersonagem(Personagem personagem)
        {
            for (int i = 0; i < ListaPersonagens.Count; i++)
            {
                if (personagem.Nome.Equals(ListaPersonagens[i].Nome)) ListaPersonagens.RemoveAt(i);
            }
        }
        public string GerarPersonagemEmString(Personagem personagem)
        {
            return $"{personagem.Id};{personagem.Nome};{personagem.DataNascimento.ToString("yyyy/MM/dd")};{personagem.Altura};{personagem.Peso}; {personagem.Origem};{ personagem.GolpesEspeciais};{ personagem.Imagem};{personagem.PersonagemOculto};";
        }
        public bool RegraDeNegocio(Personagem personagem)
        {
            if (personagem.Nome.ToUpper().Equals("NUNES") || personagem.Origem.Equals("MP"))
                return false;
            return true;
        }
    }
}