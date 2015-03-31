package tsi.too.app;

import tsi.too.tipo.Circulo;
import tsi.too.tipo.Forma;
import tsi.too.tipo.Retangulo;
import tsi.too.tipo.Triangulo;

import static javax.swing.JOptionPane.*;

/**
 * Est� classe � respons�vel por iniciar o aplicativo Java GUI Forma Geom�trica.
 * @author Wagner
 * @version 0.1
 */
public class FormaApp {

	/**
	 * Inicia o aplicativo Java GUI.
	 * @param args um <i>array</i> de objetos da classe <code>String</code>. Este
	 * programa n�o utiliza par�metros.
	 */
	public static void main(String[] args) {
		
		/*
		 * � fundamental usar a refer�ncia de uma superclasse de uma hierarquia de
		 * classe para acessar os servi�os(m�todos) das subclasses, desde que a superclasse 
		 * tenha a defini��o destes m�todos ou a declara��o desses servi�os como m�todos
		 * abstratos. Esta t�cnica possibilita o polimorfismo usar a refer�ncia da superclasse
		 * para polimorficamente invocar os m�todos das subclasses.
		 * 
		 * 		Erro: Forma formas = new Forma(); //Porque a classe forma � abstrata.
		 */
		
		/*
		 * A vari�vel formas � um array de refer�ncias para a classe abstrata forma. Ele �
		 * iniciado com a cria��o de 3 objetos das classes concretas Retangulo, Circulo e 
		 * Tri�ngulo.
		 */
		Forma formas[] = {new Retangulo(2,8), new Circulo(0, 5), new Triangulo(7.5f, 3.5f)};
		String resultado = "";
		
		/*
		 * Obt�m os atributos e o valor da �rea de cada objeto das subclasses de Forma2D de
		 * modo polimorfico, ou seja, usando a refer�ncia da superclasse abstrata forma.
		 */
		for(Forma forma : formas)
			resultado += forma.toString() + "\n" + String.format("Area: %.4f\n\n", forma.area());
		showMessageDialog(null, resultado, "Polimorfismo", INFORMATION_MESSAGE);
		
		//Finalizar o aplicativo Java GUI.
		System.exit(0);
	}	//static void main(String[] args)

}//class FormaApp
