package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Incidencia;
import pool.PoolConexiones;

public class IncidenciaBD implements IncidenciaDAO {

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
			ps.setDate(3, incidencia.getFechaCreacion());
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

				var incidencia = new Incidencia();

				incidencia.setId(rs.getInt("id"));
				incidencia.setTitulo(rs.getString("titulo"));
				incidencia.setDescripcion(rs.getString("descripcion"));
				incidencia.setFechaCreacion(rs.getDate("fechaCreacion"));
				incidencia.setEstado(rs.getInt("estado"));
				incidencia.setTecnico(rs.getInt("tecnico"));

				return incidencia;
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
		return null;

	}

	@Override
	public boolean actualizarEstado(int id, String nuevoEstado) {

		PreparedStatement ps;
		Connection con = null;

		try {
			con = PoolConexiones.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		var sql = "UPDATE estados SET estadoIncidencia = ? WHERE id = ?";

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, nuevoEstado);
			ps.setInt(2, id);

			ps.execute();

			return true;

		} catch (SQLException e) {
			System.out.println("Error al cambiar estado: " + e.getMessage());
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
	public List<Incidencia> buscarPorEstado(String estado) {

		List<Incidencia> incidencias = new ArrayList<>();

		PreparedStatement ps;
		ResultSet rs;
		Connection con = null;

		try {
			con = PoolConexiones.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		var sql = "SELECT id, titulo, descripcion, fechaCreacion, estado, tecnico FROM incidencias WHERE estado = ?";

		try {

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				var incidencia = new Incidencia();

				ps.setInt(1, incidencia.getEstado());

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
	public boolean eliminarPorId(int id) {

		PreparedStatement ps;
		Connection con = null;

		try {
			con = PoolConexiones.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		var sql = "DELETE FROM incidencias WHERE id = ?";

		var incidencia = new Incidencia();

		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, incidencia.getId());

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

}
