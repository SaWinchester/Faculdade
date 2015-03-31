package tsi.too.tipo;

public class Triangulo extends Forma2D {
	/*
	 * Dimens�es b�sicas de todas as fomas geom�tricas de 2 dimens�es.
	 * y = altura
	 * x = base
	 */
	
		public Triangulo() {
			super("Tri�ngulo");
		}
	
		public Triangulo(float altura, float base) {
			super("Tri�ngulo",altura, base);
		}
	
		public Triangulo(String nome, float altura, float base) {
			super(nome, altura, base);
		}
	
		public Triangulo(String nome) {
			super(nome);
		}
		
		public void setAltura(float altura){
			setY(altura);
		}
		
		public float getAltura(){
			return y;
		}
		
		public void setBase(float base){
			setX(base);
		}
		
		public float getBase() {
			return x;
		}
			
		@Override
		public String toString() {
			return nome + " Altura: " + y + ", Base: " + x;
		}
	
		@Override
		public float area() {
			return x * y / 2;
		}
		@Override
		public float volume() {
			return 0;
		}
	
		@Override
		public void desenhar() {
	
		}
		
		@Override
		public boolean lerDimensoes() {
			return true;
		}
		
}
