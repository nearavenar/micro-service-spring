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

import com.aravena.arriendolibrosbackend.model.Rol;
import com.aravena.arriendolibrosbackend.service.RolService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@ApiOperation(value = "Obtener todos los Roles existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Rol")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	@GetMapping
    public List<Rol> findAll(){
        return rolService.findAll();
    }

	@ApiOperation(value = "Obtener Rol existente por Id",
            notes = "Se necesita el id del Rol como parametros de entrada",
            response = Rol.class,
            responseContainer = "Rol")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Rol findById(@PathVariable("id") Integer id){
        return rolService.findById(id);
    }

	
	@ApiOperation(value = "Crea un nuevo Rol",
            notes = "Se necesitan los parametros del Rol",
            response = Rol.class,
            responseContainer = "Rol")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Rol save(@RequestBody Rol rol){
        return rolService.save(rol);
    }

	@ApiOperation(value = "Actualiza un Rol existente en el sistema",
            notes = "Se necesitan los parametros del Rol",
            response = Rol.class,
            responseContainer = "Rol")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Rol update(@RequestBody Rol rol){
        return rolService.update(rol);
    }

	@ApiOperation(value = "Elimina un Rol del sistema",
            notes = "Se necesita el id del Rol como parametros de entrada",
            response = String.class,
            responseContainer = "Rol")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return rolService.delete(id);
    }
}
