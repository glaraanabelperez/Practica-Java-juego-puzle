package puzleGame;

public class MetodosGenerales {
	
	  public static boolean hayColision(
	            int elemento1PosicionX, int elemento1PosicionY, int elemento1Ancho, int elemento1Largo,
	            int elemento2PosicionX, int elemento2PosicionY, int elemento2Ancho, int elemento2Largo) {
	        if (
	            haySolapamientoDeRango(
	                elemento1PosicionX,
	                elemento1PosicionX+elemento1Ancho,
	                elemento2PosicionX,
	                elemento2PosicionX+elemento2Ancho)
	            &&     
	            haySolapamientoDeRango(
	                elemento1PosicionY,
	                elemento1PosicionY+elemento1Largo,
	                elemento2PosicionY,
	                elemento2PosicionY+elemento2Largo)) {
	            return true;
	        }
	        return false;
	    }
	    
	    private static boolean haySolapamientoDeRango(int a, int b, int c, int d) {
	        if (a < d && b > c  ) {
	            return true;
	        }
	        return false;
	    }
	    
	    //VERIFICA EMPAREJAMIENTO IZQ, DER, ARRIBA, ABAJO;
	    public static String emparejamientoCirculos( int e1PosX, int e1PosY, int e1Ancho, int e1Largo,
	            int e2PosX, int e2PosY, int e2Ancho, int e2Largo) {
	    	if(
	    			e1PosX+(e1Ancho)==e2PosX+(e2Ancho)
	    			&&
	    			e1PosY>=e2PosY
	    			&&
	    			e1PosY+(e1Largo)<=e2PosY+(e2Largo/2)
	    			) {
	    		return "izq";
	    	}else if(
	    			e1PosX-(e1Ancho*2)==e2PosX-(e2Ancho/2)
	    			&&
	    			e1PosY>=e2PosY
	    			&&
	    			e1PosY+(e1Largo*2+1)<=e2PosY+(e2Largo/2+10)
	    			) {
	    		return "derecha";
	    	}else if(
	    			e1PosY+(e1Largo*2)==e2PosY
	    			&& 
	    			e1PosX>=e2PosX
	    			&&
	    			e1PosX+(e1PosX+e1Ancho)<=e2PosX+(e2PosX+e2Ancho)
	    			) {
	    		return "arriba";
	    	}else if(
	    			e1PosY-(e1Largo*2)==e2PosY+(e2Ancho/4)
	    			&&
	    			e1PosX>=e2PosX
	    			&&
	    			e1PosX+(e1PosX+e1Ancho)<=e2PosX+(e2PosX+e2Ancho)
	    			) {
	    		return "abajo";
	    	}else {
		    	return "no";
	    	}
	    }

		public static boolean comprobarUnion( int e1PosX, int e1PosY, int e1Ancho, int e1Largo,
	            int e2PosX, int e2PosY, int e2Ancho, int e2Largo) {
			if(
					e1PosX<=e2PosX 
					&&
					e1PosX+(e1PosX + e1Largo)<=e2PosX+(e2PosX + e2Largo)
					&&
					e1PosY>=e2PosY 
					&&
					e1PosY+(e1PosY + (5))>=e2PosY-(e2PosY + (5))) {
				
	    		return true;
	    		
	    	}else {
	    		return false;
	    	}
		}
	    
	    
	    
}

