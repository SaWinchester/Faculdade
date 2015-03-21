package tsi.too.app;

import tsi.too.tipo.Aluno;

public class AlunoApp {

	public static void main(String[] args) {
		/*
		 * 	N�o � poss�vel criar um objeto Disciplina em AlunoApp porque a classe Disciplina possui acesso de pacote.
		 * 	S� pode ser usada dentro do pacote 'tsi.too.tipo'.
		 */
		System.out.printf("N�mero de Alunos: %d\n", Aluno.getQuantidadeAlunos());
		
		Aluno aline = new Aluno("Aline", "Inform�tica"),
				 pedro = new Aluno("Pedro", "Biologia"),
				 clara = new Aluno("Clara", "F�sica"),
				 lucas = new Aluno("Lucas", "Qu�mica");
		
		aline.definirNomeDisciplina("L�gica de programa��o");
		aline.definirNotaDisciplina(9.5f);
		pedro.definirNomeDisciplina("Biologia Marinha");
		pedro.definirNotaDisciplina(10.0f);
		clara.definirNomeDisciplina("F�sica IV");
		clara.definirNotaDisciplina(6.1f);
		lucas.definirNomeDisciplina("Qu�mica Org�nica");
		lucas.definirNotaDisciplina(6.0f);
		
		System.out.println(aline.toString());
		System.out.println(pedro.toString());
		System.out.println(clara.toString());
		System.out.println(lucas.toString());
		System.out.printf("N�mero de Alunos: %d\n", Aluno.getQuantidadeAlunos());
		
		/*
		 *	Marca as refer�ncias da classe Aluno para indicar que os objetos correspondentes n�o
		 *	ser�o mais usados e consequentemente podem ser eliminados. 	
		 */
		pedro = null;
		aline = null;
		clara = null;
		lucas = null;
		
		//Chama explicitamente o coletor de lixo do java.
		System.gc();
		
		/*
		 * 	O objetivo do for � provocar um atraso (delay) na execu��o do programa com o 
		 * 	objetivo de dar tempo de executar o coletor de lixo.
		 */
		for (long delay = 0; delay < Integer.MAX_VALUE; delay++)
		{}
	}//main

}//class AlunoApp
