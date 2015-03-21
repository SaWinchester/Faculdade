package tsi.too.app;

import tsi.too.tipo.Produto;

public class ProdutoApp {
	public static void main(String[] args){
		Produto perfume, //Refer�ncia para um objeto da classe Produto.
					 //Cria objetos da classe Produto e inicia as refer�ncias dos objetos.
					 sabonete = new Produto("Sabonete"),
					 arroz = new Produto("Arroz", 2),
					 feijao = new Produto("Feij�o", 4, 9.5f);
		
		/*
		 * 		sabonete.quantidade = 10  // Erro, n�o � poss�vel fazer isso, pois a vari�vel de inst�ncia do Objeto sabonete da classe Produto � 
		 * 													  privado, isso faz com que seja poss�vel modificar seus valores somente pelos m�todos set. 
		 */
		sabonete.setQuantidade(10);
		sabonete.setPreco(1.5f);
		arroz.setPreco(5.8f);
		
		//	Cria e inicia o objeto produto.
		perfume = new Produto("", 2, 95f);
		
		//	Exibe as informa��es do objeto sabonete, utilizando os m�todos get.
		System.out.printf("Nome %s\nQuantidade: %d\nPre�o: R$ %1.2f\n\n", sabonete.getNome(),
																													  sabonete.getQuantidade(),
																													  sabonete.getPreco());
		
		//	Exibe as informa��es do objeto feij�o, utilizando o m�todo toString.
		System.out.printf(feijao.toString());
		
		System.out.println(arroz);
		
		System.out.println(perfume);
	}//main()
}//ProdutoApp
