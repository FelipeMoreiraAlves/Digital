package br.com.fiap.jsf.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.to.Paciente;
import br.com.fiap.ws.service.PacienteService;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;

	@PostConstruct
	private void init() {
		paciente = new Paciente();
		paciente.setDataNascimento(Calendar.getInstance());
		service = new PacienteService();
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public List<Paciente> getPacientes() {
		try {
			return service.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String salvar(){
		FacesMessage msg;
		try {
			if (paciente.getCodigo() == 0) {
				service.cadastrar(paciente);
				msg = new FacesMessage("Sucesso!!");
			}else {
				service.atualizar(paciente);
				msg = new FacesMessage("Atualizado!!");
			}
		} catch (Exception e) {
			e.printStackTrace();

			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "lista-paciente?faces-redirect=true";
	}

	public String deletar(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Paciente apagado");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao apagar Paciente");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "lista-paciente?faces-redirect=true";
	}
}
