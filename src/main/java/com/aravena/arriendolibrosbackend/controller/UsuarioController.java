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

import com.aravena.arriendolibrosbackend.model.Usuario;
import com.aravena.arriendolibrosbackend.service.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@ApiOperation(value = "Obtener todos los Usuario existentes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 401, message = "No esta autorizado"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	@GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

	@ApiOperation(value = "Obtener Usuario existente por Id",
            notes = "Se necesita el id del Usuario como parametros de entrada",
            response = Usuario.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Integer id){
        return usuarioService.findById(id);
    }

	@ApiOperation(value = "Crea un nuevo Usuario",
            notes = "Se necesitan los parametros del Usuario",
            response = Usuario.class,
            responseContainer = "Usuario")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

	@ApiOperation(value = "Actualiza una Usuario existente en el sistema",
            notes = "Se necesitan los parametros del Usuario",
            response = Usuario.class,
            responseContainer = "Usuario")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

	@ApiOperation(value = "Elimina un Usuario del sistema",
            notes = "Se necesita el id del Usuario como parametros de entrada",
            response = String.class,
            responseContainer = "Usuario")
	@ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return usuarioService.delete(id);
    }
}
