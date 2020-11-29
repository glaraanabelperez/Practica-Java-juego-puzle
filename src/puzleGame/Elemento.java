package puzleGame;

import java.awt.Color;
import java.awt.Graphics2D;


public interface Elemento {
	
	
	public int getPosx();
	
	public int getPosy();
	
	public int getVx();
	
	public int getVy();
	
	public int getAncho();
	
	public int getLarg();
	
	public Color getColor();
		
	public void dibujarse(Graphics2D g);
	
	public void moversePrueba(int i);

	
	//public boolean hayColision();
	
		
}

