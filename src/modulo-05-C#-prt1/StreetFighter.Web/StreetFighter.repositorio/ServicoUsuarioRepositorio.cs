using StreetFighter.dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.repositorio
{
    public class ServicoUsuarioRepositorio
    {
        Usuario[] ListaUsuarios;
        //private const string LOCAL_ARQUIVO = @"C:\Users\Arthur.Souza\Documents\Git\crescer-2016-2\crescer-2016-2\src\modulo-05-C#-prt1\usuario.csv";

        public ServicoUsuarioRepositorio()
        {
            ListaUsuarios = new Usuario[10];
        }


        /* public Usuario[] GetUsuarios()
         {

             string connectionString =
                 ConfigurationManager.ConnectionStrings["StreetFighter"]
                                     .ConnectionString;

             Usuario[] result = new Usuario[10];

             using (var connection = new SqlConnection(connectionString))
             {
                 connection.Open();

                 string sql = "SELECT * FROM Usuario";
                 var command = new SqlCommand(sql, connection);

                 SqlDataReader reader = command.ExecuteReader();

                 int i =  0;
                 while (reader.Read())
                 {
                     Usuario found = ConvertReaderToUsuario(reader);
                     result[i] = found;
                     i++;
                 }
                 connection.Close();
             }
             return result;

    }*/

    public Usuario ConvertReaderToUsuario(SqlDataReader reader)
        {
            int idRow = Convert.ToInt32(reader["Id"]);
            string usernameRow = reader["Username"].ToString();
            string passwordRow = reader["Senha"].ToString();
            string permissoesRow = reader["Permissoes"].ToString();

            var usuario = new Usuario(
                 id: idRow,
                 nome: usernameRow,
                 senha: passwordRow,
                 permissoes: new string[] { permissoesRow }
            );

            return usuario;
        }
















        /* public Usuario[] GetUsuarios()
         {
             Usuario[] ListaRetorno = new Usuario[10];
             var linhas = File.ReadLines(LOCAL_ARQUIVO);

             int i = 0;
             foreach (var linha in linhas)
             {  
                 var propriedades = linha.Split(';');

                 Usuario usuario = new Usuario(
                         propriedades[0],
                         propriedades[1],
                         new string[] {propriedades[2]}
                      );
                 ListaRetorno[i] = usuario;
                 i++;
             }
             return ListaRetorno;
         }*/
    }
}
