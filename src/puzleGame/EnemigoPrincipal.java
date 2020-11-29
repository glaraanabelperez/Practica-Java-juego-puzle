package puzleGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class EnemigoPrincipal extends Enemigos {
		
		int changex, changey;
	EnemigoPrincipal(int posX, int posY, int vX, int vY, int largo, int ancho, Color color) {
		super(posX, posY, vX, vY, largo, ancho, color);
		this.changex=1;
		this.changey=1;
	}
	
	@Override
	public void dibujarse(Graphics2D g) {
		// TODO Auto-generated method stub
		 	g.setColor(getColor());
		 	g.fillOval(this.getPosx(), this.getPosy(), getAncho(), getLarg());
	}

	@Override
	public void moversePrueba(int i) {
		// TODO Auto-generated method stub
		posX=(posX+vX);
		posY=(posY+vY);
		
		if(posX>=600) {
	    	posX=5;
	    }else if(posX<=0) {
	    	posX=600;
	    }
	    if(posY>=600) {
	    	posY=5;
	    }else if(posY<=0) {
	    	posY=600;
	    }
	}
	
}

