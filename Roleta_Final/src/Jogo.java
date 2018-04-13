import java.util.Scanner;

public class Jogo {
	public static void main(String[]args){
	Scanner input =new Scanner(System.in);
	Jogador[] jogadores = new Jogador[2];
	boolean Fichasdisponiveis = true;
	
	//-------PRENCHER O ARRAY--------
			for(int i=0; i < jogadores.length;i++){
				if(jogadores[i]==null){
					System.out.println("Deseja inserir jogador na posição " + (i+1) + "? sim ou não");
					if(input.next().equals("sim")){
						System.out.println("Insere um nome");
						String nome = input.next();
						Jogador J = new Jogador(nome);
						jogadores[i] = J;
					}//if
				}//if
			}//for
			ApostarOuNao(jogadores);//apostando
			rodar(jogadores);
}//Main
	
//----------QUER APOSTAR OU NÃO------------
	public static void ApostarOuNao(Jogador []jogadores){
		Scanner input =new Scanner(System.in);
		
		for(int i=0; i < jogadores.length;i++){
			if(jogadores[i]!=null){
				System.out.println(jogadores[i].getNome()+ " Deseja apostar? sim ou não");
				if(input.next().equals("sim")){ // quer apostar
					apostar(jogadores[i]);					
				}else 
					if(jogadores[i].getSemapostas()==3){
						System.out.println("Você já tem 3 rodadas sem apostas");
						apostar(jogadores[i]);
					}else
						jogadores[i].SemApostar();
			}//if
		}//for
	}//ApostarOuNao
	
	
	//----------APOSTAR--------------
	private static void apostar(Jogador J){
		
		Banca banc = new Banca();
		Scanner input =new Scanner(System.in);
		if(J.getFichas()>0){ //verificar se o jogador tem fichas suficientes
			System.out.println("Apostar");
			System.out.println("--------");
			System.out.println("par ou impar\npreto ou vermelho\nnumero\nmaior ou menor");
			String aposta = input.next();
			J.setAposta(aposta);
			
			System.out.println("Insere o valor (número de fichas)");
			J.setFichasApostadas(input.nextInt());
			banc.ganharDoJogador(J.getFichasApostadas());
			if(J.getAposta().equals("numero")){
				System.out.println("Qual número deseja apostar?");
				J.setNumeroAposta(input.nextInt());
			}
		}//if
		input.close();
	}//Apostar
	
	
//----------------------------RODAR------------------------//
	public static void rodar(Jogador[] jogadores){
		Roleta rol = new Roleta();
		Banca banc = new Banca();
		rol.rodar();
		int numero = rol.getNumero();
		String cor = rol.getCor();
	}//Rodar
	
}//Class_Jogo
