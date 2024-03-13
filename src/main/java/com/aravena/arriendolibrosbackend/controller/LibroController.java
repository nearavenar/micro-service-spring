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

import com.aravena.arriendolibrosbackend.model.Libro;
import com.aravena.arriendolibrosbackend.service.LibroService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/libro")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class LibroController {

	@Autowired
	LibroService libroService;
	
	@ApiOperation(value = "Obtener todos los libros existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Libros")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron libros en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping
    public List<Libro> findAll(){
        return libroService.findAll();
    }

	@ApiOperation(value = "Obtener Libro existente por Id",
            notes = "Se necesita el id del Libro como parametros de entrada",
            response = Libro.class,
            responseContainer = "Idioma")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Libro findById(@PathVariable("id") Integer id){
        return libroService.findById(id);
    }

	@ApiOperation(value = "Crea un nuevo Libro",
            notes = "Se necesitan los parametros del Libro",
            response = Libro.class,
            responseContainer = "Libro")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Libro save(@RequestBody Libro libro){
        return libroService.save(libro);
    }

	@ApiOperation(value = "Actualiza un Libro existente en el sistema",
            notes = "Se necesitan los parametros de Libro",
            response = Libro.class,
            responseContainer = "Libro")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Libro update(@RequestBody Libro libro){
        return libroService.update(libro);
    }

	@ApiOperation(value = "Elimina un Libro del sistema",
            notes = "Se necesita el id del Libro como parametros de entrada",
            response = String.class,
            responseContainer = "Libro")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return libroService.delete(id);
    }
}
