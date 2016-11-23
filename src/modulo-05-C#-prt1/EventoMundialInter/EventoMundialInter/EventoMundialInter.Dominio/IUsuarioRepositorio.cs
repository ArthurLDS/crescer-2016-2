using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventoMundialInter.Dominio
{
    public interface IUsuarioRepositorio
    {
        List<Usuario> ListarUsuarios();

        List<Usuario> ListarUsuariosPorData(DataEvento data);

        void Cadastar(Usuario usuario);
    }
}
