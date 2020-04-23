/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.tableModel;

import br.com.cde.model.Tipo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloTipo extends AbstractTableModel{

    public static final int COLUNA_CODIGO_TIPO = 0;
    public static final int COLUNA_TAMANHO_TIPO = 1;
    public static final int COLUNA_DESCRICAO_TIPO = 2;
    public ArrayList<Tipo>lista;

    public TabelaModeloTipo(ArrayList<Tipo> lista) {
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Tipo tipo = lista.get(linha);
        if (coluna == COLUNA_CODIGO_TIPO) return tipo.getCodigoTipo();
        if (coluna == COLUNA_TAMANHO_TIPO) return tipo.getTipo();
        if (coluna == COLUNA_DESCRICAO_TIPO) return tipo.getDescricao();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CODIGO_TIPO) return "Código";
        if (coluna == COLUNA_TAMANHO_TIPO) return "Tamanho";
        if (coluna == COLUNA_DESCRICAO_TIPO) return "Descrição";
        return "";
    }
    
    
}
