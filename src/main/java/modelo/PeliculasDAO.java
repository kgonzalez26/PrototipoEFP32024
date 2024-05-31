/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.Peliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class PeliculasDAO {

    private static final String SQL_SELECT = "SELECT idPeliculas, nombre, precio FROM peliculas";
    private static final String SQL_INSERT = "INSERT INTO peliculas(idPeliculas, nombre, precio) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE peliculas SET nombre=?, precio=? WHERE idPeliculas = ?";
    private static final String SQL_DELETE = "DELETE FROM peliculas WHERE idPeliculas=?";
    private static final String SQL_QUERY = "SELECT idPeliculas, nombre, precio FROM peliculas WHERE idPeliculas = ?";

    public List<Peliculas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Peliculas tipoMoneda = null;
        List<Peliculas> TiposDeMoneda = new ArrayList<Peliculas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPeliculas");
                String nombre = rs.getString("nombre");
                String valor = rs.getString("precio");

                tipoMoneda = new Peliculas();
                tipoMoneda.setIdMoneda(id);
                tipoMoneda.setNombreMoneda(nombre);
                tipoMoneda.setValorMoneda(valor);
                TiposDeMoneda.add(tipoMoneda);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return TiposDeMoneda;
    }

    public int insert(Peliculas tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt   (1, tipoMoneda.getIdMoneda());
            stmt.setString(2, tipoMoneda.getNombreMoneda());
            stmt.setString(3, tipoMoneda.getValorMoneda());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Peliculas tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tipoMoneda.getNombreMoneda());
            stmt.setString(2, tipoMoneda.getValorMoneda());
            stmt.setInt   (3, tipoMoneda.getIdMoneda());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Peliculas tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tipoMoneda.getIdMoneda());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Peliculas query(Peliculas tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, tipoMoneda.getIdMoneda());
            rs = stmt.executeQuery();
            if (rs.next()) {
                tipoMoneda.setNombreMoneda(rs.getString("nombre_moneda"));
                tipoMoneda.setValorMoneda(rs.getString("valor_moneda"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tipoMoneda;
    }
}
