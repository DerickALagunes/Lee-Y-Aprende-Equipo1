/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Area;
import CONEXION.conexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosa
 */
public class AreaDao {
    
    public boolean insertar(Area area){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO areas (nombrearea) VALUES (?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);            
            pstm.setString(1, area.getNombreArea());

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
    
    public boolean existe(String nombre){
        
        boolean existe = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombrearea FROM areas WHERE nombrearea = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                existe= true;
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return existe;
        
    }
    
    public List<Area> consultar(){
        
        List<Area> areas = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM areas";
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
    
    public boolean modificar(int id, Area area){
        
        boolean  status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE areas SET nombrearea = ? WHERE areas_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, area.getNombreArea());
            pstm.setInt(2, id);
            
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
            
            pstm.close();
            conexion.close();
        
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
            
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return status;
        
    }
    
    public List<String> consultarNombre(){
        
        List<String> areas = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombrearea FROM areas WHERE estado = 1 ORDER BY nombrearea";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                String area = resultado.getString(1);
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
    
    public Area consultarPorId(int idArea){
        
        Area area = new Area();
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT nombrearea FROM areas WHERE areas_id = ?";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setInt(1, idArea);
            ResultSet resultado=pstm.executeQuery();

            while(resultado.next()){
                area.setIdAreas(idArea);
                area.setNombreArea(resultado.getString(1));
            }
            
            resultado.close();
            pstm.close();
            conexion.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return area;
        
        }
    
    public Area consultarPorNombre(String  nombre){
        
        Area area = new Area();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT areas_id FROM areas WHERE nombreArea = ? AND "
                    + "estado = 1";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            ResultSet resultado=pstm.executeQuery();
            
            
            while(resultado.next()){
                area.setNombreArea(nombre);
                area.setIdAreas(resultado.getInt(1));
            }
            
            pstm.close();
            conexion.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return area;
    
    }
    
    public String consultarAreaLibro(int idArea){
        
        String area = new String();   
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombrearea FROM areas WHERE areas_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idArea);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                area = resultado.getString(1);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return area;
        
    }
    
    public List<Area> consultaAvanzada(String busqueda){
                
        List<Area> areas = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT areas_id, nombrearea, estado FROM areas "
                    + "WHERE nombrearea LIKE '%"+busqueda+"%' ORDER BY nombrearea";
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
    
}
