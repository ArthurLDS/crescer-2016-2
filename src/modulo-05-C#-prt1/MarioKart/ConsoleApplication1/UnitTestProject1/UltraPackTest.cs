using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleApplication1;

namespace UnitTestProject1
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        public void UltraPackRecebeUmEquipamentoDeBonus3eAumenta1()
        {
            var equipamentoQualquer = new MotorABaseDeLava(); // recebe 3 de bônus
            var ultrapack = new UltraPack(equipamentoQualquer);
            var resultado = ultrapack.Bonus;

            Assert.AreEqual(4, resultado);
        }
        [TestMethod]
        public void UltraPackRecebeUmEquipamentoDeBonus5eAumenta2()
        {
            var equipamentoQualquer = new FogueteDePlutonio(5); // recebe 10 de bônus
            var ultrapack = new UltraPack(equipamentoQualquer);
            var resultado = ultrapack.Bonus;

            Assert.AreEqual(12, resultado);
        }
        [TestMethod]
        public void UltraPackRecebeUmEquipamentoDeBonus2eAumenta1()
        {
            var equipamentoQualquer = new PneusDeCouroDeDragao(); // recebe 2 de bônus
            var ultrapack = new UltraPack(equipamentoQualquer);
            var resultado = ultrapack.Bonus;

            Assert.AreEqual(3, resultado);
        }

    }
}
