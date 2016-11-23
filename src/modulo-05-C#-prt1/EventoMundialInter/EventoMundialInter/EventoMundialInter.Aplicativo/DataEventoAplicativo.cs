using EventoMundialInter.Dominio;
using EventoMundialInter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventoMundialInter.Aplicativo
{
    public class DataEventoAplicativo
    {
        DataEventoRepositorio DataDoEventoRepositorio;

        public DataEventoAplicativo()
        {
            this.DataDoEventoRepositorio = new DataEventoRepositorio();
        }

        public int GetQuantidadePorId(int id)
        {
            return this.DataDoEventoRepositorio.GetQuantidadePorId(id);
        }

        public List<DataEvento> ListarDataEventos()
        {
            return this.DataDoEventoRepositorio.ListarDataEventos();
        }
        public DataEvento GetDataEventoPorId(int id)
        {
            return DataDoEventoRepositorio.GetDataEventoPorId(id);
        }
    }
}
