package tsi.too.tipo;

/**
 * Classe base para representar as formas geom�tricas.
 * 
 * @author Wagner
 * @version 0.1
 */

public abstract class Forma {
	/**
	 * Nome da forma geom�trica.
	 */
	protected String nome;
	
	/**
	 * Define o nome da forma geom�trica.
	 */
	public Forma() {
		nome = "Forma";
	}
	
	/**
	 * Define o nome para a forma geom�trica.
	 * @param nome <code>String</code> com o nome da Forma Geom�trica.
 	 */
	
	public Forma(String nome) {
		setNome(nome);
	}
	
	/**
	 * Obt�m o nome da forma geom�trica.
	 * @return um <code>String</code> com o nome da forma geom�trica.
	 */
	
	/*
	 * Um m�todo final n�o pode ser sobrescrito, ou seja, a subclasse n�o pode fornecer uma nova
	 * implementa��o para um m�todo final definido na superclasse.
	 */
	public final String getNome() {
		return nome;
	}
	
	/**
	 * Define o nome de forma geom�trica.
	 * 
	 * @param nome <code> String </code> com o nome da forma geom�trica.
	 */
	public final void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Obt�m uma representa��o <code> String </code> do objeto <code> Forma</code>
	 * @return <code>String</code> com o nome da forma geom�trica.
	 */
	@Override
	public String toString() {
		return "Nome: " + nome;
	}
	
	/**
	 *	Exibe uma mensagem <i>Console</i> quando um objeto � removido da mem�ria. 
	 */
	@Override
	protected void finalize() {
		System.err.println("Objeto Forma removido da mem�ria.");
	}

	/**
	 * Calcula � �rea de uma forma geom�trica.
	 * 
	 *  @return um <code> float </code> com o valor da �rea de um objeto <code>Forma</code>.
	 */
	public abstract float area();
	
	/**
	 * Calcula o volume de uma forma geom�trica.
	 * 
	 *  @return um <code> float </code> com o volume de um objeto <code>Forma</code>.
	 */
	public abstract float volume();
	
	/**
	 * Desenha uma forma geom�trica.
	 */
	public abstract void desenhar();	
}//class Forma
