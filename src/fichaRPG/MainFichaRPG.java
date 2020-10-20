package fichaRPG;

import java.io.IOException;
import java.util.*;

public class MainFichaRPG {
	public static void main (String[] args) throws InterruptedException {
		Scanner leia = new Scanner(System.in);
		String nomePersonagem, nomeJogador;
		int nivel=0;
		String[][] equipamentos = new String[10][100];
		String[][] caracteristicas = new String[10][100];
		int[][] habilidades = new int[10][6];
		boolean loop = true;
		
		//String nomePersonagem, String nomeJogador, String classe, int nivel, int pontosVida, int[] habilidade,
		//String[] equipamentos, String[] caracteristicas
		
		System.out.println("Seja bem-vindo/a ao nosso demo de construção de ficha de Dungeons & Dragons 5e");
		System.out.println("****Por favor, insira o nome do jogador que criará a ficha de Bárbaro****");
		nomeJogador = leia.next();
		System.out.println("Agora, insira o nome do personagem");
		nomePersonagem = leia.next();
		System.out.println("Por final, insira o nível do personagem");
		do {
			try {
				nivel = leia.nextInt();
				loop = false; //deu certo
			} catch (InputMismatchException e) {
				System.out.println("Erro - Insira um número inteiro, por favor");
				leia.nextLine();
			}
		}while(loop);
		Barbaro barbaro = new Barbaro(nomePersonagem, nomeJogador, "Bárbaro", nivel, 0, habilidades[0], equipamentos[0], caracteristicas[0]);
		
		System.out.println("****Por favor, insira o nome do jogador que criará a ficha de Guerreiro****");
		nomeJogador = leia.next();
		System.out.println("Agora, insira o nome do personagem");
		nomePersonagem = leia.next();
		System.out.println("Por final, insira o nível do personagem");
		do {
			try {
				nivel = leia.nextInt();
				loop = false; //deu certo
			} catch (InputMismatchException e) {
				System.out.println("Erro - Insira um número inteiro, por favor");
				leia.nextLine();
			}
		}while(loop);
		Guerreiro guerreiro = new Guerreiro(nomePersonagem, nomeJogador, "Guerreiro", nivel, 0, habilidades[1], equipamentos[1], caracteristicas[1]);
		
		System.out.println("****Por favor, insira o nome do jogador que criará a ficha de Ladino****");
		nomeJogador = leia.next();
		System.out.println("Agora, insira o nome do personagem");
		nomePersonagem = leia.next();
		System.out.println("Por final, insira o nível do personagem");
		do {
			try {
				nivel = leia.nextInt();
				loop = false; //deu certo
			} catch (InputMismatchException e) {
				System.out.println("Erro - Insira um número inteiro, por favor");
				leia.nextLine();
			}
		}while(loop);
		Ladino ladino = new Ladino(nomePersonagem, nomeJogador, "Ladino", nivel, 0, habilidades[2], equipamentos[2], caracteristicas[2]);
		
		System.out.println("****E, por fim, insira o nome do jogador que criará a ficha de Clérigo****");
		nomeJogador = leia.next();
		System.out.println("Agora, insira o nome do personagem");
		nomePersonagem = leia.next();
		System.out.println("Por final, insira o nível do personagem");
		do {
			try {
				nivel = leia.nextInt();
				loop = false; //deu certo
			} catch (InputMismatchException e) {
				System.out.println("Erro - Insira um número inteiro, por favor");
				leia.nextLine();
			}
		}while(loop);
		Clerigo clerigo = new Clerigo(nomePersonagem, nomeJogador, "Clerigo", nivel, 0, habilidades[3], equipamentos[3], caracteristicas[3]);
		
		//Barbaro
		
		System.out.println("\n****Agora vamos definir as habilidades do Barbaro****\n");
		barbaro.definirHabilidades();
		System.out.println("\n\nAgora vamos definir os equipamentos do Barbaro\n\n");
		barbaro.definirEquipamentos();
		System.out.println("\n\nE, finalmente, vamos definir as características do Barbaro\n\n");
		barbaro.definirCaracteristicas();
		barbaro.definirPontosVida(12);
		//Guerreiro
		
		System.out.println("\n\n****Agora vamos definir as habilidades do Guerreiro****\n");
		guerreiro.definirHabilidades();
		System.out.println("\n\nAgora vamos definir os equipamentos do Guerreiro\n\n");
		guerreiro.definirEquipamentos();
		System.out.println("\n\nE, finalmente, vamos definir as características do Guerreiro\n\n");
		guerreiro.definirCaracteristicas();
		guerreiro.definirPontosVida(10);
		
		//Ladino
		
		System.out.println("\n\n****Agora vamos definir as habilidades do Ladino****\n");
		ladino.definirHabilidades();
		System.out.println("\n\nAgora vamos definir os equipamentos do Ladino\n\n");
		ladino.definirEquipamentos();
		System.out.println("\n\nE, finalmente, vamos definir as características do Ladino\n\n");
		ladino.definirCaracteristicas();
		ladino.definirPontosVida(8);
		
		//Clerigo
		
		System.out.println("\n\n****Agora vamos definir as habilidades do Clérigo****\n");
		clerigo.definirHabilidades();
		System.out.println("\n\nAgora vamos definir os equipamentos do Clérigo\n\n");
		clerigo.definirEquipamentos();
		System.out.println("\n\nE, finalmente, vamos definir as características do Clérigo\n\n");
		clerigo.definirCaracteristicas();
		clerigo.definirPontosVida(8);
		
		//Mostrar personagens geradas
		barbaro.Mostrar(); //funciona
		guerreiro.Mostrar(); //funciona
		ladino.Mostrar(); //funciona
		clerigo.Mostrar(); //funciona
		
		leia.close();
	}
	public static void apagarConsoleEclipse() {
		System.out.printf("Aperte Enter para continuar\n");
		try {
	        System.in.read();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		for (int i = 0; i<99535; i++) {
			System.out.printf(" ");
		}
		System.out.printf("\r");
	}
	public static void aperteEnter(Scanner scanner) throws InterruptedException {
		
		scanner.nextLine();
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(500);
	}
}
