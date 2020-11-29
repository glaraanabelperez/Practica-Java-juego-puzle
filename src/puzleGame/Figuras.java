package puzleGame;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Figuras extends ElementoBase{

	private boolean figuraUnida;

	Figuras(int posx, int posy, int largo, int ancho, Color color) {
		super(posx, posy, largo, ancho, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void moversePrueba(int i);

	@Override
	public abstract void dibujarse(Graphics2D g2d);

	public abstract boolean comprobarUnion(Figuras eBase);
	
	public abstract void unir(Figuras eBase);
	
	public boolean getfiguraUnida() {
		return figuraUnida;
	}
	
	public void setfiguraUnida(boolean x) {
		this.figuraUnida=x;
	}	

}
