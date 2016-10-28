using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class FogueteDePlutonio : IEquipamentos
    {
        public FogueteDePlutonio()
        {
            this.Nivel = 2;
        }
        public FogueteDePlutonio(int nivel)
        {
            bool ehValido = nivel == 1 || nivel == 2 || nivel == 3 || nivel == 4 || nivel == 5;

            if (ehValido)
                this.Nivel = nivel;
            else
                this.Nivel = 2;
        }
        public int Nivel { get; set; }

        public int Bonus
        {
            get
            {
                return Nivel*2;
            }
        }
    }
}
