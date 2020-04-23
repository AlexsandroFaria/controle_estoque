/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.dao;

import br.com.cde.connection.ConnectionFactory;
import br.com.cde.model.Tipo;
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
public class TipoDAO {
    
    private Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Statement st;
    
    public TipoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarTipo(Tipo tipo){
        try {
                String sql = "insert into tabela_tipo (tipo_tipo, descricao_tipo) values (?,?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tipo.getTipo());
            stmt.setString(2, tipo.getDescricao());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tipo cadastrado com sucesso!");
        } catch (SQLException sqlError) {
            throw new RuntimeException(sqlError);
        }
    }
    
    public ArrayList<Tipo> listarTipo(){
        String sql = "select * from tabela_tipo";
        ArrayList<Tipo>lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Tipo tipo = new Tipo();
                tipo.setCodigoTipo(rs.getInt("codigo_tipo"));
                tipo.setTipo(rs.getString("tipo_tipo"));
                tipo.setDescricao(rs.getString("descricao_tipo"));
                lista.add(tipo);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta.");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }
    
    public void excluirTipo(Tipo tipo){
        try {
            String sql = "delete from tabela_tipo where codigo_tipo = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tipo.getCodigoTipo());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tipo excluido com sucesso.");
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Tipo.");
            throw new RuntimeException(sqlError);
        }
    }
}
