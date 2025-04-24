package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Incidencia;
import pool.PoolConexiones;

public class IncidenciasBD implements IIncidenciasDao {

	@Override
	public boolean crear(Incidencia incidencia) {
		PreparedStatement ps;
		Connection con = null;
		try {
			con = PoolConexiones.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		var sql = "INSERT INTO incidencias (titulo, descripcion, fechaCreacion, estado, tecnico) VALUES (?, ?, ?, ?, ?)";

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, incidencia.getTitulo());
			ps.setString(2, incidencia.getDescripcion());
			ps.setDate(3, (java.sql.Date) incidencia.getFechaCreacion());
			ps.setInt(4, incidencia.getEstado());
			ps.setInt(5, incidencia.getTecnico());

			ps.execute();

			return true;

		} catch (SQLException e) {
			System.out.println("Error al agregar incidencia: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar conexión: " + e.getMessage());
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<Incidencia> listarTodas() {

		List<Incidencia> incidencias = new ArrayList<>();

		PreparedStatement ps;
		ResultSet rs;
		Connection con = null;
		try {
			con = PoolConexiones.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		var sql = "SELECT id, titulo, descripcion, fechaCreacion, estado, tecnico FROM incidencias ORDER BY id";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				var incidencia = new Incidencia();

				incidencia.setId(rs.getInt("id"));
				incidencia.setTitulo(rs.getString("titulo"));
				incidencia.setDescripcion(rs.getString("descripcion"));
				incidencia.setFechaCreacion(rs.getDate("fechaCreacion"));
				incidencia.setEstado(rs.getInt("estado"));
				incidencia.setTecnico(rs.getInt("tecnico"));

				incidencias.add(incidencia);
			}
		} catch (SQLException e) {
			System.out.println("Error al listar incidencias: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar conexión: " + e.getMessage());
				e.printStackTrace();
			}
		}

		return incidencias;
	}

	@Override
	public Incidencia buscarPorId(int id) {
		PreparedStatement ps;
		ResultSet rs;
		Connection con = null;
		try {
			con = PoolConexiones.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		var sql = "SELECT id, titulo, descripcion, fechaCreacion, estado, tecnico FROM incidencias WHERE id = ?";
		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				incidencia.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setMembresia(rs.getInt("membresia"));

				return true; // Encontramos el registro
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar cliente por id: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar conexión: " + e.getMessage());
				e.printStackTrace();
			}
		}

		return false; // No encontramos el registro
	}

}
