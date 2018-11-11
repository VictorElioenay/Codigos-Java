
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manarquivo {
	
	private static int[][] matrizAdj = null;
	
	public static int[][] lerArquivo( String caminho ) throws IOException {
		
		ArrayList<Integer> vetor = new ArrayList<Integer>();
		String valor = new String();
		BufferedReader leitor = null;
		
		try {
			leitor = new BufferedReader( new FileReader(caminho) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		leitor.mark(1);
		while( leitor.ready() ) {
			
			char letra = (char)leitor.read();
			if( (letra) != ' ' ) {
				if( letra != '\n' && (int)letra != 13 )
					valor += letra;
				else {
					if( !valor.equals("") ) vetor.add(Integer.parseInt(valor));
					matrizAdj = new int[vetor.size()][vetor.size()];
					valor = "";
					break;
				}
			} else {
				if( !valor.equals("") ) vetor.add(Integer.parseInt(valor));
				valor = "";
			}
		}
		leitor.reset();
		
		for( int i = 0, j = 0; leitor.ready(); ) {
			
			char letra = (char)leitor.read();
			
			if( (letra) != ' ' ) {
				if( letra != '\n' ) {
					if( (int)letra != 13 ) valor += letra;
				}
				else {
					if( !valor.equals("") ) matrizAdj[i][j] = Integer.parseInt(valor);
					i++; j = 0; 
					valor = "";
				} 
			} else {
				if( !valor.equals("") ) matrizAdj[i][j] = Integer.parseInt(valor);
				valor = "";
				j++;
			}
			if( !leitor.ready() ) if( !valor.equals("") ) matrizAdj[i][j] = Integer.parseInt(valor);
		}
		
		leitor.close();
		return matrizAdj;
	}
}
