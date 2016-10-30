using ConsoleApplication1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class SkyFusion : Kart, IEquipamentos
    {
        public SkyFusion(Corredor corredor): base(corredor)
        {

        }
        public int Bonus {
            get
            {
                int totalBonus = Equipamentos.Count*2 + CorredorKart.GetBonusHabilidade()*2;
                BonusTipoKart = totalBonus;

                totalBonus = (Velocidade > 12) ? (int)this.Velocidade + 5 : totalBonus;
                return totalBonus;
            }
        }

    }
}
