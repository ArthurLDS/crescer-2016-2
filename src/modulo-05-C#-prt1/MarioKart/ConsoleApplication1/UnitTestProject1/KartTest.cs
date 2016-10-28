using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using ConsoleApplication1;

namespace UnitTestProject1
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void KartCorredorMedianoTemVelocidadeIgualA10()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Mediano);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            
            kart.Equipar(pneus);
            Assert.AreEqual(10, kart.Velocidade);
        }
        [TestMethod]
        public void KartCorredorMedianoTem2EquipamentosETemVelocidadeIgualA10()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Mediano);
            var kart = new Kart(corredor);

            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);
            Assert.AreEqual(13, kart.Velocidade);
        }
        [TestMethod]
        public void KartCorredorProfissionalTemVelocidadeIgualA12()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Profissional);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();

            kart.Equipar(pneus);
            Assert.AreEqual(12, kart.Velocidade);
        }
        [TestMethod]
        public void KartCorredorProfissionalTem2EquipamentosETemVelocidadeIgualA16()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Profissional);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            kart.Equipar(pneus);
            kart.Equipar(motor);
            Assert.AreEqual(16, kart.Velocidade);
        }
        [TestMethod]
        public void KartCorredorProfissionalTem3EquipamentosETemVelocidadeIgualA1()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Profissional);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();
            var foguete = new FogueteDePlutonio(2);

            kart.Equipar(foguete);
            kart.Equipar(pneus);
            kart.Equipar(motor);
            Assert.AreEqual(21, kart.Velocidade);
        }
    }
}
