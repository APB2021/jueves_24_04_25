package dao;

import java.util.List;

import modelo.Incidencia;

public interface IncidenciaDAO {

	boolean crear(Incidencia incidencia);

	List<Incidencia> listarTodas();

	Incidencia buscarPorId(int id);

	boolean actualizarEstado(int id, String nuevoEstado);

	List<Incidencia> buscarPorEstado(String estado);

	boolean eliminarPorId(int id);

}