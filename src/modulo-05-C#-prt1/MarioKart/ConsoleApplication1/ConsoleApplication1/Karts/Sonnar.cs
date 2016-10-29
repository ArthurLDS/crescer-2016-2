using MarioKart;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor)
        {
            Velocidade = Equipamentos.Count >= 1 ? Velocidade + 2 : Velocidade;
        }
    }
}
