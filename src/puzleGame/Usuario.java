package puzleGame;

public class Usuario {

	public String nom;
	public int vidas;
	public int puntos;
	
	Usuario(String nom, int vidas){
		this.nom=nom;
		this.vidas=vidas;
		this.puntos=0;
	}

	public void setVidas(){
		vidas=vidas-1;
	}

	public void setPuntos() {
		puntos=puntos+1;
	}

	public String  getNombre() {
		return nom;
	}

	
	public int getVidas() {
		int vidaX12=0;
		if(vidas<=12 && vidas>0) {
			vidaX12=1;
		}else if(vidas<=24 && vidas>12) {
			vidaX12=2;
		}else if(vidas<=36 && vidas>24) {
			vidaX12=3;
		}else if(vidas<=0) {
			vidaX12=0;
		}
		return  vidaX12;
	}

	public int getPuntos() {
		return puntos;
	}

}

