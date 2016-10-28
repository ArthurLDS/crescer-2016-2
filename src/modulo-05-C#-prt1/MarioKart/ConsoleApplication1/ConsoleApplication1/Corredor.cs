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
        public string Nome { get; }
        public Habilidade NivelHabilidade { get; set; }
        public int GetBonusHabilidade()
        {
            if (NivelHabilidade == Habilidade.Noob)
                return 3;
            else if (NivelHabilidade == Habilidade.Mediano)
                return 5;
           return 6;
        }
    }
}