using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult FichaTecnica()
        {
            var modelo = new FichaTecnicaModel();
            modelo.Imagem = "https://files.slack.com/files-pri/T2FVBENMS-F2RM5AKSL/blanka.png";
            modelo.Nome = " Blanka";
            modelo.DataNascimento = new DateTime(1966, 02, 12);
            modelo.Altura = 192;
            modelo.Peso = 96;
            modelo.Origem = "Brasil";
            modelo.GolpesEspeciais = " Electric Thunder, Rolling Attack.";
            modelo.PersonagemOculto = false;

            return View(modelo);

        }
        public ActionResult Sobre()
        {
            var modelo = new SobreModel();
            modelo.PrimeiraAparicao = " Igrejinha - RS ";
            modelo.Nascimento = " 27 de novembro de 1998";
            modelo.Altura = 182;
            modelo.Peso = 76;
            modelo.TipoSanguineo = " O-";
            modelo.HabilidadesEspeciais = " Montar cubo mágico e jogar FIFA.";
            modelo.Gosta = " Pizza, Bacon, Café, Sua mãe.";
            modelo.EstiloDeLuta = " Peleia Bagual.";
            modelo.Origem = " Rio Grande do Sul.";
            modelo.UmaFalaDeVitoria = "Não tá morto quem peleia";
            modelo.GolpesEspeciais = " Voadora giratória com os dois pés.";

            return View(modelo);
        }
        public ActionResult Cadastro(FichaTecnicaModel model)
        {
            PopularPaises();
            return View();
        }
        public ActionResult Salvar(FichaTecnicaModel model)
        {
            if (ModelState.IsValid)
            {
                return View("FichaTecnica", model);
            }
            else
            {
                return View("Cadastro");
            }
        }

        public void PopularPaises()
        {
            ViewData["ListaPaises"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "AR", Text = "Argentina" },
                new SelectListItem() { Value = "JP", Text = "Japão" },
                new SelectListItem() { Value = "US", Text = "EUA" }
            };
        }
    }
}