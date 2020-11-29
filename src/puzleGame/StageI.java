package puzleGame;


public class StageI implements PosicionesTablero {
		
		//SON 2 POSICIONES x, y ...
		private int inicioX;
		private int inicioY;
		private int fijaX;
		private int fijaY;
		private int filas=7;
		private int columnas=3;
		private int [] vFilas;
		private int [] vColumnas;
		private int cantUniones;
	
	
	StageI(){
		this.inicioX=70;
		this.inicioY=150;
		this.fijaX=460;
		this.fijaY=70;
        this.vFilas=new int [filas];
        this.vColumnas=new int [columnas];
        setMatriz();
	}
	
	@Override
	 public void setMatriz() {
		for(int i=0; i<columnas; i++) {
				vColumnas[i]=inicioX;
				this.inicioX+=120;
				System.out.println("c" + vColumnas[i]);
			}
		for(int i=0; i<filas; i++) {
				vFilas[i]=inicioY;
				inicioY+=60;
		}
	}

	@Override
	public int[] getvectorfilas() {
		return vFilas;		
	}

	@Override
	public int[] getvectorColumnas() {
		return vColumnas;		
	}
	
	@Override
	public int getInicioX() {
		return inicioX;		
	}
	
	@Override
	public int getInicioY() {
		return inicioY;		
	}

	public int getFijaX() {
		return fijaX;
	}

	@Override
	public int getFijaY() {
		// TODO Auto-generated method stub
		return fijaY;
	}

	@Override
	public int getCantidadUniones() {
		// TODO Auto-generated method stub
		return this.cantUniones;
	}
	
}

