import java.io.IOException;

public class Dijkstra {
	
    public static void main(String args[]) throws IOException{
    	
    	int[][] matrizAdj = {
    						{0,2,10,0},
    						{2,0,5,3},
    						{10,5,0,1},
    						{0,3,1,0}
    					 };
    	int[] peso = new int[matrizAdj.length];
    	int[] precursor = new int[matrizAdj.length];
    	
    	for( int k = 0; k < matrizAdj.length; k++ ) {
    		
	    	for( int i = 0; i < matrizAdj.length; i++ ) {
	    		precursor[i] = -1;
	    		peso[i] = (int) Float.POSITIVE_INFINITY;
	    	}
	    	
	    	peso[k] = 0; //Nó de origem
	    	while(true) {
	    	
	    		int i = minimo(peso);
	    		if( i == -1 ) break;
	    		
	    		for( int j = 0; j < matrizAdj.length; j++ ) {
	    			
	    			if( matrizAdj[i][j] != 0 ) {
	    				
	    				if( (peso[i] + matrizAdj[i][j]) < peso[j] ) {
	    					peso[j] = peso[i] + matrizAdj[i][j];
	    					precursor[j] = i;
	    				}
	    			}
	    		}
	    		peso[i] = -1;
	    	}
	    	
	    	for( int i = 0; i < precursor.length; i++ )
	    		System.out.print(precursor[i] + " ");    
	    	System.out.print("\n");
    	}
    }
    
    public static int minimo(int[] vetor) {
    	
    	for( int i = 0, min = -1, index = -1; i < vetor.length; i++ ){
    		
    		if( vetor[i] != -1 ){
    			
    			min = vetor[i];
    			index = i;
    			
    			for( i = 0; i < vetor.length; i++ ) {
 
    	    		if( min > vetor[i] && vetor[i] != -1 ) {
    	    			min = vetor[i];
    	    			index = i;
    	    		}
    	    	}
    			return index;
    		}
    	}
    	return -1;
    }
}