/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import CONEXION.conexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rosa
 */
public class LoginDao {
    
    public String login(String user, String password){
        
        String respuesta = "";
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT Administrador FROM usuario WHERE email = ? AND pass = ? AND mostrar = 1";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, user);
            pstm.setString(2, password);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                if(resultado.getInt(1) == 1){
                    respuesta = "Administrador";                    
                }else{
                    respuesta = "Usuario";
                }
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       return respuesta;
       
    }
    
}
