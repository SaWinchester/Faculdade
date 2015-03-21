package tsi.too.app;

import static javax.swing.JOptionPane.*;

/*
 * Este programa executa a soma de v�rios n�meros reais. Os par�metros a serem usados na
 * linha de comando do sistema operacional s�o:
 * 
 * Sintaxe: soma <N1> <N2> . . . <Nn> [/h | /?] [/g]
 * 
 * Onde:
 * 
 * 		<N1> <N2> . . . <Nn> = representa os n�meros a serem somados;
 *  	/h ou /? = apresenta um texto de ajuda do programa. 
 *  	/g = exibe o resultado da soma ou o texto de ajuda (se /h ou /? for usado) em uma interface gr�fica.
 *  
 *  Nota��o: 
 *  
 *  	<> = valores a serem substitu�dos pelos par�metros;
 *  	[ ] = indica o uso opcional de par�metro;
 *  	| = este s�mbolo representa uma escolha, ou exclusivo, ou usa a op��o /h ou /?.
 *  
 *  Exemplos em Java:
 *  	c:\> java -jar soma.jar /h
 *   	c:\> java -jar soma.jar 2 3 /g      
 *  	c:\> java -jar soma.jar 9.92 3.75 1578
 */
public class Soma {
	private static double numeros[]; // N�meros a serem somados.
	private static boolean ajuda, // Se true exibe a tela de ajuda; false n�o.
	 							  gui; // Se true exibe o resultado na GUI; false exibe no console. 

	// Inicia o aplicativo Java.
	public static void main(String[] args) {
		final String MSG_ERRO = "Voc� deve digitar pelo menos 2 n�meros a serem " +
			      "somados ou /h para obter a ajuda.";
		int numeroOpcoes = 0;

		// Verifica se o usu�rio forneceu algum argumento para o programa.
		if (args.length > 0) {
			/* 
			 * Percorre o vetor args verificando quais as op��es (/h, /? e /g) que foram passadas 
			 * como argumento para o programa. 
			 */
			for (String argumento : args) 
			{
				switch (argumento.toLowerCase()) {
				// /h = exibe tela de ajuda.
				case "/h": 
				case "/?":	ajuda = true;
				numeroOpcoes++;
				break;

				// /g = exibe o resultado via GUI.
				case "/g":  gui = true;
				numeroOpcoes++;
				break;
				} // switch
			} // for

			/*
			 *  A quantidade de n�meros � igual a quantidade total de argumentos passados para 
			 *  o programa menos o total de op��es  (/h, /? e /g).
			 */
			int quantidadeNumeros = args.length - numeroOpcoes;

			/*
			 * Verifica se dentre os argumentos passados para o programa existe uma quantidade
			 * de "valores num�ricos" suficientes para realizar a soma.
			 */
			if (quantidadeNumeros > 1) 
			{
				// Cria o array para receber os n�meros passados como argumento. 
				numeros = new double[quantidadeNumeros];

				// Obt�m os n�meros do array args e converte para valores num�ricos reais (double).
				for (int indice = 0; indice< quantidadeNumeros; indice++) 
					numeros[indice] = Double.parseDouble(args[indice]);

				// Exibe o resultado.
				exibirResultado();
			}
			else
				// Usu�rio passou um argumento, portanto verifica se � /h. 
				if (ajuda) 
				{
					// Verifica se a sa�da � no console ou GUI.
					if (gui)
						showMessageDialog(null, obterAjuda(), "Soma", INFORMATION_MESSAGE);
					else
						System.out.println(obterAjuda());
				}
				else 
				{
					System.out.println(MSG_ERRO);
					showMessageDialog(null, MSG_ERRO, "Soma", INFORMATION_MESSAGE);
				}
		} // if (args.length > 0) 
		else 
		{
			System.out.println(MSG_ERRO);
			showMessageDialog(null, MSG_ERRO, "Soma", INFORMATION_MESSAGE);
		}

		// Finaliza o aplicativo Java GUI corretamente.
		System.exit(0);
	} // main()
	
	// Calcula a soma dos n�meros armazenados no array numeros.
	private static double soma() {
		double sum = 0;
		
		// Calcula a soma dos n�meros do array.
		for (double numero : numeros)
			sum += numero;

		return sum;
	} // soma()

	// Exibe o resultado no console ou GUI segundo o valor definido para gui.
	private static void exibirResultado() {
		String resultado;
		
		// Constr�i o resultado para exibi��o no console ou GUI.
		resultado = "A soma = " + soma();
		
		if (ajuda)
			resultado += obterAjuda();
				
		// Exibe a sa�da na GUI.
		if (gui)
			showMessageDialog(null, resultado, "Soma", INFORMATION_MESSAGE);
		else
			// Exibe a sa�da no console.
			System.out.println(resultado); 
	} // exibirResultado()

	// Exibe um texto de ajuda do programa.
	private static String obterAjuda() {
		return "\nEste programa executa a soma de v�rios n�meros reais.\n" + 
				"\nSintaxe: soma <N1> <N2> . . . <Nn> [/h | /?] [/g]\n" + 
				"\nPar�metros:\n"+
				"  <N1> <N2> . . . <Nn> = representa os n�meros a serem somados\n" +
				"  /h ou /? = apresenta um texto de ajuda do programa.\n" + 
				"  /g = exibe o resultado da soma ou o texto de ajuda (se /h ou /? for usado) em uma "
				+ "interface gr�fica.\n" +
				"\nExemplos em Java:\n" +
				"  c:\\> java -jar soma.jar /h\n" +
				"  c:\\> java -jar soma.jar 2 3 /g\n" +      
				"  c:\\> java -jar soma.jar 9.92 3.75 1578\n\n"; 
	}
} // class Soma
