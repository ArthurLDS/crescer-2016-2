using EventoMundialInter.Dominio;
using EventoMundialInter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventoMundialInter.Aplicativo
{
    public class UsuarioAplicativo
    {
        UsuarioRepositorio UserRepositorio;

        public UsuarioAplicativo()
        {
             UserRepositorio= new UsuarioRepositorio();
        }

        public List<Usuario> ListarUsuarios()
        {
            return this.UserRepositorio.ListarUsuarios();
        }

        public List<Usuario> ListarUsuariosPorData(DataEvento data)
        {   

            for(int i=0; i< ListarUsuariosPorData(data).Count; i++)
            {

            }
            return UserRepositorio.ListarUsuariosPorData(data);
        }

        public void Cadastar(Usuario usuario)
        {
            UserRepositorio.Cadastar(usuario);
        }
        public void EnviarEmail(string email, string nome)
        {
            UserRepositorio.EnviarEmail(email, nome);
        }
        

    }
}
