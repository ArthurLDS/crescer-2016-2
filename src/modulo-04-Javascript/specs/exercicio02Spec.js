//Teste Exercicio 02
describe('foraDaGuerraCivil()', function() {

  it('deve dar true', function() {
    let heroi = new Herois();
    let resultado = heroi.pesquisaSimples().length;
    expect(resultado).toEqual(3);
  });

  it('deve encontrar 1 heroi fora da CivilWar', function() {
    let dadosHerois = [
      { name: 'Debug Destruidor', events: { items:{nome:'Civil War'} } },
      { name: 'Tipagem Maravilhosa', events: { items:{nome:'Batalha das trevas'} } },
      { name: 'Compilador Prateado', events: { items:{nome:'Civil War'} } }
    ]
    let heroi = new Herois(dadosHerois);
    let resultado = heroi.foraDaGuerraCivil().length;
    expect(resultado).toEqual(1);
  });
});
/*Teste Exercicio 03
describe('maisPublicado()', function() {
  it('deve encontrar heroi mais publicado  que é o segundo.', function() {
    let dadosHerois = [
      { name: 'Debug Destruidor', comics: { available: 12 } },
      { name: 'Tipagem Maravilhosa', comics: { available: 39 } },
      { name: 'Compilador Prateado', comics: { available: 3 } }
    ]
    let resultado = maisPublicado(dadosHerois);
    expect(resultado).toEqual({name: 'Tipagem Maravilhosa', comics: { available: 39 }});
  });
});
//Teste Exercicio 04
describe('mediaPaginas()', function(){
  it('deve encontrar a media de paginas 6', function() {
    let dadosHerois = [
      { name: 'Debug Destruidor', comics: { items: 6 } },
      { name: 'Tipagem Maravilhosa', comics: { items: 6 } },
      { name: 'Compilador Prateado', comics: { items: 6 } }
    ]
    let resultado = mediaPaginas(ma).length;
    expect(resultado).toEqual(107);
  });
});*/
