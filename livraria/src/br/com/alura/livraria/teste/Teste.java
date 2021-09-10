package br.com.alura.livraria.teste;

import java.time.LocalDate;

import br.com.alura.livraria.modelo.GestaoLivraria;

public class Teste {

	public static void main(String[] args) {
		GestaoLivraria g = new GestaoLivraria();
		
		g.setNome("Robert");
		g.setEmail("algo@hotmail.com");
		g.setDataNascimento(LocalDate.of(1982, 7, 11));
		g.setMiniCurriculo("Teste mini curriculo");
		
		System.out.println(g);

	}

}
