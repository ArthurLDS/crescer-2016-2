using StreetFighter.dominio;
using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEF
{
    public class DatabaseContext : DbContext
    {   
        public DbSet<Usuario> User { get; set; }
        public DbSet<Personagem> Personagem { get; set; }
    }
}
