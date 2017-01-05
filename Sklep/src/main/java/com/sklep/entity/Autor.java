package com.sklep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {

	@Id
	@GeneratedValue
	private int Autor_ID;

	@Column(name = "AutorNazwa")
	private String autorNazwa;

	public Autor() {
	};

	public int getId() {
		return Autor_ID;
	}

	public void setId(int id) {
		this.Autor_ID = id;
	}

	public String getAutorNazwa() {
		return autorNazwa;
	}

	public void setAutorNazwa(String autor_nazwa) {
		this.autorNazwa = autor_nazwa;
	}

}
