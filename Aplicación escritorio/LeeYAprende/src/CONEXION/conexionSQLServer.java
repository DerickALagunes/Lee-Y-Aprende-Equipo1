/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rosa
 */
public class conexionSQLServer {
    
    private static String ipAddress = "localhost";
    private static String dbName = "Biblioteca";
    private static String user = "sa";
    private static String password = "root";
    private static String service = "1433";
    
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://" + ipAddress + ":" + service + ";databaseName=" + dbName;
        return DriverManager.getConnection(url, user, password);
    }    
        public static void main(String[] args) throws SQLException {
        Connection con = conexionSQLServer.getConnection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
    
}
