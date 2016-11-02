using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class CadastroModel
    {   
        public string Imagem { get; set; }
        public string Nome { get; set; }
        public string DataNascimento { get; set; }
        public int Altura { get; set; }
        public int Peso { get; set; }
        public string Origem { get; set; }
        public string GolpesEspeciais { get; set; }
        public bool PersonagemOculto { get; set; }
    }
}