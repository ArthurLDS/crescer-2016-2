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

	//Exercicio 05
	seriesPorLongevidade(marvel){
		var seriesOrdernadas = [];

		for(var i in marvel){
			var itens = marvel[i]['series']['items'];
			for(var j in itens){
					var itemAtual = itens[j];
					seriesOrdernadas.push(itemAtual);
			}
		}
		//Sort
		function ordena() {seriesOrdernadas.sort(function(x,y){
				var serie1 = x.endYear - x.startYear;
				var serie2 = y.endYear - y.startYear;
				return serie2 - serie1;
		});}

		/*
		for(var i=seriesOrdernadas.length-1; i>=0; i--){
			for(var j=0; j<=i; j++){
					var tempoTot = seriesOrdernadas[j].endYear - seriesOrdernadas[j].startYear;
					var tempoStartProx = seriesOrdernadas[j+1].startYear;
					if(tempoTot<seriesOrdernadas[j+1].endYear - tempoStartProx){
						var aux = seriesOrdernadas[j];
						seriesOrdernadas[j] = seriesOrdernadas[j+1];
						seriesOrdernadas[j+1] = aux;
					}
			}
		}*/
		ordena();
		//Teste
		for(var i in seriesOrdernadas){
			var tempoTot = seriesOrdernadas[i].endYear - seriesOrdernadas[i].startYear;
			console.log(tempoTot);
		}
		return ordena();
	}

	// Exercicio 06 (NÃO TERMINADO)
	comicMaisCara(marvel){
		var maior = 0;
		var maiorComic;

		for(var i in marvel){
			var itens = marvel[i]['comics']['items'];
			for(var j in itens){
					var itemAtual = itens[j];
					if(itemAtual['prices'][0]>maior){
						maior = itemAtual['prices'][0]; //Rafatore isso!
						maiorComic = itemAtual;
					}
			}
		}
		return maiorComic;
	}


}
