package cl.aravena.microservicioproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aravena.microservicioproductos.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	public Producto findOneByNombre(String nombre);
}
