public class Banca {
	
	int budget = 1000;
	
	public Banca(){
		
	}
	public int getBudget(){
		return budget;
	}
	public void pagarJogador(int valor){
		budget -= valor;
	}
	public void ganharDoJogador(int valor){
		budget += valor;
	}
}