using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class LoginModel
    {
        public LoginModel(Usuario usuario)
        {
            this.Id = usuario.Id;
            this.Email = usuario.Email;
            this.Senha = usuario.Senha;
        }
        public int Id { get; set; }

        [Required]
        public string Email { get; set; }

        [Required]
        public string Senha { get; set; }
    }
}