using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Corredor
    {
        public Corredor(string nome, Habilidade habilidade)
        {
            this.Nome = nome;
            this.NivelHabilidade = habilidade;
        }
        protected string Nome { get; }  
        protected Habilidade NivelHabilidade { get; }
    }
}
