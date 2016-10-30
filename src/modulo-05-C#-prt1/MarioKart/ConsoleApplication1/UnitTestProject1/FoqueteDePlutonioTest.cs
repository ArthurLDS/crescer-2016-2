using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;
using ConsoleApplication1;

namespace UnitTestProject1
{
    [TestClass]
    public class FoqueteDePlutonioTest
    {
        [TestMethod]
        public void FogueteDePlutonioTemNivel2eRecebe4DeBonusDoCorredor()
        {
            var foguete = new FogueteDePlutonio(2);
           
            Assert.AreEqual(4, foguete.Bonus);
        }
        [TestMethod]
        public void FogueteDePlutonioTemNivel5eRecebe10DeBonusDoCorredor()
        {
            var foguete = new FogueteDePlutonio(5);

            Assert.AreEqual(10, foguete.Bonus);
        }
        [TestMethod]
        public void FogueteDePlutonioSemParametroRecebe2PorDefaultERecebe4BonusDoCorredor()
        {
            var foguete = new FogueteDePlutonio();

            Assert.AreEqual(4, foguete.Bonus);
        }
        [TestMethod]
        public void FogueteDePlutonioRecebeValorInvalidoEBonusDoCorredorFicaDefault()
        {
            var foguete = new FogueteDePlutonio(9);

            Assert.AreEqual(4, foguete.Bonus);
        }
    }
}
