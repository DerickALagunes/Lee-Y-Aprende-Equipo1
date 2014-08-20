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
public class ConsultasDao {
    
    public List<Ejemplar> consultarNumeroEjemplares(){
        
        List<Ejemplar> ejemplares = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "Select cosas2.editorial,cosas3.ejemplares,editorial.estado "
                    + "from cosas3 join cosas2 on cosas2.ejemplares=cosas3.ejemplares "
                    + "join editorial on editorial.nombre=cosas2.editorial where estado = 1";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            
            while(resultado.next()){
                Ejemplar ejemplar = new Ejemplar();
                
                Libro libro = new Libro();
                libro.setTitulo(resultado.getString(1));
                
                ejemplar.setLibro(libro);
                ejemplar.setNumeroEjemplares(resultado.getInt(2));
                ejemplar.setEstado(resultado.getBoolean(3));       
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
    
    public List<Ejemplar> consultarExistencias(){
        
        List<Ejemplar> ejemplares = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "Select libro.titulo,mostar from cosas4 join libro on libro.libro_id=cosas4.libro";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            
            while(resultado.next()){
                Ejemplar ejemplar = new Ejemplar();
                
                Libro libro = new Libro();
                libro.setTitulo(resultado.getString(1));
                
                ejemplar.setLibro(libro);
                ejemplar.setEstado(resultado.getBoolean(2));       
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
    
}
