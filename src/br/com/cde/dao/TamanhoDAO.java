/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.dao;

import br.com.cde.connection.ConnectionFactory;
import br.com.cde.model.Tamanho;
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
public class TamanhoDAO {
    
    private Connection con;
    Tamanho tamanho = new Tamanho();
    PreparedStatement stmt;
    ResultSet rs;
    Statement st;
    
    public TamanhoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarTamanho(Tamanho tamanho){
        try {
            String sql = "insert into tabela_tamanho (tamanho_tamanho, descricao_tamanho) values (?,?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tamanho.getTamanho());
            stmt.setString(2, tamanho.getDescricao());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tamanho de peça cadastrado com sucesso!");
        } catch (SQLException sqlError) {
            throw new RuntimeException(sqlError);
        }
    }
    
    public ArrayList<Tamanho> listarTamanho(){
        String sql = "select * from tabela_tamanho";
        ArrayList<Tamanho>lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Tamanho tamanho = new Tamanho();
                tamanho.setCódigoTamanho(rs.getInt("codigo_tamanho"));
                tamanho.setTamanho(rs.getString("tamanho_tamanho"));
                tamanho.setDescricao(rs.getString("descricao_tamanho"));
                lista.add(tamanho);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta.");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }
    
    public void excluirTamanho(Tamanho tamanho){
        try {
            String sql = "delete from tabela_tamanho where codigo_tamanho = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, tamanho.getCodigoTamanho());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tamanho de Peça excluido com sucesso.");
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar tamanho de Peça");
            throw new RuntimeException(sqlError);
        }
    }
}
