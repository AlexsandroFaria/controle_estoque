/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.model;

/**
 *
 * @author alafaria
 */
public class Usuario {
    
    private int codigoUsuario;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String lembreteSenha;
    private String permissaoAcesso;

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLembreteSenha() {
        return lembreteSenha;
    }

    public void setLembreteSenha(String lembreteSenha) {
        this.lembreteSenha = lembreteSenha;
    }

    public String getPermissaoAcesso() {
        return permissaoAcesso;
    }

    public void setPermissaoAcesso(String permissaoAcesso) {
        this.permissaoAcesso = permissaoAcesso;
    }
    
    
}
