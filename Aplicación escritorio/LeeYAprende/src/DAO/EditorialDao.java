/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Editorial;
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
public class EditorialDao {
    
    public boolean insertar(Editorial editorial){ 
        
        boolean status=false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO editorial (nombre) values (?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);                
            pstm.setString(1, editorial.getNombre());
               
            if (pstm.executeUpdate()==1) {
                status=true;
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
            String Query = "SELECT nombre FROM editorial WHERE nombre = ?";
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
    
    public List<Editorial> consultar(){
    
        List<Editorial> editoriales=new ArrayList<Editorial>();
        
        try{            
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM editorial";
            PreparedStatement pstm = conexion.prepareStatement(Query);          
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){                
                Editorial editorial=new Editorial();
                editorial.setIdEditorial(resultado.getInt("editorial_id"));
                editorial.setNombre(resultado.getString("nombre"));
                editorial.setEstado(resultado.getBoolean("estado"));
                editoriales.add(editorial);
            }
                
            resultado.close();
            pstm.close();
            conexion.close();            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return editoriales;
        
    }
    
    public boolean modificar(int idEditorial, Editorial editorial){
        
        boolean status=false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE editorial SET nombre = ? WHERE "
                    + "editorial_id="+idEditorial+"";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, editorial.getNombre());
                
            if (pstm.executeUpdate()==1) {
                status=true;
            }
                
            pstm.close();
            conexion.close();
                
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        return status;
            
    }
    
    public boolean eliminar(int idEditorial){
        
        boolean status=false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query="UPDATE editorial SET estado = 0 WHERE editorial_id ="+idEditorial;
            PreparedStatement pstm = conexion.prepareStatement(Query);
                
            if (pstm.executeUpdate()==1) {
                status=true;
            }
            
            pstm.close();
            conexion.close();
                
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        return status;
    }
    
    public boolean recuperar(int idEditorial){
        
        boolean status=false;
            
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE editorial SET estado = 1 WHERE editorial_id ="+idEditorial;
            PreparedStatement pstm = conexion.prepareStatement(Query);
                
            if (pstm.executeUpdate()==1) {
                status=true;
            }
            
            pstm.close();
            conexion.close();
                
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        return status;
        
    }
    
    public List<String> consultarNombre(){  
        
        List<String> editoriales = new ArrayList<>();        
        
        try{            
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombre FROM editorial WHERE estado = 1 ORDER BY nombre";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                String editorial = resultado.getString(1);
                editoriales.add(editorial);
            }
                
            resultado.close();
            pstm.close();
            conexion.close();           
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return editoriales;
        
    }
        
    public Editorial consultarPorId(int idEditorial){
        
        Editorial editorial = new Editorial();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT nombre FROM editorial WHERE editorial_id = ?";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setInt(1, idEditorial);
            ResultSet resultado=pstm.executeQuery();
            
            
            while(resultado.next()){
                editorial.setIdEditorial(idEditorial);
                editorial.setNombre(resultado.getString(1));
            }
            
            pstm.close();
            conexion.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return editorial;
    
    }
    
    public Editorial consultarPorNombre(String  nombre){
        
        Editorial editorial = new Editorial();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT editorial_id FROM editorial WHERE nombre = ? AND estado = 1";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            ResultSet resultado=pstm.executeQuery();
            
            
            while(resultado.next()){
                editorial.setNombre(nombre);
                editorial.setIdEditorial(resultado.getInt(1));
            }
            
            pstm.close();
            conexion.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return editorial;
    
    }
    
    public String consultarEditorialLibro(int idEditorial){
        
        String editorial = new String();   
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombre FROM editorial WHERE editorial_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idEditorial);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                editorial = resultado.getString(1);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return editorial;
        
    }
    
    public List<Editorial> consultaAvanzada(String busqueda){
                
        List<Editorial> editoriales = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT editorial_id, nombre, estado FROM editorial "
                    + "WHERE nombre LIKE '%"+busqueda+"%' ORDER BY nombre";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Editorial editorial = new Editorial();
                editorial.setIdEditorial(resultado.getInt(1));
                editorial.setNombre(resultado.getString(2));
                editorial.setEstado(resultado.getBoolean(3));
                editoriales.add(editorial);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return editoriales;  
        
    }
    
}
