package puzleGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class EnemigoAleatorio extends Enemigos {

	int changex, changey;

	EnemigoAleatorio(int posx, int posy, int vx, int vy, int largo, int ancho, Color color) {
		super(posx, posy, vx, vy, largo, ancho, color);
		// TODO Auto-generated constructor stub
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
		if(i==1) {
			this.vX=0;
			this.vY=3;
			posX=420;
			posY+=(vY*changey);
		}else {
			this.vX=1;
			this.vY=1;
			posX+=vX*changex;
			posY+=vY*changey;
		}
			
		if(posX<0){
			posX=1;	
			changex=-changex;
		}
		if(posX>=600){
			posX=599;	
			changex=-changex;
		}
		if(posY<0){
			posY=5;
			changey=-changey;
		}
		if(posY + 15>=600){
			posY=580;
			changey=-changey;	
		}	
	}
	
	
}

