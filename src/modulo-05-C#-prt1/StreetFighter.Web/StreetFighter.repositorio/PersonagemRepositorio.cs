using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        const string CaminhoArquivo = @"C:\Users\Arthur\Documents\Projeto Crescer\GitHub\crescer-2016-2\src\modulo-05-C#-prt1\listaPersonagens.csv";
        public List<Personagem> ListaPersonagens { get; private set; }

        public PersonagemRepositorio()
        {
            this.ListaPersonagens = new List<Personagem>();

        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            List<Personagem> Lista = new List<Personagem>();
            var linhas = File.ReadLines(CaminhoArquivo);

            foreach (var linha in linhas) {
                var propriedade = linha.Split(';');
                
                        
                Personagem personagem  = new Personagem(
                   Convert.ToInt32("0"),
                   propriedade[1],
                   DateTime.Parse(propriedade[2].ToString()),
                   Convert.ToInt32(propriedade[3]),
                   Convert.ToDecimal(propriedade[4]),
                   propriedade[5],
                   propriedade[6],
                   propriedade[7],
                   Convert.ToBoolean(false)
                   
                   );

                if (filtroNome == null || personagem.Nome.Contains(filtroNome)) Lista.Add(personagem);
            }
            return Lista;
        }


        public void IncluirPersonagem(Personagem personagem)
        {
            this.ListaPersonagens.Add(personagem);

            string linhaResultado =
            $"0;{personagem.Nome};{personagem.DataNascimento.ToString("yyyy/MM/dd")};{personagem.Altura};{personagem.Peso}; {personagem.Origem};{ personagem.GolpesEspeciais};{ personagem.Imagem};{personagem.PersonagemOculto};";

            File.AppendAllText(CaminhoArquivo, Environment.NewLine + linhaResultado);



            // REFATORAR SUSHI DE STRING
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }
    }
}