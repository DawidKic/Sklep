package com.sklep.entity.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("autorRepository")
public class AutorRepository {

	@Autowired
	Autor autor;
	@PersistenceContext
	EntityManager entityManager;
	 @Transactional
	    public Autor findAutor(int Autor_ID) {
		 Autor autor =  entityManager.find(Autor.class, Autor_ID);
		 return autor;
	    }
	 
	 @Transactional
	    public Autor createAutor(String autorName) {
		 Autor autor = new Autor();
		 autor.setAutorNazwa(autorName);
		 entityManager.merge(autor);
		 return autor;
	    }
	 
	 @Transactional
	    public Autor createAutorPersist(String autorName) {
		 Autor autor = new Autor();
		 autor.setAutorNazwa(autorName);
		 entityManager.persist(autor);
		 return autor;
	    }
	
}
