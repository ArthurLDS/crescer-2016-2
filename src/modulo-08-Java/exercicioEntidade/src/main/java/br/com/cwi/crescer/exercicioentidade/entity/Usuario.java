/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicioentidade.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")

public class Usuario {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;
    
    @Basic(optional = false)
    @Column(name = "DS_SENHA")
    private String dsSenha;
    
    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;
    
    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;
    
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nmUsuario;
    
    @Basic(optional = false)
    @Column(name = "TP_PERMISSION")
    private String tpPermission;

    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public String getTpPermission() {
        return tpPermission;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public void setTpPermission(String tpPermission) {
        this.tpPermission = tpPermission;
    }
    
    
}
