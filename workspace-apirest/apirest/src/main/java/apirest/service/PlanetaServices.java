package apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import apirest.entity.Planeta;
import apirest.repository.PlanetaRepository;
import apirest.swapi.SwapiConn;
import apirest.swapi.RequestWrapper;
import javassist.NotFoundException;

@Service
public class PlanetaServices {

	@Autowired
	private PlanetaRepository planetaRepository;

	// Return All;
	public Iterable<Planeta> findAll() {
		return planetaRepository.findAll();
	}

	// Save;
	public Planeta save(Planeta planeta) throws Exception {
		String nome = planeta.getNome();
		String clima = planeta.getClima();
		String terreno = planeta.getTerreno();

		Planeta novoPlaneta = new Planeta(nome, clima, terreno);

		SwapiConn conn = new SwapiConn();
		ResponseEntity<RequestWrapper> wrapper = conn.getPlanetByName(nome);

		if (findByNome(nome) == null) {
			if (wrapper == null) {
				return planetaRepository.save(novoPlaneta); // SEM numAparicoes
			} else {
				int numAparicoes = wrapper.getBody().getResults().get(0).getFilms().size();
				novoPlaneta.setNumAparicoes(numAparicoes);

				return planetaRepository.save(novoPlaneta); // COM numAparicoes
			}
		} else {
			throw new IllegalArgumentException(">>>>> Já adicionado, esse planeta foi!");
		}
	}

	// findById
	public Object findById(Long id) throws NotFoundException {
		Optional<Planeta> planeta = planetaRepository.findById(id);

		if (planeta.isPresent()) {
			return planeta;
		} else {
			throw new NotFoundException(">>>>> Com esse id, nenhum planeta foi encontrado...");
		}
	}

	// findByNome
	public Object findByNome(String nome) throws NotFoundException {
		Iterable<Planeta> planetas = planetaRepository.findAll();

		for (Planeta planeta : planetas) {
			if (planeta.getNome().equals(nome)) {
				return planeta;
			}
		}

		return null;
	}

	// deleteById
	public Object deleteById(Long id) throws NotFoundException {
		Optional<Planeta> planeta = planetaRepository.findById(id);

		if (planeta.isPresent()) {
			planetaRepository.deleteById(id);
			return " - O Planeta " + planeta.get().getNome() + " foi removido.";
		} else {
			throw new NotFoundException(">>>>> Com esse id, nenhum planeta foi encontrado...");
		}
	}
}
