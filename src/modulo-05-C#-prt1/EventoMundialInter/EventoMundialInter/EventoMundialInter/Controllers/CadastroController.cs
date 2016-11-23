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
    public class CadastroController : Controller
    {
        // GET: Cadastro
        public ActionResult Index(string nome, string email)
        {
            UsuarioModel modelo = new UsuarioModel(nome, email);

            //ListarUsuarios(nome, email);
            return View(modelo);
        }

        /*public JsonResult ListarUsuarios(string nome, string email)
        {
            List<string> listaInfo = new List<string>();
            listaInfo.Add(nome);
            listaInfo.Add(email);

            return new JsonResult()
            {
                Data = new { lista = listaInfo },
                JsonRequestBehavior = JsonRequestBehavior.AllowGet
            };
        }*/
        public JsonResult ListarDatas()
        {
            DataEventoAplicativo dataAplicativo = new DataEventoAplicativo();
            List<DataEvento> listaDeEventos = dataAplicativo.ListarDataEventos();

            List<string> listaEventosString = new List<string>();
            List<int> listaEventosId = new List<int>();

            for(int i=0; i<listaDeEventos.Count; i++)
            {
                listaEventosId.Add(listaDeEventos[i].Id);
                listaEventosString.Add(listaDeEventos[i].Data.ToLongDateString());

                //ToString("dd 'de' MMMM 'de' yyyy")
            }

            return new JsonResult()
            {
                Data = new { lista = listaEventosString, listaId = listaEventosId},
                JsonRequestBehavior = JsonRequestBehavior.AllowGet
            };
        }

        public void Salvar(string nome, string email, string telefone, string cidade, string cpf, int dataId)
        {
            UsuarioAplicativo userAplicativo = new UsuarioAplicativo();
            DataEventoAplicativo dataAplicativo = new DataEventoAplicativo();

            DataEvento data = dataAplicativo.GetDataEventoPorId(dataId);

            Usuario usuario = new Usuario(nome, email, telefone, cidade, cpf, data);

            userAplicativo.Cadastar(usuario);
        }

    }   
}