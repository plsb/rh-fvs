/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.os.rh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados...");
        try {
            return DriverManager.getConnection("jdbc:mysql://192.168.3.38/rh",  //192.168.3.38
                    "root", "040908");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
