describe('foraDaGuerraCivil(marvel)', function() {

  it('deve encontrar 107 herois fora da CivilWar', function() {
    let resultado = foraDaGuerraCivil(marvel).lenght;
    expect(resultado).toEqual(107);
  });
});
