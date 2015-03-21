package tsi.too.tipo;

public class Forma {
	protected String nome;

	public Forma() {
		nome = "Forma";
	}

	public Forma(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
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
		
}//class Forma
