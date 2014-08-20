/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Ejemplar;
import BEAN.Libro;
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
public class EjemplarDao {
    
    public boolean insertar(Ejemplar ejemplar, int idLibro){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO ejemplar (localizacion, libro_id) VALUES (?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);            
            pstm.setString(1, ejemplar.getLocalizacion());
            pstm.setInt(2, idLibro);

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
    
    public List<Ejemplar> consultar(){
        
        List<Ejemplar> ejemplares = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM info_ejemplares";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            int i =1;
            
            
            while(resultado.next()){
                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setIdEjemplar(i);
                
                Libro libro = new Libro();
                libro.setTitulo(resultado.getString(1));                
                ejemplar.setLibro(libro);

                ejemplar.setLocalizacion(resultado.getString(2));
                ejemplar.setNumeroEjemplares(resultado.getInt(3));
                ejemplar.setEstado(resultado.getBoolean(4));               
                ejemplares.add(ejemplar);
                i++;
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return ejemplares;
        
    }
  
    public boolean modificar(int id, String localizacion){
        
        boolean  status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE ejemplar SET localizacion = ? WHERE ejemplar_id=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, localizacion);
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
    
    public boolean eliminar(int idEjemplar){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE ejemplar SET estado = 0 WHERE ejemplar_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idEjemplar);
            
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
    
    public boolean recuperar(int idEjemplar){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE ejemplar SET estado = 1 WHERE ejemplar_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idEjemplar);
            
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
    
    public List<Ejemplar> consultaAvanzada(String busqueda){
                
        List<Ejemplar> ejemplares = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM info_ejemplares WHERE "
                    + "titulo LIKE '%"+busqueda+"%' OR localizacion LIKE '%"+busqueda+"%' ORDER BY Titulo";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Ejemplar ejemplar = new Ejemplar();
                
                Libro libro = new Libro();
                libro.setTitulo(resultado.getString(1));
                
                ejemplar.setLocalizacion(resultado.getString(2));
                ejemplar.setNumeroEjemplares(resultado.getInt(3));
                ejemplar.setEstado(resultado.getBoolean(4));
                ejemplar.setLibro(libro);
                ejemplares.add(ejemplar);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return ejemplares;  
        
    }
    
    public Ejemplar consultarPorId(int idEjemplar){
        
        Ejemplar ejemplar = new Ejemplar();
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT Titulo, Localizacion, NumeroDeEjemplares, Estado"
                    + " FROM info_ejemplares WHERE ID = ? AND Estado = 1";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setInt(1, idEjemplar);
            ResultSet resultado=pstm.executeQuery();

            while(resultado.next()){
                Libro libro = new Libro();
                libro.setTitulo(resultado.getString(1));
                
                ejemplar.setLocalizacion(resultado.getString(2));
                ejemplar.setNumeroEjemplares(resultado.getInt(3));
                ejemplar.setEstado(resultado.getBoolean(4));
                
                ejemplar.setLibro(libro);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return ejemplar;
        
        }
    
}
