/*
 * Hecho por Axel Lagunes.
 */

package DAO;

import BEAN.Usuario;
import conexionBD.conexionSQLServer;
import java.sql.*;

/**
 *
 * @author derick
 */
public class validar {
    
    
        public static Usuario user(String usuario,String pass){
        
        Usuario user = new Usuario();
        
        try{
            Connection con = conexionSQLServer.getConnection();
            String Query="select * from usuario where email=? and pass=?;";
            PreparedStatement ps = con.prepareStatement(Query);
            
            ps.setString(1, usuario);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                user.setNombre(rs.getString(2));
                user.setApaterno(rs.getString(3));
                user.setAmaterno(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setTelefono(rs.getString(8));
                user.setDireccion(rs.getString(9));
                user.setPenalizado(rs.getBoolean(10));
            }
            
            rs.close();
            ps.close();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return user;
    }
    
    public static boolean checkUsario(String usuario,String pass){
        
        boolean existe = false;
        
        try{
            Connection con = conexionSQLServer.getConnection();
            String Query="select * from usuario where email=? and pass=? and mostrar=1;";
            PreparedStatement ps = con.prepareStatement(Query);
            
            ps.setString(1, usuario);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            existe = rs.next();
            
            rs.close();
            ps.close();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return existe;
    }
    
    public static boolean checkAdministrador(String usuario,String pass){
        
        boolean administrador = false;
        
        try{
            
            Connection con = conexionSQLServer.getConnection();
            String Query="SELECT administrador FROM usuario WHERE email=? and pass=? and mostrar=1;";
            PreparedStatement ps = con.prepareStatement(Query);
          
            
            ps.setString(1, usuario);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                if (rs.getInt("administrador")==1){
                    administrador=true;
                }
            }
                
            rs.close();
            ps.close();
            con.close();
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return administrador;
    }
    
}
