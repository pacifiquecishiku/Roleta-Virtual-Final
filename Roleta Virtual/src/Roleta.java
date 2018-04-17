import java.util.Random;

public class Roleta {

	Random rand = new Random();
	int numero;
	String cor;
        private boolean parOUimpar = false;
	
	public void rodar(){
		this.numero = rand.nextInt(36);
                if(numero%2==0)
                    parOUimpar= true;
                
                
		if(parOUimpar && numero>=1 && numero<=10)
			cor = "preto";
		else if(!parOUimpar && numero>=1 && numero<=10)
			cor = "vermelho";
//------------------------------------------
		if(parOUimpar && numero>=11 && numero<=18)
			cor = "vermelho";
		else if(!parOUimpar && numero>=11 && numero<=18)
			cor = "preto";
//--------------------------------------------
		if(parOUimpar && numero>=19 && numero<=28)
			cor = "preto";
		else if(!parOUimpar && numero>=19 && numero<=28)
			cor = "vermelho";
//-----------------------------------------------
		if(parOUimpar && numero>=29 && numero<=36)
			cor = "vermelho";
		else if(!parOUimpar && numero>=29 && numero<=36)
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
        public boolean getParOuImpar(){
            return parOUimpar;
        }
}