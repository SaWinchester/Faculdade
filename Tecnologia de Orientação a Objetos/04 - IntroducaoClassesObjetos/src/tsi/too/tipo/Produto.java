package tsi.too.tipo;

public class Produto {
	//	Vari�veis do Objeto ou vari�veis de inst�ncia porque o Objeto � uma inst�ncia.
	private String nome;
	private int quantidade;
	private float preco;
	
	//	Construtor default.
	public Produto() {	}
	
	//	Construtor sobrecarregado. Recebe como argumento o nome do produto.
	public Produto(String nome) {
		setNome(nome);
	}

	//	Construtor sobrecarregado. Recebe como argumentos nome e quantidade.
	public Produto(String nome, int quantidade) {
		setNome(nome);
		setQuantidade(quantidade);
	}
	
	//	Construtor sobrecarregado.	Recebe como argumentos nome, quantidade e pre�o.
	public Produto(String nome, int quantidade, float preco) {
		setNome(nome);
		setQuantidade(quantidade);
		setPreco(preco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	//	Retorna o objeto Produto em uma string literal.
	public String toString() {
		return "Nome: " + nome + 
				"\nQuantidade: " + quantidade
				+ "\nPreco: R$" + String.format("%1.2f\n", preco);
	}
	
	
}//Produto()
