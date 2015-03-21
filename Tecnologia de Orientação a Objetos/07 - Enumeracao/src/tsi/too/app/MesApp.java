package tsi.too.app;

import java.util.EnumSet;

public class MesApp {
	//Define um conjunto de constantes enumeradas chamado de enumera��o.
	enum Mes {janeiro, fevereiro, marco, abril, maio, junho, julho, 
		   				agosto, setembro, outubro, novembro, dezembro};
	
	public static void main(String[] args) {
		String meses[] = {"janeiro", "fevereiro", "marco", "abril", "maio", "junho", "julho", 
								   "agosto", "setembro", "outubro", "novembro", "dezembro"};
		
		//Solu��o 1: Uso do loop for tradicional
		for(int mes = Mes.janeiro.ordinal(); mes <= Mes.dezembro.ordinal(); mes++)
			System.out.printf(" %d - %s ",mes + 1, meses[mes]);
		System.out.printf("\n");
		
		//Solu��o 2: Uso do for aprimorado.
		for(Mes mes : Mes.values())
			System.out.printf(" %d - %s ", mes.ordinal() + 1, mes);
		System.out.printf("\n");
		
		/*
		 * Solu��o 3: Uso do for aprimorado para exibir os meses do primeiro semestre. O m�todo est�tico
		 * range da classe java.util EnumSet retorna um objeto0 EunSet, ou seja, um subconjunto de constantes
		 * enumeradas. O subconjunto � definido pelos dois par�metros passados ao m�todo range.
		 */
		System.out.println("Semestres do ano");
		for(Mes mes : EnumSet.range(Mes.janeiro, Mes.junho))
			System.out.printf(" %d - %s ", mes.ordinal() + 1, mes);
	}//main(String[] args)
}//class MesApp
