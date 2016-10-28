using MarioKart;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Light : Kart
    {
        public Light() : base(new Corredor("", Habilidade.Noob))
        {
            if (CorredorKart.NivelHabilidade == Habilidade.Noob)
                Velocidade += 3;
            else if (CorredorKart.NivelHabilidade == Habilidade.Profissional)
                Velocidade -= 1;
        }
    }
}
