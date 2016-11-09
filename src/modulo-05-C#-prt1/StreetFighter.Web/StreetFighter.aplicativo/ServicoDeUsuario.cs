using StreetFighter.dominio;
using StreetFighter.Infra;
using StreetFighter.repositorio;
using StreetFighter.RepositorioEF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.aplicativo
{
    public class ServicoDeUsuario
    {
        public ServicoUsuarioRepositorio UsuarioRepositorio = new ServicoUsuarioRepositorio();




        public static Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            Usuario[] _usuarios = new UsuarioRepositorioEF().BuscarPorNome("").ToArray();

            Usuario usuarioEncontrado = _usuarios.FirstOrDefault(
                usuario => usuario.Nome.Equals(nome));

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }

            return null;
        }
    }
}
