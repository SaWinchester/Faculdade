package tsi.too.tipo;

/*
 * Toda classe que implementa uma interface deve implementar todos os m�todos abstratos da interface.
 * Se a classe for abstrata, as subclasses desta classe abstrata devem implementar estes m�todos.
 * Toda classe que implementa uma inteface possui o relacionamento "� um" com a interface.
 */
public abstract class Forma implements OperacaoForma {
	protected String nome;

	public Forma() {
		nome = "Forma";
	}

	public Forma(String nome) {
		setNome(nome);
	}
	
	/*
	 * Um m�todo final n�o pode ser sobrescrito, ou seja, a subclasse n�o pode fornecer uma nova
	 * implementa��o para um m�todo final definido na superclasse.
	 */
	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}
	
	/*
	 * A implementa��o abaixo do m�todo toString representa uma sobreposi��o (override) do m�todo toString 
	 * definido na superclasse (Object) mas adaptado a necessidade da subclasse (implementa��o diferente).
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nome: " + nome;
	}
	
	@Override
	protected void finalize() {
		System.err.println("Objeto Forma removido da mem�ria.");
	}
}//class Forma
