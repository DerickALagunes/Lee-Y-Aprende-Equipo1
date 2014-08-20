/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Autor;
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
public class AutorDao {
    
        public int consultarid(String nombre){
        int id = 0;    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT autor_id FROM autor WHERE nombre=?"; //regresa el ultimo libro ingresado
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
    
    
    public boolean insertar(String nombre,String paterno, String materno){
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO autor (nombre, apellidoPaterno, apellidoMaterno) VALUES (?, ?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            pstm.setString(2, paterno);
            pstm.setString(3, materno);
                    
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
    
    public List<Autor> consultar(){
        List<Autor> autores = new ArrayList<>();    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM autor";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Autor autor = new Autor();
                autor.setIdAutor(resultado.getInt(1));
                autor.setNombre(resultado.getString(2));
                autor.setApaterno(resultado.getString(3));
                autor.setAMaterno(resultado.getString(4));
                autor.setEstado(resultado.getBoolean(5));
                autores.add(autor);
                
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return autores;
    }
    
    public boolean modificar(String nombre,String paterno, String materno, int id){
        boolean  status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE autor SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ? WHERE autor_id=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            
            pstm.setString(1, nombre);
            pstm.setString(2, paterno);
            pstm.setString(3, materno);
            pstm.setInt(4, id);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return status;
    }
    
    public boolean eliminar(int idAutor){
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE autor SET mostrar = 0 WHERE autor_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idAutor);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }           
            
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean recuperar(int idAutor){
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE autor SET mostrar = 1 WHERE autor_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idAutor);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }           
            
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    
}
