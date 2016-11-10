using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class Produto
    {
        public Produto(int id, string nome, decimal valor)
        {
            this.Id = id;
            this.Nome = nome;
            this.Valor = valor;
        }

        public Produto() { }

        public int Id { get; set; }

        public string Nome { get; set; }

        public decimal Valor { get; set; }
    }
}
