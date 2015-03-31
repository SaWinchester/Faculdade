package tsi.too.tipo;

public abstract class Forma2D extends Forma {
	/*
	 * Dimens�es b�sicas de todas as fomas geom�tricas de 2 dimens�es.
	 * y = altura
	 * x = base
	 */
	protected float y, 	//Altura 
							  x;	//Base

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
	public Forma2D(float altura, float base) {
		this("Forma Bidimensional");
		setY(altura);
		setX(base);
	}
	
	//Construtor sobrecarregado da subclasse Forma2D.
	public Forma2D(String nome, float altura, float base) {
		super(nome);
		setY(altura);
		setX(base);
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		if(y >= 0) this.y = y;
		else	this.y = 0;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		if(x >= 0) this.x = x;
		else this.x = 0;
	}

	@Override
	public String toString() {
		//Chama o m�todo toString da superclasse Forma para obter a representa��o string da mesma.
		return super.toString() + ", y: " + y + ", x: " + x;
	}
	
	
	@Override
	protected void finalize() {
		System.err.printf("Objeto forma3D %s removido da mem�ria.", nome);
		super.finalize();
	}
	
}// class Forma2D extends Forma 
