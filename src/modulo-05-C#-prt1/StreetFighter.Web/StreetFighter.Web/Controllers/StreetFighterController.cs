using StreetFighter.aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Contexts;
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
        public ActionResult FichaTecnica(string nome)
        {
            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
            Personagem personagem = personagemAplicativo.BuscarPersonagemPorNome(nome);
            return View(personagem);


            /*var modelo = new FichaTecnicaModel();
            modelo.Imagem = "https://files.slack.com/files-pri/T2FVBENMS-F2RM5AKSL/blanka.png";
            modelo.Nome = " Blanka";
            modelo.DataNascimento = new DateTime(1966, 02, 12);
            modelo.Altura = 192;
            modelo.Peso = 96;
            modelo.Origem = "Brasil";
            modelo.GolpesEspeciais = " Electric Thunder, Rolling Attack.";
            modelo.PersonagemOculto = false;*/

            //return View(modelo);

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
        public ActionResult ListaDePersonagem(string filtro, string nomePersonagem)
        {
            PersonagemAplicativo modelo = new PersonagemAplicativo();
            try
            {
                if (nomePersonagem != null)
                {
                    Personagem personagemASerExcluido = modelo.BuscarPersonagemPorNome(nomePersonagem);
                    modelo.ExcluirPersonagem(personagemASerExcluido);
                    ViewBag.Situacao = "Personagem excluído com SUCESSO!";
                }
                return View(modelo.ListarPersonagens(filtro));

            }
            catch { } // CONSERTAR GAMBI HORRENDA
            return View(modelo.ListarPersonagens(filtro));

        }
        public ActionResult Salvar(FichaTecnicaModel model)
        {
            Personagem personagem = new Personagem
                    (0, model.Nome, model.DataNascimento, model.Altura,
                    model.Peso, model.Origem, model.GolpesEspeciais, model.Imagem, model.PersonagemOculto);

            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();

            if (!personagemAplicativo.RegraDeNegocio(personagem))
            {
                ViewBag.Mensagem = "Não é permitido cadastrar persongens overpowered.";
                return RedirectToAction("Cadastro");            }
            if (ModelState.IsValid)
            {
                personagemAplicativo.Salvar(personagem);

                ViewBag.Mensagem = "Cadastrado com SUCESSO!";
                return View("FichaTecnica", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro.");
            }
            return View("Cadastro");
        }
        public ActionResult EditarPersonagem(string nome)
        {
            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
            Personagem personagem = new Personagem();

            personagem = personagemAplicativo.BuscarPersonagemPorNome(nome);

            FichaTecnicaModel personagemEmFichaTecnica = new FichaTecnicaModel();
            personagemEmFichaTecnica.Id = personagem.Id;
            personagemEmFichaTecnica.Nome = personagem.Nome;
            personagemEmFichaTecnica.DataNascimento = personagem.DataNascimento;
            personagemEmFichaTecnica.Altura = personagem.Altura;
            personagemEmFichaTecnica.Peso = personagem.Peso;
            personagemEmFichaTecnica.Origem = personagem.Origem;
            personagemEmFichaTecnica.GolpesEspeciais = personagem.GolpesEspeciais;
            personagemEmFichaTecnica.PersonagemOculto = personagem.PersonagemOculto;
            personagemEmFichaTecnica.Imagem = personagem.Imagem;

            return View("Cadastro", personagemEmFichaTecnica);
        }

        public void PopularPaises()
        {
            ViewData["ListaPaises"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "AR", Text = "Argentina" },
                new SelectListItem() { Value = "JP", Text = "Japão" },
                new SelectListItem() { Value = "US", Text = "EUA" },
                new SelectListItem() { Value = "MP", Text = "Morro da Pedra" }
            };
        }
    }
}