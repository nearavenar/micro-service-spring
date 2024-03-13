package cl.aravena.microserviciocompra.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.bouncycastle.asn1.icao.ICAOObjectIdentifiers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aravena.microserviciocompra.client.ProductoClient;
import cl.aravena.microserviciocompra.dto.CompraDto;
import cl.aravena.microserviciocompra.dto.DetalleCompraDto;
import cl.aravena.microserviciocompra.dto.ProductoDto;
import cl.aravena.microserviciocompra.models.Compra;
import cl.aravena.microserviciocompra.models.DetalleCompra;
import cl.aravena.microserviciocompra.models.DetalleCompraPk;
import cl.aravena.microserviciocompra.repository.CompraRepository;
import cl.aravena.microserviciocompra.repository.DetalleCompraRepository;

@Service
public class CompraServiceImpl implements CompraService, DetalleCompraService{

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private DetalleCompraRepository detalleCompraRepository;
	
	@Autowired
	private ProductoClient productoClient;
	
	@Override
	public List<Compra> findAllCompra() {
		return compraRepository.findAll();
	}

	@Override
	public Compra findByIdCompra(Integer id) {
		return compraRepository.findById(id).orElse(null);
	}

	@Override
	public Compra saveCompra(Compra c) {
		return compraRepository.save(c);
	}
	
	@Override
	@Transactional
	public CompraDto saveCompra(CompraDto c) {
		
		Compra compra = new Compra();
		compra.setIdUsuario(c.getIdUsuario());
		compra.setFecha(c.getFecha());
		compra.setTotalCompra(c.getTotalCompra());
		
		Compra idCompra = compraRepository.save(compra);
		
		CompraDto compraDto = new CompraDto(idCompra);
		
		List<DetalleCompraDto> listaDetalle = new ArrayList<DetalleCompraDto>();
		
		for (DetalleCompraDto dto : c.getDetalleCompraDto()) {
			DetalleCompra detalle = new DetalleCompra();
			
			DetalleCompraPk id = new DetalleCompraPk();
			id.setIdCompra(idCompra.getIdCompra());
			id.setIdProducto(dto.getIdProducto());
			
			detalle.setValor(dto.getValor());
			detalle.setCantidad(dto.getCantidad());
			detalle.setId(id);
			
			DetalleCompra detalleCompra = detalleCompraRepository.save(detalle);

			DetalleCompraDto detalleCompraDto = new DetalleCompraDto(detalleCompra);
			
			listaDetalle.add(detalleCompraDto);
			
		}
		
		compraDto.setDetalleCompraDto(listaDetalle);
		return compraDto;
	}

	@Override
	public Compra updateCompra(Compra c) {
		Compra ProductoUpd = findByIdCompra(c.getIdCompra());
		ProductoUpd.setFecha(c.getFecha());
		ProductoUpd.setTotalCompra(c.getTotalCompra());		
		return compraRepository.save(c);
	}
	
	@Override
	@Transactional
	public CompraDto updateCompra(CompraDto c) {
		
		Compra compraUpd = compraRepository.findCompraByIdCompraAndIdUsuario(c.getIdCompra(), c.getIdUsuario());
		CompraDto compraDto = null;

		if(compraUpd!=null) {			
			Compra compra = new Compra();
			compra.setIdCompra(compraUpd.getIdCompra());
			compra.setIdUsuario(compraUpd.getIdUsuario());
			compra.setFecha(c.getFecha());
			compra.setTotalCompra(c.getTotalCompra());
			
			compraRepository.save(compra);
			
			compraDto = new CompraDto(compra);
			
			List<DetalleCompraDto> listaDetalle = new ArrayList<DetalleCompraDto>();
			
			List<DetalleCompra> ListaDetalleCom = detalleCompraRepository.findByIdCompra(compraUpd.getIdCompra());
			
			int x = 0;
			for (DetalleCompra dto : ListaDetalleCom) {
				DetalleCompra detalle = new DetalleCompra();
				
				detalle.setValor(c.getDetalleCompraDto().get(x).getValor());
				detalle.setCantidad(c.getDetalleCompraDto().get(x).getCantidad());
				
				DetalleCompraPk id = new DetalleCompraPk();
				id.setIdCompra(dto.getId().getIdCompra());
				id.setIdProducto(dto.getId().getIdProducto());
				
				detalle.setId(id);
				
				DetalleCompra detalleCompra = detalleCompraRepository.save(detalle);

				DetalleCompraDto detalleCompraDto = new DetalleCompraDto(detalleCompra);
				
				listaDetalle.add(detalleCompraDto);
				x=x+1;
			}
			
			compraDto.setDetalleCompraDto(listaDetalle);
		}
		return compraDto;
	}

	@Override
	public void deleteByIdCompra(Integer id) {
		compraRepository.deleteById(id);
	}

	@Override
	public List<DetalleCompra> findAllDetalleCompra() {
		return detalleCompraRepository.findAll();
	}

	@Override
	public DetalleCompra findByIdDetalleCompra(Integer id) {
		return detalleCompraRepository.findById(id).orElse(null);
	}

	@Override
	public DetalleCompra saveDetalleCompra(DetalleCompra d) {
		return detalleCompraRepository.save(d);
	}

	@Override
	public DetalleCompra updateDetalleCompra(DetalleCompra d) {
		DetalleCompra detalleCompraUpd = findByIdDetalleCompra(d.getId().getIdCompra());
		detalleCompraUpd.setCantidad(d.getCantidad());
		detalleCompraUpd.setValor(d.getValor());		
		return detalleCompraRepository.save(detalleCompraUpd);
	}

	@Override
	public void deleteByIdDetalleCompra(Integer id) {
		detalleCompraRepository.deleteById(id);
	}

	@Override
	public CompraDto findDetalleCompraByIdCompraAndIdUser(Integer idCompra, Integer idUser) {
		Compra compra = compraRepository.findCompraByIdCompraAndIdUsuario(idCompra, idUser);
		CompraDto compraDto = null;
		if(compra != null) {
			List<DetalleCompra> listaDetalleCompra = detalleCompraRepository.findByIdCompra(idCompra);
			
			List<DetalleCompraDto> listaDetalleCompraDto = new ArrayList<DetalleCompraDto>();
			for (DetalleCompra detalleCompra : listaDetalleCompra) {
				DetalleCompraDto detalleCompraDto = new DetalleCompraDto(detalleCompra.getId().getIdCompra()
						, detalleCompra.getId().getIdProducto(), detalleCompra.getCantidad(), detalleCompra.getValor());
				listaDetalleCompraDto.add(detalleCompraDto);
			}
			
			compraDto = new CompraDto(compra.getIdCompra(), compra.getIdUsuario()
			                      	, compra.getFecha(), compra.getTotalCompra(), listaDetalleCompraDto);
		}
		
		return compraDto;
	}
	
	@Override
	public List<CompraDto> findDetalleCompraByIdUser(Integer idUser) {		
		List<CompraDto> listaCompraaDto = new ArrayList<CompraDto>();

		List<Compra> listaCompras = compraRepository.findByIdUsuario(idUser);
		
		for (Compra compra : listaCompras) {
			
			CompraDto compraDto = new CompraDto();
			compraDto.setIdCompra(compra.getIdCompra());
			compraDto.setIdUsuario(compra.getIdUsuario());
			compraDto.setFecha(compra.getFecha());
			compraDto.setTotalCompra(compra.getTotalCompra());
			
			List<DetalleCompra> listaDetalleCompra = detalleCompraRepository.findByIdCompra(compra.getIdCompra());

			List<DetalleCompraDto> listaDetalleCompraDto = new ArrayList<DetalleCompraDto>();
			
			for (DetalleCompra detalleCompra : listaDetalleCompra) {
				DetalleCompraDto detalleCompraDto = new DetalleCompraDto(detalleCompra.getId().getIdCompra()
						, detalleCompra.getId().getIdProducto(), detalleCompra.getCantidad(), detalleCompra.getValor());
				listaDetalleCompraDto.add(detalleCompraDto);
			}
			
			compraDto.setDetalleCompraDto(listaDetalleCompraDto);
			
			listaCompraaDto.add(compraDto);
		}
		
		return listaCompraaDto;
	}
	
	@Override
	public List<ProductoDto> findAllProductos() {
		return productoClient.findAll();
	}
	
	@Override
	public ProductoDto findByIdProducto(Integer id) {
		return productoClient.findById(id);
	}
}
