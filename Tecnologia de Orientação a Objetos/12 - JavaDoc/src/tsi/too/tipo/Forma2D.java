package tsi.too.tipo;

/**
 * Define uma forma geom�trica bidimensional (2D)
 * @author Wagner
 * @version 0.1
 * @since 0.1
 */
public abstract class Forma2D extends Forma {
	/**
	 * Coordenada x da forma geom�trica bidimensional (2D) (Horizontal_.
	 */
	protected float x;	//Base

	/**
	 * Coordenada y da forma geom�trica bidimensional (2D) (Vertical)
	 */
	protected float y;	//Altura
	
	/**
	 * Define o nome da forma geom�trica bidimensional.
	 */
	public Forma2D() {
		//Chamada impl�cita ao contrutor default da superclasse Forma.
		nome = "Forma Bidimensional";
	}//	public Forma2D()
	
	/**
	 * Define o nome da forma geom�trica bidimensional.
	 * 
	 * @param nome <code> String </code> com o nome da forma geom�trica.
	 */
	public Forma2D(String nome) {
		/*
		 * Chama o construtor sobrecarregado da superclasse Forma. A primeira instru��o
		 * sempre deve ser a chamada do construtor da superclasse.
		 */
		super(nome);
	}//	public Forma2D(String nome)
	
	/**
	 * Define um nome para a forma geom�trica bidimensicona com as coordenadas
	 * <code>y</code> e <code>x</code>.
	 * 
	 * @param altura coordenada vertical <code>y</code> da forma geom�trica bidimensional.
	 * @param base coordenada horizontal <code>x</code> da forma geom�trica bidimensional.
	 */
	public Forma2D(float altura, float base) {
		this("Forma Bidimensional");
		setY(altura);
		setX(base);
	}
	
	/**
	 * Define um <code>String</code> nome para a forma geom�trica bidimensicona com as coordenadas
	 * <code>y</code> e <code>x</code>.
	 * 
	 * @param nome <code>String</code> nome para a forma geom�trica bidimensional.
	 * @param altura coordenada vertical <code>y</code> da forma geom�trica bidimensional.
	 * @param  base coordenada horizontal <code>x</code> da forma geom�trica bidimensional.
	 */
	public Forma2D(String nome, float altura, float base) {
		super(nome);
		setY(altura);
		setX(base);
	}
	
	/**
	 * Obt�m a coordenada vertical <code>y</code> da forma geom�trica.
	 * 
	 * @return um <code>float</code> com o valor da coordenada vertical <code>y</code>
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Modifica o valor da coordenada vertical <code>y</code> da forma geom�trica.
	 * 
	 * @param y um <code>float</code> com o valor da coordenada vertical <code>y</code>.
	 */
	public void setY(float y) {
		if(y >= 0) this.y = y;
		else	this.y = 0;
	}
	
	/**
	 * Obt�m a coordenada horizontal <code>x</code> da forma geom�trica.
	 * 
	 * @return um <code>float</code> com o valor da coordenada horizontal<code>x</code>.
	 */
	public float getX() {
		return x;
	}

	/**
	 * Modifica o valor da coordenada horizontal <code>x</code> da forma geom�trica.
	 * 
	 * @param x um <code>float</code> com o valor da coordenada horizontal <code>x</code>.
	 */
	public void setX(float x) {
		if(x >= 0) this.x = x;
		else this.x = 0;
	}
	
	/**
	 * Obt�m o nome e as coordenadas da forma geom�trica bidimencional.
	 * @return um <code> String </code> com as coordenadas do objeto Forma2D.
	 * @see #getNome()
	 */
	public String toString() {
		//Chama o m�todo toString da superclasse Forma para obter a representa��o string da mesma.
		return super.toString() + ", y: " + y + ", x: " + x;
	}
	
	/**
	 * 	Exibe uma mensagem no <i>Console</i> quando um objeto Forma2D � removido da mem�ria.
	 */
	protected void finalize() {
		System.err.printf("Objeto forma3D %s removido da mem�ria.", nome);
		super.finalize();
	}
	
}// class Forma2D extends Forma 
