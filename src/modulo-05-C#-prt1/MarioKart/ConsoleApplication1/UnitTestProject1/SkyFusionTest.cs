using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using ConsoleApplication1;

namespace UnitTestProject1
{
    [TestClass]
    public class SkyFusionTest
    {
        [TestMethod]
        public void SkyFusionRecebeDoisEquipamentosECorredorNoobEBonusRetorna26()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Noob);
            var skyFusion = new SkyFusion(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            skyFusion.Equipar(pneus);
            skyFusion.Equipar(motor);

            var resultado = skyFusion.Bonus;

            Assert.AreEqual(26, resultado);
        }
        [TestMethod]
        public void SkyFusionRecebe2EquipamentosECorredorMedianoEBonusRetorna32()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Mediano);
            var skyFusion = new SkyFusion(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            skyFusion.Equipar(pneus);
            skyFusion.Equipar(motor);

            var resultado = skyFusion.Bonus;

            Assert.AreEqual(32, resultado);
        }
        [TestMethod]
        public void SkyFusionRecebe2EquipamentosECorredorProfissionalEBonusRetorna37()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Profissional);
            var skyFusion = new SkyFusion(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            skyFusion.Equipar(pneus);
            skyFusion.Equipar(motor);

            var resultado = skyFusion.Bonus;

            Assert.AreEqual(37, resultado);
        }
    }
}
