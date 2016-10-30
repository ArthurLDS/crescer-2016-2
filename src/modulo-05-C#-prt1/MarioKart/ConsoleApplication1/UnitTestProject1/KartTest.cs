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
        public void KartCorredorProfissionalTem3EquipamentosETemVelocidadeIgual21()
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
        [TestMethod]
        public void KartCorredorNoobTem2EquipamentosETemVelocidadeIgualA11()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Noob);
            var kart = new Kart(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();
            
            kart.Equipar(pneus);
            kart.Equipar(motor);
            Assert.AreEqual(11, kart.Velocidade);
        }
        [TestMethod]
        public void KartDinamCorredorNoobTem2EquipamentosETemVelocidadeIgualA14()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Noob);
            var dinam= new Dinam(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            dinam.Equipar(pneus);
            dinam.Equipar(motor);
            Assert.AreEqual(14, dinam.Velocidade);
        }
        [TestMethod]
        public void KartDinamCorredorMedianoTem2EquipamentosETemVelocidadeIgualA18()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Mediano);
            var dinam = new Dinam(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            dinam.Equipar(pneus);
            dinam.Equipar(motor);
            Assert.AreEqual(18, dinam.Velocidade);
        }
        [TestMethod]
        public void KartSonnarCorredorNoobTem2EquipamentosETemVelocidadeIgualA13()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Noob);
            var sonnar = new Sonnar(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            sonnar.Equipar(pneus);
            sonnar.Equipar(motor);
            Assert.AreEqual(13, sonnar.Velocidade);
        }
        [TestMethod]
        public void KartSonnarCorredorProfissionalTem2EquipamentosETemVelocidadeIgualA18()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Profissional);
            var sonnar = new Sonnar(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            sonnar.Equipar(pneus);
            sonnar.Equipar(motor);
            Assert.AreEqual(18, sonnar.Velocidade);
        }
        [TestMethod]
        public void KartLightCorredorNoobTem2EquipamentosETemVelocidadeIgualA14()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Noob);
            var light = new Light(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            light.Equipar(pneus);
            light.Equipar(motor);
            Assert.AreEqual(14, light.Velocidade);
        }
        [TestMethod]
        public void KartLightCorredorProfissionalTem2EquipamentosETemVelocidadeIgualA15()
        {
            var corredor = new Corredor("Nego Drama", Habilidade.Profissional);
            var light = new Light(corredor);
            var pneus = new PneusDeCouroDeDragao();
            var motor = new MotorABaseDeLava();

            light.Equipar(pneus);
            light.Equipar(motor);
            Assert.AreEqual(15, light.Velocidade);
        }
    }
}

