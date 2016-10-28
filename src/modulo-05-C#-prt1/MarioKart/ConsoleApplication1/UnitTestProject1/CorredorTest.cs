using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using MarioKart;

namespace UnitTestProject
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorComNomeFulanoEHabilidadeNoob()
        {
           var corredor = new Corredor("Fulano", Habilidade.Noob);

            Assert.AreEqual("Fulano", corredor.Nome);
            Assert.AreEqual(Habilidade.Noob, corredor.NivelHabilidade);
        }
        
    }
}
