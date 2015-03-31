package tsi.too.app;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showInternalMessageDialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tsi.too.gui.Janela;
import tsi.too.tipo.Circulo;
import tsi.too.tipo.Forma;
import tsi.too.tipo.OperacaoForma;

public class FormaApp {
	private Janela janela;
	private Forma forma = new Circulo();
	
	//Cria e exibe a inteface gr�fica do aplicativo.
	public FormaApp() {
		janela = new Janela();
		adicionarForma();
	}

	public static void main(String[] args) {
		new FormaApp();
	}//public static void main(String[] args)
	
	/*
	 * Este m�todo adiciona um bot�o na janela do aplicativo para cada forma geom�trica
	 * localizada no pacote tsi.too.tipo.
	 */
	private void adicionarForma() {
		
		//Idenfica os nomes das formas geom�tricas.
		String formas[] = {"C�rculo", "Ret�ngulo", "Tri�ngulo"};
		
		//Cria um array de objetos da classe javax.swing.JButton
		JButton botoes[] = new JButton[formas.length];
		
		/*
		 * Define o gerenciador de layout a ser usado na janela do aplicativo. O gerenciador
		 * de layout � usado para definir a organiza��o dos componentes na interface gr�fica
		 * do programa. O java.awt.FlowLayout organiza os componentes como uma linha de
		 * texto, ou seja, os componentes s�o colocados no container da janela da esquerda para
		 * direita.
		 */
		janela.setLayout(new FlowLayout());
		
		/*
		 * Cria os bot�es e adiciona-os ao painel de conte�do da Janela.
		 * 		(Cont�iner - java.awt.Container)
		 * Registra o tratador de evento para cada bot�o criado.
		 */
		for(int indice = 0; indice < botoes.length; indice++){
			botoes[indice] = new JButton(formas[indice]);
			janela.add(botoes[indice]);
			/*
			 * Define quem � o objeto respons�vel por tratar os eventos de cada bot�o da janela 
			 * usando um objeto da classe interna an�nima. A cria��o da classe interna an�nima 
			 * abaixo equivale a:
			 * 
			 * 		private class <ClasseInterna> implements ActionListener{
			 * 			
			 * 			public void actionPerformed(ActionEvent arg0) {
			 *		
			 *			}
			 * 		}//class <ClasseInterna> implements ActionListener
			 * 
			 * Objeto a ser passado para o m�todo addActionListener � o objeto de uma classe que
			 * implementa a interface ActionListener, portanto � um objeto da classe interna que 
			 * implementa ActionListener.
			 */
			botoes[indice].addActionListener(
					new ActionListener() {//Inicio do corpo da classe interna an�nima.
						
					/*
					 * Exibe uma caixa de di�logo para ler as dimens�es da forma geom�trica e em seguida
					 * desenha a forma usando os valores das dimens�es fornecidos pelo usu�rio.
					 */
					public void actionPerformed(ActionEvent event) {

						// Verifica se forma � uma inst�ncia de um objeto Forma. 
						if(forma instanceof Forma)
							//if(forma.lerDimensoes()) forma.desenhar();
							showInternalMessageDialog(janela.getContentPane(),"Este forma geom�trica � " + event.getActionCommand(), 
																		  OperacaoForma.FORMA_GEOMETRICA, ERROR_MESSAGE);
						else
								showInternalMessageDialog(janela.getContentPane(),"Este objeto n�o � uma forma geom�trica", 
																			OperacaoForma.FORMA_GEOMETRICA, ERROR_MESSAGE);
					}//void actionPerformed(ActionEvent arg0) 
				}//Fim do corpo da classe interna an�nima
			);//Fim da chamada ao m�todo addActionListener
		}//For
	}
	
}//class FormaApp
