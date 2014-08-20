/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Ejemplar;
import BEAN.Penalizacion;
import BEAN.Prestamo;
import BEAN.Usuario;
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
public class PrestamoDao {
    
    public boolean insertar(Prestamo prestamo){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO prestamo (fecha_prestamo, fecha_devolucion) VALUES (?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);            
            pstm.setString(1, prestamo.getFecha_prestamo());
            pstm.setString(2, prestamo.getFecha_devolucion());
            
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
    
    public List<Prestamo> consultar(){
        
        List<Prestamo> prestamos = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM prestamo WHERE estado = 1";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Prestamo prestamo = new Prestamo();                
                prestamo.setIdPrestamo(resultado.getInt(1));                
                prestamo.setFecha_prestamo(resultado.getString(2));
                prestamo.setFecha_devolucion(resultado.getString(3));
                prestamo.setEstado(resultado.getBoolean(4));
                
                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setIdEjemplar(resultado.getInt(5));
                
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt(6));
                
                Penalizacion penalizacion = new Penalizacion();
                penalizacion.setIdPenalizacion(resultado.getInt(7));
                
                prestamo.setEjemplar(ejemplar);
                prestamo.setUsuario(usuario);
                prestamo.setPenalizaion(penalizacion);                
                
                prestamos.add(prestamo);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return prestamos;
    
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
            
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return status;
    
    }
    
    public boolean eliminar(int idPrestamo){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE prestamo SET estado = 0 WHERE prestamo_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idPrestamo);
            
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
    
    public boolean recuperar(int idPrestamo){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE prestamo SET estado = 1 WHERE prestamo_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idPrestamo);
            
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
