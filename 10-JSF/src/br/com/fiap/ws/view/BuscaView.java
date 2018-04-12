package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.to.Selecao;
import br.com.fiap.ws.service.SelecaoService;

public class BuscaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Código");
		int codigo = sc.nextInt();
		
		
		try {
			SelecaoService service = new SelecaoService();
			Selecao selecao = service.buscar(codigo);
			
			System.out.println(selecao.getPais());
			System.out.println(selecao.getNumeroMundiais());
			System.out.println(selecao.isClassificado());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}
}
