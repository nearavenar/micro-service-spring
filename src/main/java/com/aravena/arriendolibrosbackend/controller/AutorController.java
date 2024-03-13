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

import com.aravena.arriendolibrosbackend.model.Autor;
import com.aravena.arriendolibrosbackend.service.AutorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	AutorService autorService;
	
	@ApiOperation(value = "Obtener todos los autores existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Autores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	@GetMapping
    public List<Autor> findAll(){
        return autorService.findAll();
    }

	@ApiOperation(value = "Obtener autor existente por Id",
            notes = "Se necesita el id del autor como parametros de entrada",
            response = Autor.class,
            responseContainer = "Autor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Autor findById(@PathVariable("id") Integer id){
        return autorService.findById(id);
    }

	@ApiOperation(value = "Crea un nuevo Autor",
            notes = "Se necesitan los parametros de Autor",
            response = Autor.class,
            responseContainer = "Autor")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Autor save(@RequestBody Autor autor){
        return autorService.save(autor);
    }

	@ApiOperation(value = "Actualiza un Autor existente en el sistema",
            notes = "Se necesitan los parametros de Autor",
            response = Autor.class,
            responseContainer = "Autor")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Autor update(@RequestBody Autor autor){
        return autorService.update(autor);
    }

	@ApiOperation(value = "Elimina un Autor del sistema",
            notes = "Se necesita el id del autor como parametros de entrada",
            response = boolean.class,
            responseContainer = "Autor")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id){
        return autorService.delete(id);
    }
}
