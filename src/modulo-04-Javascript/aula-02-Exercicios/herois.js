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

}
