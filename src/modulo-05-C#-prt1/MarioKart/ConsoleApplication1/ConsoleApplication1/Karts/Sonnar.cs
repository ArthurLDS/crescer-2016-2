using ConsoleApplication1;
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
            
        }
        override
        public void Equipar(IEquipamentos equipamento)
        {
            this.Equipamentos.Add(equipamento);
            BonusTipoKart = Equipamentos.Count >= 1 ? 2 : 0; // Atualizando Velocidade após Equipar.
        }
    }
}
