package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Incidencia {

	private int id;
	private String titulo;
	private String descripcion;
	private Date fechaCreacion;
	private LocalDate fechaCreacion2;
	private int estado;
	private int tecnico;

	public Incidencia() {
	}

	public Incidencia(String titulo, String descripcion, Date fechaCreacion, int estado, int tecnico) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.tecnico = tecnico;
	}

	public Incidencia(int id, String titulo, String descripcion, Date fechaCreacion, int estado, int tecnico) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.tecnico = tecnico;
	}

	public Incidencia(int id, String titulo, String descripcion, int estado, int tecnico) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tecnico = tecnico;
	}

	public Incidencia(int id, String titulo, String descripcion, LocalDate fechaCreacion2, int estado, int tecnico) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion2 = fechaCreacion2;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getTecnico() {
		return tecnico;
	}

	public void setTecnico(int tecnico) {
		this.tecnico = tecnico;
	}

	public LocalDate getFechaCreacion2() {
		return fechaCreacion2;
	}

	public void setFechaCreacion2(LocalDate fechaCreacion2) {
		this.fechaCreacion2 = fechaCreacion2;
	}

	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", estado=" + estado + ", tecnico=" + tecnico + "]";
	}

}
