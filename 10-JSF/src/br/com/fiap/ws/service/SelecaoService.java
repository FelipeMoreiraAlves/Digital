package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.Selecao;

public class SelecaoService {

	private Client client = Client.create();
	
	private static final String URL = "http://localhost:8080/07-WS-Restiful-Server/rest/selecao";
	public List<Selecao> listar() throws Exception{
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200) {
			throw new Exception("ERRO: " + response.getStatus());
		}
		
		return Arrays.asList(response.getEntity(Selecao[].class));
	}
	
	public void cadastrar(Selecao selecao) throws Exception {
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,selecao);
		
		//Valida se cadastrou HTTP Status 201 Created
		
		if (response.getStatus() != 201) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
	
	public Selecao buscar(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				//Adiciona o código na URL
				.path(String.valueOf(codigo));
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new Exception("Erro: " + response.getStatus());
		}
		return response.getEntity(Selecao.class);
	}
	
	public void atualizar(Selecao selecao) throws Exception {
		WebResource resource = client.resource(URL).path(String.valueOf(selecao.getCodigo()));
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, selecao);
		
		if (response.getStatus() != 200) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
	
	public void remover(int codigo) throws Exception{
		WebResource resource = client.resource(URL).path(String.valueOf(codigo));
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204) {
			throw new Exception("Erro: " + response.getStatus());
		}
	}
}
