using EventoMundialInter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EventoMundialInter.Models
{
    public class UsuarioModel
    {
        public UsuarioModel(string nome, string email)
        {
            this.Nome = nome;
            this.Email = email;
        }

        public UsuarioModel()
        {

        }

        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Telefone { get; set; }
        public string Cidade { get; set; }
        public string Cpf { get; set; }
        public DataEvento DataEvento { get; set; }
    }
}