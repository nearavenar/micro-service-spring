package cl.aravena.microservicioproducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aravena.microservicioproducto.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	public Producto findOneByNombre(String nombre);
}
