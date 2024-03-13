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

import com.aravena.arriendolibrosbackend.model.EstadoArriendo;
import com.aravena.arriendolibrosbackend.service.EstadoArriendoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/estadoArriendo")
public class EstadoArriendoController {

	@Autowired
	private EstadoArriendoService estadoArriendoService;
	
	@ApiOperation(value = "Obtener todos los estado del arriendo existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "estadoArriendo")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	@GetMapping
    public List<EstadoArriendo> findAll(){
        return estadoArriendoService.findAll();
    }

	@ApiOperation(value = "Obtener el estado del arriendo existente por Id",
            notes = "Se necesita el id del estado del arriendo como parametros de entrada",
            response = EstadoArriendo.class,
            responseContainer = "EstadoArriendo")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public EstadoArriendo findById(@PathVariable("id") Integer id){
        return estadoArriendoService.findById(id);
    }

	
	@ApiOperation(value = "Crea un nuevo Estado del arriendo",
            notes = "Se necesitan los parametros del Estado del arriendo",
            response = EstadoArriendo.class,
            responseContainer = "EstadoArriendo")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public EstadoArriendo save(@RequestBody EstadoArriendo genero){
        return estadoArriendoService.save(genero);
    }

	@ApiOperation(value = "Actualiza un  Estado del arriendo existente en el sistema",
            notes = "Se necesitan los parametros de Estado del arriendo",
            response = EstadoArriendo.class,
            responseContainer = "EstadoArriendo")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public EstadoArriendo update(@RequestBody EstadoArriendo genero){
        return estadoArriendoService.update(genero);
    }

	@ApiOperation(value = "Elimina un Estado del arriendo del sistema",
            notes = "Se necesita el id del Estado del arriendo como parametros de entrada",
            response = String.class,
            responseContainer = "EstadoArriendo")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return estadoArriendoService.delete(id);
    }
}
