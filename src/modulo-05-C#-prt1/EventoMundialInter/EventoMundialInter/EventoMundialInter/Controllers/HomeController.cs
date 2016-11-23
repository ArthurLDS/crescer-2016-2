using EventoMundialInter.Aplicativo;
using EventoMundialInter.Dominio;
using EventoMundialInter.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EventoMundialInter.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        public JsonResult ListarDatas()
        {
            DataEventoAplicativo dataAplicativo = new DataEventoAplicativo();
            List<DataEvento> listaDeEventos = dataAplicativo.ListarDataEventos();

            return new JsonResult()
            {
                Data = new { lista = listaDeEventos },
                JsonRequestBehavior = JsonRequestBehavior.AllowGet
            };
        }

        public ActionResult EnviaEmail(string email, string nome)
        {
            UsuarioAplicativo userAplicativo = new UsuarioAplicativo();
            userAplicativo.EnviarEmail(email, nome);

            return View("Index");
        }
        
    }
}