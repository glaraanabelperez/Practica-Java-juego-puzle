package puzleGame;

import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Tablero  extends JPanel implements Runnable, KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int anchoTablero;
	private int altoTablero;
	private Usuario usuario;
	private List<Figuras> listaUnirBase;
	private List<Figuras> listaUnir2;
	private ElementoBase pelotaPrin;
	private ElementoBase enemigoPerseguidor;
	private List<ElementoBase> listEnemigos;
	private Mensajes mensaje;
	//GUARDA EL OBJETO G2D, PARA DISPONIBILIDAD FUERA DEL PAINT ...
	private Graphics2D g2d;
	//POS, VELOCIDAD, TAMANIO ELEMENTOS...
	private int posX, posY;
	private int velocX, velocY;
	private int largoE, anchoE;
	//VARIABLES PARA VERIFICACIONES...
	private boolean juegoCorriendo;
	private boolean pararJuego;
	private boolean setGanado;
	private boolean colision;
	private String empalmeCirculos;

	
	public Tablero(int ancho, int largo, Usuario a) {
		this.anchoTablero=ancho; 
		this.altoTablero=largo;
		this.usuario=a;
		this.posX=90; 
		this.posY=20; 
		this.velocX=0; 
		this.velocY=0;
		this.largoE=15; 
		this.anchoE=15;
		this.pelotaPrin=new PelotaPrin(posX, posY, velocX, velocY, largoE, anchoE, Color.red);
        this.enemigoPerseguidor=new EnemigoPrincipal(6, 6, velocX, velocY, largoE, anchoE, Color.ORANGE);
        this.listEnemigos = new ArrayList<ElementoBase>();
		this.mensaje=new Mensajes();
		
//		crearFiurasUnir();
		crearEnemigo(2);
		this.juegoCorriendo=true;
		this.pararJuego=false;
		this.colision=false;
		this.setGanado=false;

	}
	public void setListaFiguras( List<Figuras> listaFigurasBase, List<Figuras> listaFiguras2) {
		this.listaUnirBase=listaFigurasBase;
		this.listaUnir2=listaFiguras2;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
			super.paintComponent(g)	;	
			this.g2d = (Graphics2D) g;
	        g2d.setStroke(new BasicStroke(2));
        	//if(juegoCorriendo==true) {
        		
        		limpiarPantalla();
                if (!pararJuego) {
                	int i;
                	//dibujarFigDecorativo(g2d);
                    for(i=0; i<listaUnirBase.size(); i++) {
                    	listaUnirBase.get(i).dibujarse(g2d);
                    }
                    for(i=0; i<listaUnir2.size(); i++) {
                    	listaUnir2.get(i).dibujarse(g2d);
                    }
                    pelotaPrin.dibujarse(g2d);
                    enemigoPerseguidor.dibujarse(g2d);
                    listEnemigos.get(0).dibujarse(g2d);
                    listEnemigos.get(1).dibujarse(g2d);
                    
                } else {
                	//Dibuja el mensaje que le adjudicaron en verificarJuego
                		if(setGanado==true) {
                			mensaje.dibujar(this.g2d);
                		}else{
                			mensaje.dibujar(this.g2d);
                		}
                	}
            }
    
	 private void limpiarPantalla() {
			// TODO Auto-generated method stub
	    	this.g2d.setColor(new Color(0, 170, 228));
	        this.g2d.fillRect(0, 0, anchoTablero, altoTablero);
		}
	

	private void crearEnemigo(int i) {
			for(int e=0 ; e<=i; e++) {
				EnemigoAleatorio x=new EnemigoAleatorio(6, 6, 0, 0, largoE, anchoE, Color.gray);
				this.listEnemigos.add(x);
			}
	}
	
	@Override
	public Dimension getPreferredSize() {
	     return new Dimension(anchoTablero, altoTablero);
	}
	
	@Override
	public void run() {
	        while (juegoCorriendo==true) {
	            iniciarJuego();
	            this.repaint();
	            try {
	                Thread.sleep(5);
	            } catch (Exception e1) {
	                throw new RuntimeException(e1);
	            }
	        }
	}
		
	private void iniciarJuego() {
	        verificarEstadoAmbiente();
	        pelotaPrin.moversePrueba(0);
	        enemigoPerseguidor.moversePrueba(0);
	        listEnemigos.get(0).moversePrueba(1);
	        listEnemigos.get(1).moversePrueba(2);
    }
	
	private void verificarEstadoAmbiente() {
	        verificarCoalisiones();
	        verificarEmparejamiento();
	        verificarUnionFiguras();
	        verificarFinDeJuego();
    }
	
	private void verificarCoalisiones() {
			// VERIFICA COLISION ENTRE E.PRINCIPAL Y PERSEGUIDOR...
			colision=pelotaPrin.hayColision(enemigoPerseguidor);
			if(colision==true) {
					usuario.setVidas();
					if(usuario.getPuntos()>=5) {
						usuario.setVidas();
					}
			}
			// VERIFICA COLISION ENTRE E.PRINCIPAL Y OTROS ENEMIGOS...
			for(ElementoBase e: listEnemigos) {
					colision=pelotaPrin.hayColision(e);
					if(colision==true) {
						usuario.setVidas();
						colision=false;
					}
			}	
	}
	
	private void verificarEmparejamiento() {
			for(Figuras e2:listaUnir2) {
				if(e2.getfiguraUnida()==false) {
					// VERIFICA EMPALME DE E.PRINCIPAL CON FIGURAS A UNIR...
					empalmeCirculos=pelotaPrin.empalmeCirculos(e2);
					if(empalmeCirculos.equalsIgnoreCase("izq")) {
						e2.empujadoX(-1);
					}else if(empalmeCirculos.equalsIgnoreCase("derecha")) {
						e2.empujadoX(1);
					}else if(empalmeCirculos.equalsIgnoreCase("arriba")) {
						e2.empujadoY(1);
					}else if(empalmeCirculos.equalsIgnoreCase("abajo")) {
						e2.empujadoY(-1);
					}
				}
			}
	}
	
	private void verificarUnionFiguras() {
		// VERIFICA PUZLE...
			boolean union1=false;
				for(Figuras e:listaUnir2) {
					if(e.getfiguraUnida()==false) {
						for(Figuras eBase:listaUnirBase) {
							union1=e.comprobarUnion(eBase);
							 if(union1==true) {
								union1=false;
								e.unir(eBase);
								e.setfiguraUnida(true);
								e.setColor(new Color(255,213,0));
								usuario.setPuntos();
							 }
						}
				}
			}
	}

	private void verificarFinDeJuego() {
			if((usuario.getPuntos())==4) {
				mensaje.setMensaje("Oh excelente!!");
				pararJuego=true;
        		juegoCorriendo=false;
			}
			if((usuario.getVidas())==0) {
				mensaje.setMensaje("Chau Chau...");
				pararJuego=true;
        		juegoCorriendo=false;
			}
	}
	
	//EVENTOS TECLADO CON FLECHAS...
	@Override
    public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == 40) {
	            pelotaPrin.setVy(1);
		        enemigoPerseguidor.setVy(1);
	        }
        // si mantengo apretada la tecla 39
        if (arg0.getKeyCode() == 39) {
            pelotaPrin.setVx(1);
            enemigoPerseguidor.setVx(1);

        }
        if (arg0.getKeyCode() == 37) {
        	pelotaPrin.setVx(-1);
        	enemigoPerseguidor.setVx(-1);

        }
        if (arg0.getKeyCode() == 38) {
            pelotaPrin.setVy(-1);
            enemigoPerseguidor.setVy(-1);

        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    	if (arg0.getKeyCode() == 37|| arg0.getKeyCode() == 38|| arg0.getKeyCode() == 39|| arg0.getKeyCode() == 40) {
            pelotaPrin.setVy(0);
            pelotaPrin.setVx(0);

        }
    }

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
//	//FIGURA DECORATIVA...
//	public void dibujarFigDecorativo(Graphics2D g2d) {
//		// TODO Auto-generated method stub
//		// TODO Auto-generated method stub
//	 	g2d.setColor(Color.lightGray);
//	 	g2d.fillRoundRect(135, 120, anchoTablero-350, altoTablero-150, 100, 100 );
//	}
}
