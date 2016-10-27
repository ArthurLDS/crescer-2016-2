using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TerraMedia.Equipamentos
{
    public class Espada : IEquipamento
    {
        public int BonusDeAtaque
        {
            get
            {
                return 3;
            }
        }

        public int BonusDeDefesa
        {
            get
            {
                return 0;
            }
        }
        
    }
}
