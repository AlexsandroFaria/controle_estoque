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
public class Tamanho {
    
    private int codigoTamanho;
    private String tamanho;
    private String descricao;

    public int getCodigoTamanho() {
        return codigoTamanho;
    }

    public void setCódigoTamanho(int codigoTamanho) {
        this.codigoTamanho = codigoTamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getTamanho();
    }
    
    
    
}
