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
public class LibroDao {
    
    public boolean insertar(Libro libro){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO libro (ISBN, titulo, numpag, editorial_id, "
                    + "areas_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);            
            pstm.setString(1, libro.getIsbn());
            pstm.setString(2, libro.getTitulo());
            pstm.setInt(3, libro.getNum_paginas());
            pstm.setInt(4, libro.getEditorial().getIdEditorial());
            pstm.setInt(5, libro.getArea().getIdAreas());

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
    
    public List<Libro> consultar(){
        List<Libro> libros = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT ISBN, titulo, numpag, autor.nombre, "
                    + "apellidoPaterno, apellidoMaterno, editorial.nombre, "
                    + "nombrearea, libro.mostar,libro.libro_id FROM libro "
                    + "JOIN editorial ON libro.editorial_id = editorial.editorial_id "
                    + "JOIN areas ON areas.areas_id = libro.areas_id "
                    + "JOIN ficha ON ficha.libro_id = libro.libro_id "
                    + "JOIN autor ON ficha.autor_id = autor.autor_id "
                    + "WHERE libro.mostar = 1;";
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
                autor.setAMaterno(resultado.getString(6));
                
                Editorial editorial = new Editorial();
                editorial.setNombre(resultado.getString(7));
                
                Area area = new Area ();
                area.setNombreArea(resultado.getString(8));
                
                libro.setMostrar(resultado.getBoolean(9));
                libro.setIdLibro(resultado.getInt(10));
                
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
    
    public List<Libro> consultarAdministrador(){
        List<Libro> libros = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT ISBN, titulo, numpag, autor.nombre, "
                    + "apellidoPaterno, apellidoMaterno, editorial.nombre, "
                    + "nombrearea, libro.mostar,libro.libro_id FROM libro "
                    + "JOIN editorial ON libro.editorial_id = editorial.editorial_id "
                    + "JOIN areas ON areas.areas_id = libro.areas_id "
                    + "JOIN ficha ON ficha.libro_id = libro.libro_id "
                    + "JOIN autor ON ficha.autor_id = autor.autor_id";
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
                autor.setAMaterno(resultado.getString(6));
                
                Editorial editorial = new Editorial();
                editorial.setNombre(resultado.getString(7));
                
                Area area = new Area ();
                area.setNombreArea(resultado.getString(8));
                
                libro.setMostrar(resultado.getBoolean(9));
                libro.setIdLibro(resultado.getInt(10));
                
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
    
    public boolean modificar(int idLibro, Libro libro){
        
        boolean  status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE libro SET ISBN = ?, titulo = ?, numpag = ?, "
                    + "editorial_id = ?, areas_id = ? WHERE libro_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, libro.getIsbn());
            pstm.setString(2, libro.getTitulo());
            pstm.setInt(3, libro.getNum_paginas());
            pstm.setInt(4, libro.getEditorial().getIdEditorial());
            pstm.setInt(5, libro.getArea().getIdAreas());
            pstm.setInt(6, idLibro);
            
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
            
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return status;
        
    }
    
    public boolean recuperar(int idLibro){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE libro SET mostrar = 1 WHERE libro_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idLibro);
            
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
        
        List<String> libros = new ArrayList<>();        
        
        try{            
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT titulo FROM libro WHERE mostar = 1";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                String libro = resultado.getString(1);
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
    
    public Libro consultarPorId(int idLibro){
        
        Libro libro = new Libro();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT isbn, titulo, numpag, areas_id, editorial_id, "
                    + "autor_id FROM libro JOIN ficha ON libro.libro_id = ficha."
                    + "libro_id  WHERE libro.libro_id = ?";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setInt(1, idLibro);
            ResultSet resultado=pstm.executeQuery();

            while(resultado.next()){
                libro.setIdLibro(idLibro);
                libro.setIsbn(resultado.getString(1));
                libro.setTitulo(resultado.getString(2));
                libro.setNum_paginas(resultado.getInt(3));  
                
                Area area = new Area();
                area.setIdAreas(resultado.getInt(4));
                
                Editorial editorial = new Editorial();
                editorial.setIdEditorial(resultado.getInt(5));
                
                Autor autor = new Autor();
                autor.setIdAutor(resultado.getInt(6));
                
                libro.setEditorial(editorial);
                libro.setArea(area);
                libro.setAutor(autor);                
            }
            
            resultado.close();
            pstm.close();
            conexion.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return libro;
        
    }
    
    public Libro consultarPorNombre(String  nombre){
        
        Libro libro = new Libro();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT libro_id FROM libro WHERE titulo = ? AND "
                    + "mostar = 1";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            ResultSet resultado=pstm.executeQuery();
            
            
            while(resultado.next()){
                libro.setTitulo(nombre);
                libro.setIdLibro(resultado.getInt(1));
            }
            
            pstm.close();
            conexion.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return libro;
    
    }
    
    public int consultarId(Libro libro){
        
        int idLibro = 0;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT libro_id FROM libro WHERE ISBN = ? AND titulo "
                    + "= ? AND numpag = ? AND editorial_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, libro.getIsbn());
            pstm.setString(2, libro.getTitulo());
            pstm.setInt(3, libro.getNum_paginas());
            pstm.setInt(4, libro.getEditorial().getIdEditorial());           
            ResultSet resultado = pstm.executeQuery();
            
            
            while(resultado.next()){
                idLibro = resultado.getInt(1);
            }
            
            pstm.close();
            conexion.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return idLibro;
    
    }
       
    public List<Libro> consultaAvanzada(String busqueda){
                
        List<Libro> libros = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT ISBN, titulo, numpag, autor.nombre, "
                    + "apellidoPaterno, apellidoMaterno, editorial.nombre, "
                    + "nombrearea, libro.mostar,libro.libro_id FROM libro "
                    + "JOIN editorial ON libro.editorial_id = editorial.editorial_id "
                    + "JOIN areas ON areas.areas_id = libro.areas_id "
                    + "JOIN ficha ON ficha.libro_id = libro.libro_id "
                    + "JOIN autor ON ficha.autor_id = autor.autor_id "
                    + "WHERE libro.ISBN LIKE '%"+busqueda+"%' OR libro.titulo LIKE '%"+busqueda+"%' "
                    + "OR libro.numpag LIKE '%"+busqueda+"%' OR autor.nombre LIKE '%"+busqueda+"%' "
                    + "OR autor.apellidoPaterno LIKE '%"+busqueda+"%' OR autor.apellidoMaterno LIKE '%"+busqueda+"%' "
                    + "OR editorial.nombre LIKE '%"+busqueda+"%' OR areas.nombrearea LIKE '%"+busqueda+"%' "
                    + "AND libro.mostar = 1;";
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
                autor.setAMaterno(resultado.getString(6));
                
                Editorial editorial = new Editorial();
                editorial.setNombre(resultado.getString(7));
                
                Area area = new Area ();
                area.setNombreArea(resultado.getString(8));
                
                libro.setMostrar(resultado.getBoolean(9));
                libro.setIdLibro(resultado.getInt(10));
                
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
    
        
    public List<Libro> consultaAvanzadaAdministrador(String busqueda){
                
        List<Libro> libros = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT ISBN, titulo, numpag, autor.nombre, "
                    + "apellidoPaterno, apellidoMaterno, editorial.nombre, "
                    + "nombrearea, libro.mostar,libro.libro_id FROM libro "
                    + "JOIN editorial ON libro.editorial_id = editorial.editorial_id "
                    + "JOIN areas ON areas.areas_id = libro.areas_id "
                    + "JOIN ficha ON ficha.libro_id = libro.libro_id "
                    + "JOIN autor ON ficha.autor_id = autor.autor_id "
                    + "WHERE libro.ISBN LIKE '%"+busqueda+"%' OR libro.titulo LIKE '%"+busqueda+"%' "
                    + "OR libro.numpag LIKE '%"+busqueda+"%' OR autor.nombre LIKE '%"+busqueda+"%' "
                    + "OR autor.apellidoPaterno LIKE '%"+busqueda+"%' OR autor.apellidoMaterno LIKE '%"+busqueda+"%' "
                    + "OR editorial.nombre LIKE '%"+busqueda+"%' OR areas.nombrearea LIKE '%"+busqueda+"%'";
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
                autor.setAMaterno(resultado.getString(6));
                
                Editorial editorial = new Editorial();
                editorial.setNombre(resultado.getString(7));
                
                Area area = new Area ();
                area.setNombreArea(resultado.getString(8));
                
                libro.setMostrar(resultado.getBoolean(9));
                libro.setIdLibro(resultado.getInt(10));
                
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
    
    public List<Libro> todo(){
        List<Libro> libros = new ArrayList<>();    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT ISBN, titulo, numpag,autor.nombre,apellidoPaterno,editorial.nombre,nombrearea,libro.mostar,libro.libro_id,editorial.estado,areas.estado,autor.mostrar,apellidoMaterno FROM libro "
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
                autor.setAMaterno(resultado.getString(13));
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
    
    
}
