package puzleGame;

import javax.swing.JFrame;

public class Arranque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana=new Marco();

		ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
     
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

