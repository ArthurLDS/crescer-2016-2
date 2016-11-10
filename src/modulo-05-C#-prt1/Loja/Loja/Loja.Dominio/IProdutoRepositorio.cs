using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        List<Produto> ListarProdutos(string nome="");

        void SalvarProduto(Produto produto);

        Produto BuscarPorId(int id);
    }
}
