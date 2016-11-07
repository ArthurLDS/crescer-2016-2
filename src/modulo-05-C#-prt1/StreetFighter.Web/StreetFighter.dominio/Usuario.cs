using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.dominio
{
    public class Usuario
    {
        public string Nome { get; set; }
        public string Senha { get; set; }

        public string[] Permissoes { get; set; }

        public Usuario(){}

        public Usuario(string nome, string senha, string[] permissoes)
        {
            this.Nome = nome;
            this.Senha = senha;
            this.Permissoes = permissoes;
        }
    }
}
