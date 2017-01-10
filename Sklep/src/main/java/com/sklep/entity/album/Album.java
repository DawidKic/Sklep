package com.sklep.entity.album;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.sklep.entity.utwor.Utwor;
import com.sklep.entity.autor.Autor;

@Component
@Entity
@Table(name = "album")
public class Album implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Album_ID;

	@Column(name = "AlbumNazwa")
	private String albumNazwa;

	@Column(name = "Wytwornia")
	private String wytwornia;

	@Column(name = "DataWydania")
	//@Temporal(TemporalType.DATE)
	private String dataWydania;

	@ManyToOne()
	@JoinColumn(name = "Autor_ID")
	private Autor Autor;
	
	@OneToMany(mappedBy = "Album", cascade = {CascadeType.ALL})
	private Set<Utwor> Utwory;

	public Album(String albumNazwa, String wytwornia, String dataWydania) {
		this.albumNazwa = albumNazwa;
		this.wytwornia = wytwornia;
		this.dataWydania = dataWydania;	
	};

	public Album() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Album_ID;
	}
	
	public void setId(int Album_ID){
		this.Album_ID = Album_ID;
	}
	
	public Autor getAutor()
	{
		return this.Autor;
	}
	
	public void setAutor(Autor autor) {
		this.Autor = autor;
	}

	public String getAlbumNazwa() {
		return albumNazwa;
	}

	public void setAlbumNazwa(String album_nazwa) {
		this.albumNazwa = album_nazwa;
	}

	public String getWytwornia() {
		return wytwornia;
	}

	public void setWytwornia(String wytwornia) {
		this.wytwornia = wytwornia;
	}

	public String getDataWydania() {
		return dataWydania;
	}

	public void setDataWydania(String dataWydania) {
		this.dataWydania = dataWydania;
	}
}
