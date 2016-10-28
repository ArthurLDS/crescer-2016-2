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
                return Equipamento.Bonus + vintePorcentoBonus(Equipamento.Bonus);
            }
        }
        public int vintePorcentoBonus(int numero){
            var retorno = Convert.ToInt32(Math.Ceiling(Convert.ToDecimal(numero * 20 / 100)));
            return retorno; // Essa redundância é para facilitar o monitoramento do Debug. 
        }
    }
}
