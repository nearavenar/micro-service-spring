package cl.aravena.microserviciocompra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aravena.microserviciocompra.models.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

	public List<Compra> findByIdUsuario(Integer idUsuario);
	public Compra findCompraByIdCompraAndIdUsuario(Integer idCompra, Integer idUser);
}
