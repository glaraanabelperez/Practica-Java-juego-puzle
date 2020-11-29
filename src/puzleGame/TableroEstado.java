package puzleGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

public class TableroEstado extends Tablero  implements Dibujables{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int anchoTestado;
	private Usuario u;
	private String texto;
	private int anchoCeldas;
	
	TableroEstado(int ancho, int alto, Usuario u){
		super(ancho, alto,  u);
		
		this.anchoTestado=ancho;
		this.u=u;
		this.texto=" Ok comenzamos";
		this.anchoCeldas=anchoTestado/14;
        
	}
	
	@Override
    protected void paintComponent(Graphics g2d) {
		 g2d.setColor(Color.white);
	     g2d.fillRect(0, 0, anchoTestado, 34);
	     dibujar(g2d);
	}
	
	@Override
	public Dimension getPreferredSize() {
	     return new Dimension(this.anchoTestado, 34);
	}
	
	@Override
	public void dibujar(Graphics g2d) {
		// TODO Auto-generated method stub
		 g2d.setColor(Color.DARK_GRAY);
	     g2d.setFont(new Font("Roboto mono", 2, 16));
	     g2d.drawString("Stage I "  , anchoCeldas, 28);
	     g2d.drawString("Tenes " + this.u.getVidas() + " vidas "  , anchoCeldas*3, 28);
	     g2d.drawString("puntos:  " + this.u.getPuntos() , anchoCeldas*6, 28);
	     g2d.setFont(new Font("Roboto mono", 3, 16));
	     g2d.drawString(texto , anchoCeldas*9, 28);

	     verificarCambios();
	     this.repaint();
	}
	
	public void verificarCambios() {
		if(this.u.getVidas()<3 && this.u.getVidas()>1) {
			texto=" ups! cuidado!!!";
		}else if(this.u.getVidas()<2 && this.u.getVidas()>0) {
			texto= "ups! te han chocado  ";
		}else if (this.u.getVidas()==0) {
			texto= "Stage II ... proximamente ";
		}
	}	
	
}

