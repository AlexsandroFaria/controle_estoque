/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.tableModel;

import br.com.cde.model.Lote;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloLote extends AbstractTableModel{

    public static final int COLUNA_CODIGO_LOTE = 0;
    public static final int COLUNA_LOTE_LOTE = 1;
    public static final int COLUNA_DESCRICAO_LOTE = 2;
    public ArrayList<Lote>lista;

    public TabelaModeloLote(ArrayList<Lote> lista) {
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
        Lote lote = lista.get(linha);
        if (coluna == COLUNA_CODIGO_LOTE) return lote.getCodigoLote();
        if (coluna == COLUNA_LOTE_LOTE) return lote.getLote();
        if (coluna == COLUNA_DESCRICAO_LOTE) return lote.getDescricao();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CODIGO_LOTE) return "Código";
        if (coluna == COLUNA_LOTE_LOTE) return "Lote";
        if (coluna == COLUNA_DESCRICAO_LOTE) return "Descrição";
        return "";
    }
    
    
}
