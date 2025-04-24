package modelo;

public class Estado {

	private int id;
	private String estadoIncidencia;

	public Estado() {
	}

	public Estado(String estadoIncidencia) {
		this.estadoIncidencia = estadoIncidencia;
	}

	public Estado(int id, String estadoIncidencia) {
		this.id = id;
		this.estadoIncidencia = estadoIncidencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstadoIncidencia() {
		return estadoIncidencia;
	}

	public void setEstadoIncidencia(String estadoIncidencia) {
		this.estadoIncidencia = estadoIncidencia;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", estadoIncidencia=" + estadoIncidencia + "]";
	}

}
