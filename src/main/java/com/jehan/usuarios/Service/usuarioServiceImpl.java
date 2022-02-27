package com.jehan.usuarios.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jehan.usuarios.DAORepository.usuarioRepository;
import com.jehan.usuarios.ModeloEntidad.usuarios;

@Service
public class usuarioServiceImpl implements usuarioService{

	@Autowired 
	private usuarioRepository usuarioRepository;

	@Override
	public Iterable<usuarios> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Page<usuarios> findAll(Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}

	@Override
	public Optional<usuarios> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public usuarios save(usuarios usuarios) {
		return usuarioRepository.save(usuarios);
	}

	@Override
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}
}
