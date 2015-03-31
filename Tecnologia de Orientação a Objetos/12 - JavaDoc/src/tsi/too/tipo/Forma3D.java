package tsi.too.tipo;

public abstract class Forma3D extends Forma2D {
	/*
	 * Dimens�es b�sicas de todas as fomas geom�tricas de 2 dimens�es.
	 * y = altura
	 * x = base
	 * z = profundidade.
	 */
	/*
	 * Dimens�es b�sicas de todas as fomas geom�tricas de 3 dimens�es.
	 * As dimens�es largura e comprimento s�o herdadas da superclasse Forma2D.
	 */
	protected float z; //Profundidade
	
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

	public Forma3D(float largura, float comprimento, float z) {
		super("Forma Tridimensional", largura, comprimento);
		setZ(z);
	}

	public Forma3D(String nome, float altura, float base, float profundidade) {
		super(nome, altura, base);
		setZ(profundidade);
	}

	public float getAltura() {
		return z;
	}

	public void setZ(float z) {
		if(z > 0) this.z = z;
		else this.z = 0;
	}
	
	@Override
	public String toString() {
		//Chama o m�todo toString da superclasse Forma para obter a representa��o string da mesma.
		return super.toString() + ", Profundidade: " + z;
	}

	@Override
	protected void finalize() {
		System.err.printf("Objeto forma2D %s removido da mem�ria.", nome);
		super.finalize();
	}
	
}// class Forma3D extends Forma
