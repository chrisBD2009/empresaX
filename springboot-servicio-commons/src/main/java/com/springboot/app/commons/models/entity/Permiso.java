package com.springboot.app.commons.models.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the cata_cliente database table.
 * 
 */
@Entity
@Table(name="permiso")
@NamedQuery(name="Permiso.findAll", query="SELECT c FROM Permiso c")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPermiso;

	@Column(name="nombre_empleado")
	private String nombre;

	@Column(name="apellidos_empleado")
	private String apellidos;
	
	@Column(name="fecha_permiso")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd HH:mm:ss")
	private Timestamp fechPerm;

	@ManyToOne
	@JoinColumn(name="tipo_permiso")
	private TipoPermiso tipoPermiso;

	
	
	public Permiso() {
	}

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Timestamp getFechPerm() {
		return fechPerm;
	}

	public void setFechPerm(Timestamp fechPerm) {
		this.fechPerm = fechPerm;
	}

	public TipoPermiso getTipoPermiso() {
		return tipoPermiso;
	}

	public void setTipoPermiso(TipoPermiso tipoPermiso) {
		this.tipoPermiso = tipoPermiso;
	}

}