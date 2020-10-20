package fichaRPG;
import java.util.*;

public class Ladino extends Personagem{
	//Fernanda

	int escolhaDeEquipamento;
	Scanner leia = new Scanner (System.in);
	int[] habilidades;

	public Ladino(String nomePersonagem, String nomeJogador, String classe, int nivel, int pontosVida, int[] habilidades,
			String[] equipamentos, String[] caracteristicas) {
		super(nomePersonagem, nomeJogador, classe, nivel, pontosVida, habilidades, equipamentos, caracteristicas);
	}


	@Override
	public void definirEquipamentos() {
		System.out.printf("Escolha o primeiro equipamento: \n1 - Rapieira\n2- Espada Longa");
		escolhaDeEquipamento = leia.nextInt();
		String[] equipamentos = this.getEquipamentos();
		if (escolhaDeEquipamento == 1) {
			equipamentos[0] = "Rapieira";
		}
		else if (escolhaDeEquipamento == 2)
			equipamentos[0] = "Espada Longa";
		else {
			System.out.printf("Escolha uma alternativa v�lida.");
		}

		System.out.printf("Escolha o segundo equipamento: \n1 - Arco Curto + Aljava com 20 flechas \n2- Espada Curta");
		escolhaDeEquipamento = leia.nextInt();

		if  (escolhaDeEquipamento == 1) {
			equipamentos[1] = "Arco Curto + Aljava 20 Flechas";
		}
		else if (escolhaDeEquipamento == 2) {
			equipamentos[1] = "Espada Curta";
		}
		else {
			System.out.printf("Escolha uma alternativa v�lida.");
		}

		System.out.printf("Escolha o terceiro equipamento: \n1 - Pacote de Assaltante\n2- Pacote de Aventureiro\n3- Pacote de Explorador\n");
		escolhaDeEquipamento = leia.nextInt();

		if (escolhaDeEquipamento == 1) {
			equipamentos[2] = "Pacote de Assaltante";
		}
		else if (escolhaDeEquipamento == 2) {
			equipamentos[2] = "Pacote de Aventureiro";
		}
		else if (escolhaDeEquipamento == 3) {
			equipamentos[2] = "Pacote de Explorador";
		}
		else {
			System.out.printf("Escolha uma alternativa v�lida.");
		}
		equipamentos[3] = "Armadura de couro, duas adagas e ferramentas de ladr�o";
		this.setEquipamentos(equipamentos);
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

	@Override
	public void definirCaracteristicas() {
		int nivel = getNivel();
		int incrementaHab = 0;
		String[] caracteristicas = this.getCaracteristicas();
		switch (nivel) {
		case 20:
			caracteristicas[19] = "Golpe de Sorte";
		case 19: 
			caracteristicas[18] = "Incremento no Valor de Habilidade";incrementaHab++;			
		case 18:
			caracteristicas[17] = "Elusivo";
		case 17:
			caracteristicas[16] = "Caracter�stica de Arqu�tipo de Ladino";
		case 16:
			caracteristicas[15] = "Incremento no Valor de Habilidade";incrementaHab++;
		case 15:
			caracteristicas[14] = "Mente Escorregadia";
		case 14:
			caracteristicas[13] = "Sentido Cego";
		case 13:
			caracteristicas[12] = "Caracter�stica de Arqu�tipo de Ladino";
		case 12:
			caracteristicas[11] =  "Incremento no Valor de Habilidade";incrementaHab++;
		case 11:
			caracteristicas[10] = "Talento Confi�vel";
		case 10:
			caracteristicas[9] =  "Incremento no Valor de Habilidade";incrementaHab++;
		case 9:
			caracteristicas[8] = "Caracter�stica de Arqu�tipo de Ladino";
		case 8:
			caracteristicas[7] = "Incremento no Valor de Habilidade";incrementaHab++;
		case 7:
			caracteristicas[6] = "Evas�o";
		case 6:
			caracteristicas[5] = "Especializa��o";
		case 5:
			caracteristicas[4] = "Esquiva Sobrenatural";
		case 4:
			caracteristicas[3] = "Incremento no Valor de Habilidade";incrementaHab++;
		case 3:
			caracteristicas[2] = "Arqu�tipo de Ladino";
		case 2:
			caracteristicas[1] = "A��o Ardilosa";
		case 1:
			caracteristicas[0] = "Especializa��o, Ataque Furtivo, G�ria de Ladr�o"; break;
		default: System.out.println("Digite uma op��o v�lida");
		}
		this.incrementarHabilidade(incrementaHab);
		this.setCaracteristicas(caracteristicas);
	}
	
	public void Mostrar() {
		System.out.println("\n \n \n");
		System.out.println("\t\tNome do Personagem: " + this.getNomePersonagem());
		System.out.println("\n\t\tNome do Jogador: " + this.getNomeJogador() + ", o/a Ladino/a");
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