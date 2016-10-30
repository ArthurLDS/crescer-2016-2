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
        public Light(Corredor corredor) : base(corredor)
        {
            if (CorredorKart.NivelHabilidade == Habilidade.Noob)
                BonusTipoKart = 3;
            if (CorredorKart.NivelHabilidade == Habilidade.Profissional)
                BonusTipoKart = -1;
            
        }
    }
}
