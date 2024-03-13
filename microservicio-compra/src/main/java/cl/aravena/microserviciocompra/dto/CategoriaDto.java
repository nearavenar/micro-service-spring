package cl.aravena.microserviciocompra.dto;

public class CategoriaDto {

	private Integer idCategoria;	
	private String descripcion;
	
	public CategoriaDto() {
		
	}
	
	public CategoriaDto(Integer idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CategoriaDto [idCategoria=" + idCategoria + ", descripcion=" + descripcion + "]";
	}
}
