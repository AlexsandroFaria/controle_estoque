/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.tableModel;

import br.com.cde.model.BaixaEstoque;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloBaixaEstoque extends AbstractTableModel{
    
    public static final int COLUNA_CODIGO_PRODUTO = 0;
    public static final int COLUNA_NOME_PRODUTO = 1;
    public static final int COLUNA_DESCRICAO_PRODUTO = 2;
    public static final int COLUNA_TAMANHO_PRODUTO = 3;
    public static final int COLUNA_VALOR_PRODUTO = 4;
    public static final int COLUNA_LOTE_PRODUTO = 5;
    public static final int COLUNA_TIPO_PRODUTO = 6;
    public static final int COLUNA_CATEGORIA_PRODUTO = 7;
    public static final int COLUNA_DATA_PRODUTO = 8;
    
    public ArrayList<BaixaEstoque>lista;
    
     public TabelaModeloBaixaEstoque(ArrayList<BaixaEstoque> lista) {
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
         BaixaEstoque baixaEstoque = lista.get(linha);
        if (coluna == COLUNA_CODIGO_PRODUTO) return baixaEstoque.getCodigoBaixaProduto();
        if (coluna == COLUNA_NOME_PRODUTO) return baixaEstoque.getNome();
        if (coluna == COLUNA_DESCRICAO_PRODUTO) return baixaEstoque.getDescricao();
        if (coluna == COLUNA_TAMANHO_PRODUTO) return baixaEstoque.getTamanho();
        if (coluna == COLUNA_VALOR_PRODUTO) return baixaEstoque.getValor();
        if (coluna == COLUNA_LOTE_PRODUTO) return baixaEstoque.getLote();
        if (coluna == COLUNA_TIPO_PRODUTO) return baixaEstoque.getTipo();
        if (coluna == COLUNA_CATEGORIA_PRODUTO) return baixaEstoque.getCategoria();
        if (coluna == COLUNA_DATA_PRODUTO) return baixaEstoque.getData();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CODIGO_PRODUTO) return "Código";
        if (coluna == COLUNA_NOME_PRODUTO) return "Nome";
        if (coluna == COLUNA_DESCRICAO_PRODUTO) return "Descrição";
        if (coluna == COLUNA_TAMANHO_PRODUTO) return "Tamanho";
        if (coluna == COLUNA_VALOR_PRODUTO) return "Valor";
        if (coluna == COLUNA_LOTE_PRODUTO) return "Lote";
        if (coluna == COLUNA_TIPO_PRODUTO) return "Tipo";
        if (coluna == COLUNA_CATEGORIA_PRODUTO) return "Categoria";
        if (coluna == COLUNA_DATA_PRODUTO) return "Data de Baixa";
        
        return "";
    }
}
