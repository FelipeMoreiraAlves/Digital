package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

	private String nome;
	
	private String nomeUsuario;
	
	private String senha;
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void exibirNome() {
		System.out.println(nome);
	}
	
	public void validarUsuario() {
		if ((nomeUsuario.equalsIgnoreCase("fiap")) && (senha.equals("fiap2018"))){
			System.out.println("Usuario logado com sucesso!!");
		}
	}
}
