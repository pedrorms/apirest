package apirest.swapi;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class SwapiConn {
	public ResponseEntity<RequestWrapper> getPlanetByName(String nome) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.add(HttpHeaders.USER_AGENT, "");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<RequestWrapper> wrapper = null;
		String url = "https://swapi.co/api/planets/?search=";

		try {
			wrapper = restTemplate.exchange(url + nome, HttpMethod.GET, entity, RequestWrapper.class);
		} catch (HttpStatusCodeException e) {
			throw new Exception(">>>>> Erro na chamada da SWAPI: " + e);
		}

		// Nome identico, impedir resultados que contenham 'nome';
		if(wrapper.getBody().getResults().get(0).getName().equals(nome)) {
			return wrapper;
		} else {
			return null;
		}
		
	}
}
