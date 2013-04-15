package br.com.blog.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.blog.dao.AssuntoDAO;
import br.com.blog.dao.ComentarioDAO;
import br.com.blog.dao.MateriaDAO;
import br.com.blog.model.Comentario;

/**
 * 
 * @version 1.0
 * @since   13/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

@Controller
public class HomeController {
	
	@Autowired
	private AssuntoDAO assuntoDAO;
	
	@Autowired
	private ComentarioDAO comentarioDAO;
	
	@Autowired
	private MateriaDAO materiaDAO;
	
	// Minha ideia nesse aqui é utilizar uma url mais amigavel, 
	// e que não precise replicar código como acontece nos seguintes mapeamentos:
	// /comente-sobre/java/{id}, /comente-sobre/engenharia-software/{id}, /comente-sobre/tdd/{id} e /comente-sobre/rup/{id}.
	@RequestMapping(value="/comente-sobre/categoria/{id}", method=RequestMethod.GET)
	public ModelAndView comenteSobre(@PathVariable Long id) {
		System.out.println(id);
		ModelAndView modelAndView = new ModelAndView("metodos-ageis/lista");
		
		// busca da materia com base na categoria escolhida.
		// Do jeito que esta listaria todas as materias para um determinado assunto, no entanto deveria retornar apenas um.
		// Pois os comentarios são especificos por materia.
		modelAndView.addObject(materiaDAO.listar(id));
		
		// busca dos assuntos para o "menu".
		modelAndView.addObject(assuntoDAO.listar());
		
		//busca dos comentarios com base na categoria escolhida.
		modelAndView.addObject(comentarioDAO.listar(id));
		return modelAndView;
	}
	
	@RequestMapping(value="/comente-sobre/categoria/salvar")
	public String salvar(Comentario comentario, BindingResult result) {
		comentario.setPostagem(Calendar.getInstance().getTime());
		comentarioDAO.salvar(comentario);
		return "redirect:/comente-sobre/categoria/"+comentario.getAssunto().getId();
	}
	
	@RequestMapping(value="/comente-sobre")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("home/bemvindo");
		modelAndView.addObject(assuntoDAO.listar());
		return modelAndView;
		
	}
	
	@RequestMapping(value="/comente-sobre/java/{id}", method=RequestMethod.GET)
	public ModelAndView java() {
		ModelAndView modelAndView = new ModelAndView("em-construcao/em_construcao");
		modelAndView.addObject(assuntoDAO.listar());
		modelAndView.addObject(comentarioDAO.listar(Long.valueOf("2")));
		return modelAndView;
	}
	
	@RequestMapping(value="/comente-sobre/engenharia-software/{id}", method=RequestMethod.GET)
	public ModelAndView engenhariaDeSoftware() {
		ModelAndView modelAndView = new ModelAndView("em-construcao/em_construcao");
		modelAndView.addObject(assuntoDAO.listar());
		modelAndView.addObject(comentarioDAO.listar(Long.valueOf("3")));
		return modelAndView;
	}
	
	@RequestMapping(value="/comente-sobre/tdd/{id}", method=RequestMethod.GET)
	public ModelAndView tdd() {
		ModelAndView modelAndView = new ModelAndView("em-construcao/em_construcao");
		modelAndView.addObject(assuntoDAO.listar());
		modelAndView.addObject(comentarioDAO.listar(Long.valueOf("4")));
		return modelAndView;
	}
	
	@RequestMapping(value="/comente-sobre/rup/{id}", method=RequestMethod.GET)
	public ModelAndView rup() {
		ModelAndView modelAndView = new ModelAndView("em-construcao/em_construcao");
		modelAndView.addObject(assuntoDAO.listar());
		modelAndView.addObject(comentarioDAO.listar(Long.valueOf("5")));
		return modelAndView;
	}
	
}
