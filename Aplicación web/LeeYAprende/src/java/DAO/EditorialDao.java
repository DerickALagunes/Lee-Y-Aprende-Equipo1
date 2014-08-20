/*
 * Hecho por Axel Lagunes.
 */

package DAO;

import BEAN.Editorial;
import conexionBD.conexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author derick
 */
public class EditorialDao {
    
    
            public int consultarid(String nombre){
        int id = 0;    
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT editorial_id FROM editorial WHERE nombre=?"; //regresa el ultimo libro ingresado
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
    
    
        public static List<Editorial> consultar(){
        
        List<Editorial> editoriales=new ArrayList<Editorial>();
        
        try{
            
            Connection con = conexionSQLServer.getConnection();
            String Query="SELECT * FROM editorial ORDER BY nombre";
            PreparedStatement ps = con.prepareStatement(Query);
          
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Editorial editorial=new Editorial();
                
                editorial.setIdEditorial(rs.getInt("editorial_id"));
                editorial.setNombre(rs.getString("nombre"));
                editorial.setEstado(rs.getBoolean("estado"));
                
                editoriales.add(editorial);
            }
                
            rs.close();
            ps.close();
            con.close();
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return editoriales;
    } //regresa una lista de todas las editoriales
        
        public static boolean insertar(String editorial){ 
            boolean status=false;
            
            try{
                Connection con = conexionSQLServer.getConnection();
                String Query="INSERT INTO editorial (nombre) values (?)";
                PreparedStatement ps = con.prepareStatement(Query);
                
                ps.setString(1, editorial);
                
                if (ps.executeUpdate()==1) {
                    status=true;
                }
                
                ps.close();
                con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            return status;            
            
        } //inserta una editorial que le mandes y regresa true o false
        
        public static boolean noExiste(String editorial){ 
            boolean noExiste=true;
            
            try{
                Connection con = conexionSQLServer.getConnection();
                String Query="SELECT * FROM editorial where nombre =?;";
                PreparedStatement ps = con.prepareStatement(Query);
                ps.setString(1, editorial);
                ResultSet res = ps.executeQuery();
                
                while (res.next()) {
                    noExiste=false;
                }
                    
                res.close();
                ps.close();
                con.close();
                        
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            return noExiste;            
            
        } //inserta una editorial que le mandes y regresa true o false
        
        public static boolean modificar(int idEditorial,String nuevo){
            boolean status=false;
            
            try{
                Connection con = conexionSQLServer.getConnection();
                String Query="UPDATE editorial SET nombre = '"+nuevo+"' WHERE "
                        + "editorial_id="+idEditorial+""; //checar que tan bien este esta cosa
                PreparedStatement ps = con.prepareStatement(Query);
                
                if (ps.executeUpdate()==1) {
                    status=true;
                }
                ps.close();
                con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            return status;
        } //hace un update donde le des el id de editorial y cambia el nombre donde nuevo
    
        public static boolean eliminar(int idEditorial){
            boolean status=false;
            
             try{
                Connection con = conexionSQLServer.getConnection();
                String Query="UPDATE editorial SET estado = 0 WHERE editorial_id ="+idEditorial;
                PreparedStatement ps = con.prepareStatement(Query);
                
                if (ps.executeUpdate()==1) {
                    status=true;
                }
                
                ps.close();
                con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            return status;
        }// hace el atributo estado = 0 donde este el id ingresado
        
        public static boolean recuperar(int idEditorial){
            boolean status=false;
            
             try{
                Connection con = conexionSQLServer.getConnection();
                String Query="UPDATE editorial SET estado = 1 WHERE editorial_id ="+idEditorial;
                PreparedStatement ps = con.prepareStatement(Query);
                
                if (ps.executeUpdate()==1) {
                    status=true;
                }
                
                ps.close();
                con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            return status;
        }// hace el atributo estado = 0 donde este el id ingresado
}
