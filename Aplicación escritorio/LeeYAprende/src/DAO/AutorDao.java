/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Area;
import BEAN.Autor;
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
public class AutorDao {

    public boolean insertar(Autor autor) {

        boolean status = false;

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "INSERT INTO autor (nombre, apellidoPaterno, apellidoMaterno) VALUES (?, ?, ?)";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, autor.getNombre());
            pstm.setString(2, autor.getApaterno());
            pstm.setString(3, autor.getAMaterno());

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

    public boolean existe(Autor autor) {

        boolean existe = false;

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombre, apellidoPaterno FROM"
                    + " autor WHERE nombre = ? AND apellidoPaterno = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, autor.getNombre());
            pstm.setString(2, autor.getApaterno());
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                existe = true;
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;

    }

    public List<Autor> consultar() {

        List<Autor> autores = new ArrayList<>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT * FROM autor";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                Autor autor = new Autor();
                autor.setIdAutor(resultado.getInt(1));
                autor.setNombre(resultado.getString(2));
                autor.setApaterno(resultado.getString(3));
                autor.setAMaterno(resultado.getString(4));
                autor.setEstado(resultado.getBoolean(5));
                autores.add(autor);
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autores;

    }

    public boolean modificar(int idAutor, Autor autor) {

        boolean status = false;

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE autor SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ? WHERE autor_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, autor.getNombre());
            pstm.setString(2, autor.getApaterno());
            pstm.setString(3, autor.getAMaterno());
            pstm.setInt(4, idAutor);

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

    public boolean eliminar(int idAutor) {

        boolean status = false;

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE autor SET mostrar = 0 WHERE autor_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idAutor);

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

    public boolean recuperar(int idAutor) {

        boolean status = false;

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "UPDATE autor SET mostrar = 1 WHERE autor_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idAutor);

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

    public List<Autor> consultarNombre() {

        List<Autor> autores = new ArrayList<>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombre, apellidoPaterno, apellidoMaterno FROM autor WHERE mostrar = 1 ORDER BY nombre";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                Autor autor = new Autor();
                autor.setNombre(resultado.getString(1));
                autor.setApaterno(resultado.getString(2));
                autor.setAMaterno(resultado.getString(3));
                autores.add(autor);
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autores;

    }

    public Autor consultarPorId(int idAutor) {

        Autor autor = new Autor();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombre, apellidoPaterno, apellidoMaterno FROM autor WHERE autor_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idAutor);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                autor.setIdAutor(idAutor);
                autor.setNombre(resultado.getString(1));
                autor.setApaterno(resultado.getString(2));
                autor.setAMaterno(resultado.getString(3));
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autor;

    }

    public int consultarPorNombre(String[] nombre) {

//        String[] nombreCompleto = new String[3];
//        nombreCompleto = nombre.split(" ");
        int idAutor = 0;

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT autor_id FROM autor WHERE nombre = ? AND apellidoPaterno = ? "
                    + "AND apellidoMaterno = ? AND mostrar = 1";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setString(1, nombre[0]);
            pstm.setString(2, nombre[1]);
            pstm.setString(3, nombre[2]);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                idAutor = resultado.getInt(1);
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idAutor;

    }

    public int[] consultarPorNombreAxel(String[] autores) {
        
        int [] idAutor = new int[autores.length];
        
        for (int i = 0; i < autores.length; i++) {
            try{
                Connection conexion = conexionSQLServer.getConnection();

                    String Query = "Select id from nombreautores where nombre = ?";
                    PreparedStatement pstm = conexion.prepareStatement(Query);
                    pstm.setString(1, autores[i]);
                    ResultSet resultado = pstm.executeQuery();

                    while(resultado.next()){
                        idAutor[i] = resultado.getInt(1);
                    }
                    
                    resultado.close();
                    pstm.close();

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        

        
        

//        int[] idAutor = new int[autores.length];
//
//        for (int i = 0; i < autores.length; i++) {
//
//            String[] nombre = autores[i].split(" ");
//            String Query = "";
//
//            if (nombre.length == 2) {
//                Query = "SELECT autor_id FROM autor WHERE nombre = '" + nombre[0] + "' AND apellidoPaterno = '" + nombre[1] + "' AND mostrar = 1";
//            } else if (nombre.length == 1) {
//                Query = "SELECT autor_id FROM autor WHERE nombre = '" + nombre[0] + "' AND mostrar = 1";
//            } else if (nombre.length == 3) {
//                Query = "SELECT autor_id FROM autor WHERE nombre = '" + nombre[0] + "' AND apellidoPaterno = '" + nombre[1] + "' AND apellidoMaterno = '" + nombre[2] + "' AND mostrar = 1";
//            }

//            try {
//                Connection conexion = conexionSQLServer.getConnection();
//                PreparedStatement pstm = conexion.prepareStatement(Query);
//                ResultSet resultado = pstm.executeQuery();
//
//                while (resultado.next()) {
//                    idAutor[i] = resultado.getInt(1);
//                }
//
//                resultado.close();
//                pstm.close();
//                conexion.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
        return idAutor;
    }

    public String consultarAutorLibro(int idLibro) {
        String autor = new String();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT nombre, apellidoPaterno, apellidoMaterno FROM"
                    + " autor JOIN ficha ON autor.autor_id = ficha.ficha_id WHERE"
                    + " libro_id = ?";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            pstm.setInt(1, idLibro);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                autor = resultado.getString(1) + " " + resultado.getString(2) + " " + resultado.getString(3);
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autor;

    }

    public List<Autor> consultaAvanzada(String busqueda) {

        List<Autor> autores = new ArrayList<>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "SELECT autor_id, nombre, apellidoPaterno, apellidoMaterno, mostrar FROM autor "
                    + "WHERE nombre LIKE '%" + busqueda + "%' OR apellidoPaterno LIKE '%" + busqueda + "%' OR "
                    + "apellidoMaterno LIKE '%" + busqueda + "%' ORDER BY nombre";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {

                Autor autor = new Autor();
                autor.setIdAutor(resultado.getInt(1));
                autor.setNombre(resultado.getString(2));
                autor.setApaterno(resultado.getString(3));
                autor.setAMaterno(resultado.getString(4));
                autor.setEstado(resultado.getBoolean(5));
                autores.add(autor);
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autores;

    }

}