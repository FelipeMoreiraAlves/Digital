package br.com.fiap.jsf.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	private SelecaoService service;

	//Método de inicialização do ManagedBean
	@PostConstruct
	private void init() {
		selecao = new Selecao();
		service = new SelecaoService();
	}
	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
	public void cadastrar() {
		try {
			service.cadastrar(selecao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
