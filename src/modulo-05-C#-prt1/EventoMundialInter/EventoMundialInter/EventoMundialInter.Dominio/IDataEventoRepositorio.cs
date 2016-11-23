using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventoMundialInter.Dominio
{
    public interface IDataEventoRepositorio
    {
        int GetQuantidadePorId(int id);

        List<DataEvento> ListarDataEventos();
    }
}
