package ar.edu.unju.fi.model;

public class ConsejosDeSalud {
    private String titulo;
    private String descripcion;

    // Constructor parametrizado
    public ConsejosDeSalud(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Getters y setters
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

	public int getId() {
		return 0;
	}
}
