package com.RestAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.repository.IUsuarioRepository;
import com.RestAPI.model.Usuario;
@Service
@Transactional
public class UsuarioService {
	  @Autowired
	   private IUsuarioRepository usuarioRepository;
	    public List<Usuario> listAllUser() {
	        return usuarioRepository.findAll();
	    }
	    public Usuario getUser(Integer id) {
	        return usuarioRepository.findById(id).get();
	    }
	    public void saveUser(Usuario user) {
	    	usuarioRepository.save(user);
	    }

	    public void deleteUser(Integer id) {
	    	usuarioRepository.deleteById(id);
	    }
}
