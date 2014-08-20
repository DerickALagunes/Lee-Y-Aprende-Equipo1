/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Ejemplar;
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
public class EjemplarDao {
    
    
     public boolean insertar(String localizacion, int idLibro){
         
        boolean status = false;
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO ejemplar(localizacion,libro_id ) VALUES (?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, localizacion);
            pstm.setInt(2, idLibro);

            if(pstm.executeUpdate()==1) status=true;

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
            
            if(pstm.executeUpdate() == 1) status = true;                      
        
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
            
            if(pstm.executeUpdate() == 1) status = true;                      
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    
        //regresa todos los datos de un libro
    public List<Ejemplar> tabla(){
        List<Ejemplar> ejemplares = new ArrayList<>();    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT titulo,localizacion,COUNT(libro.titulo) as numeroDeEjemplares FROM ejemplar join libro on libro.libro_id=ejemplar.libro_id GROUP BY titulo,localizacion;";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                
                Ejemplar ejem = new Ejemplar();
                
                ejem.setTitulo(resultado.getString(1));
                ejem.setLocalizacion(resultado.getString(2));              
                ejem.setNumeroEjemplares(resultado.getInt(3));
               
                ejemplares.add(ejem);
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
