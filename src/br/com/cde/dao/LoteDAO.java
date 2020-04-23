/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.dao;

import br.com.cde.connection.ConnectionFactory;
import br.com.cde.model.Lote;
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
public class LoteDAO {
    
    private Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Statement st;
    
    public LoteDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarLote(Lote lote){
        try {
                String sql = "insert into tabela_lote (lote_lote, descricao_lote) values (?,?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, lote.getLote());
            stmt.setString(2, lote.getDescricao());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Lote cadastrado com sucesso!");
        } catch (SQLException sqlError) {
            throw new RuntimeException(sqlError);
        }
    }
    
    public ArrayList<Lote> listarLote(){
        String sql = "select * from tabela_lote";
        ArrayList<Lote>lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Lote lote = new Lote();
                lote.setCodigoLote(rs.getInt("codigo_lote"));
                lote.setLote(rs.getString("lote_lote"));
                lote.setDescricao(rs.getString("descricao_lote"));
                lista.add(lote);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta.");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }
    
    public void excluirLote(Lote lote){
        try {
            String sql = "delete from tabela_lote where codigo_lote = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, lote.getCodigoLote());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Lote excluido com sucesso.");
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar Lote.");
            throw new RuntimeException(sqlError);
        }
    }
}
