using ConsoleApplication1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    class Program
    {
        static void Main(string[] args)
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Profissional);
            var kart = new Kart(corredor);
            //var motor = new MotorABaseDeLava();
            var pneus = new PneusDeCouroDeDragao();

            //kart.Equipar(motor);
            kart.Equipar(pneus);

            Console.WriteLine(kart.Velocidade);
            Console.ReadLine();
        }
    }
}
