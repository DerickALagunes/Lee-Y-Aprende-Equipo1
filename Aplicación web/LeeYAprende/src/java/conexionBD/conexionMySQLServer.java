/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PROFESOR
 */
public class conexionMySQLServer {

    // Parametros necesarios
    private static String ipAddress = "localhost"; //nota: localhost= 127.0.0.1
    private static String dbName = "Biblioteca";
    private static String user = "root";
    private static String password = "root";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://" + ipAddress + "/" + dbName;
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException {
        Connection con = conexionMySQLServer.getConnection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
}
