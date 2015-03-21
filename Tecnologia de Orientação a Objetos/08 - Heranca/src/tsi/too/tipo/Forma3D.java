package tsi.too.tipo;

public class Forma3D extends Forma2D {
	/*
	 * Dimens�es b�sicas de todas as fomas geom�tricas de 3 dimens�es.
	 * As dimens�es largura e comprimento s�o herdadas da superclasse Forma2D.
	 */
	protected int altura;
	
	public Forma3D() {
		super("Forma Tridimensional");
	}
	
	public Forma3D(String nome) {
		/*
		 * Chama o construtor sobrecarregado da superclasse Forma2D. A primeira instru��o
		 * sempre deve ser a chamada do construtor da superclasse.
		 */
		super(nome);
	}

	public Forma3D(int largura, int comprimento, int altura) {
		super("Forma Tridimensional", largura, comprimento);
		setAltura(altura);
	}

	public Forma3D(String nome, int largura, int comprimento, int altura) {
		super(nome, largura, comprimento);
		setAltura(altura);
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		if(altura > 0) this.altura = altura;
		else this.altura = 0;
	}
	
	@Override
	public String toString() {
		//Chama o m�todo toString da superclasse Forma para obter a representa��o string da mesma.
		return super.toString() + ", Altura: " + altura;
	}
	
}// class Forma3D extends Forma
