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
                double bonusEquipamento = this.Equipamento.Bonus;
                return Convert.ToInt32(Math.Ceiling(bonusEquipamento * 1.20));
            }
        }
    }
}
