-- Exercício 1
Select Empregado, COUNT(1) as Total From Projeto Group By Empregado having COUNT(1) > 1;
Select Responsavel, COUNT(1) as Total From Projeto Group By Responsavel Having COUNT(1) > 1;

-- Exercício 2
Select Projeto, (ValorFaturado-ValorRealizado) as Lucro from Projeto where (ValorFaturado-ValorRealizado) > 0;

-- Exercício 3
Select ((ValorRealizado-ValorFaturado) * 100 / ValorRealizado) as PercentualDePerda 
from Projeto where (ValorFaturado-ValorRealizado)<0;

-- Exercicio 4
Select SubString(Empregado, 1, Case when CHARINDEX(' ', Empregado) = 0 then len(Empregado) 
else CHARINDEX(' ', Empregado)end)
as PrimeiroNome from Projeto;