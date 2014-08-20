/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Area;
import BEAN.Autor;
import BEAN.Editorial;
import BEAN.Libro;
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
public class LibroDao {
    
    public int consultarid(String titulo){
        int id = 0;    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT libro_id FROM libro WHERE titulo=?"; //regresa el ultimo libro ingresado
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, titulo);
            
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
    
     public boolean insertar(String isbn, String titulo, int pags, int area, int editorial,int[] idautor){
        boolean status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO libro (ISBN, titulo, numpag, areas_id, editorial_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, isbn);
            pstm.setString(2, titulo);
            pstm.setInt(3, pags);
            pstm.setInt(4, area);
            pstm.setInt(5, editorial);
            
            if(pstm.executeUpdate() == 1){
                status = true;
                
               int idlibro = consultarid(titulo);
            
            FichaDao ficha = new FichaDao();
            ficha.insertar(idlibro, idautor);
                
            }
 
            
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;    
    }
      
    public boolean modificar(String isbn, String titulo, int pags, int area, int editorial,int[] idautor,int id){
        boolean  status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE libro SET ISBN=?, titulo=?, numpag=?, areas_id=?, editorial_id=? WHERE libro_id=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, isbn);
            pstm.setString(2, titulo);
            pstm.setInt(3, pags);
            pstm.setInt(4, area);
            pstm.setInt(5, editorial);
            pstm.setInt(6, id);
                      
            if(pstm.executeUpdate() == 1){
                status = true;
                
            int idlibro = consultarid(titulo);
            
            FichaDao ficha = new FichaDao();
            ficha.borrar(idlibro);
            ficha.insertar(idlibro, idautor);
                
            }
        
            pstm.close();
            conexion.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return status;
    }
    
    public boolean eliminar(int idLibro){
        boolean status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE libro SET mostar = 0 WHERE libro_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idLibro);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }                      
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    
    public boolean recuperar(int idLibro){
        boolean status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE libro SET mostar = 1 WHERE libro_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idLibro);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }                      
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    
        //regresa todos los datos de un libro
    public List<Libro> consultar(){
        List<Libro> libros = new ArrayList<>();    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT ISBN, titulo, numpag,autor.nombre,apellidoPaterno,editorial.nombre,nombrearea,libro.mostar,libro.libro_id,editorial.estado,areas.estado,autor.mostrar FROM libro "
                    + "join editorial on libro.editorial_id=editorial.editorial_id "
                    + "join areas on areas.areas_id=libro.areas_id "
                    + "join ficha on ficha.libro_id=libro.libro_id "
                    + "join autor on ficha.autor_id=autor.autor_id";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Libro libro = new Libro();
                libro.setIsbn(resultado.getString(1));
                libro.setTitulo(resultado.getString(2));
                libro.setNum_paginas(resultado.getInt(3));
                
                Autor autor = new Autor();
                autor.setNombre(resultado.getString(4));
                autor.setApaterno(resultado.getString(5));
                autor.setEstado(resultado.getBoolean(12));
                
                Editorial editorial = new Editorial();
                editorial.setNombre(resultado.getString(6));
                editorial.setEstado(resultado.getBoolean(10));
                
                Area area = new Area ();
                area.setNombreArea(resultado.getString(7));
                area.setEstado(resultado.getBoolean(11));
                
                
                libro.setMostrar(resultado.getBoolean(8));
                libro.setIdLibro(resultado.getInt(9));
                
                libro.setAutor(autor);
                libro.setEditorial(editorial);
                libro.setArea(area);
               
                libros.add(libro);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return libros;
    }
    
    //regresa tambien el id del libro y su estado
    public List<Libro> consultarAdmin(){ 
        List<Libro> libros = new ArrayList<>();    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT ISBN, titulo,autor.nombre,apellidoPaterno, libro.mostar, libro.libro_id FROM libro "
                    + "join ficha on ficha.libro_id=libro.libro_id "
                    + "join autor on ficha.autor_id=autor.autor_id";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Libro libro = new Libro();
                libro.setIsbn(resultado.getString(1));
                libro.setTitulo(resultado.getString(2));
                
                Autor autor = new Autor();
                autor.setNombre(resultado.getString(3));
                autor.setApaterno(resultado.getString(4));
                
                libro.setAutor(autor);
                
                libro.setMostrar(resultado.getBoolean(5));
                libro.setIdLibro(resultado.getInt(6));
                
                
               
                libros.add(libro);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return libros;
    }
    
}
