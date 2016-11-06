using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
           this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }
        public bool RegraDeNegocio(Personagem personagem)
        {
            return this.repositorio.RegraDeNegocio(personagem);
        }

        public List<Personagem> ListarPersonagens(string filtro) {

            return repositorio.ListarPersonagens(filtro);
        }

        public void Salvar(Personagem personagem)
        {
            if (repositorio.RegraDeNegocio(personagem) && personagem.Id == 0) {
                repositorio.IncluirPersonagem(personagem);
            }
            //else
            //    repositorio.EditarPersonagem(personagem);
        }
        public Personagem BuscarPersonagemPorNome(string nome)
        {
            var repositorio = new PersonagemRepositorio();
            return repositorio.BuscarPersonagemPorNome(nome);
        }
        public void ExcluirPersonagem(Personagem personagem)
        {
            this.repositorio.ExcluirPersonagem(personagem);
        }
    }
}
