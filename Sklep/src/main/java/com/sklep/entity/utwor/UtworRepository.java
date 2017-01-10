package com.sklep.entity.utwor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sklep.entity.album.Album;
import com.sklep.entity.autor.Autor;

@Repository("utworRepository")
public class UtworRepository {

	@Autowired
	Utwor utwor;
	@PersistenceContext
	EntityManager entityManager;
	 
	 @Transactional
	    public Utwor createUtwor(String utworNazwa, String dlugosc, Album album) {
		 Utwor utwor = new Utwor();
		 utwor.setUtworNazwa(utworNazwa);
		 utwor.setDlugosc(dlugosc);
		 utwor.setAlbum(album);
		 entityManager.persist(utwor);
		 return utwor;
	    }
	
}
