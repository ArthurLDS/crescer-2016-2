$(function () {
    let nomeUser = $("#nomeUser"); 
    let emailUser = $("#EmailUser");
    let telefoneUser = $("#TelefoneUser");
    let cidadeUser = $("#CidadeUser");
    let cpfUser = $("#CpfUser");
    let datas = $("#selectData");

    let notificacao = $("#notificacao");

    $.getJSON('/Cadastro/ListarDatas', u => u.lista).done(
        function (listaResposta) {
            for (var i = 0; i < listaResposta.lista.length; i++) {
                datas.append("<option value= '" + listaResposta.listaId[i] + "' >" + listaResposta.lista[i] + "</option>");
            }
        });



    $("#btn-salvar").bind('click',
        function () {
            $.get('/Cadastro/Salvar', { nome: "" + nomeUser.val(), email: "" + emailUser.val(), telefone: "" + telefoneUser.val(), cidade: "" + cidadeUser.val(), cpf: "" + cpfUser.val(), dataId: "" + datas.val() + "" })
            .done(function () {
                if (cidadeUser.val() !== "" && telefoneUser.val() !== "") {
                    notificacao.css("display", "block")
                    alert("Cadastrado com SUCESSO!");
                }
                else{
                    notificacao.removeClass("alert-success");
                    notificacao.addClass("alert-danger");
                    notificacao.text("Preecha todos os campos!");
                }
             });
        });
});