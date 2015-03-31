package tsi.too.tipo;

//	Uma classe final n�o pode ser estendida, ela n�o admite subclasse. 
 
public final class Retangulo extends Forma2D {
	
	/*
	 * Dimens�es b�sicas de todas as fomas geom�tricas de 2 dimens�es.
	 * y = altura
	 * x = base
	 */
	
	public Retangulo() {
		super("Ret�ngulo");
	}

	public Retangulo(int largura, int comprimento) {
		super("Ret�ngulo", largura, comprimento);
	}

	public Retangulo(String nome, int largura, int comprimento) {
		super(nome, largura, comprimento);
	}

	public Retangulo(String nome) {
		super(nome);
	}
	
	public void setBase(float base) {
		setX(base);
	}
	
	public float getBase() {
		return x;
	}
	
	public float getAltura() {
		return y;
	}
	public void setAltura(float altura) {
		setY(altura);
	}
	
	@Override
	public String toString() {
		return nome + ", Base: " + x + ", Altura: " + y;
	}
	
	
	@Override
	public float area() {
		return y * x;
	}

	@Override
	public float volume() {
		return 0;
	}

	@Override
	public void desenhar() {	}
	
}
