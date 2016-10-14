-- Exercicio 1
Select  NomeEmpregado, DataAdmissao, DateDiff(MONTH, DataAdmissao, '31-12-2000') MesesTrabalhados
from Empregado where DataAdmissao between '01-05-1980' and '20-01-1982';

-- Exercicio 2
Select Max(meuCont) CargoMaisEmpregados from 
(		
	Select COUNT(Cargo) as meuCont 
	from Empregado 
	Group by Cargo) As coutador;

-- Exercicio 3
Select UF, COUNT(1) NumeroDeCidades from Cidade Group by UF;

-- Exercicio 4
Select Nome, COUNT(1) CidadesDuplicadas from Cidade Group by Nome

-- Exercicio 6
Select NomeEmpregado, Salario, 

case when Salario <= 1164 then 0
	 when Salario >  1164 and Salario <= 2326 then 15
	 when Salario >  2326 then 27.5
end ImpostoDeRenda

from Empregado;