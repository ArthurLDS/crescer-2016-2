using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class PersonagemRepositorioEF : IPersonagemRepositorio
    {
        public List<Personagem> ListarPersonagens(string nome)
        {
            return BuscarByName(nome);
        }
        public void IncluirPersonagem(Personagem personagem)
        {
            Salvar(personagem);
        }
        public void EditarPersonagem(Personagem personagem) { }
        public void ExcluirPersonagem(Personagem personagem) { }
        public bool RegraDeNegocio(Personagem persongem) { return false; }


        public void Salvar(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                if (personagem.Id > 0)
                    context.Entry<Personagem>(personagem).State = EntityState.Modified;
                else
                    context.Entry<Personagem>(personagem).State = EntityState.Added;

                context.SaveChanges();
            }
        }

        public Personagem BuscarById(int id)
        {
            using (var context = new DatabaseContext())
            {
                return context.Personagem.Find(id);
            }
        }
        public List<Personagem> BuscarByName(string nome)
        {
            using (var context = new DatabaseContext())
            {
                return context.Personagem.Where(u => u.Nome.Contains(nome)).ToList();
            }
        }


    }
}
