package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Imovel;

public class ImovelService {

	private static final String URL = "http://localhost:8080/CorrecaoNac-Server/rest/imovel";

	private Client client = Client.create();

	public void cadastrar(Imovel imovel) throws Exception {
		WebResource resourse = client.resource(URL);
		ClientResponse resp = resourse.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, imovel);

		if (resp.getStatus() != 201) {
			throw new Exception("Erro!");
		}
	}

	public List<Imovel> listar() throws Exception {
		// Chamar o webservice
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// validar se foi ok
		if (resp.getStatus() != 200) {
			throw new Exception("Erro!");
		}

		// retornar a lista de imoveis
		return Arrays.asList(resp.getEntity(Imovel[].class));
	}

	public void atualizar(Imovel imovel) throws Exception {
		// Chamar o webservice
		WebResource resource = client.resource(URL).path(String.valueOf(imovel.getCodigo()));
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, imovel);

		// Validar se deu certo
		if (resp.getStatus() != 200)
			throw new Exception("Erro");

	}

}
