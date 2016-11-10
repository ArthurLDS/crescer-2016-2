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
        public ActionResult FichaTecnica(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            Produto produto = produtoServico.BuscarPorId(id);

            ProdutoModel modelo = new ProdutoModel(produto);
            return View("FichaTecnica", modelo);
        }
        public ActionResult Cadastro()
        {
            return View();
        }
        public ActionResult Salvar(ProdutoModel modelo)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            Produto produto = new Produto(modelo.Id, modelo.Nome, modelo.Valor);

            if (ModelState.IsValid || (modelo.Id.Equals(0) && modelo.Nome!=null && modelo.Valor!=0))
            {
                produtoServico.SalvarProduto(produto);
                return View("FichaTecnica", modelo);
                
            }
            ViewBag.Situacao = "Vefirique os dados.";
            return View("Cadastro");
        }
        public ActionResult Editar(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            Produto produto = produtoServico.BuscarPorId(id);
            ProdutoModel modelo = new ProdutoModel(produto);

            return View("Cadastro", modelo);
        }

    }
}