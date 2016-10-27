using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Personagens
{
    public class Anao : Personagem
    {
        public Anao() : base(20)
        {
            this.Ataque = 1;
            this.Defesa = 2;
        }

        protected override void ReceberAtaque(int ataque)
        {
            bool podeUsarDefesa = this.PodeUsarDefesa(ataque);
            if (podeUsarDefesa)
            {
                ataque -= this.Defesa;
            }

            base.ReceberAtaque(ataque);
        }

        private bool PodeUsarDefesa(int ataqueRecebido)
        {
            return ataqueRecebido >= 5;
        }
    }
}
