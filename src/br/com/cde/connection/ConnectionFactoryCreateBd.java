/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cde.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alafaria
 */
public class ConnectionFactoryCreateBd {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost?useTimezone=true&serverTimezone=UTC", "root", "root");
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
}
