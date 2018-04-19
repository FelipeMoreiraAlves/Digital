package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

@ManagedBean
public class SelecaoBean {

	private Selecao selecao;
	private SelecaoService service;

	// Método de inicialização do ManagedBean
	@PostConstruct
	private void init() {
		selecao = new Selecao();
		service = new SelecaoService();
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public List<Selecao> getSelecoes() {
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public void salvar() {
		FacesMessage msg;
		try {
			if (selecao.getCodigo() == 0) {
				service.cadastrar(selecao);
				msg = new FacesMessage("Sucesso!");
			}else {
				service.atualizar(selecao);
				msg = new FacesMessage("Atualizado!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		// Adiciona a mensagem para a tela exibir
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}
	
	public void deletar(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Seleção apagada");
		}catch(Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao apagar Seleção");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
