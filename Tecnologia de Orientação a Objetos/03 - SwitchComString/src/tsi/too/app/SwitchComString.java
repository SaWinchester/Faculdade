package tsi.too.app;

import java.util.Scanner;

public class SwitchComString {

	public static void main(String[] args) {
		
		/*
		 * 		Cria uma ref�rencia para um objeto da classe java.util.Scanner para ler valores do teclado.
		 * 		O teclado � identificado pelo objeto padr�o de entrada de dados (System.in).
		 */
		Scanner teclado = new Scanner(System.in);
		
		/*
		 * 		A classe String � a �nica classe do java que pode ser usada para criar um objeto
		 * 		sem usar o operador de aloca��o din�mica new. Considerando o recurso autoboxing e
		 * 		unboxing, as classes empacotadoras (Double, Float, etc), a partir da vers�o 1.5 do Java, 
		 * 		tamb�m pode ser utilizado para esta. 
		 */
		String dia = "";
		
		do{	System.out.println("Palavra m�gica: ");
		
		//Valida a String fornecida pelo usu�rio.
		}while(dia.equalsIgnoreCase("fim"));
	}

}
