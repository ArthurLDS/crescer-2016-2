-- Exercicio 1
Select  NomeEmpregado, DataAdmissao, DateDiff(MONTH, DataAdmissao, convert(datetime, '31/12/2000', 103)) MesesTrabalhados
from Empregado 
where DataAdmissao between convert(datetime, '01/05/1980', 103)
				   and convert(datetime, '20/01/1982', 103);

-- Exercicio 2
Select Max(meuCont) CargoMaisEmpregados from 
(		
	Select COUNT(Cargo) as meuCont 
	from Empregado 
	Group by Cargo) As contador;

-- Exercicio 3
Select Nome, UF, COUNT(1) NumeroDeCidades from Cidade Group by Nome, UF having count(1)>1;

-- Exercicio 4
Select Nome, UF,COUNT(1) desDuplicadas from Cidade Group by Nome, UF

-- Exercicio 5
Select isnull(max(idassociado),0) +1 as Proximo_ID from Associado;

-- Exercicio 6
Select NomeEmpregado, Salario, 

case when Salario <= 1164 then 0
	 when Salario >  1164 and Salario <= 2326 then 15
	 when Salario >  2326 then 27.5
end ImpostoDeRenda

from Empregado;

-- Exercicio 7
select e.NomeEmpregado, de.NomeDepartamento DepartamentoEmpregado, g.NomeEmpregado NomeGerente, dg.NomeDepartamento DepartamentoGerado 
from Empregado e
	left join Empregado g on e.IDGerente = g.IDEmpregado
	left join Departamento de on de.IDDepartamento = e.IDDepartamento
	left join Departamento dg on dg.IDDepartamento = g.IDDepartamento;

-- Exercicio 8
select e.idempregado, e.nomeempregado, e.cargo,
e.idgerente, e.dataadmissao, 
case when  localizacao = 'SAO PAULO'
	 then e.salario * 1.145
else 
	e.salario
end salario, e.comissao, e.iddepartamento
into aumentarSalario
from empregado e 
    inner join departamento d on e.iddepartamento = d.iddepartamento

DROP TABLE aumentarSalario;
-- Exercicio 9
select
	 SUM(e.Salario) antes,
	 SUM(sa.salario) depois, 
	(SUM(sa.salario)-SUM(e.Salario)) diferenca
from empregado e inner join aumentarSalario sa on e.IDEmpregado = sa.IDEmpregado;


-- Exercicio 10
select top 1 with ties
	d.NomeDepartamento, MAX(e.Salario) TotalEmpregados	
from Empregado e inner join Departamento d on e.IDDepartamento = d.IDDepartamento
group by d.NomeDepartamento
order by TotalEmpregados desc

Select * from Empregado
order by Salario desc;
