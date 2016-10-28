using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Dinam : Kart
    {
        public Dinam() : base(new Corredor("", Habilidade.Noob))
        {
             int bonusCorredor = CorredorKart.GetBonusHabilidade();
             Velocidade = (Velocidade - bonusCorredor) + bonusCorredor*2;
        }
    }
}
