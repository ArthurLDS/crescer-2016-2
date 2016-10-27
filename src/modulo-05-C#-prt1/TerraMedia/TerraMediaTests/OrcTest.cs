using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Personagens;

namespace TerraMediaTests
{
    [TestClass]
    public class OrcTest
    {
        [TestMethod]
        public void TestMethod1()
        {
            var orc = new Orc();

            Assert.AreEqual(12, orc.Ataque);
        }
    }
}
