package tsi.too.app;

public class VetorApp {

	public static void main(String[] args) {
		
		/*
		 * 		Define dois arrays de String.
		 * 		O primeiro array � inicializado com Strings literais (Em java, string literal � um objeto do tipo String.).
		 * 		O segundo array � iniciado com 3 strings.
		 * 		Todo array em java � um objeto.
		 */
		String[] vogais = {"A","E","I","O","U"},
					trimestre = {"Janeiro", "Fevereiro","Mar�o"};
		
		int numero[], //Define uma refer�ncia para um array de n�meros inteiros.
			 n1;	//Vari�vel do tipo inteiro.
		
		//Cria um array de 10 n�meros inteiros.
		numero = new int[10];
		
		/*
		 * 		Preenche um vetor de inteiros. Todo array em java � uma refer�ncia para um objeto, portanto 
		 * 		possuem alguns m�todos predefinidos. No exemplo abaixo � usado o m�todo lenght que retorna
		 * 		o n�mero de elemento do array. 
		 */
		for(int indice = 0; indice < numero.length; indice++)
			 numero[indice] = indice + 1;
				
		//Imprime o conte�do do array n�meros
		printArray(numero);
		
		//Imprime o conte�do do array digitos.
		printArray(trimestre);
		
		//Modifica um elemento do array numeros.
		replace(numero, 0, 23);
		
		printArray(numero);
		
		//	Modifica todos os elementos do array de String  trimestre.
		replace(trimestre, "Alface");
		
		printArray(trimestre);
	}//main

	//Exibe o conte�do de um array de inteiros.
	private static void printArray(int[] array){		
		/*
		 * 		Usa o loop for aprimorado (introduzino no Java 1.5) para exiibir todos os elementos do array.
		 *		
		 *		Usando o loop for tradicional seria:
		 *			
		 *			for(int indice = 0; indice < array.lenght; indice++)
		 *				System.out.printf("%d",array[indice]);	
		 */		
		for(int numero : array)
			System.out.printf("%d", numero);
		System.out.println();
	}
	
	//Exibe o conte�do de um array de Strings.
	private static void printArray(String[] array){	
		//	Usa o loop for aprimorado (introduzino no Java 1.5) para exiibir todos os elementos do array.
		for(String digitos : array)
			System.out.printf("%s",digitos);
		System.out.println();
	}
	
	//	Substitui o elemento do array na posi��o especificada pelo par�metro indice, com o par�metro novo.
	private static void replace(int[] array, int indice, int novoElemento){
		//	Verifica se o indice passado por par�metro � v�lido, caso seja, substitui o elemento da posi��o especificada pelo novo.
		if(indice >= 0 && indice < array.length) 
			array[indice] = novoElemento;		
	}
	
	//	Substitui todas as Strings pela nova String.
	private static void replace(String[] array, String novaString){
			for(int indice = 0; indice < array.length; indice++)
				array[indice] = novaString;
	}
}//class ArrayApp
