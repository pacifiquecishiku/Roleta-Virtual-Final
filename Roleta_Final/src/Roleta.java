import java.util.Random;

public class Roleta {

	Random rand = new Random();
	int numero;
	String cor;
	
	public void rodar(){
		this.numero = rand.nextInt(36);
		if(numero%2==0 && numero>=1 && numero<=10)
			cor = "preto";
		else if(numero%2==1 && numero>=1 && numero<=10)
			cor = "vermelho";
//------------------------------------------
		if(numero%2==0 && numero>=11 && numero<=18)
			cor = "vermelho";
		else if(numero%2==1 && numero>=11 && numero<=18)
			cor = "preto";
//--------------------------------------------
		if(numero%2==0 && numero>=19 && numero<=28)
			cor = "preto";
		else if(numero%2==1 && numero>=19 && numero<=28)
			cor = "vermelho";
//-----------------------------------------------
		if(numero%2==0 && numero>=29 && numero<=36)
			cor = "vermelho";
		else if(numero%2==1 && numero>=29 && numero<=36)
			cor = "preto";
//------------------------------------------
		if(numero ==0)
			cor = "verde";
		
	}
	public int getNumero(){
		return numero;
	}
	public String getCor(){
		return cor;
	}	
}

