package fichaRPG;
import java.util.*;
public class Guerreiro extends Personagem {
	//Luisa

	Scanner ler = new Scanner(System.in);

	public Guerreiro (String nomePersonagem, String nomeJogador, String classe, int nivel, int pontosVida,
			int[] habilidades, String[] equipamentos, String[] caracteristicas) {
		super(nomePersonagem, nomeJogador, classe, nivel, pontosVida, habilidades, equipamentos, caracteristicas);
	}

	public void definirEquipamentos() {
		int equipamento; 
		String[] equipamentos = this.getEquipamentos(); 
		System.out.println("Escolha seu primeiro equipamento:");
		//Thread.sleep(2000);
		System.out.println("\n1- Cota de malha ou 2- Gibão de peles, arco longo e 20 flechas");
		equipamento = ler.nextInt();
		switch (equipamento) {
		case 1: 
			equipamentos[0] = "Cota de malha";
			break;
		case 2:	
			equipamentos[0] = "Gibão de peles, arco longo e 20 flechas";
			break;
		default: 
			System.out.println("Escolha inválida");
		}

		System.out.println("Escolha seu segundo equipamento:");
		System.out.println("\n1- Uma arma marcial e um escudo ou 2- Duas armas marciais");
		equipamento = ler.nextInt();
		switch (equipamento) {
		case 1: 
			equipamentos[1] = "Uma arma marcial e um escudo";
			break;
		case 2:	
			equipamentos[1] = "Duas armas marciais";
			break;
		default: 
			System.out.println("Escolha inválida");
		}

		System.out.println("Escolha seu terceiro equipamento:");
		System.out.println("\n1- Uma besta leve e 20 virotes ou 2- Dois machados de arremesso");
		equipamento = ler.nextInt();
		switch (equipamento) {
		case 1: 
			equipamentos[2] = "Uma besta leve e 20 virotes";
			break;
		case 2:	
			equipamentos[2] = "Dois machados de arremesso";
			break;
		default: 
			System.out.println("Escolha inválida");
		}

		System.out.println("Escolha seu quarto equipamento:");
		System.out.println("\n1- Um pacote de aventureiro ou 2- Um pacote de explorador");
		equipamento = ler.nextInt();
		switch (equipamento) {
		case 1: 
			equipamentos[3] = "Um pacote de aventureiro";
			break;
		case 2:	
			equipamentos[3] = "Um pacote de explorador";
			break;
		default: 
			System.out.println("Escolha inválida");
		}
		this.setEquipamentos(equipamentos);
	}
	@Override
	public void definirCaracteristicas() {
		int incrementaHab = 0;
		String[] caracteristicas = this.getCaracteristicas();
		switch (getNivel()) {
		case 20: 
			caracteristicas[19] = "Ataque Extra ";
		case 19: 
			caracteristicas[18] = "Incremento no valor da Habilidade";
			incrementaHab++;
		case 18: 
			caracteristicas[17] = "Característica de Arquétipo Marcial";
		case 17: 
			caracteristicas[16] = "Surto de Ação (dois usos),\r\n"
					+ "Indomável (três usos)";
		case 16: 
			caracteristicas[15] = "Incremento no Valor de Habilidade";
			incrementaHab++;
		case 15: 
			caracteristicas[14] = "Característica de Arquétipo Marcial";
		case 14: 
			caracteristicas[13] = "Incremento no Valor de Habilidade";
			incrementaHab++;
		case 13: 
			caracteristicas[12] = "Indomável (dois usos)";
		case 12: 
			caracteristicas[11] = "Incremento no Valor de Habilidade";
			incrementaHab++;
		case 11: 
			caracteristicas[10] = "Ataque Extra";
		case 10: 
			caracteristicas[9] = "Característica de Arquétipo Marcial";
		case 9:
			caracteristicas[8] = "Indomável (um uso)";
		case 8: 
			caracteristicas[7] = "Incremento no Valor de Habilidade";
			incrementaHab++;
		case 7: 
			caracteristicas[6] = "Característica de Arquétipo Marcial";
		case 6: 
			caracteristicas[5] = "Incremento no Valor de Habilidade";
			incrementaHab++;
		case 5: 
			caracteristicas[4] = "Ataque Extra";
		case 4: 
			caracteristicas[3] = "Incremento no Valor de Habilidade";
			incrementaHab++;
		case 3: 
			caracteristicas[2] = "Arquétipo Marcial";
		case 2: 
			caracteristicas[1] = "Surto de Ação (um uso)";
		case 1: 
			caracteristicas[0] = "Estilo de Luta, Retomar o Fôlego";
			break;
		default: 
			System.out.println("Digite uma opção válida");
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
		System.out.println("\n\t\tNome do Jogador: " + this.getNomeJogador() + ", o/a Guerreiro/a");
		System.out.println("\n\t\tNivel: " + this.getNivel());
		System.out.println("\n\t\tPontos de Vida Máximos: " + this.getPontosVida());
		System.out.println("\n\t\tHabilidades: " );
		System.out.println("\t\t Força: " + this.getHabilidade(0));
		System.out.println("\t\t Destreza: " + this.getHabilidade(1));
		System.out.println("\t\t Constituição: " + this.getHabilidade(2));
		System.out.println("\t\t Inteligência: " + this.getHabilidade(3));
		System.out.println("\t\t Sabedoria: " + this.getHabilidade(4));
		System.out.println("\t\t Carisma: " + this.getHabilidade(5));
		System.out.println("\n\t\tCaracterísticas: ");
		this.mostrarCaracteristicas();
		System.out.println("\n\t\tEquipamentos: ");
		this.mostrarEquipamentos();
	}
}
