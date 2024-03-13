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

import com.aravena.arriendolibrosbackend.model.Idioma;
import com.aravena.arriendolibrosbackend.service.IdiomaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/idioma")
public class IdiomaController {

	@Autowired
	IdiomaService idiomaService;
	
	@ApiOperation(value = "Obtener todos los Idiomas existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Idiomas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<Idioma> findAll(){
        return idiomaService.findAll();
    }

	@ApiOperation(value = "Obtener Idioma existente por Id",
            notes = "Se necesita el id del idioma como parametros de entrada",
            response = Idioma.class,
            responseContainer = "Idioma")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Idioma findById(@PathVariable("id") Integer id){
        return idiomaService.findById(id);
    }

	@ApiOperation(value = "Crea un nuevo Idioma",
            notes = "Se necesitan los parametros del Idioma",
            response = Idioma.class,
            responseContainer = "Idioma")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Idioma save(@RequestBody Idioma idioma){
        return idiomaService.save(idioma);
    }

	@ApiOperation(value = "Actualiza un Idioma existente en el sistema",
            notes = "Se necesitan los parametros de Idioma",
            response = Idioma.class,
            responseContainer = "Idioma")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Idioma update(@RequestBody Idioma idioma){
        return idiomaService.update(idioma);
    }

	@ApiOperation(value = "Elimina un Idioma del sistema",
            notes = "Se necesita el id del idioma como parametros de entrada",
            response = String.class,
            responseContainer = "Idioma")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return idiomaService.delete(id);
    }
}
