/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
 * @author Derick
 */
public class ConsultasDao {

    //regresa una lista de libros con (id, titulo)
    public List<Libro> librosConMayorExistencia() {
        List<Libro> libros = new ArrayList<>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = " Select libro.titulo,mostar from cosas4 join libro on libro.libro_id=cosas4.libro;";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                Libro libro = new Libro();

                libro.setTitulo(resultado.getString(1));
                libro.setMostrar(resultado.getBoolean(2));

                libros.add(libro);
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
    
    //regresa una lista de editoriales con (nombre, estado)
    public List<Editorial> editorialesConMenorExistencia() {
        List<Editorial> editoriales = new ArrayList<>();

        try {
            Connection conexion = conexionSQLServer.getConnection();
            String Query = "Select cosas2.editorial,cosas3.ejemplares,editorial.estado from cosas3 join cosas2 on cosas2.ejemplares=cosas3.ejemplares join editorial on editorial.nombre=cosas2.editorial;";
            PreparedStatement pstm = conexion.prepareStatement(Query);
            ResultSet resultado = pstm.executeQuery();

            while (resultado.next()) {
                Editorial editorial = new Editorial();

                editorial.setNombre(resultado.getString(1));
                editorial.setEstado(resultado.getBoolean(3));

                editoriales.add(editorial);
            }

            resultado.close();
            pstm.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editoriales;
    }

}
