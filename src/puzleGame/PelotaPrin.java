package puzleGame;

import java.awt.Color;
import java.awt.Graphics2D;

public  class PelotaPrin extends ElementoBase {
	
	PelotaPrin(int posx, int  posy, int  vx, int  vy, int  largo, int  ancho, Color color){
		super(posx,posy, largo,ancho,color);
	}

	@Override
	public void dibujarse(Graphics2D g2d) {
		// TODO Auto-generated method stub
		 	g2d.setColor(getColor());
		 	g2d.fillOval(getPosx(), getPosy(), 30, 30);
	}

	@Override
	public void moversePrueba(int i) {
		// TODO Auto-generated method stub
		 posX = posX + vX;
	     posY = posY + vY;
	}

	
}

	
