/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.dao;

import br.com.cde.connection.ConnectionFactory;
import br.com.cde.model.Categoria;
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
public class CategoriaDAO {
    
    private Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Statement st;
    
    public CategoriaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCategoria(Categoria categoria){
        try {
                String sql = "insert into tabela_categoria (categoria_categoria, descricao_categoria) values (?,?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getCategoria());
            stmt.setString(2, categoria.getDescricao());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Categoria cadastrado com sucesso!");
        } catch (SQLException sqlError) {
            throw new RuntimeException(sqlError);
        }
    }
    
    public ArrayList<Categoria> listarCategoria(){
        String sql = "select * from tabela_categoria";
        ArrayList<Categoria>lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setCodigoCategoria(rs.getInt("codigo_categoria"));
                categoria.setCategoria(rs.getString("categoria_categoria"));
                categoria.setDescricao(rs.getString("descricao_categoria"));
                lista.add(categoria);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta.");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }
    
    public void excluirCategoria(Categoria categoria){
        try {
            String sql = "delete from tabela_categoria where codigo_categoria = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoria.getCodigoCategoria());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Categoria excluido com sucesso.");
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar categoria.");
            throw new RuntimeException(sqlError);
        }
    }
}
