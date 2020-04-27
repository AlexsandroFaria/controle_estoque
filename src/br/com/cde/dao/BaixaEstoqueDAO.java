/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.dao;

import br.com.cde.connection.ConnectionFactory;
import br.com.cde.model.BaixaEstoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author alafaria
 */
public class BaixaEstoqueDAO {
    
    private Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Statement st;

    public BaixaEstoqueDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarProdutoBaixa(BaixaEstoque baixaEstoque) {
        try {
            String sql = "insert into tabela_baixa_estoque (nome_be, descricao_be, tamanho_be, valor_be, lote_be, tipo_be, categoria_be, data_be) values (?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, baixaEstoque.getNome());
            stmt.setString(2, baixaEstoque.getDescricao());
            stmt.setString(3, baixaEstoque.getTamanho());
            stmt.setDouble(4, baixaEstoque.getValor());
            stmt.setString(5, baixaEstoque.getLote());
            stmt.setString(6, baixaEstoque.getTipo());
            stmt.setString(7, baixaEstoque.getCategoria());
            stmt.setString(8, baixaEstoque.getData());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Baixa de estoque executada!");
        } catch (SQLException sqlError) {
            throw new RuntimeException(sqlError);
        }
    }
    
    
    public ArrayList<BaixaEstoque> listarProdutoPorNome(String pesquisa) {

        String sql = "select codigo_be, nome_be, descricao_be, tamanho_be, valor_be, lote_be, tipo_be, categoria_be, DATE_FORMAT(data_be,'%d/%m/%Y') as data_be from tabela_baixa_estoque where nome_be like '%" + pesquisa + "%' ";
        ArrayList<BaixaEstoque> lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                BaixaEstoque baixaEstoque = new BaixaEstoque();
                baixaEstoque.setCodigoBaixaProduto(rs.getInt("codigo_be"));
                baixaEstoque.setNome(rs.getString("nome_be"));
                baixaEstoque.setDescricao(rs.getString("descricao_be"));
                baixaEstoque.setTamanho(rs.getString("tamanho_be"));
                baixaEstoque.setValor(rs.getDouble("valor_be"));
                baixaEstoque.setLote(rs.getString("lote_be"));
                baixaEstoque.setTipo(rs.getString("tipo_be"));
                baixaEstoque.setCategoria(rs.getString("categoria_be"));
                baixaEstoque.setData(rs.getString("data_be"));
                lista.add(baixaEstoque);
            }
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(erroSql);
        }
        return lista;
    }

    public ArrayList<BaixaEstoque> listarProdutoBaixa() {
        String sql = "select codigo_be, nome_be, descricao_be, tamanho_be, valor_be, lote_be, tipo_be, categoria_be, DATE_FORMAT(data_be,'%d/%m/%Y') as data_be from tabela_baixa_estoque";
        ArrayList<BaixaEstoque> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                BaixaEstoque baixaEstoque = new BaixaEstoque();
                baixaEstoque.setCodigoBaixaProduto(rs.getInt("codigo_be"));
                baixaEstoque.setNome(rs.getString("nome_be"));
                baixaEstoque.setDescricao(rs.getString("descricao_be"));
                baixaEstoque.setTamanho(rs.getString("tamanho_be"));
                baixaEstoque.setValor(rs.getDouble("valor_be"));
                baixaEstoque.setLote(rs.getString("lote_be"));
                baixaEstoque.setTipo(rs.getString("tipo_be"));
                baixaEstoque.setCategoria(rs.getString("categoria_be"));
                baixaEstoque.setData(rs.getString("data_be"));
                
                lista.add(baixaEstoque);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }
}
