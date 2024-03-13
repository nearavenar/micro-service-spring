package com.aravena.arriendolibrosbackend.service;

import java.util.List;

import com.aravena.arriendolibrosbackend.dto.DetalleArriendoDTO;
import com.aravena.arriendolibrosbackend.model.Arriendo;;

public interface ArriendoService {
	public List<Arriendo> findAll();
	public Arriendo findById(Integer id);
	public Arriendo save(Arriendo autor);
	public Arriendo update(Arriendo autor);
	public String delete(Integer id);
	public List<DetalleArriendoDTO> listarTodosLosArriendos();
	public List<DetalleArriendoDTO> listarArriendosPorUsuario(int idUsuario) ;
	public Arriendo devolverArriendoLibro(Integer idArriendo);
}
