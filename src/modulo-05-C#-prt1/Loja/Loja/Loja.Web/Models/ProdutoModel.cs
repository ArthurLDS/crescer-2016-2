using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public ProdutoModel(Produto produto)
        {
            this.Id = produto.Id;
            this.Nome = produto.Nome;
            this.Valor = produto.Valor;
        }
        public ProdutoModel(int id, string nome, decimal valor)
        {
            this.Id = id;
            this.Nome = nome;
            this.Valor = Valor;
        }
        public ProdutoModel()
        {

        }

        public int Id { get; set; }
        
        [Required]
        public string Nome { get; set; }

        [Required]
        public decimal Valor { get; set; }
    }
}