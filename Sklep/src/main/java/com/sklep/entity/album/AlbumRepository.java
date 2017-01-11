package com.sklep.entity.album;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sklep.entity.autor.Autor;

@Repository("albumRepository")
public class AlbumRepository {

	@Autowired
	Album album;

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public Album createAlbum(String albumNazwa, String wytwornia, String dataWydania, Autor autor) {
		Album album = new Album();
		album.setAlbumNazwa(albumNazwa);
		album.setWytwornia(wytwornia);
		album.setDataWydania(dataWydania);
		album.setAutor(autor);
		entityManager.persist(album);
		return album;

	}
	
	public List listAlbum() {
		String query = "SELECT a FROM Album a";
		return entityManager.createQuery(query).getResultList();
		}

}