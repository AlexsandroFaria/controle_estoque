/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.tableModel;

import br.com.cde.model.Categoria;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloCategoria extends AbstractTableModel{

    public static final int COLUNA_CODIGO_CATEGORIA = 0;
    public static final int COLUNA_TAMANHO_CATEGORIA = 1;
    public static final int COLUNA_DESCRICAO_CATEGORIA = 2;
    public ArrayList<Categoria>lista;

    public TabelaModeloCategoria(ArrayList<Categoria> lista) {
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
        Categoria categoria = lista.get(linha);
        if (coluna == COLUNA_CODIGO_CATEGORIA) return categoria.getCodigoCategoria();
        if (coluna == COLUNA_TAMANHO_CATEGORIA) return categoria.getCategoria();
        if (coluna == COLUNA_DESCRICAO_CATEGORIA) return categoria.getDescricao();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CODIGO_CATEGORIA) return "Código";
        if (coluna == COLUNA_TAMANHO_CATEGORIA) return "Categoria";
        if (coluna == COLUNA_DESCRICAO_CATEGORIA) return "Descrição";
        return "";
    }
    
    
}
