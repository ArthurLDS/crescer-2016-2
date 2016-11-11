class TelaPrincipal {

  constructor(seletor) {
    this.$elem = $(seletor);
    this.renderizarEstadoInicial();

    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=6c9c0da2607c3ff1fbfdbf4da338a98d&orderBy=-modified&limit=20';
    $.get(url).then(
      res => console.log(res.data.results)
    );

  }

  registrarBindsEventos(self) {
    self.$btnNovoHeroi = $('#btn-novo-heroi');
    self.$btnNovoHeroi.on('click', self.cadastrarNovoHeroi);
  }

  cadastrarNovoHeroi() {
    console.log('Cadastrou!!!');
    $.post('/api/herois', {
      nome: 'Super Debug',
      urlThumbnail: 'http://www.ironhenry.com/wp-content/uploads/2013/06/debug.png'
    }).done((res) => {
      console.log('novo id', res.id);
    });

  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();
    //let self = this;

    $.get('/api/herois')
      .done(function (res) {
        let renderizar = marvelflix.render('.tela', 'tela-principal', {
          chars: res.map(function (item) {
            return {
              id: item.id,
              name: item.nome,
              thumbnail: item.urlThumbnail
            }
          })
        });
        //renderizar.then(self.registrarBindsEventos.bind(self));
        renderizar.then(() => {
          this.registrarBindsEventos(this);
        })
      }.bind(this));
  }

}
