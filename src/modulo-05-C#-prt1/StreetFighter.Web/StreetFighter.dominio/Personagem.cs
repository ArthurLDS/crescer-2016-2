using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.dominio
{
    public class Personagem
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        public string Origem { get; set; }
        public Personagem(int id, string nome, string origem)
        {
            this.Id = id;
            this.Nome = nome;
        }
        public Personagem(string nome, string origem)
        {
            this.Nome = nome;
            this.Origem = origem;
        }
    }
}
