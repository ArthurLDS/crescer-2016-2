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
        protected List<IEquipamentos> Equipamentos { get; set; }
        protected Corredor CorredorKart { get; set; }

        protected int BonusTipoKart { get; set; } = 0;

        public float Velocidade
        {
            get
            {
                int somaBonus = 0;
                foreach (IEquipamentos equipamento in this.Equipamentos) {
                    somaBonus += equipamento.Bonus;
                }
                return somaBonus = CorredorKart.NivelHabilidade == Habilidade.Profissional ?
                somaBonus + CorredorKart.GetBonusHabilidade() + Equipamentos.Count + 3 + BonusTipoKart
                : somaBonus + CorredorKart.GetBonusHabilidade() + 3 + BonusTipoKart;
            }
            private set
            {
                this.Velocidade = value;
            }
        }
        public virtual void Equipar(IEquipamentos equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }
        /*public void AcrecentarVelocidade(int bonus)
        {
            BonusTipoKart = bonus;
        }*/
    }
}