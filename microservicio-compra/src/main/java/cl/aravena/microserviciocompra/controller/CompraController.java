package cl.aravena.microserviciocompra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.aravena.microserviciocompra.dto.CompraDto;
import cl.aravena.microserviciocompra.dto.ProductoDto;
import cl.aravena.microserviciocompra.models.Compra;
import cl.aravena.microserviciocompra.models.DetalleCompra;
import cl.aravena.microserviciocompra.service.CompraServiceImpl;

@RestController
public class CompraController {

	@Autowired
	private CompraServiceImpl compraService;
	
	@Value("${server.port}")
	private Integer puerto;
	
	@GetMapping("/buscaTodasCompras")
	public List<Compra> findAll(){
		return compraService.findAllCompra();
	}
	
	@GetMapping("/buscarCompraPorId/{id}")
	public Compra findById(@PathVariable("id") Integer id) {
		Compra producto = compraService.findByIdCompra(id);
		return producto;
	}
	
	@PostMapping("/crearCompra")
	@ResponseStatus(HttpStatus.CREATED)
	public CompraDto save(@RequestBody CompraDto producto){
		return compraService.saveCompra(producto);
	}
	
	@PutMapping("/actualizarCompra")
	@ResponseStatus(HttpStatus.CREATED)
	public CompraDto update(@RequestBody CompraDto producto){
		return compraService.updateCompra(producto);
	}
	
	@DeleteMapping("/eliminaCompraPorId/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		compraService.deleteByIdCompra(id);
	}
	
	@GetMapping("/detalleCompra")
	public List<DetalleCompra> findAllDetalleCompra(){
		return compraService.findAllDetalleCompra();
	}
	
	@GetMapping("/detalleCompraPorId/{idCompra}/{idUser}")
	public CompraDto findDetalleCompraByIdCompraAndIdUser(@PathVariable("idCompra") Integer id
			                                             ,@PathVariable("idUser") Integer idUser) {
		System.out.println("puerto:" + puerto);
		CompraDto compraDto = compraService.findDetalleCompraByIdCompraAndIdUser(id, idUser);
		return compraDto;
	}
	
	@GetMapping("/detalleCompraPorIdUsuario/{idUser}")
	public List<CompraDto> findDetalleCompraByIdUser(@PathVariable("idUser") Integer idUser) {
		System.out.println("puerto:" + puerto);
		List<CompraDto> compraDto = compraService.findDetalleCompraByIdUser(idUser);
		return compraDto;
	}

	@GetMapping("/listaTodosProductos")
	public List<ProductoDto> findAllProductos(){
		return compraService.findAllProductos();
	}
	
	@GetMapping("/buscarProductoPorId/{id}")
	public ProductoDto findByIdProducto(@PathVariable("id") Integer id) {		
		return compraService.findByIdProducto(id);
	}
}
