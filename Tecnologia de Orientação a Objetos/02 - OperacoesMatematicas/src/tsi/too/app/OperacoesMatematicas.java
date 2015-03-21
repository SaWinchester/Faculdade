package tsi.too.app;

//	Importa todos os membros static da classe JOptinPane.
import static javax.swing.JOptionPane.*;

public class OperacoesMatematicas {

	public static void main(String[] args) {
		menu();
	}//	Fim do m�todo psvm()

	//	Exibe um menu de op��es, l�, valida e executar a op��o escolhida pelo usu�rio.
	public static void menu(){
		String opcao;
		
		menu: // Define um bloco associado ao loop do while() mais externo;
		do{
			/*
			 * Verifica e v�lida a op��o digitada pelo usu�rio. Evita que ele digite um String vazia (d� enter sem excrever uma op��o).
			 */
			do{
				opcao = showInputDialog(null, "1 - Exponencia��o\n2 - Raiz Quadrada\n3 - PI\n4 - N�mero "
						+ "E\n5 - Sair", "Opera��es Matem�ticas", QUESTION_MESSAGE);
				
				/*	Verifica se o bot�o verificar da caixa de saida foi precionado. Caso seja e o usu�rio n�o tenha digitado 
				 * 	nenhuma op��o, encerra o loop do while e encerra o programa.
				 * */
				if (opcao == null)	break menu; //	Encerra o bloco menu caso a op��o seja digitada inv�lida. 
				
				//	Verifica se o usu�rio digitou uma op��o.
				if(opcao.equals(""))
					exibirMensagemErro("Voc� deve escolher uma op��o.");
			}while(opcao.equals(""));
			
				//	Se a op��o � v�lida, executa a op��o selecionada.
				switch(opcao.charAt(0)){
					case '1': exponenciacao(); break;
					case '2': raizQuadrada(); break;
					case '3': exibirMensagem("Valor do n�mero PI = " + Math.PI, "N�mero PI"); break;
					case '4': exibirMensagem("Valor do n�mero E = " + Math.E, "N�mero E"); break;
					default: 
						if(opcao.charAt(0) != '5') exibirMensagemErro("Op��o Inv�lida.");
				}
				
		}while(opcao.charAt(0) != '5');
		
		System.exit(0);
	}//Menu()
	
	/*	O m�todo exibirMensagem recebe dois argumentos, a mensagem que ser� exibida e o t�tulo da janela
	 * 	que ser� exibida.
	 * */
	private static void exibirMensagem(String mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}
	
	
	public static void exponenciacao(){
		//	Define uma refer�ncia para um objeto Double.
		Double expoente;
		
		expoente = lerNumeroReal("Expoente: ", "Digite o valor para o c�lculo:");
		
		//Verifica se o expoente for diferente de null, calcula o valor, caso contr�rio n�o executa a opera��o.
		if(expoente != null)
			exibirMensagem(String.format("O resultado � = %1.6f", Math.exp(expoente)), "Expon�ncia��o");
	}
	
	/*
	 * 	L� e valida o n�mero real do usu�rio. Retorna null se o usu�rio cancelar a op��o.
	 * 	Os par�metros s�o:
	 * 		 
	 * Este m�todo utiliza o recurso AUTOBOXING e UNBOXING que foi introduzido a partir do Java 1.5.
	 * 
	 * Autoboxing: Converte automaticamente o valor de um tipo primitivo em objeto.
	 * 		Ex: Double numero = 0.5; // Double = double.
	 * 
	 * Unboxing: Converte automaticamente o valor de um objeto em um tipo primitivo.
	 * 		Ex: double n = numero; //Tipo primitivo para um objeto. (double = Double)
	 */
	private static Double lerNumeroReal(String mensagem, String titulo) {
		
		//	Cria uma refer�ncia para um objeto do tipo Double e inicia com null (que � uma refe�ncia inv�lida).
		Double numero = null;
		String valor;
		
		// Exibe uma caixa e l� o n�mero real e retorna para o local de retorno. 
		do{
			valor = showInputDialog(null, mensagem, titulo, QUESTION_MESSAGE); 
			
			//	Retorna null caso o usu�rio n�o digite nada.
			if(valor == null) return numero;
			
			//	Exibe uma mensagem de erro caso o usu�rio n�o digitar um n�mero.
			if(valor.equals(""))
				exibirMensagemErro("Voc� deve digitar um n�mero.");
			
		}while(valor.equals(""));
		
		//	Converte a String lida para Double.
		return Double.parseDouble(valor);
	}

	public static void raizQuadrada(){
		//	Define uma refer�ncia para um objeto Double.
		Double raizQuadrada;
		
		raizQuadrada = lerNumeroReal("N�mero real: ", "Digite o valor para o c�lculo:");
		
		//Verifica se o expoente for diferente de null, calcula o valor, caso contr�rio n�o executa a opera��o.
		if(raizQuadrada != null)
			if(raizQuadrada > 0)
				exibirMensagem(String.format("O resultado � = %1.2f", Math.sqrt(raizQuadrada)), "Raiz Quadrada: ");
			else
				exibirMensagemErro("Voc� deve digitar um n�mero positivo.");
	}
	
	
	public static void exibirMensagemErro(String mensagem){
		showMessageDialog(null, mensagem, "Erro", ERROR_MESSAGE);
	}
}//OperacoesMatematicas
