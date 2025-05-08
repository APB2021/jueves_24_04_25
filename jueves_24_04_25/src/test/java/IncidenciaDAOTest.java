
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import dao.IncidenciaDAO;
import modelo.Incidencia;

import java.util.*;
import java.time.LocalDate;
import java.util.concurrent.*;

public class IncidenciaDAOTest {

	private static IncidenciaDAO dao;

	@BeforeAll
	public static void prepararDAO() {
		dao = new IncidenciaDAO();
	}

	@Test
	public void testCrearYBuscar() {
		Incidencia i = new Incidencia(1, "Pantalla azul", "Error grave", LocalDate.now(), "Abierta", "Juan",
				"juan@ejemplo.com");
		assertTrue(dao.crear(i));
		Incidencia recuperada = dao.buscarPorId(i.getId());
		assertNotNull(recuperada);
		assertEquals("Pantalla azul", recuperada.getTitulo());
	}

	@Test
	public void testActualizarEstado() {
		Incidencia i = new Incidencia(2, "Problema de red", "No hay conexión", LocalDate.now(), "Abierta", "Ana",
				"ana@ejemplo.com");
		dao.crear(i);
		assertTrue(dao.actualizarEstado(i.getId(), "En progreso"));
		Incidencia actualizada = dao.buscarPorId(i.getId());
		assertEquals("En progreso", actualizada.getEstado());
	}

	@Test
	public void testBuscarPorEstado() {
		List<Incidencia> abiertas = dao.buscarPorEstado("Abierta");
		assertNotNull(abiertas);
	}

	@Test
	public void testEliminarPorId() {
		Incidencia i = new Incidencia(3, "Eliminar esto", "Solo para test", LocalDate.now(), "Abierta", "Luis",
				"luis@ejemplo.com");
		dao.crear(i);
		assertTrue(dao.eliminarPorId(i.getId()));
		assertNull(dao.buscarPorId(i.getId()));
	}

	@Test
	public void testInsertarInvalido() {
		Incidencia invalida = new Incidencia(4, null, null, LocalDate.now(), null, null, null);
		assertFalse(dao.crear(invalida), "No debería permitir insertar incidencias inválidas.");
	}

	@Test
	public void testBuscarConFecha() {
		Incidencia i = new Incidencia(5, "Con fecha", "Test fecha", LocalDate.of(2024, 1, 1), "Abierta", "Mario",
				"mario@ejemplo.com");
		dao.crear(i);
		Incidencia r = dao.buscarPorId(i.getId());
		assertEquals(LocalDate.of(2024, 1, 1), r.getFechaCreacion());
	}

	@Test
	public void testConcurrenciaPoolConexiones() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Callable<Boolean>> tareas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			tareas.add(() -> {
				Incidencia i1 = new Incidencia(6, "Concurrencia " + finalI, "Test", LocalDate.now(), "Abierta",
						"Técnico", "t@t.com");
				return dao.crear(i1);
			});
		}
		List<Future<Boolean>> resultados = executor.invokeAll(tareas);
		for (Future<Boolean> r : resultados) {
			assertTrue(r.get(), "Falló una inserción concurrente.");
		}
		executor.shutdown();
	}
}
