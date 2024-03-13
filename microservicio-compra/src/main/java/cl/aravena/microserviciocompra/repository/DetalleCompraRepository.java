package cl.aravena.microserviciocompra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.aravena.microserviciocompra.models.DetalleCompra;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {

	@Query(value = "select d.id_compra, d.id_producto, d.cantidad, d.valor from detalle_compra d where d.id_compra = :idCompra", nativeQuery = true)
	public List<DetalleCompra> findByIdCompra(Integer idCompra);
	//public List<Object[]> listarTodosArriendos();
}
