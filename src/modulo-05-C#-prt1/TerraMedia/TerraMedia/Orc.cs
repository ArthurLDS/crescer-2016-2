using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Personagens
{
    public class Orc : Personagem
    {
        public Orc() : base(32)
        {
            this.Ataque = 7;
            this.Defesa = 0;
        }

        public override int Ataque
        {
            get
            {
                return base.Ataque + 2;
            }

            protected set
            {
                base.Ataque = value;
            }
        }
    }
}
