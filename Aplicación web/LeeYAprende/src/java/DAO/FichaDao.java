/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import conexionBD.conexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Derick
 */
public class FichaDao {
    
    public boolean insertar(int libro, int[] autor){
        boolean status = false;
        
        try{
            
            for (int i = 0; i < autor.length; i++) {
                
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO ficha (libro_id, autor_id) VALUES (?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            
            pstm.setInt(1, libro);
            pstm.setInt(2, autor[i]);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }
            
            pstm.close();
            conexion.close();
        
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;    
    }
    
    public boolean borrar(int libro){
        boolean status = false;
        
        try{
                
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "DELETE FROM ficha WHERE libro_id=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            
            pstm.setInt(1, libro);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }
            
            pstm.close();
            conexion.close();
        
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;    
    }
    
    
}
