package tsi.too.tipo;

public abstract class Forma {
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

	/*
	 * Os m�todos abstratos devem ser implementados nas subclasses. Se um m�todo abstrato
	 * n�o � implementado em uma subclasse, essa deve ser declarada como abstrata.
	 */
	public abstract float area();
	public abstract float volume();
	public abstract void desenhar();	
}//class Forma
