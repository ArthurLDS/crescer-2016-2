using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public string PrimeiraAparicao { get; set; } 
        public string Nascimento { get; set; }
        public int Altura {get; set;}
        public int Peso { get; set; }
        public string Medidas { get; set; }
        public string TipoSanguineo {get; set;}
        public string HabilidadesEspeciais { get; set; }
        public string Gosta { get; set; }
        public string EstiloDeLuta { get; set; }
        public string Origem { get; set; }
        public string UmaFalaDeVitoria { get; set; }
        public string Ssf2 { get; set; }
        public string Sfa3 { get; set; }
        public string Sf4 { get; set; }
        public string Sfa3Stage { get; set; }
        public string Sf2Stage { get; set; }
        public string GolpesEspeciais { get; set; }
    }
}