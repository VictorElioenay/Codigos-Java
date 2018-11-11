
public class BellmanFord {
	
	public static void main(String args[]) {
		
		int[][] matrizAdj = {
				{0,2,10,0},
				{2,0,5,3},
				{10,5,0,1},
				{0,3,1,0}
			 };
		int[] peso = new int[matrizAdj.length];
		int[] precursor = new int[matrizAdj.length];
		int flag;
		
		
		for( int k = 0; k < matrizAdj.length; k++ ) {
			
			for( int i = 0; i < matrizAdj.length; i++ ) {
				precursor[i] = -1;
				peso[i] = (int) Float.POSITIVE_INFINITY;
			}
			
			peso[k] = 0; // Nó de origem
			while( true ) {
				
				flag = 0;
				for( int i = 0; i < matrizAdj.length; i++ ) {
					
					if( peso[i] != (int) Float.POSITIVE_INFINITY ) {
					
						for( int j = 0; j < matrizAdj.length; j++ ) {
							
							if( matrizAdj[i][j] != 0 ) {
								
								if( matrizAdj[i][j] + peso[i] < peso[j] ) {
									peso[j] = matrizAdj[i][j] + peso[i];
									precursor[j] = i;
									flag = 1;
								}	
							}
						}
					}
				}
				if( flag == 0 ) break; 		
			}
			
			for( int i = 0; i < precursor.length; i++ )
	    		System.out.print(precursor[i] + " "); 
			System.out.print("\n");
		}
		
	}
}