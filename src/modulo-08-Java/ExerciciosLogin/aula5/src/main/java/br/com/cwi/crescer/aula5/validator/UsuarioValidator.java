/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.validator;

import br.com.cwi.crescer.aula5.bean.UserBean;
import br.com.cwi.crescer.aula5.filters.User;
import br.com.cwi.crescer.aula5.mbean.CadastroMBean;
import static br.com.cwi.crescer.aula5.utils.FacesUtils.getContext;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;

/**
 *
 * @author Arthur
 */
public class UsuarioValidator implements Validator{
    
    UserBean userB = new UserBean();
    
    @Override
    public void validate(FacesContext contexto, UIComponent componente, Object value) throws ValidatorException {
        if(value.equals(null) || !userB.findByUsername(value.toString())){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario já cadastrado! ", "");
            getContext().addMessage(componente.getId(), facesMessage);
        }
    }

    
}
