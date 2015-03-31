package tsi.too.tipo;

public class Triangulo2 extends Triangulo {
	
	private Ponto vertice1, vertice2, vertice3;
	
	public Triangulo2(Ponto vertice1, Ponto vertice2, Ponto vertice3) {
		setVertice1(vertice1);
		setVertice2(vertice2);
		setVertice3(vertice3);
	}
	
	public Triangulo2() {
		super("Tri�ngulo");
	}

	public Triangulo2(float altura, float base) {
		super("Tri�ngulo",altura, base);
	}

	public Triangulo2(String nome, float altura, float base) {
		super(nome, altura, base);
	}

	public Triangulo2(String nome) {
		super(nome);
	}
	
	public Ponto getVertice1() {
		return vertice1;
	}

	public void setVertice1(Ponto vertice1) {
		this.vertice1 = vertice1;
	}

	public Ponto getVertice2() {
		return vertice2;
	}

	public void setVertice2(Ponto vertice2) {
		this.vertice2 = vertice2;
	}

	public Ponto getVertice3() {
		return vertice3;
	}
	
	public void setVertice3(Ponto vertice3) {
		this.vertice3 = vertice3;
	}
		
	@Override
	public String toString() {
		return super.toString() +", Vertice 1: " + vertice1
				+ ", Vertice 2: " + vertice2 + ", Vertice 3: " + vertice3;
	}

	/*
	 * 	A classe Ponto � uma classe interna que encapsula os pontos x e y que representa o v�rtice
	 * de um tri�ngulo. Um objeto da classe interna p�blica est�tico pode ser criado fora da classe sem
	 * que seja necess�rio criar um objeto da classe externa, basta usar a seguinte nota��o, basta usar
	 * a seguinte nota��o:
	 * 
	 * 			<ClasseInterna> <referenciaDaClasseInterna> =  new <ClasseExterna>.<ClasseInterna>
	 * 	
	 * Exemplo:
	 * 			Ponto v1 = Triangulo2.new Ponto(2,2)
	 */
	public static class Ponto {
		
			private int x, y;
	
			public Ponto() {
				super();
			}
			
			public Ponto(int x, int y) {
				this.x = x;
				this.y = y;
			}	
			
			public int getX() {
				return x;
			}
	
			public void setX(int x) {
				this.x = x;
			}
	
			public int getY() {
				return y;
			}
	
			public void setY(int y) {
				this.y = y;
			}
	
			@Override
			public String toString() {
				return "Ponto x: " + x + ", y: " + y;
			}
		}//class Ponto			
}//class Triangulo2

		
	

	

