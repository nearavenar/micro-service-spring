package cl.aravena.microserviciocompra.dto;

public class ProductoDto {

	private Integer idProducto;
	private String nombre;	
	private String descripcion;
	private Integer valor;
	private int stock;
	private CategoriaDto categoria;
	private ProveedorDto proveedor;
	
	public ProductoDto() {
		
	}
	
	public ProductoDto(Integer idProducto, String nombre, String descripcion, Integer valor, int stock,
			CategoriaDto categoria, ProveedorDto proveedor) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.stock = stock;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}

	public ProveedorDto getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDto proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "ProductoDto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", valor=" + valor + ", stock=" + stock + ", categoria=" + categoria + ", proveedor=" + proveedor
				+ "]";
	}
}
