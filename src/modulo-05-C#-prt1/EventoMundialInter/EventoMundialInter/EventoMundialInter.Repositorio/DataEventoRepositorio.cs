using EventoMundialInter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace EventoMundialInter.Repositorio
{
    public class DataEventoRepositorio : IDataEventoRepositorio
    {
        public int GetQuantidadePorId(int id)
        {
            using (var contexto = new ContextoDeDados())
            {
                return Convert.ToInt16(contexto.DataEvento.FirstOrDefault(u => u.Id.Equals(id)).Quantidade);
            }
        }

        public DataEvento GetDataEventoPorId(int id)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.DataEvento.FirstOrDefault(u => u.Id.Equals(id));
            }
        }

        public List<DataEvento> ListarDataEventos()
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.DataEvento.ToList();
            }
        }

        public void DecrementarQuantidade(int id)
        {
            using (var contexto = new ContextoDeDados())
            {
                var registro = contexto.DataEvento.FirstOrDefault(u => u.Id.Equals(id));

                if(registro != null)
                {
                    registro.Quantidade--;

                    contexto.SaveChanges();
                }
            }
        }

    }
}
