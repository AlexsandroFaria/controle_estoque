/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.tableModel;

import br.com.cde.model.Tamanho;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloTamanho extends AbstractTableModel{

    public static final int COLUNA_CODIGO = 0;
    public static final int COLUNA_TAMANHO = 1;
    public static final int COLUNA_DESCRICAO = 2;
    public ArrayList<Tamanho>lista;

    public TabelaModeloTamanho(ArrayList<Tamanho> lista) {
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
        Tamanho tamanho = lista.get(linha);
        if (coluna == COLUNA_CODIGO) return tamanho.getCodigoTamanho();
        if (coluna == COLUNA_TAMANHO) return tamanho.getTamanho();
        if (coluna == COLUNA_DESCRICAO) return tamanho.getDescricao();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CODIGO) return "Código";
        if (coluna == COLUNA_TAMANHO) return "Tamanho";
        if (coluna == COLUNA_DESCRICAO) return "Descrição";
        return "";
    }
    
    
}
