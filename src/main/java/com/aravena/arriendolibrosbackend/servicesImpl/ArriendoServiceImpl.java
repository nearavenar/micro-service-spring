package com.aravena.arriendolibrosbackend.servicesImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aravena.arriendolibrosbackend.constant.Constant;
import com.aravena.arriendolibrosbackend.dto.DetalleArriendoDTO;
import com.aravena.arriendolibrosbackend.model.Arriendo;
import com.aravena.arriendolibrosbackend.model.EstadoArriendo;
import com.aravena.arriendolibrosbackend.repository.ArriendoRepository;
import com.aravena.arriendolibrosbackend.repository.EstadoArriendoRepository;
import com.aravena.arriendolibrosbackend.repository.LibroRepository;
import com.aravena.arriendolibrosbackend.repository.UsuarioRepository;
import com.aravena.arriendolibrosbackend.service.ArriendoService;
import com.aravena.arriendolibrosbackend.util.Utils;

import org.hibernate.exception.ConstraintViolationException;

@Service
public class ArriendoServiceImpl implements ArriendoService{

	@Autowired
	private ArriendoRepository arriendoRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EstadoArriendoRepository estadoArriendoRepository;
	
	@Override
	public List<Arriendo> findAll() {
		return arriendoRepository.findAll();
	}

	@Override
	public Arriendo findById(Integer id) {
		Arriendo arriendo = arriendoRepository.findOneByIdArriendo(id);
		if (arriendo == null) {
			throw new UsernameNotFoundException(String.format("Arriendo no existe", id));
		} else {
			return arriendo;
		}
	}

	@Transactional
	@Override
	public Arriendo save(Arriendo arriendo) {
		String validar = Utils.validarModelos(arriendo); 
		if(validar.isEmpty()) {
			
			if(LocalDate.parse(arriendo.getFechaArriendoDesde().toString())
					.isAfter(LocalDate.parse(arriendo.getFechaArriendoHasta().toString()))){
				throw new ValidationException("Fecha desde no puede ser mayor a fecha hasta");
			}

			if(usuarioRepository.findOneByIdUsuario(arriendo.getUsuario().getIdUsuario()) == null) {
				throw new UsernameNotFoundException("El id del usuario no existe");
			}
			
			if(libroRepository.findOneByIdLibro(arriendo.getLibro().getIdLibro()) == null) {
				throw new UsernameNotFoundException("El id del libro no existe");
			}
			
			if(estadoArriendoRepository.findOneByIdEstadoArriendo(arriendo.getEstadoArriendo().getIdEstadoArriendo()) == null) {
				throw new UsernameNotFoundException("El id de estado de arriendo no existe");
			}
			
			if(libroRepository.verStockDisponible(arriendo.getLibro().getIdLibro())<1) {
				throw new ValidationException("No hay stock suficientes del libro para arrendar");
			}
			
			arriendo.setFechaArriendo(LocalDateTime.now());
			Arriendo arr = arriendoRepository.save(arriendo);			
			arriendoRepository.restarStockLibro(arriendo.getLibro().getIdLibro());
			arriendoRepository.actualizaEstadoArriendo(arr.getEstadoArriendo().getIdEstadoArriendo(), Constant.ARRENDAR_LIBRO);
			return arr;
		}else {			
			throw new ValidationException(validar);
		}
	}


	@Transactional
	@Override
	public Arriendo devolverArriendoLibro(Integer idArriendo) {
		
		Arriendo arriendo = arriendoRepository.findOneByIdArriendo(idArriendo);
		
		if (arriendo == null) {
			throw new UsernameNotFoundException(String.format("Arriendo no existe para devolver", idArriendo));
		} 
		 
		arriendoRepository.sumarStockLibro(arriendo.getLibro().getIdLibro());
		arriendoRepository.actualizaEstadoArriendo(idArriendo, Constant.DEVOLVER_LIBRO);
		return arriendoRepository.findOneByIdArriendo(idArriendo);
	}
	
	@Override
	public Arriendo update(Arriendo arriendo) {
		if (arriendoRepository.findOneByIdArriendo(arriendo.getIdArriendo()) == null) {
			throw new UsernameNotFoundException(String.format("Arriendo no existe para modificar", arriendo.getIdArriendo()));
		}
		
		String validar = Utils.validarModelos(arriendo); 
		if(validar.isEmpty()) {
			
			return arriendoRepository.save(arriendo);
		}else {			
			throw new ValidationException(validar);
		}
	}

	@Override
	public String delete(Integer id) {
		if (arriendoRepository.findOneByIdArriendo(id) == null) {
			throw new UsernameNotFoundException(String.format("Arriendo no existe para eliminar", id));
		} else {
			arriendoRepository.deleteById(id);
		}
		return "Arriendo eliminado correctamente";
	}

	@Override
	public List<DetalleArriendoDTO> listarTodosLosArriendos() {
		List<DetalleArriendoDTO> listaArriendos = new ArrayList<>();		
		arriendoRepository.listarTodosArriendos().forEach(x -> {
			DetalleArriendoDTO dto = new DetalleArriendoDTO();
			dto.setTituloLibro(String.valueOf(x[0]));
			dto.setFechaPublicacion(String.valueOf(x[1]));
			dto.setDescripcion(String.valueOf(x[2]));
			dto.setEditorial(String.valueOf(x[3]));
			dto.setGenero(String.valueOf(x[4]));
			dto.setAutor(String.valueOf(x[5]));
			dto.setIdioma(String.valueOf(x[6]));
			dto.setPaginas(Integer.parseInt(String.valueOf(x[7])));
			dto.setValorDiario(Integer.parseInt(String.valueOf(x[8])));
			dto.setFechaArriendo(String.valueOf(x[9]));
			dto.setFechaDesde(String.valueOf(x[10]));
			dto.setFechaHasta(String.valueOf(x[11]));			
			dto.setValorTotal(Utils.separadorMiles(Integer.parseInt(String.valueOf(x[12]))));			
			dto.setNombreUsuario(String.valueOf(x[13]));
			dto.setEmail(String.valueOf(x[14]));
			dto.setDireccion(String.valueOf(x[15]));
			dto.setTelefono(String.valueOf(x[16]));
			dto.setDiasArriendo(Integer.parseInt(String.valueOf(x[17])));
			dto.setEstado(String.valueOf(x[18]));	
			dto.setIdArriendo(Integer.parseInt(String.valueOf(x[19])));
			
			listaArriendos.add(dto);
		});
		return listaArriendos;
	}

	@Override
	public List<DetalleArriendoDTO> listarArriendosPorUsuario(int idUsuario) {
		List<DetalleArriendoDTO> listaArriendos = new ArrayList<>();
		arriendoRepository.listarArriendosPorUsuario(idUsuario).forEach(x -> {

			DetalleArriendoDTO dto = new DetalleArriendoDTO();
			dto.setTituloLibro(String.valueOf(x[0]));
			dto.setFechaPublicacion(String.valueOf(x[1]));
			dto.setDescripcion(String.valueOf(x[2]));
			dto.setEditorial(String.valueOf(x[3]));
			dto.setGenero(String.valueOf(x[4]));
			dto.setAutor(String.valueOf(x[5]));
			dto.setIdioma(String.valueOf(x[6]));
			dto.setPaginas(Integer.parseInt(String.valueOf(x[7])));
			dto.setValorDiario(Integer.parseInt(String.valueOf(x[8])));
			dto.setFechaArriendo(String.valueOf(x[9]));
			dto.setFechaDesde(String.valueOf(x[10]));
			dto.setFechaHasta(String.valueOf(x[11]));			
			dto.setValorTotal(Utils.separadorMiles(Integer.parseInt(String.valueOf(x[12]))));			
			dto.setNombreUsuario(String.valueOf(x[13]));
			dto.setEmail(String.valueOf(x[14]));
			dto.setDireccion(String.valueOf(x[15]));
			dto.setTelefono(String.valueOf(x[16]));
			dto.setDiasArriendo(Integer.parseInt(String.valueOf(x[17])));
			dto.setEstado(String.valueOf(x[18]));
			dto.setIdArriendo(Integer.parseInt(String.valueOf(x[19])));
			
			listaArriendos.add(dto);
		});
		return listaArriendos;
	}
}
