 package com.jehan.usuarios.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jehan.usuarios.ModeloEntidad.usuarios;
import com.jehan.usuarios.Service.usuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class usuariosController {
	@Autowired
	private usuarioService usuarioservice;

	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody usuarios usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioservice.save(usuario));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value ="id") Integer userid){
		Optional<usuarios> ousuario = usuarioservice.findById(userid);
		
		if(!ousuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ousuario);
	}
	//update user
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody usuarios userDetails, @PathVariable(value = "id") Integer userId){
		Optional<usuarios> user = usuarioservice.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		user.get().setNombre(userDetails.getNombre());
		user.get().setApellido(userDetails.getApellido());
		user.get().setCedula(userDetails.getCedula());
		user.get().setStatus(userDetails.getStatus());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioservice.save(user.get()));
		
	}
	//delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Integer userId){
		if (!usuarioservice.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioservice.deleteById(userId);
		return ResponseEntity.ok().build();
	} 
	//read all user
	@GetMapping
	public List<usuarios> readAll (){
		List<usuarios> users = StreamSupport
				.stream(usuarioservice.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}
	
}
