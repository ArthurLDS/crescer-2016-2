using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class UltraPack : IEquipamentos
    {
        public UltraPack(IEquipamentos equipamento)
        {
            this.Equipamento = equipamento;
        }
        private IEquipamentos Equipamento { get; set; }

        public int Bonus
        {
            get
            {
                int vintePorcentoBonus = 
                    Convert.ToInt32(Math.Ceiling(Convert.ToDecimal(Equipamento.Bonus * 20 / 100)));
                return Equipamento.Bonus + vintePorcentoBonus;
            }
        }
    }
}
