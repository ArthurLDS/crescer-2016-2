using StreetFighter.dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.repositorio
{
    public class ServicoUsuarioRepositorio
    {
        Usuario[] ListaUsuarios;
        private const string LOCAL_ARQUIVO = @"C:\Users\Arthur\Documents\Projeto Crescer\GitHub\crescer-2016-2\src\modulo-05-C#-prt1\usuario.csv";

        public ServicoUsuarioRepositorio()
        {
            ListaUsuarios = new Usuario[10];
        }

        public Usuario[] GetUsuarios()
        {
            Usuario[] ListaRetorno = new Usuario[10];
            var linhas = File.ReadLines(LOCAL_ARQUIVO);

            int i = 0;
            foreach (var linha in linhas)
            {  
                var propriedades = linha.Split(';');

                Usuario usuario = new Usuario(
                        propriedades[0],
                        propriedades[1],
                        new string[] {propriedades[2]}
                     );
                ListaRetorno[i] = usuario;
                i++;
            }
            return ListaRetorno;
        }
    }
}
