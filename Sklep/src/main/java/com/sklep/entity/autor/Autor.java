package com.sklep.entity.autor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import com.sklep.entity.album.Album;

@Component
@Entity
@Table(name = "autor")
public class Autor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Autor_ID;

	@Column(name = "AutorNazwa")
	private String autorNazwa;
	
	@OneToMany(mappedBy = "Autor", cascade = {CascadeType.ALL})
	private Set<Album> Albumy;

	public Autor() {
	};

		
	public int getId() {
		return Autor_ID;
	}
	
	public void setId(int Autor_Id){
		this.Autor_ID = Autor_Id;
	}

	public String getAutorNazwa() {
		return autorNazwa;
	}

	public void setAutorNazwa(String autor_nazwa) {
		this.autorNazwa = autor_nazwa;
	}

}
