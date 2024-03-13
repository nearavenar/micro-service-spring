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

import com.aravena.arriendolibrosbackend.model.Editorial;
import com.aravena.arriendolibrosbackend.service.EditorialService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

	@Autowired
	EditorialService editorialService;
	
	@ApiOperation(value = "Obtener todas las Editoriales existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Editorial")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	@GetMapping
    public List<Editorial> findAll(){
        return editorialService.findAll();
    }

	@ApiOperation(value = "Obtener Editoriales existente por Id",
            notes = "Se necesita el id de la Editoriales como parametros de entrada",
            response = Editorial.class,
            responseContainer = "Editorial")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Editorial findById(@PathVariable("id") Integer id){
        return editorialService.findById(id);
    }

	@ApiOperation(value = "Crea un nuevo Editorial",
            notes = "Se necesitan los parametros del Editorial",
            response = Editorial.class,
            responseContainer = "Editorial")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Editorial save(@RequestBody Editorial editorial){
        return editorialService.save(editorial);
    }

	@ApiOperation(value = "Actualiza una Editorial existente en el sistema",
            notes = "Se necesitan los parametros de la Editorial",
            response = Editorial.class,
            responseContainer = "Editorial")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Editorial update(@RequestBody Editorial editorial){
        return editorialService.update(editorial);
    }

	@ApiOperation(value = "Elimina un Editorial del sistema",
            notes = "Se necesita el id de la Editorial como parametros de entrada",
            response = String.class,
            responseContainer = "Editorial")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return editorialService.delete(id);
    }
}
