using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventoMundialInter.Dominio
{
    public class Usuario
    {
        public Usuario(string nome, string email, string telefone, string cidade, string cpf, DataEvento data)
        {
            this.Nome = nome;
            this.Email = email;
            this.Telefone = telefone;
            this.Cidade = cidade;
            this.Cpf = cpf;
            this.DataEvento = data;
        }

        public Usuario()
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
