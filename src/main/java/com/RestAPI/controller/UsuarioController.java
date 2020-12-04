package com.RestAPI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.service.UsuarioService;
import com.RestAPI.model.Usuario;
import javax.validation.Valid;


//Cors me permite restringir las peticiones dependiendo del dominio que solicita la peticion
//@CrossOrigin(origins={"https://localhost:4200"})

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	// Definiendo logger
	//private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);    
	@Autowired
    UsuarioService usuarioService;

    @GetMapping("/users")
    public List<Usuario> list() {
        return usuarioService.listAllUser();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Integer id) {
        try {
            Usuario user = usuarioService.getUser(id);
            return new ResponseEntity<Usuario>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/users")
    public ResponseEntity<Usuario> add(@Valid @RequestBody Usuario user) {
    	usuarioService.saveUser(user);
    	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario user, @PathVariable Integer id) {
        try {
            Usuario existUser = usuarioService.getUser(id);
            user.setId(id);            
            usuarioService.saveUser(user);
            return new ResponseEntity<Usuario>(user,HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
    	usuarioService.deleteUser(id);
    	  Map<String, Object> body = new HashMap<String, Object>();
          body.put("MSJ", "SE HA ELIMINADO EL USUARIO: "+id);
          return new ResponseEntity<>(body,HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
    }
    }
}
