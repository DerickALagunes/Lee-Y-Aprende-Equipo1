/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Usuario;
import conexionBD.conexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Derick
 */
public class UsuarioDao {

    public boolean insertar(String nombre, String paterno, String materno, String mail, String pass, String telefono, String direccion) {
        boolean status = false;
        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO usuario (nombre,apellido_p,apellido_m,email,pass,telefono,direccion) "
                    + "VALUES (?,?,?,?,?,?,?);";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            pstm.setString(2, paterno);
            pstm.setString(3, materno);
            pstm.setString(4, mail);
            pstm.setString(5, pass);
            pstm.setString(6, telefono);
            pstm.setString(7, direccion);

            List<Usuario> correo = correos();
            boolean existe = false;
            for (int i = 0; i < correo.size(); i++) {
                Usuario temporal = correo.get(i);
                String cuenta = temporal.getEmail();
                if (cuenta.equals(mail)) {
                    existe = true;
                }
            }

            if (!existe) {
                if (pstm.executeUpdate() == 1) {
                    status = true;
                }
            }

            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean modificar(String nombre, String paterno, String materno, String mail, String pass, String telefono, String direccion, int id) {
        boolean status = false;
        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE usuario SET "
                    + "nombre=?, apellido_p=?, apellido_m=?, email=?, pass=?, telefono=?, direccion=? "
                    + "WHERE usuario_id=" + id + ";";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, nombre);
            pstm.setString(2, paterno);
            pstm.setString(3, materno);
            pstm.setString(4, mail);
            pstm.setString(5, pass);
            pstm.setString(6, telefono);
            pstm.setString(7, direccion);

            if (pstm.executeUpdate() == 1) {
                status = true;
            }

            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean eliminar(int idUsuario) {
        boolean status = false;
        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE usuario SET mostrar = 0 WHERE usuario_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idUsuario);

            if (pstm.executeUpdate() == 1) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean recuperar(int idUsuario) {
        boolean status = false;
        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE usuario SET mostrar = 1 WHERE usuario_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idUsuario);

            if (pstm.executeUpdate() == 1) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Usuario> consultar() {

        List<Usuario> usuarios = new ArrayList<>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM usuario";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {

                Usuario user = new Usuario();

                user.setIdUsuario(resultado.getInt(1));
                user.setNombre(resultado.getString(2));
                user.setApaterno(resultado.getString(3));
                user.setAmaterno(resultado.getString(4));
                user.setEmail(resultado.getString(5));
                user.setPass(resultado.getString(6));
                user.setAdministrador(resultado.getBoolean(7));
                user.setTelefono(resultado.getString(8));
                user.setDireccion(resultado.getString(9));
                user.setPenalizado(resultado.getBoolean(10));
                user.setMostrar(resultado.getBoolean(11));

                usuarios.add(user);

            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public List<Usuario> correos() {

        List<Usuario> usuarios = new ArrayList<>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT email FROM usuario";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {

                Usuario user = new Usuario();

                user.setEmail(resultado.getString(5));

                usuarios.add(user);

            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}
