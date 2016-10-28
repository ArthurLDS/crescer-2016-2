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
        public void FogueteDePlutonioTemNivel2eRecebeODobroDeBonusDoCorredor()
        {
            var foguete = new FogueteDePlutonio(2);
           
            Assert.AreEqual(4, foguete.Bonus);
        }
        [TestMethod]
        public void FogueteDePlutonioNaoTemNivelRecebe2eRecebeODobroDeBonusDoCorredor()
        {
            var foguete = new FogueteDePlutonio();

            Assert.AreEqual(4, foguete.Bonus);
        }
    }
}
