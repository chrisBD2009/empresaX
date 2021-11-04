package com.springboot.app.permisos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.commons.models.entity.Permiso;
import com.springboot.app.permisos.repository.PermisoRepository;
import com.springboot.app.permisos.service.PermisoService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class PermisoController {

	private static final Logger log = LoggerFactory.getLogger(PermisoController.class);
	
	@Autowired
	private PermisoService service;
	
	@Autowired
	private PermisoRepository repo;
	
	@PostMapping("/solicitarPermiso/")
	public ResponseEntity<?> crear(@RequestBody Permiso obj) {

		log.info("Guardar datos de permiso***");
		  
		try{
			if(obj != null) {
				
				Integer consulta = repo.consultaExistencia(obj.getTipoPermiso().getIdTipo());
				if (consulta == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo Permiso NO Encontrado");
				}
				obj = service.save(obj);
				return ResponseEntity.status(HttpStatus.OK).body(obj);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
	}

	
	@PutMapping("/actualizarDatos/{id}")
	public ResponseEntity<?> modificar(@RequestBody Permiso obj, @PathVariable Integer id) {

		log.info("Modificar datos de un permiso ***");
		Permiso objFind = null;
		try {	
			objFind = service.findById(id); 
			System.out.println("consulta de datos--> "+objFind.getNombre());
			if(objFind != null) {
				obj.setIdPermiso(id);
				objFind.setNombre(obj.getNombre());
				objFind.setApellidos(obj.getApellidos());
				objFind.getTipoPermiso().setIdTipo(objFind.getTipoPermiso().getIdTipo());
				objFind.setFechPerm(obj.getFechPerm());
				obj = service.save(obj);
				
				return ResponseEntity.status(HttpStatus.OK).body(obj);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");

	}
	

	@GetMapping("/consultarPermisos")
	public ResponseEntity<List<Permiso>> buscarTodo() {

		log.info("Buscar lista completa de permisos ***");
		List<Permiso> list = null;

		try {
			list = service.findAll(); 	
			if(list != null && list.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK).body(list);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(list);
	}

	
	@GetMapping("/consultarPorId/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {

		log.info("Buscar permiso por ID ***");
		Permiso obj = null;
		try {
			obj = service.findById(id);
			if(obj != null) {
				return ResponseEntity.status(HttpStatus.OK).body(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
	}
		
	@DeleteMapping("/eliminarPermiso/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Integer id) {

		log.info("Borrar datos de un permiso***");
		try {
			service.deleteById(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
	}
}


