package puzleGame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Mensajes implements Dibujables{
	
	private Color colorBase;
	private Color colorTexto;
	private String m;
	
	Mensajes(){
		this.m="Sin mensaje";
		this.colorBase=Color.white;
		this.colorTexto=Color.DARK_GRAY;
	}
	
	public void setMensaje(String m) {
		this.m=m;
	}
	
	public String getMensaje() {
		return m;
	}
	
	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(colorBase);
		g.fillRoundRect(200, 250, 150, 150, 10,10);
        g.fillOval(200, 300, 10, 10);

		g.setColor(colorTexto);
        g.setFont(new Font("Roboto mono", 8, 20));
        g.drawString(m, 225, 330);
	}

}

