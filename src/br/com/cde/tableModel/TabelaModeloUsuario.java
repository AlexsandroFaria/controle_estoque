/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.tableModel;

import br.com.cde.model.Usuario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloUsuario extends AbstractTableModel{

    public static final int COLUNA_CODIGO_USUARIO = 0;
    public static final int COLUNA_NOME_USUARIO = 1;
    public static final int COLUNA_EMAIL_USUARIO = 2;
    public static final int COLUNA_LOGIN_USUARIO = 3;
    public static final int COLUNA_SENHA_USUARIO = 4;
    public static final int COLUNA_LEMBRETE_SENHA_USUARIO = 5;
    public static final int COLUNA_PERMISSAO_ACESSO_USUARIO = 6;
    
    public ArrayList<Usuario>lista;

    public TabelaModeloUsuario(ArrayList<Usuario> lista) {
        this.lista = new ArrayList(lista);
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       Usuario usuario = lista.get(linha);
        if (coluna == COLUNA_CODIGO_USUARIO) return usuario.getCodigoUsuario();
        if (coluna == COLUNA_NOME_USUARIO) return usuario.getNome();
        if (coluna == COLUNA_EMAIL_USUARIO) return usuario.getEmail();
        if (coluna == COLUNA_LOGIN_USUARIO) return usuario.getLogin();
        if (coluna == COLUNA_SENHA_USUARIO) return usuario.getSenha();
        if (coluna == COLUNA_LEMBRETE_SENHA_USUARIO) return usuario.getLembreteSenha();
        if (coluna == COLUNA_PERMISSAO_ACESSO_USUARIO) return usuario.getPermissaoAcesso();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CODIGO_USUARIO) return "Código";
        if (coluna == COLUNA_NOME_USUARIO) return "Nome";
        if (coluna == COLUNA_EMAIL_USUARIO) return "E-mail";
        if (coluna == COLUNA_LOGIN_USUARIO) return "Login";
        if (coluna == COLUNA_SENHA_USUARIO) return "Senha";
        if (coluna == COLUNA_LEMBRETE_SENHA_USUARIO) return "Lembrete de senha";
        if (coluna == COLUNA_PERMISSAO_ACESSO_USUARIO) return "Permissão de Acesso";
        return "";
    }
    
    
}
