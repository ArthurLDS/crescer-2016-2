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


            var modelo = new FichaTecnicaModel();
            modelo.PrimeiraAparicao = "Morro da Perdra.";
            return View(primeiraAparicao);
        }
    }
}