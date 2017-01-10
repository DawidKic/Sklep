package com.sklep.entity.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sklep.entity.autor.Autor;

@Controller
public class AutorController {

	@Autowired
	AutorRepository autorRepository;
	
	@RequestMapping(value = "/autorFindTest", method = RequestMethod.GET)
	public String findTest(ModelMap model) {
		Autor autor =autorRepository.findAutor(1);
		model.addAttribute("message", autor.getAutorNazwa());
		return "index";
	}
	
	@RequestMapping(value = "/addAutor", method = RequestMethod.GET)
	public String addAutorTest(ModelMap model) {
		Autor autor = autorRepository.createAutorPersist("Closterkeller");
		model.addAttribute("message", autor.getAutorNazwa());
		return "index";
	}
}
