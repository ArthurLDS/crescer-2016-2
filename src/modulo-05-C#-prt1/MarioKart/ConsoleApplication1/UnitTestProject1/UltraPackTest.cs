using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleApplication1;

namespace UnitTestProject1
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        public void FogueteDePlutonioTemNivel2eRecebeODobroDeBonusDoCorredor()
        {
            var equipamentoQualquer = new MotorABaseDeLava(); // recebe 3 de bônus
            var ultrapack = new UltraPack(equipamentoQualquer);
            var resultado = ultrapack.Bonus;

            Assert.AreEqual(4, resultado);
        }
        
    }
}
