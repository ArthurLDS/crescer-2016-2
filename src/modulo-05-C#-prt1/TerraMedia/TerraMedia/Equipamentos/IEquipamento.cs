using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TerraMedia.Equipamentos
{
    public interface IEquipamento
    {
        int BonusDeAtaque { get; }
        int BonusDeDefesa { get; }
    }
}
