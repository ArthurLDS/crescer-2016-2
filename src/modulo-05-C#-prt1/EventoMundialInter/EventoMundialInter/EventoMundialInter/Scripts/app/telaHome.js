let telaHome = {}

telaHome.renderizarListaDeEvento = function () {

    telaHome.listaDatas = $("#listaDatas");

    $.getJSON('/Home/ListarDatas', u => test = u.lista)
        .done(function (listaResposta) {
            for (var i = 0; i < listaResposta.lista.length; i++) {
                telaHome.listaDatas.append("<li class='list-group-item'><strong>Dia: " + moment(listaResposta.lista[i].Data).format('MMMM Do YYYY, h:mm:ss a') + "</strong> | Vagas: " + listaResposta.lista[i].Quantidade + " unidades</li>");
            }
        });
}


var emailUser = $("#txt-email");
var nomeUser = $("#txt-nome");

let notificacao = $("#notificacao");

telaHome.EnviarEmail =
    function () {

        if (emailUser.val() !== "" || nomeUser.val() !== "") {
            notificacao.css("display", "block");

            $.get('/Home/EnviaEmail', { email: emailUser.val(), nome: nomeUser.val() }).done(
                function () {

                    notificacao.removeClass("alert-danger");
                    notificacao.removeClass("alert-info");

                    notificacao.addClass("alert-success");
                    notificacao.text("Email eviando com sucesso!");
                });
        }

        else {
            if (notificacao.hasClass("alert-info")) {
                notificacao.removeClass("alert-info");
            }
            else {
                notificacao.removeClass("alert-success");
            }

            notificacao.addClass("alert-danger");
            notificacao.text("Preecha todos os campos!");
        }
    }

telaHome.configurarBotoes = function () {
    telaHome.$btnInscrever.click(telaHome.EnviarEmail);
}

telaHome.iniciar = function () {
    telaHome.renderizarListaDeEvento();

    telaHome.$btnInscrever = $("#btn-enviarEmail");

    telaHome.configurarBotoes();
}

$(function () {
    telaHome.iniciar();
});