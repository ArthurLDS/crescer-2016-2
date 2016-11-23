using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EventoMundialInter.Dominio
{
    public class DataEvento
    {
        public DataEvento(DateTime data, int quantidade)
        {
            this.Data = data;
            this.Quantidade = quantidade;
        }

        public DataEvento() { }

        public int Id { get; set; }
        public DateTime Data { get; set; }
        public int Quantidade { get; set; }
        
    }
}
