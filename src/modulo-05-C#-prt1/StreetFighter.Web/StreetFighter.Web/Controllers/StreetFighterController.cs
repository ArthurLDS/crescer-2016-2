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
            modelo.Imagem = "http://4.bp.blogspot.com/-5yZGmO2TCpQ/VQmqe8v6RfI/AAAAAAAAN0g/J4X3N-YR9ws/s1600/Blanka%2B1.gif";
            modelo.Nome = " Blanka";
            modelo.DataNascimento = " 12 de fevereiro de 1966";
            modelo.Altura = 192;
            modelo.Peso = 96;
            modelo.Origem = " Brasil (lugar de nascença é provável como sendo Tailândia).";
            modelo.GolpesEspeciais = " Electric Thunder, Rolling Attack.";
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
    }
}