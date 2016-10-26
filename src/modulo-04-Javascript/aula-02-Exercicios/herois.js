class Herois {
	// Exercicio 01
	constructor([id, nome, descricao]){
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	//Exercicio 02
	foraDaGuerraCivil(marvel) {
		var osDeFora = [];
	  for(var i in marvel){
			var itens 	= marvel[i]['events']['items'];
			for(var j in itens){
					if(itens[j].name !=='Civil War'){
						osDeFora.push(marvel[i]);
					}
			}
	  }
		return osDeFora;
	}
	//Exercicio 03
	maisPublicado(marvel){
			var maior = 0;
			var maiorPersonagem;
			for(var i in marvel){
				var	qntHistorias = marvel[i]['comics']['available'];
				if(qntHistorias>maior){
					maior = qntHistorias;
					maiorPersonagem = marvel[i];
				}
			}
			return maiorPersonagem;
	}

	// Exercicio 04
	mediaPaginas(marvel){
		var somador =  0;
		for(var i in marvel){
			let itens = marvel[i]['comics']['items'];
			for(var j in itens){
					somador += itens[j].pageCount;
			}
		}
		return somador / marvel.length;
	}
}
