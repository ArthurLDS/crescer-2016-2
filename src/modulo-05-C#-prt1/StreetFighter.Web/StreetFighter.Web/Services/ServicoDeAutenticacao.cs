﻿using StreetFighter.dominio;
using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Services
{
    public class ServicoDeAutenticacao
    {
        private const string USUARIO_LOGADO_CHAVE = "USUARIO_LOGADO_CHAVE";
        public static void Autenticar(UsuarioLogadoModel model)
        {
            HttpContext.Current.Session[USUARIO_LOGADO_CHAVE] = model;
        }

        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO_CHAVE];
            }
        }

    }
}