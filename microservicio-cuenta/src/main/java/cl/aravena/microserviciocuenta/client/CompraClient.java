package cl.aravena.microserviciocuenta.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.aravena.microserviciocuenta.dto.CompraDto;

@FeignClient("servicio-compra")
public interface CompraClient {

	@GetMapping("/detalleCompraPorIdUsuario/{idUser}")
	public List<CompraDto> findDetalleCompraByIdUser(@PathVariable("idUser") Integer idUser);
	
	@GetMapping("/detalleCompraPorId/{idCompra}/{idUser}")
	public CompraDto findDetalleCompraByIdCompraAndIdUser(@PathVariable("idCompra") Integer id
			                                             ,@PathVariable("idUser") Integer idUser);
}
