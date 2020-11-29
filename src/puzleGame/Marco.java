package puzleGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Marco extends JFrame{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tablero newGame;
	private Usuario u;
	private Thread t;
	private List<Figuras> listaUnirBase;
	private List<Figuras> listaUnir2;
	private PosicionesTablero stage;
//comentario
	 Marco(){
		 
		 this.stage=new StageI();	   
		  setSize(800, 800);
		  this.listaUnirBase = new ArrayList<Figuras>();
	      this.listaUnir2 = new ArrayList<Figuras>();
	      crearFiurasUnir();

		  this.u=new Usuario("Lara", 36);
		  JPanel tableroEstado=new TableroEstado(600, 25, u);
		  add(tableroEstado, BorderLayout.NORTH);
		  
		  this.newGame=new Tablero(600,650, u);
		  add(newGame, BorderLayout.CENTER);
		  addKeyListener(newGame);
		  setFocusable(true);
	      newGame.setListaFiguras(listaUnirBase, listaUnir2);

		 
		  this.t = new Thread(newGame);	
		  t.start();

	 }
	
	 private void crearFiurasUnir() {
			int  medidas=100;
			int color=256;
			int []vFilas=stage.getvectorfilas();
			int []vColumnas=stage.getvectorColumnas();
			int xFija=stage.getFijaX();
			int yFija=stage.getFijaY();
			int cont=1;
			
			for(int i=0; i<vColumnas.length; i++) {
				for(int e=0; e<vFilas.length-1; e++) {
					Color ca=new Color((int)(Math.random()*256), 215, (int)(Math.random()*256));
//					while(cont%3==0) {
//						e++;
//						cont++;
//					}
						FigurasUnir a=new FigurasUnir(xFija, yFija, medidas, medidas, ca);
						this.listaUnir2.add(a);
					
					FigurasUnir b=new FigurasUnir(vColumnas[i], vFilas[e], medidas, medidas, ca);
					this.listaUnirBase.add(b);
					cont++;
					yFija+=60;
				}
			}
		}
}

