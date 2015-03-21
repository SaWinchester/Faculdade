package tsi.too.tipo;

public class Forma2D extends Forma {
	//Dimens�es b�sicas de todas as fomas geom�tricas de 2 dimens�es.
	protected int largura, comprimento;

	public Forma2D() {
		//Chamada impl�cita ao contrutor default da superclasse Forma.
		nome = "Forma Bidimensional";
	}//	public Forma2D()

	public Forma2D(String nome) {
		/*
		 * Chama o construtor sobrecarregado da superclasse Forma. A primeira instru��o
		 * sempre deve ser a chamada do construtor da superclasse.
		 */
		super(nome);
	}//	public Forma2D(String nome)
	
	//Construtor sobrecarregado da subclasse Forma2D.
	public Forma2D(int largura, int comprimento) {
		this("Forma Bidimensional");
		setComprimento(comprimento);
		setLargura(largura);
	}
	
	//Construtor sobrecarregado da subclasse Forma2D.
	public Forma2D(String nome, int largura, int comprimento) {
		super(nome);
		setLargura(largura);
		setComprimento(comprimento);
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		if(largura >= 0) this.largura = largura;
		else	this.largura = 0;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		if(comprimento >= 0) this.comprimento = comprimento;
		else this.comprimento = 0;
	}

	@Override
	public String toString() {
		//Chama o m�todo toString da superclasse Forma para obter a representa��o string da mesma.
		return super.toString() + ", Largura: " + largura + ", Comprimento: " + comprimento;
	}
	
}// class Forma2D extends Forma 
