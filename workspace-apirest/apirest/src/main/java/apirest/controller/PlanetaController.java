package apirest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import apirest.entity.Planeta;
import apirest.service.PlanetaServices;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class PlanetaController {

	@Autowired
	private PlanetaServices planetaServices;

	// Listar Planetas;
	@RequestMapping("/planetas")
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Planeta> listaPlanetas() {
		Iterable<Planeta> listaPlanetas = planetaServices.findAll();
		return listaPlanetas;
	}

	// CREATE - Adicionar Planeta;
	@PostMapping("/planeta")
	public Planeta addPlaneta(@RequestBody @Valid Planeta planeta) throws Exception {
		return planetaServices.save(planeta);
	}

	@GetMapping("/planeta")
	public Planeta addPlanetaSubmit(@ModelAttribute Planeta planeta, Model model) throws Exception {
		model.addAttribute("planeta", planeta);
		Planeta novoPlaneta = new Planeta(planeta.getNome(), planeta.getClima(), planeta.getTerreno());
		return planetaServices.save(novoPlaneta);
	}

	// RETRIEVE - Buscar por id;
	@GetMapping("/planeta/id/{id}")
	public Object buscarID(@PathVariable Long id) throws NotFoundException {
		return planetaServices.findById(id);
	}

	// RETRIEVE - Buscar por nome;
	@GetMapping("/planeta/nome/{nome}")
	public Object buscarNome(@PathVariable String nome) throws NotFoundException {
		return planetaServices.findByNome(nome);
	}

	// DELETE - Remover Planeta por ID;
	@DeleteMapping("/planeta/remover/{id}")
	public Object deletePlaneta(@PathVariable Long id) throws NotFoundException {
		return planetaServices.deleteById(id);
	}
}
