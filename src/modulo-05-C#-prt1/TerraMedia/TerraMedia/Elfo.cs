using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Personagens
{
    public class Elfo : Personagem
    {
        public Elfo() : base(10)
        {
            this.Ataque = 2;
            this.Defesa = 1;
        }
    }
}
