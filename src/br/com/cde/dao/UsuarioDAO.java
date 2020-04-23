/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.dao;

import br.com.cde.connection.ConnectionFactory;
import br.com.cde.model.Usuario;
import br.com.cde.view.TelaLogin;
import br.com.cde.view.TelaPrincipal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alafaria
 */
public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarUsuario(Usuario usuario) {
        try {
            String sql = "insert into tabela_usuario (nome_usuario, email_usuario, login_usuario, senha_usuario, lembrete_senha_usuario, permissao_acesso_usuario) values (?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getLembreteSenha());
            stmt.setString(6, usuario.getPermissaoAcesso());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

        } catch (SQLException erroSql) {
            throw new RuntimeException(erroSql);
        }
    }

    public Usuario consultarUsuariosPorNome(String nome) {
        try {
            String sql = "select * from tabela_usuario where nome_usuario = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            Usuario usuario = new Usuario();

            while (rs.next()) {
                usuario.setCodigoUsuario(rs.getInt("codigo_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setLogin(rs.getString("login_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setLembreteSenha(rs.getString("lembrete_senha_usuario"));
                usuario.setPermissaoAcesso(rs.getString("permissao_acesso_usuario"));
            }
            return usuario;
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(erroSql);
        }
    }

    public void excluirUsuario(Usuario usuario) {
        try {
            String sql = "delete from tabela_usuario where codigo_usuario = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getCodigoUsuario());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso.");
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar usuário!");
            throw new RuntimeException(erroSql);
        }
    }

    public void alterarUsuario(Usuario usuario) {
        try {
            String sql = "update tabela_usuario set nome_usuario=?, email_usuario=?, login_usuario=?, senha_usuario=?, lembrete_senha_usuario=?, permissao_acesso_usuario=? where codigo_usuario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getLembreteSenha());
            stmt.setString(6, usuario.getPermissaoAcesso());
            stmt.setInt(7, usuario.getCodigoUsuario());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");

        } catch (SQLException erroSql) {
            throw new RuntimeException(erroSql);
        }
    }

    public ArrayList<Usuario> listarUsuario() {
        String sql = "select * from tabela_usuario";
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigoUsuario(rs.getInt("codigo_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setLogin(rs.getString("login_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setLembreteSenha(rs.getString("lembrete_senha_usuario"));
                usuario.setPermissaoAcesso(rs.getString("permissao_acesso_usuario"));

                lista.add(usuario);
            }
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(erroSql);
        }
        return lista;
    }

    public ArrayList<Usuario> listarUsuarioPorNome(String nome) {
        String sql = "select * from tabela_usuario where nome_usuario like '%" + nome + "%' ";
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigoUsuario(rs.getInt("codigo_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setLogin(rs.getString("login_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setLembreteSenha(rs.getString("lembrete_senha_usuario"));
                usuario.setPermissaoAcesso(rs.getString("permissao_acesso_usuario"));
                lista.add(usuario);
            }

        } catch (SQLException erroSql) {
            throw new RuntimeException(erroSql);
        }
        return lista;
    }

    public void efetuarLogin(String login, String senha) {
        try {
            String sql = "select * from tabela_usuario where login_usuario = ? and senha_usuario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("permissao_acesso_usuario").equals("Administrador")) {
                    //caso usuário seja admin
                    JOptionPane.showMessageDialog(null, "Seja Bem Vindo!");
                    TelaPrincipal principal = new TelaPrincipal();

                    principal.usuarioLogado = rs.getString("nome_usuario");
                    principal.setVisible(true);
                } else if (rs.getString("permissao_acesso_usuario").equals("Usuario")) {
                    JOptionPane.showMessageDialog(null, "Seja Bem Vindo!");
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.usuarioLogado = rs.getString("nome_usuario");
                    principal.menuUsuario.setEnabled(false);
                    principal.submenuCadastrarCategoria.setEnabled(false);
                    principal.submenuCadastrarTamanho.setEnabled(false);
                    principal.submenuCadastrarTipo.setEnabled(false);
                    principal.submenuInserirLote.setEnabled(false);

                    principal.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e senha incorretos!");
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        }
    }
}
