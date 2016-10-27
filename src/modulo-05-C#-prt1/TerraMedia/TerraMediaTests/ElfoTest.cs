using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Personagens;
using TerraMedia.Equipamentos;

namespace TerraMediaTests
{
    [TestClass]
    public class ElfoTest
    {
        [TestMethod]
        public void ElfoNasceCom10DeVida()
        {
            Elfo elfo = new Elfo();

            Assert.AreEqual(10, elfo.Vida);
        }

        [TestMethod]
        public void ElfoAtacaAnaoEEstePerde2DeVida()
        {
            var elfo = new Elfo();
            var anao = new Anao();

            elfo.Atacar(anao);

            Assert.AreEqual(18, anao.Vida);
        }

        [TestMethod]
        public void ElfoComEspadaTemAtaque5()
        {
            var elfo = new Elfo();
            var espada = new Espada();

            elfo.Equipar(espada);

            Assert.AreEqual(5, elfo.Ataque);
        }
    }
}
