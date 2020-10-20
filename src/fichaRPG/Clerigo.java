package fichaRPG;
import java.util.*;

public class Clerigo extends Personagem{
	//Laura
	private String[] truques = new String[5];
	private String dominio;
	// Conhecimento, Engana��o, Guerra, Luz, Natureza, Tempestade ou Vida


	public Clerigo(String nomePersonagem, String nomeJogador, String classe, int nivel, int pontosVida, int[] habilidade,
			String[] equipamentos, String[] caracteristicas) {
		super(nomePersonagem, nomeJogador, classe, nivel, pontosVida, habilidade, equipamentos, caracteristicas);
	}

	public void definirEquipamentos() {
		Scanner leitor = new Scanner(System.in);
		String[] equips = this.getEquipamentos();
		int n, i = 0;
		//(a) uma ma�a ou (b) um martelo de guerra
		System.out.println("Escolha uma dessas op��es: "
				+ "\n 1 - Uma Ma�a"
				+ "\n 2 - Um Martelo de Guerra");
		do { 
			n = leitor.nextInt();
			switch(n) {
			case 1:
				equips[i] = "Ma�a"; i++;
				break;
			case 2:
				equips[i] = "Martelo de Guerra"; i++;
				break;
			default:
				System.out.println("Escolha uma op��o v�lida");
			}	
		}while(n != 1 && n != 2);
		//(a) brunea, (b) armadura de couro ou (c) cota de malha (se for proficiente)

		System.out.println("Escolha uma dessas op��es: "
				+ "\n 1 - Uma Br�nea (armadura leve de algod�o cru ou l� r�stica"
				+ "\n 2 - Uma Armadura de Couro"
				+ "\n 3 - Uma Cota de Malha");
		do { 
			n = leitor.nextInt();
			switch(n) {
			case 1:
				equips[i] = "Br�nea"; i++;
				break;
			case 2:
				equips[i] = "Armadura de Couro"; i++;
				break;
			case 3: 
				equips[i] = "Cota de Malha"; i++;
				break;
			default:
				System.out.println("Escolha uma op��o v�lida");
			}	
		}while(n != 1 && n != 2 && n != 3);

		//(a) um besta leve e 20 virotes ou (b) qualquer arma simples
		System.out.println("Escolha uma dessas op��es: "
				+ "\n 1 - Uma besta leve com 20 virotes"
				+ "\n 2 - Uma arma simples");
		do { 
			n = leitor.nextInt();
			switch(n) {
			case 1:
				equips[i] = "Besta Leve"; i++;
				equips[i] = "20 Virotes"; i++;
				break;
			case 2:
				equips[i] = "Arma Simples"; i++;
				break;
			default:
				System.out.println("Escolha uma op��o v�lida");
			}	
		}while(n != 1 && n != 2);
		//(a) um pacote de sacerdote ou (b) um pacote de aventureiro

		System.out.println("Escolha uma dessas op��es: "
				+ "\n 1 - Pacote de Sacerdote"
				+ "\n 2 - Pacote de Aventureiro");
		do { 
			n = leitor.nextInt();
			switch(n) {
			case 1:
				equips[i] = "Pacote de Sacerdote"; i++;
				break;
			case 2:
				equips[i] = "Pacote de Aventureiro"; i++;
				break;
			default:
				System.out.println("Escolha uma op��o v�lida");
			}	
		}while(n != 1 && n != 2);

		//Um escudo e um s�mbolo sagrado 
		equips[i] = "Escudo"; i++;
		equips[i] = "S�mbolo Sagrado"; i++;
		this.setEquipamentos(equips);
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
	public void definirCaracteristicas() {
		Scanner leia = new Scanner(System.in);
		int nivel = this.getNivel();
		int dominio, i = 0, aumentoAtributo = 0, truquesQuantidade, ler;
		String[] dominioLista = {"Conhecimento", "Engana��o", "Guerra", "Luz", "Natureza","Tempestade", "Vida"};
		String[] truques = new String[100];
		String[] caracteristicas = this.getCaracteristicas();
		String[] canalizar = new String[10];
		String[] aux = new String[100];
		boolean ok = false;

		//Definir o Dom�nio.
		do {
			System.out.println("Por favor, " + this.getNomePersonagem() + ", defina o seu dom�nio divino: " + "\n 1 - Conhecimento"
					+ "\n 2 - Engana��o" + "\n 3 - Guerra" + "\n 4 - Luz" + "\n 5 - Natureza" + "\n 6 - Tempestade"
					+ "\n 7 - Vida");
			dominio = leia.nextInt();
			if (dominio >= 1 && dominio <=7) ok = true;
		}while(!ok);
		//Gerar o vetor de habilidades, incluindo as habilidades de cada dom�nio, de acordo com o n�vel

		switch (nivel) {
		case 20:
			caracteristicas[i] = "20� N�vel - Interven��o Divina Aprimorada"; i++;
		case 19: 
			aumentoAtributo++;
		case 18:
			caracteristicas[i] = "18� N�vel - Canalizar Divindade - 3 vezes/descanso"; i++;
		case 17:
			canalizar[0] = "17� N�vel - Destruir Mortos-Vivos at� ND 4";
			//dominio
			switch (dominio) {
			case 1:
				caracteristicas[i] = "17� N�vel - Vis�es do Passado"; i++;
				break;
			case 2:
				canalizar[1] = "17� N�vel - Duplicidade Aprimorada";
				break;
			case 3:
				caracteristicas[i] = "17� N�vel - Avatar da Batalha"; i++;
				break;
			case 4:
				caracteristicas[i] = "17� N�vel - Coroa de Luz"; i++;
				break;
			case 5:
				caracteristicas[i] = "17� N�vel - Senhor da Natureza"; i++;
				break;
			case 6:
				caracteristicas[i] = "17� N�vel - Filho da Tormenta"; i++;
				break;
			case 7:
				caracteristicas[i] = "17� N�vel - Cura Suprema"; i++;
				break;
			}
		case 16:
			aumentoAtributo++;
		case 15: //nada
		case 14:
			if (nivel < 17) canalizar[0] = "14� N�vel - Destruir Mortos-Vivos at� ND 3";
			switch (dominio) {
			case 2:
				canalizar[2] = "14� N�vel - Golpe Divino Aprimorado - Veneno";
				break;
			case 3:
				canalizar[2] = "14� N�vel - Golpe Divino Aprimorado";
				break;
			case 5:
				canalizar[2] = "14� N�vel - Golpe Divino Aprimorado - Elemental";
				break;
			case 6:
				canalizar[2] = "14� N�vel - Golpe Divino Aprimorado - El�trico";
				break;
			case 7:
				canalizar[2] = "14� N�vel - Golpe Divino Aprimorado - Radiante";
				break;
			}
		case 13: //nada
		case 12:
			aumentoAtributo++;
		case 11:
			if (nivel < 13) {
				canalizar[3] = "11� N�vel - Destruir Mortos-Vivos at� ND 2";
			}
			else {
				canalizar[3] = null;
			}
		case 10:
			if (nivel < 20) {
				caracteristicas[i] = "10� N�vel - Interven��o Divina";
				i++;
			}
		case 9: //nada
		case 8:
			if (nivel < 11) {
				canalizar[4] = "8� N�vel - Destruir Mortos-Vivos at� ND 1";
			}
			else {
				canalizar[4] = null;
			}
			aumentoAtributo++;
			//dominio
			switch (dominio) {
			case 1:
				caracteristicas[i] = "8� N�vel - Conjura��o Poderosa"; i++;
				break;
			case 2:
				if (nivel < 14) {
					canalizar[5] = "8� N�vel - Golpe Divino - Veneno";
				}
				else {
					canalizar[5] = null;
				}
				break;
			case 3:
				if (nivel < 14) {
					canalizar[5] = "8� N�vel - Golpe Divino";

				}
				else {
					canalizar[5] = null;
				}
				break;
			case 4:
				caracteristicas[i] = "8� N�vel - Conjura��o Poderosa"; i++;
				break;
			case 5:
				if (nivel < 14) {
					canalizar[5] = "8� N�vel - Golpe Divino - Elemental";
				}
				else {
					canalizar[5] = null;
				}
				break;
			case 6:
				if (nivel < 14) {
					canalizar[5] = "8� N�vel - Golpe Divino - El�trico";
				}
				else {
					canalizar[5] = null;
				}
				break;
			case 7:
				if (nivel < 14) {
					canalizar[5] = "8� N�vel - Golpe Divino - Radiante";
				}
				else {
					canalizar[5] = null;
				}
				break;
			}
		case 7: //nada
		case 6:
			if (nivel < 18) {caracteristicas[i] = "6� N�vel - Canalizar Divindade - 2 vezes/descanso"; i++;}
			//dominio
			switch (dominio) {
			case 1:
				canalizar[6] = "6� N�vel - Ler Pensamentos";
				break;
			case 2:
				canalizar[6] = "6� N�vel - Manto das Sombras";
				break;
			case 3:
				canalizar[6] = "6� N�vel - B�n��o do Deus da Guerra";
				break;
			case 4:
				caracteristicas[i] = "6� N�vel - Labareda Protetora Aprimorada"; i++;
				break;
			case 5:
				caracteristicas[i] = "6� N�vel - Amortecer Elementos"; i++;
				break;
			case 6:
				caracteristicas[i] = "6� N�vel - Golpe do Rel�mpago"; i++;
				break;
			case 7:
				caracteristicas[i] = "6� N�vel - Curandeiro Aben�oado"; i++;
				break;
			}
		case 5:
			if (nivel < 8) {
				canalizar[7] = "5� N�vel - Destruir Mortos-Vivos at� ND 0.5"; 
			}
			else {
				canalizar[7] = null;
			}
		case 4:
			aumentoAtributo++;
		case 3://nada
		case 2:
			if (nivel < 6) {caracteristicas[i] = "2� N�vel - Canalizar Divindade"; i++;}
			if (nivel < 5) {
				canalizar[8] = "2� N�vel - Expulsar Mortos-Vivos";
			}
			else {
				canalizar[8] = null;
			}
			//dominio
			switch (dominio) {
			case 1:
				canalizar[9] = "2� N�vel - Conhecimento das Eras";
				break;
			case 2:
				if(nivel < 17) {
					canalizar[9] = "2� N�vel - Invocar Duplicidade";
				}
				else {
					canalizar[9] = null;
				}
				break;
			case 3:
				canalizar[9] = "2� N�vel - Ataque Dirigido";
				break;
			case 4:
				canalizar[9] = "2� N�vel - Radia��o do Amanhecer";
				break;
			case 5:
				canalizar[9] = "2� N�vel - Enfeiti�ar Animais e Plantas";
				break;
			case 6:
				canalizar[9] = "2� N�vel - Ira Destruidora";
				break;
			case 7:
				canalizar[9] = "2� N�vel - Preservar a Vida";
				break;
			}
		case 1:
			caracteristicas[i] = "1� N�vel - Conjura��o"; i++;
			switch (dominio) {
			case 2:
				caracteristicas[i] = "1� N�vel - Ben��o do Trapaceiro"; i++;
				break;
			case 3:
				caracteristicas[i] = "1� N�vel - Sacerdote da Guerra"; i++;
				break;
			case 4:
				//truque - luz
				if (nivel < 6) caracteristicas[i] = "1� N�vel - Labareda Protetora"; i++;
				break;
			case 5:
				//truque + 1
				break;
			case 6:
				caracteristicas[i] = "1� N�vel - Ira da Tormenta"; i++;
				break;
			case 7:
				caracteristicas[i] = "1� N�vel - Disc�pulo da Vida"; i++;
				break;
			}
		}

		//Fun��o que incrementa a Habilidade do personagem
		//Gerar o vetor de truques

		if(nivel < 4) {
			truquesQuantidade = 3;
		}
		else if (nivel < 10) {
			truquesQuantidade = 4;
		}
		else {
			truquesQuantidade = 5;
		}

		i = 0;
		boolean[] truqueEscolhido = {false, false, false, false, false, false, false}; 
		if (dominio == 4) {
			System.out.println("Por ser do dom�nio da Luz, voc� come�a com o truque \"Luz\" j� aprendido.");
			truques[i] = "Luz"; i++;
			truqueEscolhido[3] = true;
		}
		else if (dominio == 5) {
			System.out.println("Por ser do dom�nio da Natureza, voc� pode escolher um truque de Druida al�m dos "+ truquesQuantidade
					+ " truques que tem direito. \nEscolha:\n"
					+ "1 - Bord�o M�stico\n"
					+ "2 - Chicote de Espinhos\n"
					+ "3 - Consertar\n"
					+ "4 - Criar Chamas\n"
					+ "5 - Druidismo\n"
					+ "6 - Orienta��o\n"
					+ "7 - Rajada de Veneno");
			ler = leia.nextInt();
			switch (ler) {
			case 1:
				truques[i] = "Bord�o M�stico"; i++;
				break;
			case 2:
				truques[i] = "Chicote de Espinhos"; i++;
				break;
			case 3:
				truques[i] = "Consertar"; i++;
				truqueEscolhido[1] = true;
				break;
			case 4:
				truques[i] = "Criar Chamas"; i++;
				break;
			case 5:
				truques[i] = "Druidismo"; i++;
				break;
			case 6:
				truques[i] = "Orienta��o"; i++;
				truqueEscolhido[4] = true;
				break;
			case 7:
				truques[i] = "Rajada de Veneno"; i++;
				break;
			}
		}
		do {
			System.out.println(
					"Agora, escolha um dos " + truquesQuantidade + " truques que tem direito. " + "\nEscolha:");
			if (!truqueEscolhido[0])
				System.out.println("1 - Chama Sagrada");
			if (!truqueEscolhido[1])
				System.out.println("2 - Consertar");
			if (!truqueEscolhido[2])
				System.out.println("3 - Estabilizar");
			if (!truqueEscolhido[3])
				System.out.println("4 - Luz");
			if (!truqueEscolhido[4])
				System.out.println("5 - Orienta��o");
			if (!truqueEscolhido[5])
				System.out.println("6 - Resist�ncia");
			if (!truqueEscolhido[6])
				System.out.println("7 - Taumaturgia");
			ler = leia.nextInt()-1;
			if (ler < 0 || ler > 6) {
				System.out.println("Valor inv�lido.");
			}
			else if (truqueEscolhido[ler]) {
				System.out.println("Valor inv�lido.");
			}
			else {
				switch (ler) {
				case 0:
					truques[i] = "Chama Sagrada";
					i++; truquesQuantidade--;
					truqueEscolhido[0] = true;
					break;
				case 1:
					truques[i] = "Consertar";
					i++; truquesQuantidade--;
					truqueEscolhido[1] = true;
					break;
				case 2:
					truques[i] = "Estabilizar";
					i++; truquesQuantidade--;
					truqueEscolhido[2] = true;
					break;
				case 3:
					truques[i] = "Luz";
					i++; truquesQuantidade--;
					truqueEscolhido[3] = true;
					break;
				case 4:
					truques[i] = "Orienta��o";
					i++; truquesQuantidade--;
					truqueEscolhido[4] = true;
					break;
				case 5:
					truques[i] = "Resist�ncia";
					i++; truquesQuantidade--;
					truqueEscolhido[5] = true;
					break;
				case 6:
					truques[i] = "Taumaturgia";
					i++; truquesQuantidade--;
					truqueEscolhido[6] = true;
					break;
				}
			}
		} while (truquesQuantidade > 0);

		this.incrementarHabilidade(aumentoAtributo);
		//Esse c�digo converte tudo para o formato que o vetor de String getHabilidades usa

		for (int j = 0, k = 0; j < aux.length; j++) {
			aux[j] = caracteristicas[k];
			if (aux[j] != null) {
				if (aux[j].contains("Canalizar Divindade")) {
					for (int l = 0; l < canalizar.length; l++) {
						if (canalizar[l] != null) {
							j++;
							aux[j] = "\t" + canalizar[l];
						}
					}
				} 
			}
			k++;
		}

		this.setCaracteristicas(aux);
		this.setDominio(dominioLista[dominio-1]);
		this.setTruques(truques);
	}

	public void mostrarTruques() {
		for(String j : this.getTruques()) {
			if (j == null) break;
			System.out.println("\t\t" + j);
		}
	}
	public String[] getTruques() {
		return truques;
	}
	public void setTruques(String[] truques) {
		this.truques = truques;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
	public void Mostrar() {
		System.out.println("\n \n \n");
		System.out.println("\t\tNome do Personagem: " + this.getNomePersonagem());
		System.out.println("\n\t\tNome do Jogador: " + this.getNomeJogador() + ", o/a Cl�rigo/a");
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
		System.out.println("\n\t\tTruques: ");
		this.mostrarTruques();
	}
}
