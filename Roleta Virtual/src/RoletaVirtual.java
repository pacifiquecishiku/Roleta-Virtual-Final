import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pacifique
 */
public class RoletaVirtual {

        /**
     * @param args the command line arguments
     */
    Banca banc = new Banca();
    public static void main(String[] args) {
        // TODO code application logic here
        Banca banc = new Banca();
	Scanner input =new Scanner(System.in);
	Jogador[] jogadores = new Jogador[2];
	
	//-------PRENCHER O ARRAY--------
			for(int i=0; i < jogadores.length;i++){
				if(jogadores[i]==null){
					System.out.println("Deseja inserir jogador na posição " + (i+1) + "? sim ou não");
					if(input.next().equalsIgnoreCase("sim")){
						System.out.println("Insere um nome");
						String nome = input.next();
						Jogador J = new Jogador(nome);
						jogadores[i] = J;
					}//if
				}//if
			}//for
        //------------Apostar e Rodar o jogo-------------------
        int j =1;
			/*for(int i=0; i< jogadores.length; i++){
                            if (jogadores[i] != null)
                                //if(jogadores[i].getFichas() != 0) {
                                j += jogadores[i].getFichas();
                        }*/
                               
                                    while(j !=0) {
                                        j=0;
                                        if(banc.getBudget() != 0) {
                                            ApostarOuNao(jogadores);//apostando
                                            rodar(jogadores, banc);//rodando o jogo
                                            for(int i=0; i< jogadores.length; i++)
                                                if (jogadores[i] != null)
                                                    System.out.println(jogadores[i].getNome() + " possui " + jogadores[i].getFichas() + " fichas");
                                        }else System.out.println("Banco nao tem dinheiro");
                                        //----------------------
                                        for(int i=0; i< jogadores.length; i++){
                                            if (jogadores[i] != null)
                                                j += jogadores[i].getFichas();
                                        }
                                    } System.out.println("Nenhum jogador possui fichas");
}//Main
	
//----------QUER APOSTAR OU NÃO------------
	private static void ApostarOuNao(Jogador []jogadores){
		Scanner input =new Scanner(System.in);
		
        for (Jogador jogadore : jogadores) {
            if (jogadore != null) {
                System.out.println(jogadore.getNome() + " Deseja apostar? sim ou não");
                if (input.next().equalsIgnoreCase("sim")) {
                    // quer apostar
                    apostar(jogadore);
                } else if (jogadore.getSemapostas() == 3) {
                    System.out.println("Você já tem 3 rodadas sem apostas");
                    apostar(jogadore);
                } else {
                    jogadore.SemApostar();
                    jogadore.setAposta("");//Colocando um string vazio pro aposta do jogador
                }
            } //if
        } //for
	}//ApostarOuNao
	
	
	//----------APOSTAR--------------
	private static void apostar(Jogador J){
		
		//Banca banc = new Banca(); //tirar esse banco daqui pra usar só no rodar()
		Scanner input =new Scanner(System.in);
		if(J.getFichas()>0){ //verificar se o jogador tem fichas suficientes
			System.out.println("Apostar");
			System.out.println("--------");
			System.out.println("par ou impar\npreto ou vermelho\nnumero\nmaior ou menor");
			String aposta = input.next();
			J.setAposta(aposta);
                        boolean apostou=false;
			while (apostou==false){
                            System.out.println("Insere o valor (número de fichas)");
                            J.setFichasApostadas(input.nextInt());
                            if(J.getFichasApostadas() <= J.getFichas())
                                apostou=true;
                            else
                                System.out.println("Voce nao poussi tantas fichas, apenas tem " + J.getFichas() + " fichas");
                        }
                            
                        J.setFichas(J.getFichas() - J.getFichasApostadas());
			//banc.ganharDoJogador(J.getFichasApostadas());
			if(J.getAposta().equals("numero")){
				System.out.println("Qual número deseja apostar?(0 a 36) ");
				J.setNumeroAposta(input.nextInt());
			}
		}//if
                else
                    System.out.println("Você não tem fichas suficinetes para apostar");
		
	}//Apostar
	
	
//----------------------------RODAR------------------------//
	private static void rodar(Jogador[] jogadores,Banca banc){
		Roleta rol = new Roleta();
                
		rol.rodar();//girar a roleta
               //Recuperando os dados da roleta
		int numero = rol.getNumero();
		String cor = rol.getCor();
                boolean parOUimpar= rol.getParOuImpar();
                System.out.println("   RESULTADOS \n ---------------- \n  *NÚMERO: " + numero + "\n  *COR: " + cor);//Divulgando resultados
                //Percorrendo o array de jogadores
                for(Jogador JG: jogadores){
                   if (JG != null)
                    if(!JG.getAposta().equals("")){//Se o jogador fizer uma aposta
                        String aposta = JG.getAposta();//Armazenar o aposto do jogador
                        switch (aposta) {
                            case "par":
                                if(parOUimpar){//o jogador ganhou
                                    System.out.println("o jogador " + JG.getNome()+ " ganhoooou!!! ;)");
                                    if(banc.getBudget()>= JG.getFichasApostadas()*2)//a banca tem fichas suficientes pra pagar
                                        JG.ganharFichas(JG.getFichasApostadas()*2);//o jogador recebe a recompensa
                                    else{ //a banca não tem capacidade de pagar
                                        System.out.println("Você quebrou a banca");
                                        JG.ganharFichas(JG.getFichasApostadas());
                                    }
                                //??????Sérá que a banca devolve o dinheiro que o jogador apostou????????????
                                }else{//o jogador não ganhou (perdeu)
                                    banc.ganharDoJogador(JG.getFichasApostadas());//a banca recebe as fichas apostadas pelo jogador
                                    System.out.println("o jogador " + JG.getNome()+ " perdeu :(");
                                }
                                break;
                            case "impar":
                                if(!parOUimpar){
                                    System.out.println("o jogador " + JG.getNome()+ " ganhoooou!!! ;)");
                                    if(banc.getBudget()>= JG.getFichasApostadas()*2)
                                        JG.ganharFichas(JG.getFichasApostadas()*2);
                                    else
                                        System.out.println("Você quebrou a banca");
                                }else{
                                    banc.ganharDoJogador(JG.getFichasApostadas());
                                    System.out.println("o jogador " + JG.getNome()+ " perdeu :(");
                                }
                                break;
                            case "preto":
                                if(cor.equals("preto")){
                                    System.out.println("o jogador " + JG.getNome()+ " ganhoooou!!! ;)");
                                    if(banc.getBudget()>= JG.getFichasApostadas()*2)
                                        JG.ganharFichas(JG.getFichasApostadas()*2);
                                    else
                                        System.out.println("Você quebrou a banca");
                                }else{
                                    banc.ganharDoJogador(JG.getFichasApostadas());
                                    System.out.println("o jogador " + JG.getNome()+ " perdeu :(");
                                }
                               
                                break;
                            case "vermelho":
                                if(cor.equals("vermelho")){
                                    System.out.println("o jogador " + JG.getNome()+ " ganhoooou!!! ;)");
                                    if(banc.getBudget()>= JG.getFichasApostadas()*2)
                                        JG.ganharFichas(JG.getFichasApostadas()*2);
                                    else
                                        System.out.println("Você quebrou a banca");
                                }else{
                                    banc.ganharDoJogador(JG.getFichasApostadas());
                                    System.out.println("o jogador " + JG.getNome()+ " perdeu :(");
                                }
                                break;
                            case "maior":
                                if(numero>= 19 && numero<37){
                                    System.out.println("o jogador " + JG.getNome()+ " ganhoooou!!! ;)");
                                    if(banc.getBudget()>= JG.getFichasApostadas()*2)
                                        JG.ganharFichas(JG.getFichasApostadas()*2);
                                    else
                                        System.out.println("Você quebrou a banca");
                                }else{
                                    banc.ganharDoJogador(JG.getFichasApostadas());
                                    System.out.println("o jogador " + JG.getNome()+ " perdeu :(");
                                }
                                break;
                            case "menor":
                                if(numero>= 1 && numero<19){
                                    System.out.println("o jogador " + JG.getNome()+ " ganhoooou!!! ;)");
                                    if(banc.getBudget()>= JG.getFichasApostadas()*2)
                                        JG.ganharFichas(JG.getFichasApostadas()*2);
                                    else
                                        System.out.println("Você quebrou a banca");
                                }else{
                                    banc.ganharDoJogador(JG.getFichasApostadas());
                                    System.out.println("o jogador " + JG.getNome()+ " perdeu :(");
                                }
                                break;
                            case "numero":
                                if(numero == JG.getNumeroAposta()){
                                    System.out.println("o jogador " + JG.getNome()+ " ganhoooou!!! ;)");
                                    if(banc.getBudget()>= JG.getFichasApostadas()*36)
                                        JG.ganharFichas(JG.getFichasApostadas()*36);
                                    else
                                        System.out.println("Você quebrou a banca");
                                }else{
                                    banc.ganharDoJogador(JG.getFichasApostadas());
                                    System.out.println("o jogador " + JG.getNome()+ " perdeu :(");
                                }
                                break;
                            default:
                                break;
                        }
                    }//if
                }//for
	}//Rodar
}//Class Roleta