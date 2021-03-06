﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ExercicioLambda
{
    public class RepositorioFuncionarios
    {

        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            IList<Funcionario> filtradosPorCargo;

            filtradosPorCargo = Funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo).ToList();
            return filtradosPorCargo;

            throw new NotImplementedException();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            IList<Funcionario> ordenadosPorCargoEPorNome;
            ordenadosPorCargoEPorNome =
             Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo)
            .ThenBy(funcionario => funcionario.Nome)
            .ToList();
            return ordenadosPorCargoEPorNome;

            throw new NotImplementedException();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            IList<Funcionario> filtroPorNome =
            Funcionarios.Where(funcionario => funcionario.Nome.Contains(nome))
            .ToList();

            return filtroPorNome;
            throw new NotImplementedException();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            IList<Funcionario> filtroPorTurno;

            filtroPorTurno = Funcionarios.
            Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho)).
            ToList();

            return filtroPorTurno;
          
            throw new NotImplementedException();
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return Funcionarios
                .Where(funcionario => 2016 - funcionario.DataNascimento.Year >= idade - 5 &&
                2016 - funcionario.DataNascimento.Year <= idade + 5).ToList(); 
                // Keep it simple :)

            throw new NotImplementedException();
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            Funcionario[] filtrado;
            if (turno.Equals(null))
                filtrado = Funcionarios.ToArray();
            else
                filtrado = Funcionarios.Where(funcionario => funcionario.TurnoTrabalho == turno).ToArray();
            double somador = 0;

            for (int i = 0; i<filtrado.Length; i++)
                somador += filtrado[i].Cargo.Salario;

            return somador / filtrado.Length;
            throw new NotImplementedException();
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(funcionario => funcionario.DataNascimento.Month == DateTime.Now.Month).ToList();
            throw new NotImplementedException();
        }

        public IList<dynamic> BuscaRapida()
        {
            //IList<string> filtro =
            //(from funcionario in Funcionarios select funcionario.Nome).ToList();
             
            IList<dynamic> filtrado = Funcionarios
            .Select(funcionario => 
                        new
                      {
                          NomeFuncionario = funcionario.Nome,
                          TituloCargo = funcionario.Cargo.Titulo
                      })
                      .ToList<dynamic>();

            return filtrado;
            throw new NotImplementedException();
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            throw new NotImplementedException();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            throw new NotImplementedException();
        }
    }
}
