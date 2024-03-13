package cl.aravena.microservicioproducto.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.ForeignKey;

@Entity
public class Producto  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto", nullable = false)
	private Integer idProducto;
	
	@Column(nullable = false, unique = true)
	private String nombre;	
	
	private String descripcion;
	
	private Integer valor;
	
	private int stock;
	
	@ManyToOne
    @JoinColumn(name="id_categoria", nullable=false, foreignKey = @ForeignKey(name = "id_categoria_fk"))
    private Categoria categoria;
	
	@ManyToOne
    @JoinColumn(name="rut_proveedor", nullable=false, foreignKey = @ForeignKey(name = "rut_proveedor_fk"))
    private Proveedor proveedor;
	
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", valor="
				+ valor + ", stock=" + stock + ", categoria=" + categoria + ", proveedor=" + proveedor + "]";
	}
	
	private static final long serialVersionUID = 334323035017066480L;
}