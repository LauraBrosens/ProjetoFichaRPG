package fichaRPG;
import java.util.*;

public abstract class Personagem {
	/*	ler:
	 	nome do jogador
		personagem
		classe
		nivel
		
		gerar: 
 		pontosVida (específicos por classe)
 		atributos (c/ método)
 		equipamentos (específicos por classe)
 		habilidades	(específicos por classe)
	*/
	
	private String nomePersonagem, nomeJogador, classe;
	private int nivel, pontosVida;
	private int[] habilidades = new int[6];
	private String[] equipamentos = new String[100];
	private String[] caracteristicas = new String[100];
	
	public Personagem(String nomePersonagem, String nomeJogador, String classe, int nivel,
			int pontosVida, int[] habilidades, String[] equipamentos, String[] caracteristicas) {
		this.nomePersonagem = nomePersonagem;
		this.nomeJogador = nomeJogador;
		this.classe = classe;
		this.nivel = nivel;
		this.pontosVida = pontosVida;
		this.habilidades = habilidades;
		this.equipamentos = equipamentos;
		this.caracteristicas = caracteristicas;
	}

	public void definirHabilidades() {
		Scanner leia = new Scanner(System.in);
		int[] distribuicao = {15, 14, 13, 12, 10, 8};

		for (int n = 0; n<6; n++) {
			System.out.printf("Para definição de habilidades, usaremos a distribuição padrão: "
					+ "\n\tOs valores restantes são:");
			for (int i = n; i<6; i++) {
				System.out.printf("%d ", distribuicao[i]);
			}
			System.out.printf("\nHabilidade: ");
			if(getHabilidade(0) == 0) System.out.printf("\n1 - Força");
			if(getHabilidade(1) == 0) System.out.printf("\n2 - Destreza");
			if(getHabilidade(2) == 0) System.out.printf("\n3 - Constituicao");
			if(getHabilidade(3) == 0) System.out.printf("\n4 - Inteligencia");
			if(getHabilidade(4) == 0) System.out.printf("\n5 - Sabedoria");
			if(getHabilidade(5) == 0) System.out.printf("\n6 - Carisma");
			System.out.printf("\nEscolha qual habilidade receberá o valor %d: ", distribuicao[n]);

			setHabilidade(leia.nextInt()-1, distribuicao[n]);
		}
	}
	
	public void incrementarHabilidade(int vezes) {
		//Incrementa um atributo (força, destreza..) em dois, ou dois atributos em 1.
		//Não pode passar de 20.
		int n; //endereço do atributo que queremos
		Scanner leia = new Scanner(System.in);
		boolean ok = false;
		vezes *= 2;
		//! é uma operação booleana que troca o resultado de "sinal" - true vira false, false vira true
		while (vezes > 0) {
			do {
				System.out.println("Você precisa incrementar mais " + vezes + " vezes as suas habilidades");
				System.out.printf("\nHabilidades: ");
				System.out.printf("\n1 - Força: " + this.getHabilidade(0));
				System.out.printf("\n2 - Destreza: " + this.getHabilidade(1));
				System.out.printf("\n3 - Constituicao: " + this.getHabilidade(2));
				System.out.printf("\n4 - Inteligencia: " + this.getHabilidade(3));
				System.out.printf("\n5 - Sabedoria: " + this.getHabilidade(4));
				System.out.printf("\n6 - Carisma: " + this.getHabilidade(5));
				System.out.printf("\nEscolha qual habilidade será aumentada: ");
				n = leia.nextInt();
				if (n < 1 || n > 6) {
					System.out.println("Entrada inválida");
				}
				else if (this.getHabilidade(n-1) >= 20) {
					System.out.println("Entrada inválida");
				}
				else {
					this.setHabilidade(n-1, this.getHabilidade(n-1)+1);
					ok = true;
				}
			} while (!ok);
			vezes--;
			ok = false;
		}
	}
	
	public abstract void definirEquipamentos() throws InterruptedException;
	public abstract void definirCaracteristicas();
	public int getHabilidade(int n) {
		return habilidades[n];
	}
	public void setHabilidade(int n, int a) {
		this.habilidades[n] = a;
	}
	public void mostrarCaracteristicas() {
		for(String j : this.getCaracteristicas()) {
			if (j == null) break;
			System.out.println(j);
		}
	}
	public void mostrarEquipamentos() {
		for(String j : this.getEquipamentos()) {
			if (j == null) break;
			System.out.println(j);
		}
	}
	//Getters e Setters padrão
	public String getNomePersonagem() {
		return nomePersonagem;
	}
	public String getNomeJogador() {
		return nomeJogador;
	}
	public String getClasse() {
		return classe;
	}
	public int getNivel() {
		return nivel;
	}
	public int getPontosVida() {
		return pontosVida;
	}
	public String[] getEquipamentos() {
		return equipamentos;
	}
	public String[] getCaracteristicas() {
		return caracteristicas;
	}
	public void setNomePersonagem(String nomePersonagem) {
		this.nomePersonagem = nomePersonagem;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public void setClasse(String classe) {
			this.classe = classe;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}
	public void setEquipamentos(String[] equipamentos) {
		this.equipamentos = equipamentos;
	}
	public void setCaracteristicas(String[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
}
