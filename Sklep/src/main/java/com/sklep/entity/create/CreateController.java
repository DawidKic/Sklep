package com.sklep.entity.create;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sklep.entity.album.Album;
import com.sklep.entity.album.AlbumRepository;
import com.sklep.entity.autor.Autor;
import com.sklep.entity.autor.AutorRepository;
import com.sklep.entity.utwor.Utwor;
import com.sklep.entity.utwor.UtworRepository;


@Controller
public class CreateController {

	@Autowired
	AutorRepository autorRepository;
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	UtworRepository utworRepository;
	@Autowired
	CreateRepository createRepository;
	
	@RequestMapping(value = "/createTables", method = RequestMethod.GET)
	public String createTables(ModelMap model) {
		Autor autor1 = autorRepository.createAutorPersist("Closterkeller");
		Album album1 = albumRepository.createAlbum("Bordeaux", "Universal Music Polska", "2011-09-16", autor1);
		Utwor utwor1 = utworRepository.createUtwor("Alarm", "5:05", album1);
		Utwor utwor2 = utworRepository.createUtwor("Fala", "5:28", album1);
		Utwor utwor3 = utworRepository.createUtwor("Bordeaux", "4:12", album1);
		Album album2 = albumRepository.createAlbum("Aurum", "Universal Music Polska", "2009-10-05", autor1);
		Autor autor2 = autorRepository.createAutor("Disturbed");
		Autor autor3 = autorRepository.createAutor("Eminem");
		model.addAttribute("message", "Wykonano");
		return "index";
	}
	
	@RequestMapping(value = "/listAlbum", method = RequestMethod.GET)
	public String printAlbumTable(ModelMap model) {
		List result = createRepository.listAlbum();
		model.addAttribute("result", result);
		return "index";
	}
	
	@RequestMapping(value = "/listAlbumTest", method = RequestMethod.GET)
	public String printAlbumTest(ModelMap model) {
		List result = albumRepository.listAlbum();
		model.addAttribute("result", result);
		return "index";
	}
	
	
	@RequestMapping(value = "/utworList", method = RequestMethod.GET)
	public String findUtwor(ModelMap model, @RequestParam("albumId") String albumId) {
	
		List result = createRepository.listUtwor(albumId);
		model.addAttribute("utwor", result);
		return "utwor";
		
	}
}
