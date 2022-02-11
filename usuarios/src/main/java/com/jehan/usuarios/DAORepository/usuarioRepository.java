package com.jehan.usuarios.DAORepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;	
import com.jehan.usuarios.ModeloEntidad.usuarios;


@Repository
public interface usuarioRepository extends JpaRepository<usuarios, Integer>{

}

