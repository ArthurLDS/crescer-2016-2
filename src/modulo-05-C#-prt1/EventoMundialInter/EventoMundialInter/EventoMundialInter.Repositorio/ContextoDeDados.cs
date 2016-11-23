using EventoMundialInter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventoMundialInter.Repositorio
{
    public class ContextoDeDados : DbContext
    {
        public ContextoDeDados() : base("EventoInter")
        {

        }
        public DbSet<Usuario> Usuario { get; set; }

        public DbSet<DataEvento> DataEvento { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
