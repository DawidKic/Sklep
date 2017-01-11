package com.sklep.entity.create;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sklep.entity.album.Album;
import com.sklep.entity.autor.Autor;
import com.sklep.entity.utwor.Utwor;

@Repository("createRepository")
public class CreateRepository {

	@Autowired
	Album album;
	@Autowired
	Autor autor;
	@Autowired
	Utwor utwor;

	@PersistenceContext
	EntityManager entityManager;

	public List listAlbumHql() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT al.Album_ID, al.albumNazwa, al.dataWydania, al.wytwornia, au.autorNazwa FROM Album as al INNER JOIN Autor as au WHERE au.Autor_ID = al.Autor";
		Query query = session.createQuery(hql);
		List results = query.list();
		return results;
	}

	public List listAlbum() {
		String query = "SELECT al.Album_ID, al.albumNazwa, al.dataWydania, al.wytwornia, au.autorNazwa FROM Album as al, Autor as au WHERE au.Autor_ID = al.Autor";
		return entityManager.createQuery(query).getResultList();
	}
	
	public List listUtwor(String albumId) {
		Album album = new Album();
		album.setId(Integer.parseInt(albumId));
		String query = "SELECT u.utworNazwa, u.dlugosc FROM Utwor u WHERE u.Album = :Album_ID";
		return entityManager.createQuery(query).setParameter("Album_ID", album).getResultList();
		}

}
