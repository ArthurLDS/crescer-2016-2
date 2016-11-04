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

        public PersonagemRepositorio(List<Personagem> personagens)
        {
            this.ListaPersonagens = new List<Personagem>();

        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            this.ListaPersonagens.Add(personagem);
            File.AppendAllText(CaminhoArquivo, Environment.NewLine + personagem.ToString() + ";");

            throw new NotImplementedException();
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