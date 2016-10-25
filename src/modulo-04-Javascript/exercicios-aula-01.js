// Exercicio 01
function gerarPiramide(niveis) {
  for(var i=1; i<=niveis; i++)
       console.log(Array(i+1).join('R$'));
}

// Exercicio 02
function diglettDig() {
  for(var i=1; i<=100; i++){
    if(i%3 === 0 && i%5 === 0)
      console.log('Diglett dig, trio trio trio');
    else if(i%3 === 0)
      console.log('Diglett dig');
    else if (i%5 === 0)
      console.log('trio trio trio');
    else
      console.log(i);
  }
}

// Exercicio 03
function find(array, funcao){
    var result = '';
    for(var i=0; i< array.length; i++){
        if(funcao(array[i])){
          result += array[i] + ' ';
        }
    }
    return result;
}

// Exercicio 04
function subtrair(n1){
  function subtrairn2(n2){
    return subtracao = n1-n2;
  }
  return subtrairn2;
}

/* Exercicio 05 Incompleto
function iguais(n1, n2){
  if(typeof n1 === Object && typeof n2 === Object){

  }
  else if(n1 === n2)  
    return true;
  else
    return false;
}*/

/* 06
function ctrlC(valor){
 
  return valor;
}*/


// Exercicio 07 C/ BÔNUS
function mesclar(obj1, obj2){
  for(i in obj1){
    for(j in obj2){
      if(typeof obj1[i] == Object && typeof obj2[j])
          Object.assign(obj1[i], obj2[j]);
    }
  }
  Object.assign(obj1, obj2);

}

/* Teste
var objeto1 = {
  abacaxi: 0,
  banana: { peso: 52, preco: 100 },
  cereja: 97
};
var objeto2 = {
  banana: { preco: 200 },
  damasco: 100
};
mesclar(objeto1, objeto2);
console.log(objeto1); */