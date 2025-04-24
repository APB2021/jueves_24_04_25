package dao;

import java.util.List;

import modelo.Incidencia;

public interface IIncidenciasDao {

	boolean crear(Incidencia incidencia);

	List<Incidencia> listarTodas();

	Incidencia buscarPorId(int id);

}
