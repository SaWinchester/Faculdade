package tsi.too.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import tsi.too.tipo.OperacaoForma;
import static javax.swing.JOptionPane.*;

public class Janela extends JFrame {

	//Constr�i e exibe uma janela JFrame
	public Janela() {
		//Define o texto da barra de t�tulo da janela.
		super(OperacaoForma.FORMA_GEOMETRICA);
		
		//Define o tamanho da janela em pixels.
		setSize(400, 200);
		
		//Posiciona a janela no centro da tela. 
		//setLocationRelativeTo(null);
		
		//Posiciona a janela de acordo com o sistema gerenciador de janelas do Sistema Operacional.
		setLocationByPlatform(true);
		
		/*
		 * Cria e Registra o tratador de eventos (Listener) da janela, ou seja, informa quem � o objeto 
		 * respons�vel por fornecer uma resposta aos eventos da janela.
		 */
		TrataEvento trataEvento = new TrataEvento();
		addWindowListener(trataEvento);
		
		//Exibe a janela
		setVisible(true);
	}
	
	/*
	 * Est� classe interna � respons�vel por fornecer os m�todos para tratar os enventos da classe 
	 * Janela. A classe TrataEvento utiliza a classe adaptadorta java.awt.event.WindowAdapter para 
	 * herdar as implementa��es defaeul da interface java.swf.event.WindowListener e sobrepor os 
	 * m�todos necess�rios para os eventos que ser�o herdados na janela. Se a classe TrataEvento
	 * usa-se a interface, ela teria que implementar todos os 7 m�todos definidos em WindowListener.
	 */
	private class TrataEvento extends WindowAdapter{
		
		@Override
		public void windowClosing(WindowEvent arg0) {
			System.exit(0);
		}//void windowClosing(WindowEvent arg0)

		@Override
		public void windowOpened(WindowEvent arg0) {
			/*
			 * Posiciona a caixa de di�logo em rela��o a janela principal do aplicativo (JFrame ou Janela).
			 * Para acessar a refer�ncia da classe externa dentro da classe interna � preciso usar a nota��o:
			 * 			<nome da classe externa>.this
			 * No exemplo abaixo, janela principal do aplicativo Janela (que � um JFrame) � refer�nciada usando
			 * esta nota��o:
			 * 			Janela.this
			 * 
			 * O m�todo getContentPane() obt�m o painel de conte�do (um objeto da classe java.awt.Container)
			 * da janela principal do aplicativo para informar quem essa � a janela ao qual o frame interno ir� 
			 * pertencer. O frame interno � usado nas vers�es do m�todo da classe JOptionPane do tipo 
			 * showInternalXXX.
			 */
			showInternalMessageDialog(Janela.this.getContentPane(), "Seja Bem Vindo ao Programa Formas Geom�tricas!!!", 
											OperacaoForma.FORMA_GEOMETRICA, INFORMATION_MESSAGE);
		}//void windowOpened(WindowEvent arg0)
		
	}//class TrataEvento extends WindowAdapter
	
}//class Janela extends JFrame 
