/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Autor;
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
public class FichaDao {
    
    public boolean insertar(int idLibro,  int[] idAutor){
        
        boolean status = false;   
        
        for (int i = 0; i < idAutor.length; i++) {
            
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO ficha (libro_id, autor_id) VALUES (?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idLibro);
            pstm.setInt(2, idAutor[i]);
            
            if(pstm.executeUpdate() == 1){
                status = true;
            }
            
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
        
        return status;    
        
    }
    
    public boolean modificar(int idLibro, int[] idAutor){
        
        boolean status = false;   
        
        status = borrar(idLibro);
        status = insertar(idLibro, idAutor);
 
        return status;    
        
    }
    
    
    public List<Autor> consultarAutoresDeLibro(int idLibro){
        
        List<Autor> autores = new ArrayList<>();   
            
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT autor_id FROM ficha WHERE libro_id="+idLibro+";";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet res = pstm.executeQuery();
            AutorDao dao = new AutorDao();
            
            
            while (res.next()) {
                
                Autor autor = new Autor();
                autor=dao.consultarPorId(res.getInt(1));
                autores.add(autor);
                
            }
            
            res.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
  
        return autores;    
        
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