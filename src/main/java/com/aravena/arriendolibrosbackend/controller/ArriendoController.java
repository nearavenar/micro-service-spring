package com.aravena.arriendolibrosbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravena.arriendolibrosbackend.dto.DetalleArriendoDTO;
import com.aravena.arriendolibrosbackend.model.Arriendo;
import com.aravena.arriendolibrosbackend.service.ArriendoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/arriendo")
public class ArriendoController {

	@Autowired
	ArriendoService arriendoService;
	
	@ApiOperation(value = "Obtener todos los Arriendo de libros existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Arriendos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<Arriendo> findAll(){
        return arriendoService.findAll();
    }

	@ApiOperation(value = "Obtener Arriendo de libros existente por Id",
            notes = "Se necesita el id del Arriendo como parametros de entrada",
            response = Arriendo.class,
            responseContainer = "Arriendo")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Arriendo findById(@PathVariable("id") Integer id){
        return arriendoService.findById(id);
    }

	@ApiOperation(value = "Crea un nuevo Arriendo de libro",
            notes = "Se necesitan los parametros del Arriendo",
            response = Arriendo.class,
            responseContainer = "Arriendo")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Arriendo save(@RequestBody Arriendo arriendo){
        return arriendoService.save(arriendo);
    }
	
	@ApiOperation(value = "El usuario devuelve el libro arrendado existente en el sistema",
            notes = "Se necesita el id del arriendo, (actualiza el estado a ENTREGADO y el STOCK del libro)",
            response = Arriendo.class,
            responseContainer = "Arriendo")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/devolverArriendoLibro/{id}")
    public Arriendo devolverArriendoLibro(@PathVariable("id") Integer id){
        return arriendoService.devolverArriendoLibro(id);
    }

	@ApiOperation(value = "Actualiza un Arriendo existente en el sistema",
            notes = "Se necesitan los parametros de Arriendo",
            response = Arriendo.class,
            responseContainer = "Arriendo")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Arriendo update(@RequestBody Arriendo arriendo){
        return arriendoService.update(arriendo);
    }

	@ApiOperation(value = "Elimina un Arriendo del sistema",
            notes = "Se necesita el id del arriendo como parametros de entrada",
            response = String.class,
            responseContainer = "Arriendo")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return arriendoService.delete(id);
    }
	
	
	@ApiOperation(value = "Obtener todo el detalle de los Arriendo de libros existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "DetalleArriendoDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/listarDetalleArriendos")
    public List<DetalleArriendoDTO> listarTodosLosArriendos(){
        return arriendoService.listarTodosLosArriendos();
    }

	@ApiOperation(value = "Obtener detalle de los Arriendo de libros existente por Id",
            notes = "Se necesita el id del Usuario como parametros de entrada",
            response = List.class,
            responseContainer = "DetalleArriendoDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/listarDetalleArriendos/{id}")
    public List<DetalleArriendoDTO>  listarArriendosPorUsuario(@PathVariable("id") Integer id){
        return arriendoService.listarArriendosPorUsuario(id);
    }
}
