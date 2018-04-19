package br.com.fiap.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.to.Paciente;
import br.com.fiap.ws.service.PacienteService;

@ManagedBean
public class PacienteBean {

	private Paciente paciente;
	private PacienteService service;
	
	private void init() {
		paciente = new Paciente();
		service = new PacienteService();
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public List<Paciente> getPacientes() throws Exception{
		return service.listar();
	}
}
