package fichaRPG;

import java.util.Scanner;

public class Barbaro extends Personagem{
	//Babi
	Scanner leia = new Scanner(System.in);
	public Barbaro (String nomePersonagem, String nomeJogador, String classe,
			int nivel, int pontosVida, 
			int[] habilidades, 
			String[] equipamentos,
			String[] caracteristicas ) {
		super(nomePersonagem, nomeJogador, classe, nivel, pontosVida, 
				habilidades, equipamentos,caracteristicas);
	}
	@Override
	public void definirEquipamentos() {
		int equipa; 
		String[] equipamentos = this.getEquipamentos();
		//or (int i = 0; i <= getEquipamentos().length; i++) {
		System.out.println("Escolha seu primeiro equipamento:");
		System.out.println("\n 1 -  Machado grande \n 2 - Arma marcial");
		equipa = leia.nextInt();
		switch (equipa) {
		case 1: equipamentos[0] = "Machado Grande";break;
		case 2:	equipamentos[0] = "Arma Marcial";break;
		default: System.out.println("Escolha inv�lida");
		}
		System.out.println("Escolha seu segundo equipamento:");
		System.out.println("\n 1 -  Machado de M�o \n 2 - Arma Simples");
		equipa = leia.nextInt();
		switch (equipa) {
		case 1: equipamentos[1] = "Machado de M�o";break;
		case 2:	equipamentos[1] = "Arma Simples";break;
		default: System.out.println("Escolha inv�lida");
		}
		equipamentos[2] = "Pacote de Aventureiro e Quatro Azagaias";
		System.out.println("Terceiro equipamento: " + equipamentos[2]);
		this.setEquipamentos(equipamentos);
	}
	@Override
	public void definirCaracteristicas() {
		int incrementaHab = 0;
		//System.out.println("Digite seu n�vel atual (1 a 20): ");
		int nivel = this.getNivel();
		String[] caracteristicas = this.getCaracteristicas();
		switch (nivel) {
		case 20: caracteristicas[19] = "Campe�o Primitivo";
		case 19: caracteristicas[18] = "Incremento no valor da Habilidade";incrementaHab++;
		case 18: caracteristicas[17] = "For�a Indom�vel";
		case 17: caracteristicas[16] = "Cr�tico Brutal Incremento II";
		case 16: caracteristicas[15] = "Incremento no Valor de Habilidade";incrementaHab++;
		case 15: caracteristicas[14] = "F�ria Persistente";
		case 14: caracteristicas[13] = "Caracter�stica de Caminho Primitivo";
		case 13: caracteristicas[12] = "Cr�tico Brutal Incremento I";
		case 12: caracteristicas[11] = "Incremento no Valor de Habilidade";incrementaHab++;
		case 11: caracteristicas[10] = "F�ria Implac�vel";
		case 10: caracteristicas[9] = "Caracter�stica de Caminho Primitivo Incremento II";
		case 9: caracteristicas[8] = "Cr�tico Brutal";
		case 8: caracteristicas[7] = "Incremento no Valor de Habilidade";incrementaHab++;
		case 7: caracteristicas[6] = "Instinto Selvagem";
		case 6: caracteristicas[5] = "Caracter�stica de Caminho Primitivo Incremento I";
		case 5: caracteristicas[4] = "Ataque Extra +  Movimento R�pido";
		case 4: caracteristicas[3] = "Incremento no Valor de Habilidade";incrementaHab++;
		case 3: caracteristicas[2] = "Caminho Primitivo";
		case 2: caracteristicas[1] = "Ataque Descuidado + Sentido de Perigo";
		case 1: caracteristicas[0] = "F�ria + Defesa sem Armadura"; break;
		default: System.out.println("Digite uma op��o v�lida");
		}
		this.incrementarHabilidade(incrementaHab);
		this.setCaracteristicas(caracteristicas);
	}
	public void definirPontosVida(int dadoLados) {
		Scanner leia = new Scanner(System.in);
		int pontosvida = this.getPontosVida();
		int nivel = this.getNivel();
		int constMod = (this.getHabilidade(2) - this.getHabilidade(2)%2)/2 - 5;
		pontosvida = dadoLados+constMod;
		/*switch (leia.nextInt()) {
		case 1:
			//Rolagem de dado
			int dado = (int) Math.random()*dadoLados + 1;
			pontosvida = pontosvida + (nivel-1) * dado + constMod;
			break;
		case 2:*/
		//Fixo
		dadoLados = dadoLados/2 + 1;
		pontosvida += (nivel-1)*(dadoLados + constMod);
		//	}
	}
	
	public void Mostrar() {
		System.out.println("\n \n \n");
		System.out.println("\t\tNome do Personagem: " + this.getNomePersonagem());
		System.out.println("\n\t\tNome do Jogador: " + this.getNomeJogador() + ", o/a B�rbaro/a");
		System.out.println("\n\t\tNivel: " + this.getNivel());
		System.out.println("\n\t\tPontos de Vida M�ximos: " + this.getPontosVida());
		System.out.println("\n\t\tHabilidades: " );
		System.out.println("\t\t For�a: " + this.getHabilidade(0));
		System.out.println("\t\t Destreza: " + this.getHabilidade(1));
		System.out.println("\t\t Constitui��o: " + this.getHabilidade(2));
		System.out.println("\t\t Intelig�ncia: " + this.getHabilidade(3));
		System.out.println("\t\t Sabedoria: " + this.getHabilidade(4));
		System.out.println("\t\t Carisma: " + this.getHabilidade(5));
		System.out.println("\n\t\tCaracter�sticas: ");
		this.mostrarCaracteristicas();
		System.out.println("\n\t\tEquipamentos: ");
		this.mostrarEquipamentos();
	}
}

