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
public class Lote {
    
    private int codigoLote;
    private String lote;
    private String descricao;

    public int getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(int codigoLote) {
        this.codigoLote = codigoLote;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getLote();
    }
    
    
    
}
