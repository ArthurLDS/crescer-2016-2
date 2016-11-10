using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public List<Produto> ListarProdutos(string nome)
        {
            return produtoRepositorio.ListarProdutos(nome);
        }

        public void SalvarProduto(Produto produto)
        {
            this.produtoRepositorio.SalvarProduto(produto);
        }

        public Produto BuscarPorId(int id)
        {
            return this.produtoRepositorio.BuscarPorId(id);
        }
    }
}
