package com.jehan.usuarios.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jehan.usuarios.ModeloEntidad.usuarios;



public interface usuarioService {
	public Iterable<usuarios> findAll();
	public Page<usuarios> findAll(Pageable pageable);
	public Optional<usuarios> findById(Integer id);
	public usuarios save(usuarios usuario);
	public void deleteById(Integer id);
}
