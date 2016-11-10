using Loja.Dominio;
using System;
using System.Activities.Statements;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public List<Produto> ListarProdutos(string nome = "")
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produtos.Where(u => u.Nome.Contains(nome)).ToList();
            }
        }

        public void SalvarProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                if (produto.Id > 0)
                    context.Entry<Produto>(produto).State = EntityState.Modified;
                else
                    context.Entry<Produto>(produto).State = EntityState.Added;

                context.SaveChanges();
            }
        }

    }
}
