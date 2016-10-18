-- Exercicio 1
SELECT COUNT(1) as  Total_De_Pedidos FROM Pedido where DataPedido <='30-09-2016';

-- Exercicio 2
SELECT Nome FROM Produto p 
INNER JOIN ProdutoMaterial pm ON p.IDProduto = PM.IDProduto 
INNER JOIN Material ma ON pm.IDMaterial = ma.IDMaterial
WHERE ma.IDMaterial = 15836;

-- Exercicio 3
SELECT Nome, RazaoSocial FROM Cliente WHERE RazaoSocial like '%Ltda%' OR Nome like '%Ltda%';

-- Exercicio 4
INSERT INTO Produto(Nome, PrecoCusto, PrecoVenda, Situacao) VALUES ('Galocha Maragato', 35.67, 77.95, 'A');-- Exercicio 5SELECT * FROM Produto pr WHERE NOT EXISTS (SELECT * FROM PedidoItem WHERE IDProduto = pr.IDProduto);-- Exercicio 6SELECT TOP 1 ci.UF, COUNT(1) Maior_Cidade FROM Cliente cl INNER JOIN Cidade ci ON cl.IDCidade = ci.IDCidade GROUP BY ci.UFORDER BY Maior_Cidade desc-- Exercicio 7 INCOMPLETO!!SELECT pr.Nome FROM Produto prINNER JOIN ProdutoMaterial pm  ON pr.IDProduto  = pm.IDProdutoINNER JOIN Material ma ON ma.IDMaterial = pm.IDMaterial WHERE ma.IDMaterial = 14650  OR ma.IDMaterial = 15703  OR	  ma.IDMaterial = 15836  OR ma.IDMaterial = 16003  OR 	  ma.IDMaterial = 16604  OR ma.IDMaterial = 17226;-- Exercicio 9SELECT TOP 1 SUBSTRING(Nome, 1, CHARINDEX(' ', Nome)) Primeiro_Nome, COUNT(*) Nome_Mais_Popular FROM Cliente GROUP BY SUBSTRING(Nome, 1, CHARINDEX(' ', Nome))ORDER BY Primeiro_Nome desc;