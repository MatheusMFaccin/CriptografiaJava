/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author laboratorio
 */
public class ConnectionFactory {

    private Connection con;
    private final String url = "jdbc:mysql://localhost:3306/usuarios";
    private final String user = "root";
    private final String password = "1234";

    //método que retorna uma conexão
    public Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException e) {
            System.out.println("ERRO AO CONECTAR: " + e);
            return null;
        }
    }
}
