using StreetFighter.dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class UsuarioRepositorioEF
    {
        public Usuario BuscarById(int id)
        {
            using (var context = new DatabaseContext())
            {
                return context.User.Find(id);
            }
        }
        public List<Usuario> BuscarPorNome(string filtro)
        {
            using (var context = new DatabaseContext())
            {
                return context.User.Where(u => u.Nome.Contains(filtro)).ToList();
            }
        }
    }
}
