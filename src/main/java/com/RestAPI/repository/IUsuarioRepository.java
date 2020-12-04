package com.RestAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestAPI.model.Usuario;
@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario, Integer> {
	

}
