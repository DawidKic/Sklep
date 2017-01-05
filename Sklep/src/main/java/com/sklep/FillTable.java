package com.sklep;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sklep.entity.Autor;

public class FillTable {
	 private static SessionFactory factory; 
	public static void main(String[] args) {
		factory = new Configuration().configure().buildSessionFactory();
		FillTable FT = new FillTable();
		FT.addAutor("Closterkeller");
		FT.addAutor("Disturbed");
		FT.addAutor("Eminem");
	}

	public void addAutor(String autor_nazwa) {
		Session session = factory.openSession();
		session.beginTransaction();

		Autor autor = new Autor();
		autor.setAutorNazwa(autor_nazwa);

		session.save(autor);
		session.getTransaction().commit();
		session.close();
	}

}
