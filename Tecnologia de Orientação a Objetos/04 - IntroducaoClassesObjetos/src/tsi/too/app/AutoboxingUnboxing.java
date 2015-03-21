package tsi.too.app;

public class AutoboxingUnboxing {

	public static void main(String[] args) {
		//	Cria e inicia o objeto Intenger.
		Integer numero = new Integer(27),
		
		/*
		 * 		Usa o recurso autoboxing introduzido a partir do java 1.5 para iniciar um valor a  objeto
		 * 		utilizando um tipo primitivo.
		 */
		num = 15; //Equivale a num = new Intenger(15).
		
		// Cria uma vari�vel do tipo primitivo int e a inicia com o valor do objeto Intenger. (Unboxing)
		int number = numero; // Equivale a: number = numero.intValue()
				
		//	Exibe o valor do objeto n�mero utilizando uma chamada implicita ao m�todo toString.
		System.out.println("N�mero: " + numero);
		
		//	Exibe o valor do objeto n�mero utiliznado o m�todo intValue() que retorna o valor armazenado.
		System.out.println("N�mero: " + numero.intValue());
		
		// 	Exibe o valor atribuido atrav�s do recurso unboxing da vari�vel do tipo primitivo int number.
		System.out.printf("N�mero: %d\n", number);
		
		System.out.println("N�mero: " + num);

		/*
		 * 		Usar o unboxing para obter os n�meros inteiros e realizar a soma, depois utiliza o autoboxing
		 * 		para armazenar a soma.
		 */
		num = num+numero;
		System.out.printf("\nSoma: %d", num);
	}

}
