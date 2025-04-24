package modelo;

import java.time.LocalDate;

public class Incidencia {

	private int id;
	private String titulo;
	private String descripcion;
	private LocalDate fechaCreacion;
	private Estado estado;
	private Tecnico tecnico;

	public Incidencia() {
	}

	public Incidencia(String titulo, String descripcion, LocalDate fechaCreacion, Estado estado, Tecnico tecnico) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.tecnico = tecnico;
	}

	public Incidencia(int id, String titulo, String descripcion, LocalDate fechaCreacion, Estado estado,
			Tecnico tecnico) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.tecnico = tecnico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", estado=" + estado + ", tecnico=" + tecnico + "]";
	}

}
