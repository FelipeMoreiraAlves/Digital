package br.com.fiap.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.to.Paciente;
import br.com.fiap.ws.service.PacienteService;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;

	@PostConstruct
	private void init() {
		paciente = new Paciente();
		service = new PacienteService();
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public List<Paciente> getPacientes() throws Exception {
		return service.listar();
	}

	public void salvar() {
		FacesMessage msg;
		if (paciente.getCodigo() == 0) {
			service.cadastrar(paciente);
			msg = new FacesMessage("Sucesso!!");
		}
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
