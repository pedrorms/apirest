package apirest.swapi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class RequestWrapper {

	@JsonIgnoreProperties(ignoreUnknown = true)
	private ArrayList<PlanetaSwapi> results;

	public ArrayList<PlanetaSwapi> getResults() {
		return results;
	}

	public void setResults(ArrayList<PlanetaSwapi> results) {
		this.results = results;
	}
}