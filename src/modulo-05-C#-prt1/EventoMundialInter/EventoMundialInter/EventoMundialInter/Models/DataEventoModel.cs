using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EventoMundialInter.Models
{
    public class DataEventoModel
    {
        public DataEventoModel(int quantidade)
        {
            this.Quantidade = quantidade;
        }

        public DataEventoModel()
        {

        }

        public int Id { get; set; }
        public DateTime Data { get; set; }
        public int Quantidade { get; set; }
    }
}