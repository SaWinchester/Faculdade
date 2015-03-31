package tsi.too.tipo;

public interface OperacaoForma {
	
	/*
	 * As constantes definidas na interface s�o impl�citamente publicas (public), est�ticas (static) e final.
	 * 
	 * 	public static final String FORMA_GEOMETRICA = "Formas Geom�tricas";
	 * 
	 * 		equivale:
	 * 
	 * String FORMA_GEOMETRICA = "Formas Geom�tricas";
	 */
	public static final String FORMA_GEOMETRICA = "Formas Geom�tricas";
	
	/*
	 * Os m�todos abstratos devem ser implementados nas classes que implementam est�
	 * interface. 
	 */
	public abstract float area();
	public abstract boolean lerDimensoes();
	public abstract float volume();
	public abstract void desenhar();	
}
