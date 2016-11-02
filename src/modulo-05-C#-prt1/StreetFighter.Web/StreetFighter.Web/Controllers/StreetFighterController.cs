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
            modelo.PrimeiraAparicao = " Morro da Perdra.";
            modelo.Nascimento = " 12 de fevereiro de 1966";
            modelo.Altura = 192;
            modelo.Peso = 96;
            modelo.Medidas = " B198, C120, Q172.";
            modelo.TipoSanguineo = " B";
            modelo.HabilidadesEspeciais = " Caçar, Eletricidade. ";
            modelo.Gosta = " Frutas tropicais, Pirarucu, Sua mãe. ";
            modelo.EstiloDeLuta = " Luta Selvagem autodidata (Army Ants) / Capoeira.";
            modelo.Origem = " Brasil (lugar de nascença é provável como sendo Tailândia).";
            modelo.UmaFalaDeVitoria = " Ver você em ação é uma piada!";
            modelo.Ssf2 = " A selvagem criança da natureza. ";
            modelo.Sfa3 = " A animal pessoa amazônica.";
            modelo.Sf4 = " Guerreiro da selva.";
            modelo.Sfa3Stage = " Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?). ";
            modelo.Sf2Stage = " Bacia do rio Amazonas (Brasil). ";
            modelo.GolpesEspeciais = " Electric Thunder, Rolling Attack.";
            return View(modelo);
        }
        public ActionResult Sobre() {
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
        public ActionResult Cadastro(CadastroModel model) {
            return View();
        }
    }
}