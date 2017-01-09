package com.sklep;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sklep.entity.Album;
import com.sklep.entity.Autor;
import com.sklep.entity.Utwor;

public class FillTable {
	private static SessionFactory factory;

	public static void main(String[] args) {
		factory = new Configuration().configure().buildSessionFactory();
		FillTable FT = new FillTable();
		Autor autor1 = FT.addAutor("Closterkeller");
		Album album1 = FT.addAlbum("Bordeaux", "Universal Music Polska", "2011-09-16", autor1);
		Utwor utwor1 = FT.addUtwor("Pora iœæ ju¿ drogi mój", "5:05", album1);
		Utwor utwor2 = FT.addUtwor("Fala", "5:28", album1);
		Utwor utwor3 = FT.addUtwor("Bordeaux", "4:12", album1);
		Album album2 = FT.addAlbum("Aurum", "Universal Music Polska", "2009-10-05", autor1);
		Autor autor2 = FT.addAutor("Disturbed");
		Autor autor_3 = FT.addAutor("Eminem");
		
		//factory.close();

	}

	public Autor addAutor(String autor_nazwa) {
		Session session = factory.openSession();
		session.beginTransaction();

		Autor autor = new Autor();
		autor.setAutorNazwa(autor_nazwa);

		session.save(autor);
		session.getTransaction().commit();
		session.close();
		return autor;
	}

	public Album addAlbum(String albumNazwa, String wytwornia, String dataWydania, Autor autor) {
		Session session = factory.openSession();
		session.beginTransaction();

		Album album = new Album(albumNazwa, wytwornia, dataWydania);
		album.setAutor(autor);

		session.save(album);
		session.getTransaction().commit();
		session.close();
		return album;
	}

	public Utwor addUtwor(String utworNazwa, String dlugosc, Album album) {

		Session session = factory.openSession();
		session.beginTransaction();

		Utwor utwor = new Utwor();
		utwor.setUtworNazwa(utworNazwa);
		utwor.setDlugosc(dlugosc);
		utwor.setAlbum(album);

		session.save(utwor);
		session.getTransaction().commit();
		session.close();
		return utwor;
	}

}
