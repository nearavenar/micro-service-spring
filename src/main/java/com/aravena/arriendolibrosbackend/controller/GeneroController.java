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

import com.aravena.arriendolibrosbackend.model.Genero;
import com.aravena.arriendolibrosbackend.service.GeneroService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	private GeneroService generoService;
	
	@ApiOperation(value = "Obtener todos los Generos existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Genero")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	@GetMapping
    public List<Genero> findAll(){
        return generoService.findAll();
    }

	@ApiOperation(value = "Obtener Genero existente por Id",
            notes = "Se necesita el id del Genero como parametros de entrada",
            response = Genero.class,
            responseContainer = "Genero")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Genero findById(@PathVariable("id") Integer id){
        return generoService.findById(id);
    }

	
	@ApiOperation(value = "Crea un nuevo Genero",
            notes = "Se necesitan los parametros del Genero",
            response = Genero.class,
            responseContainer = "Genero")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Genero save(@RequestBody Genero genero){
        return generoService.save(genero);
    }

	@ApiOperation(value = "Actualiza un Genero existente en el sistema",
            notes = "Se necesitan los parametros de Genero",
            response = Genero.class,
            responseContainer = "Genero")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Genero update(@RequestBody Genero genero){
        return generoService.update(genero);
    }

	@ApiOperation(value = "Elimina un Genero del sistema",
            notes = "Se necesita el id del Genero como parametros de entrada",
            response = String.class,
            responseContainer = "Genero")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return generoService.delete(id);
    }
}
