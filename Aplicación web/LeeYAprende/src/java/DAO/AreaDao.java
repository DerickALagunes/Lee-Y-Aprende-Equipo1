/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Area;
import conexionBD.conexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rosa
 */
public class AreaDao {
    
    
        public int consultarid(String nombre){
        int id = 0;    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT areas_id FROM areas WHERE nombrearea=?"; 
            PreparedStatement pstm = conexion.prepareStatement(Query);
            
            pstm.setString(1, nombre);
            
            
            ResultSet resultado = pstm.executeQuery();
            
            

            while(resultado.next()){  
                id=resultado.getInt(1); 
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    }
    
    public boolean insertar(String nombre){
        boolean status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO areas (nombrearea) VALUES (?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            
            pstm.setString(1, nombre);

            
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
    
    public List<Area> consultar(){
        List<Area> areas = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM areas ORDER BY nombrearea";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Area area = new Area();
                area.setIdAreas(resultado.getInt(1));
                area.setNombreArea(resultado.getString(2));
                area.setEstado(resultado.getBoolean(3));    
                areas.add(area);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return areas;
    }
    
    public boolean modificar(int id, String nombre){
        boolean  status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE areas SET nombrearea = ? WHERE areas_id=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            pstm.setInt(2, id);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return status;
    }
    
    public boolean eliminar(int idArea){
        boolean status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE areas SET estado = 0 WHERE areas_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idArea);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }           
            
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean recuperar(int idArea){
        boolean status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE areas SET estado = 1 WHERE areas_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idArea);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }           
            
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    
}
