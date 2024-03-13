package cl.aravena.microservicioproducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aravena.microservicioproducto.models.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
