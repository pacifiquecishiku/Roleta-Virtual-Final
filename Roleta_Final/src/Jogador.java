
public class Jogador {
	
	String nome;
	int fichas = 100;
	int semApostas = 0;
	
	String aposta;
	int FichasApostadas;
	int numeroAposta;
	
	public Jogador(String nome){
		this.nome = nome;
	}
	
	public int getNumeroAposta() {
		return numeroAposta;
	}
	public void setNumeroAposta(int numeroAposta) {
		this.numeroAposta = numeroAposta;
	}
	public int getFichasApostadas() {
		return FichasApostadas;
	}
	public void setFichasApostadas(int fichasApostadas) {
		FichasApostadas = fichasApostadas;
	}
	public int getFichas(){
		return fichas;
	}
	public String getAposta() {
		return aposta;
	}

	public void setAposta(String aposta) {
		this.aposta = aposta;
	}

	public String getNome(){
		return nome;
	}
	public int getSemapostas(){
		return semApostas;
	}
	
	
//__________________________________________________________//
	public boolean apostar(int fichas){
		boolean apostou = false;
		
		if(this.fichas>= fichas){
			this.fichas-=fichas;
			apostou = true;
		}
		return apostou;
	}
	public void ganharFichas(int fichas){
		this.fichas += fichas;
	}
	public void SemApostar(){
		this.semApostas ++;
	}
}