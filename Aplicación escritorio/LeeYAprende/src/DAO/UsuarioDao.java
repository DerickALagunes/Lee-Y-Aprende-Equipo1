/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import BEAN.Usuario;
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
public class UsuarioDao {
    
    public boolean insertar(Usuario usuario){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO usuario (nombre, apellido_p, apellido_m, "
                    + "email, pass, administrador, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);            
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getApaterno());
            pstm.setString(3, usuario.getAmaterno());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getPass());
            pstm.setBoolean(6, usuario.isAdministrador());
            pstm.setString(7, usuario.getTelefono());
            pstm.setString(8, usuario.getDireccion());

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
    
    public boolean existe(String email){
        
        boolean existe = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT email FROM usuario WHERE email = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, email);
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
    
    public List<Usuario> consultar(){
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM info_usuarios";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setEmail(resultado.getString(3));
                usuario.setPass(resultado.getString(4));
                usuario.setTelefono(resultado.getString(5));
                usuario.setDireccion(resultado.getString(6));
                usuario.setMostrar(resultado.getBoolean(7));
                usuarios.add(usuario);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return usuarios;
        
    }
    
    public boolean modificar(int id, Usuario usuario){
        
        boolean  status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE usuario SET nombre = ?, apellido_p = ?, "
                    + "apellido_m = ?, email = ?, pass = ?, administrador = ?, "
                    + "telefono = ?, direccion = ? WHERE usuario_id=?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getApaterno());
            pstm.setString(3, usuario.getAmaterno());
            pstm.setString(4, usuario.getEmail());
            pstm.setString(5, usuario.getPass());
            pstm.setBoolean(6, usuario.isAdministrador());
            pstm.setString(7, usuario.getTelefono());
            pstm.setString(8, usuario.getDireccion());
            pstm.setInt(9, id);
                        
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
    
    public boolean eliminar(int idUsuario){
        
        boolean status = false;
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE usuario SET mostrar = 0 WHERE usuario_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idUsuario);
            
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
    
    public boolean recuperar(int idUsuario){
        
        boolean status = false;
                
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE usuario SET estado = 1 WHERE usuario_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idUsuario);
            
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
    
    public Usuario consultarPorId(int idUsuario){
        
        Usuario  usuario = new Usuario();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query= "SELECT nombre, apellido_p, apellido_m, email, pass, "
                    + "administrador, telefono, direccion FROM usuario WHERE "
                    + "usuario_id = ?";
            PreparedStatement pstm=conexion.prepareStatement(Query);
            pstm.setInt(1, idUsuario);
            ResultSet resultado=pstm.executeQuery();

            while(resultado.next()){
                usuario.getIdUsuario();
                usuario.setNombre(resultado.getString(1));
                usuario.setApaterno(resultado.getString(2));
                usuario.setAmaterno(resultado.getString(3));
                usuario.setEmail(resultado.getString(4));
                usuario.setPass(resultado.getString(5));
                usuario.setAdministrador(resultado.getBoolean(6));
                usuario.setTelefono(resultado.getString(7));
                usuario.setDireccion(resultado.getString(8));                
            }
            
            resultado.close();
            pstm.close();
            conexion.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return usuario;
    
    }
    
    public List<Usuario> consultaAvanzada(String busqueda){
                
        List<Usuario> usuarios = new ArrayList<>();    
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM info_usuarios "
                    + "WHERE usuario_id LIKE '%"+busqueda+"%' OR nombre LIKE '%"+busqueda+"%' "
                    + "OR email LIKE '%"+busqueda+"%' OR pass LIKE '%"+busqueda+"%' OR telefono LIKE '%"+busqueda+"%' "
                    + "OR direccion LIKE '%"+busqueda+"%' ORDER BY nombre";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setEmail(resultado.getString(3));
                usuario.setPass(resultado.getString(4));
                usuario.setTelefono(resultado.getString(5));
                usuario.setDireccion(resultado.getString(6));
                usuario.setMostrar(resultado.getBoolean(7));
                usuarios.add(usuario);
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return usuarios;  
        
    }
    
    public Usuario consultarDatos(String user, String pass){
        
        Usuario usuario = new Usuario();
        
        try{
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM info_usuarios WHERE email = ? AND pass = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            ResultSet resultado = pstm.executeQuery();
            
            while(resultado.next()){
                usuario.setIdUsuario(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
                usuario.setEmail(resultado.getString(3));
                usuario.setPass(resultado.getString(4));
                usuario.setTelefono(resultado.getString(5));
                usuario.setDireccion(resultado.getString(6));
                usuario.setMostrar(resultado.getBoolean(7));
            }
            
            resultado.close();
            pstm.close();
            conexion.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return usuario;
        
    }
    
}
