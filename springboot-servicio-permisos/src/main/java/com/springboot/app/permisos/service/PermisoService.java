package com.springboot.app.permisos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.commons.models.entity.Permiso;
import com.springboot.app.permisos.repository.PermisoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {

	@Autowired
	private PermisoRepository repo;
	
	/**
	 * Agregar nuevo permiso
	 * 
	 * 
	 */
	@Transactional
	public Permiso save(Permiso permiso) {
		
		//--Consultar si el correo esta registrado
		if( permiso != null ){
			
			System.out.print("Crear permiso*** ");
			permiso = repo.save(permiso);
			
		}
			
		return permiso;
	}

	/**
	 * Buscar permiso por Id
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Permiso findById(Integer id) {

		Optional<Permiso> value = repo.findById(id);
		if (value.isPresent()) {
			return value.get();
		}
		return null;
	}

	/**
	 * Buscar lista completa de permisos
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Permiso> findAll() {

		List<Permiso> list = (List<Permiso>) repo.findAll();
		return list;
	}

	/**
	 * Borrar el elemento
	 * @param id
	 */
	@Transactional
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

}
