// Exercicio 01
function gerarPiramide(niveis) {
  for(var i=1; i<=niveis; i++)
    for(var j=1; j<=i; j++){
      console.log('R$ ');
    }
    console.log(' ');
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



function subtrair(n1){
  function subtrairn2(n2){
    return subtracao = n1-n2;
  }
  return subtrairn2;
}
