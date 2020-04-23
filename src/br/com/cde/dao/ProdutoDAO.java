/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.dao;

import br.com.cde.connection.ConnectionFactory;
import br.com.cde.model.Produtos;
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
public class ProdutoDAO {

    private Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    Statement st;

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarProduto(Produtos produto) {
        try {
            String sql = "insert into tabela_produto (nome_produto, descricao_produto, tamanho_produto, valor_produto, lote_produto, tipo_produto, categoria_produto, quantidade_produto) values (?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setString(3, produto.getTamanho());
            stmt.setDouble(4, produto.getValor());
            stmt.setString(5, produto.getLote());
            stmt.setString(6, produto.getTipo());
            stmt.setString(7, produto.getCategoria());
            stmt.setInt(8, produto.getQuantidade());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException sqlError) {
            throw new RuntimeException(sqlError);
        }
    }

    public ArrayList<Produtos> listarProdutos() {
        String sql = "select * from tabela_produto";
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setCodigoProduto(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setTamanho(rs.getString("tamanho_produto"));
                produto.setValor(rs.getDouble("valor_produto"));
                produto.setLote(rs.getString("lote_produto"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setCategoria(rs.getString("categoria_produto"));
                produto.setQuantidade(rs.getInt("quantidade_produto"));
                lista.add(produto);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }

    public void excluirProduto(Produtos produto) {
        try {
            String sql = "delete from tabela_produto where codigo_produto = ?";

            int imput = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir permanentemente este item?");
            if (imput == JOptionPane.YES_OPTION) {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, produto.getCodigoProduto());
                stmt.execute();
                stmt.close();
            }

        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto");
            throw new RuntimeException(sqlError);
        }

    }

    public void alterarProduto(Produtos produto) {
        try {
            String sql = "update tabela_produto set nome_produto=?, descricao_produto=?, tamanho_produto=?, valor_produto=?, lote_produto=?, tipo_produto=?, categoria_produto=?, quantidade_produto=? where codigo_produto=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setString(3, produto.getTamanho());
            stmt.setDouble(4, produto.getValor());
            stmt.setString(5, produto.getLote());
            stmt.setString(6, produto.getTipo());
            stmt.setString(7, produto.getCategoria());
            stmt.setInt(8, produto.getQuantidade());
            stmt.setInt(9, produto.getCodigoProduto());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar produto");
            throw new RuntimeException(sqlError);
        }
    }

    public ArrayList<Produtos> listarProdutoPorNome(String pesquisa) {

        String sql = "select * from tabela_produto where nome_produto like '%" + pesquisa + "%' ";
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setCodigoProduto(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setTamanho(rs.getString("tamanho_produto"));
                produto.setValor(rs.getDouble("valor_produto"));
                produto.setLote(rs.getString("lote_produto"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setCategoria(rs.getString("categoria_produto"));
                produto.setQuantidade(rs.getInt("quantidade_produto"));
                lista.add(produto);
            }
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(erroSql);
        }
        return lista;
    }

    public ArrayList<Produtos> listarProdutosPorLote(String lote) {
        String sql = "select * from tabela_produto where lote_produto like '%" + lote + "%'";
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setCodigoProduto(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setTamanho(rs.getString("tamanho_produto"));
                produto.setValor(rs.getDouble("valor_produto"));
                produto.setLote(rs.getString("lote_produto"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setCategoria(rs.getString("categoria_produto"));
                produto.setQuantidade(rs.getInt("quantidade_produto"));
                lista.add(produto);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }

    public ArrayList<Produtos> listarProdutosPorTamanho(String tamanho) {
        String sql = "select * from tabela_produto where tamanho_produto like '%" + tamanho + "%'";
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setCodigoProduto(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setTamanho(rs.getString("tamanho_produto"));
                produto.setValor(rs.getDouble("valor_produto"));
                produto.setLote(rs.getString("lote_produto"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setCategoria(rs.getString("categoria_produto"));
                produto.setQuantidade(rs.getInt("quantidade_produto"));
                lista.add(produto);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }

    public ArrayList<Produtos> listarProdutosPorCategoria(String Categoria) {
        String sql = "select * from tabela_produto where Categoria_produto like '%" + Categoria + "%'";
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setCodigoProduto(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setTamanho(rs.getString("tamanho_produto"));
                produto.setValor(rs.getDouble("valor_produto"));
                produto.setLote(rs.getString("lote_produto"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setCategoria(rs.getString("categoria_produto"));
                produto.setQuantidade(rs.getInt("quantidade_produto"));
                lista.add(produto);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }

    public ArrayList<Produtos> listarProdutosPorTipo(String tipo) {
        String sql = "select * from tabela_produto where tipo_produto like '%" + tipo + "%'";
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produtos produto = new Produtos();
                produto.setCodigoProduto(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao_produto"));
                produto.setTamanho(rs.getString("tamanho_produto"));
                produto.setValor(rs.getDouble("valor_produto"));
                produto.setLote(rs.getString("lote_produto"));
                produto.setTipo(rs.getString("tipo_produto"));
                produto.setCategoria(rs.getString("categoria_produto"));
                produto.setQuantidade(rs.getInt("quantidade_produto"));
                lista.add(produto);
            }
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro na consulta");
            throw new RuntimeException(sqlError);
        }
        return lista;
    }

    public void incluirQuantidade(Produtos produto) {
        try {
            String sql = "update tabela_produto set quantidade_produto=? where codigo_produto = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getQuantidade());
            stmt.setInt(2, produto.getCodigoProduto());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Quantidade inseridade com sucesso!");
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto!");
            throw new RuntimeException(sqlError);
        }
    }

    public void decrementarQuantidade(Produtos produto) {
        try {
            String sql = "update tabela_produto set quantidade_produto=? where codigo_produto = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getQuantidade());
            stmt.setInt(2, produto.getCodigoProduto());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Quantidade retirada com sucesso!");
        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto!");
            throw new RuntimeException(sqlError);
        }
    }

    public void excluirProdutoDeBaixa(Produtos produto) {
        try {
            String sql = "delete from tabela_produto where codigo_produto = ?";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getCodigoProduto());
            stmt.execute();
            stmt.close();

        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto");
            throw new RuntimeException(sqlError);
        }
    }
}
