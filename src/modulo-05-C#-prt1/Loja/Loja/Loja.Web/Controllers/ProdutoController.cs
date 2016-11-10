using Loja.Dominio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult Produto(string nome)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();

            List<Produto> produtos = produtoServico.ListarProdutos(nome);

            List<ProdutoModel> model = new List<ProdutoModel>();

            foreach (Produto produto in produtos)
            {
                model.Add(new ProdutoModel(produto));
            }
            
            return View("Produto", model);
        }


    }
}