using EventoMundialInter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Net.Mail;
using System.Net;

namespace EventoMundialInter.Repositorio
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public List<Usuario> ListarUsuarios()
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Usuario.ToList();
            }
        }

        public List<Usuario> ListarUsuariosPorData(DataEvento data)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Usuario.Where(u => u.DataEvento.Equals(data)).ToList();
            }
        }

        public void Cadastar(Usuario usuario)
        {
            DataEventoRepositorio dataRepositorioo = new DataEventoRepositorio();
            if(!String.IsNullOrEmpty(usuario.Telefone) && usuario.DataEvento.Data!=null && !String.IsNullOrEmpty(usuario.Cidade)&& !String.IsNullOrEmpty(usuario.Cpf))
            using (var contexto = new ContextoDeDados())
            {
                contexto.Entry<Usuario>(usuario).State = EntityState.Added;


                contexto.SaveChanges();
            }
            dataRepositorioo.DecrementarQuantidade(usuario.DataEvento.Id);
        }

        public void EnviarEmail(string email, string nome)
        {
            if (!String.IsNullOrEmpty(email) && !String.IsNullOrEmpty(nome))
            {
                MailMessage mail = new MailMessage();

                mail.From = new MailAddress("arthurlds73@gmail.com");
                mail.To.Add(email); // para
                mail.Subject = "Teste"; // assunto
                mail.IsBodyHtml = true;
                mail.Body = "<html><body> <h2>Olá, " + nome + "</h2><b>Obrigado por participar do nosso evento! Para confirmar sua presença precisamos de mais algumas informções, clique aqui para terminar seu cadastro: </b><a href='http://localhost:53818/Cadastro?nome=" + "" + nome + "&" + "email=" + "" + email + "" + "'>Aqui</a></body></html>";

                using (var smtp = new SmtpClient("smtp.gmail.com"))
                {
                    smtp.EnableSsl = true; // GMail requer SSL
                    smtp.Port = 587;       // porta para SSL
                    smtp.DeliveryMethod = SmtpDeliveryMethod.Network; // modo de envio
                    smtp.UseDefaultCredentials = false; // vamos utilizar credencias especificas

                    // seu usuário e senha para autenticação
                    smtp.Credentials = new NetworkCredential("arthurlds73@gmail.com", "arml1527ls");

                    // envia o e-mail
                    smtp.Send(mail);
                }
            }
        }
    }
}
