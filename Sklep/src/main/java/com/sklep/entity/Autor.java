package com.sklep.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {

	@Id
	@GeneratedValue
	private int Autor_ID;

	@Column(name = "AutorNazwa")
	private String autorNazwa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Autor")
	private Set<Album> Albumy;

	public Autor() {
	};

		
	public int getId() {
		return Autor_ID;
	}

	public String getAutorNazwa() {
		return autorNazwa;
	}

	public void setAutorNazwa(String autor_nazwa) {
		this.autorNazwa = autor_nazwa;
	}

}
