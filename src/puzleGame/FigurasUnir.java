package puzleGame;

import java.awt.Color;
import java.awt.Graphics2D;

public class FigurasUnir extends Figuras{
		
	FigurasUnir(int posx, int posy, int largo, int ancho, Color color) {
		super(posx, posy, largo, ancho, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void moversePrueba(int i) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dibujarse(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(getColor());
	 	g2d.fillArc(getPosx(), getPosy(), getAncho(), getLarg(), -180, -180);
	}
	
	@Override
	public boolean comprobarUnion(Figuras base) {
		boolean union=MetodosGenerales.comprobarUnion(
	            this.getPosx(),
	            this.getPosy(),
	            this.getAncho(),
	            this.getLarg(),
	            base.getPosx(),
	            base.getPosy(),
	            base.getAncho(),
	            base.getLarg()
	            );
		
		if (union==true && this.getColor()==base.getColor()){
			return true;
		}else {
			return false;
		}
	}
	
	public void unir(Figuras eBase) {
		this.setPosx(eBase.getPosx());
		this.setPosy(eBase.getPosy());
	}

	
}

