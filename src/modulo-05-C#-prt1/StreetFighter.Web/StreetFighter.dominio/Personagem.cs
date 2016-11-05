using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; private set; }
        
        public string Nome { get; set; }
        
        public DateTime DataNascimento { get; set; }
        
        public int Altura { get; set; }
        
        public decimal Peso { get; set; }

        public string Origem { get; set; }

        public string GolpesEspeciais { get; set; }

        public bool PersonagemOculto { get; set; }
        public string Imagem { get; set; }

        
        public Personagem(int id, string nome, string origem)
        {
            this.Id = id;
            this.Nome = nome;
            this.Origem = origem;
        }
        public Personagem()
        {

        }

        public Personagem(
                int id,
                string nome,
                DateTime dataNascimento, 
                int altura, 
                decimal peso, 
                string origem, 
                string golpesEspeciais, 
                string imagem = "Não informado", 
                bool personagemOculto = false)
        {
            this.Id = id;
            this.Nome = nome;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpesEspeciais = golpesEspeciais;
            this.Imagem = imagem;
            this.PersonagemOculto = personagemOculto;
        }
    }
}