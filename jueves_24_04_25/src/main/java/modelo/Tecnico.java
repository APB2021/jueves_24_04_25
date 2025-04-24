package modelo;

public class Tecnico {

	private int id;
	private String nombre;
	private String email;

	public Tecnico() {
	}

	public Tecnico(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public Tecnico(int id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
