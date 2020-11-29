package puzleGame;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class ElementoBase implements Elemento{
	
	protected int posX;
	protected int posY;
	protected int vX;
	protected int vY;
	private int largo;
	private int ancho;
	private Color color;

	
	ElementoBase(int posx, int posy, int largo, int ancho, Color color){
		this.posX=posx;
		this.posY=posy;
		this.vX=0;
		this.vY=0;
		this.largo=largo;
		this.ancho=ancho;
		this.color=color;
	}
		
	
	@Override
	public abstract void moversePrueba(int i);
	
	@Override
	public abstract void dibujarse(Graphics2D g);

	
//-----Metodos Get
	@Override
	public int getPosx() {
		return this.posX;
	}

	@Override
	public int getPosy() {
		return this.posY;
	}

	@Override
	public int getVx() {
		return this.vX;
	}

	@Override
	public int getVy() {
		return this.vY;
	}

	@Override
	public int getAncho() {
		return this.ancho;
	}

	@Override
	public int getLarg() {
		return this.largo;
	}

	public Color getColor() {
		return this.color;
	}

	
//-----Metodos Set
	public void setPosx(int p) {
		 this.posX=p;
	}
	
	public void setPosy(int v) {
		this.posY=v;
	}
	
	public void setVx(int v) {
		this.vX=v;
	}
	
	public void setVy(int v) {
		this.vY=v;
	}
	
	public void setAncho(int a) {
		this.ancho=a;
	}
	
	public void setLarg(int l) {
		this.largo=l;
	}
	
	public Color setColor(Color color) {
		this.color=color;
		return null;
	}
	
//-----Metodos Otros
	   public boolean hayColision(Elemento elemento) {
	        if (MetodosGenerales.hayColision(
	            this.getPosx(),
	            this.getPosy(),
	            this.getAncho(),
	            this.getLarg(),
	            elemento.getPosx(),
	            elemento.getPosy(),
	            elemento.getAncho(),
	            elemento.getLarg())) {
	                return true;
	        } else {
	            return false;
	        }
	    }
	   
	   public String empalmeCirculos(Elemento e) {
		   
		   int e1posX= this.getPosx(), e1posY=this.getPosy();
		   int e1Ancho=this.getAncho(), e1Largo=this.getLarg();
		   int e2posX= e.getPosx(), e2posY=e.getPosy();
		   int e2Ancho=e.getAncho(), e2Largo=e.getLarg();
		   String rsta=MetodosGenerales.emparejamientoCirculos(e1posX, e1posY, e1Ancho, e1Largo,
				   e2posX, e2posY, e2Ancho, e2Largo);
		   
		   if(rsta.equalsIgnoreCase("izq")){
			   return "izq";
		   }else if(rsta.equalsIgnoreCase("derecha")) {
			   return "derecha";
		   }else if(rsta.equalsIgnoreCase("arriba")) {
			   return "arriba";
		   }else if(rsta.equalsIgnoreCase("abajo")) {
			   return "abajo";
		   }else {
			   return "no";
		   }
	   }
	   
	   
	   
		public void empujadoX(int x) {
			// TODO Auto-generated method stub
			this.setPosx(this.getPosx()+x);
		}
		
		public void empujadoY(int y) {
			// TODO Auto-generated method stub
			this.setPosy(this.getPosy()+y);

		}
}

