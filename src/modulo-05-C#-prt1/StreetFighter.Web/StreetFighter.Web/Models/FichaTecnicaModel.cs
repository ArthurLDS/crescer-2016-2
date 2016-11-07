using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {   

        public int Id { get; set; }
        
        public string Imagem { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public DateTime DataNascimento { get; set; }

        [Required]
        public int Altura { get; set; }

        [Required]
        public decimal Peso { get; set; }
        
        [Required]
        public string Origem { get; set; }

        [Required]
        public string GolpesEspeciais { get; set; }

        public bool PersonagemOculto { get; set; }
    }
}