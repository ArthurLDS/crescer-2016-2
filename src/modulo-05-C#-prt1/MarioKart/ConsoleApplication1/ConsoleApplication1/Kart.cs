using ConsoleApplication1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class Kart
    {
        public Kart(Corredor corredor)
        {
            this.CorredorKart = corredor;
            this.Equipamentos = new List<IEquipamentos>();

        }
        private List<IEquipamentos> Equipamentos { get; set; }
        private Corredor CorredorKart { get; set; }

        public float Velocidade
        {
            get
            {
                int somaBonus = 0;
                foreach (IEquipamentos equipamento in this.Equipamentos) {
                    somaBonus += equipamento.Bonus;
                }
                return somaBonus += CorredorKart.GetBonusHabilidade() + Equipamentos.Count + 3;
            }
        }
        public void Equipar(IEquipamentos equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

    }
}