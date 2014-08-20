/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Penalizacion;
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
public class PenalizacionDao {
    
    public boolean insertar(Penalizacion penalizacion){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO penalizacion (dias, monto) VALUES (?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);            
            pstm.setInt(1, penalizacion.getDias());
            pstm.setFloat(2, penalizacion.getMonto());
            
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
    
    public List<Penalizacion> consultar(){
        List<Penalizacion> penalizaciones = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM penalizacion";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Penalizacion penalizacion = new Penalizacion();
                penalizacion.setIdPenalizacion(resultado.getInt(1));
                penalizacion.setDias(resultado.getInt(2));
                penalizacion.setMonto(resultado.getFloat(3));
                penalizaciones.add(penalizacion);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return penalizaciones;
        
    }
    
    public boolean modificar(int id, Penalizacion penalizacion){
        
        boolean  status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE prestamo SET dias = ?, monto = ? WHERE penalizacion_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, penalizacion.getDias());
            pstm.setFloat(2, penalizacion.getMonto());
            pstm.setInt(3, id);
            
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
    
    public boolean eliminar(int idPenalizacion){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE penalizacion SET estado = 0 WHERE penalizacion_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idPenalizacion);
            
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
    
    public boolean recuperar(int idPenalizacion){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE areas SET estado = 1 WHERE areas_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idPenalizacion);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }                      
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return status;
        
    }
    
}
