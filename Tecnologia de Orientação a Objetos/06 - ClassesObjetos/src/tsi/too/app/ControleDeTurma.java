package tsi.too.app;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tsi.too.tipo.*;
import static javax.swing.JOptionPane.*;

public class ControleDeTurma {
	private Turma turma;
	private final String NOME_PROGRAMA = "Controle de Turma",
								  MSG_MANTER_CAMPO = "Tecle Enter se desejar manter o valor atual";
	
	public ControleDeTurma() {
		turma = new Turma();
	}
	
	//Inicia o aplicativo Java GUI. 
	public static void main(String[] args) {
		new ControleDeTurma().menu();
		
		//Finaliza corretamente o programa.
		System.exit(0);
	}//main
	
	//Exibe o menu, seleciona e executa a op��o escolhida pelo usu�rio.
	public void menu() {
		int opcao;
		String opcoes[] = {"Cadastrar","Consultar", "Relat�rio", "Alterar", "Excluir", "Sair"};
		
		//Finaliza o Programa quando o usu�rio clicar no bot�o Sair ou Fechar da caixa de di�logo. 
		do{
			opcao = showOptionDialog(null, "Escolha um comando abaixo:", NOME_PROGRAMA, 
										DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			
			//Executa o comando escolhido pelo usu�rio.
			if(opcao != CLOSED_OPTION && opcao != 5){
				
				//Verifica se � a op��o cadastrar.
				if(opcao == 0){
					//Verifica se a turma ainda n�o atingiu sua capacidade m�xima. Caso n�o tenha atingido, cadastra um novo aluno.
					if(turma.getQuantidadeAlunos() < turma.getNUMERO_MAXIMO_DE_ALUNOS())
						cadastrar();
					else
						msgErro("A turma est� cheia. N�o � possivel cadastrar novos alunos.", NOME_PROGRAMA);
				}
				else
				{
					//Verifica se a turma j� possui algum aluno cadastrado.
					if(turma.getQuantidadeAlunos() >= 1)
					{
						switch (opcao) {
							case 1: consultar("Consultar"); break;
							case 2: relatorio(); break;
							case 3: alterar(); break;
							case 4: excluir(); break;
						}//switch
					}else
						msgErro("N�o h� nenhum aluno(a) cadastrado(a) na turma.", "Erro");
				}//else
			}
		}while(opcao != CLOSED_OPTION && opcao != 5);
		
	}//menu()
	
	/*
	 * 		L� todos os dados do aluno e cadastra no array de objetos turma. Se a opera��o for cancelada
	 * 		nenhum dado � cadastrado.
	 */
	public void cadastrar() {
		String nomeAluno, nomeCurso, nomeDisciplina;
		Float nota;
		
		nomeAluno = lerString("Nome do(a) Aluno(a): ", "Voc� deve fornecer o nome do(a) aluno(a):", "Cadastrar Aluno(a)", false);
		if(nomeAluno == null) return;
		
		nomeCurso = lerString("Nome do Curso: ", "Voc� deve fornecer o nome do curso.", "Cadastrar Curso", false);
		if(nomeCurso == null) return;
		
		nomeDisciplina = lerString("Nome da Disciplina: ", "Voc� deve fornecer o nome da disciplina.", "Cadastrar Disciplina", false);
		if(nomeDisciplina == null) return;
		
		nota = lerNumeroReal("Nota da Disciplina: ", "Voc� deve fornecer a nota da disciplina.", "Cadastrar Nota", false);
		if(nota == null) return;
		
		//Cria um objeto Aluno com os dados a serem cadastrado no objeto Turma.
		Aluno aluno = new Aluno(nomeAluno,nomeCurso, nomeDisciplina, nota);
		
		//Cadastra o objeto Aluno  no array de objetos da classe turma. 
		turma.inserirAluno(aluno);
		
		//Exibe uma mensagem informando que o objeto aluno foi inserido com sucesso no objeto Turma.
		showMessageDialog(null, "Dados gravados com sucesso.", NOME_PROGRAMA + " Cadastrar", INFORMATION_MESSAGE);
	}//cadastrar()
	
	/*
	 * 		L� o nome do aluno e pesquisa na turma. Se encontrar, exibe os dados. Caso contr�rio exibe
	 * 		aluno n�o cadastrado. O usu�rio poder� verificar os dados do aluno, exceto ID. Para manter o
	 * 		dado atual basta o usu�rio teclar Enter. Ap�s a altera��o ou confirma��o dos dados pelo usu�rio
	 * 		os dados ser�o atualizados no objeto turma.
	 */
	private void alterar() {
		//Cria uma refer�ncia para um objeto aluno.
		Aluno aluno = consultar("Alterar");
		
		//Verifica se os dados n�o est�o cadastrado. Se n�o estiverem 
		if(aluno == null) return;
		
		String nomeAluno, nomeCurso, nomeDisciplina;
		Float nota;
		boolean alterado = false;
		
		nomeAluno = lerString(String.format("%s\n\nNome do(a) Aluno(a): %s\n\nNovo Nome: ", MSG_MANTER_CAMPO, 
																aluno.getNome()), "", "Alterar Aluno(a)", true);
		if(nomeAluno == null) return;
		
		nomeCurso = lerString(String.format("%s\n\nNome do Curso: %s\n\nNovo Nome: ", MSG_MANTER_CAMPO, 
																aluno.getCurso()), "", "Alterar Curso", true);
		if(nomeCurso == null) return;
		
		nomeDisciplina = lerString(String.format("%s\n\nNome da Disciplina: %s\n\nNovo Nome: ", MSG_MANTER_CAMPO,
																aluno.obterNomeDisciplina()), "", "Alterar Disciplina", true);
		if(nomeDisciplina == null) return;
		
		nota = lerNumeroReal(String.format("%s\n\nNota da Disciplina: %1.1f\n\nNova Nota: ", MSG_MANTER_CAMPO, 
																aluno.obterNotaDisciplina()), "", "Alterar Notaa", true);
		
		//Altera os atributos do objeto aluno com os novos dados fornecidos pelo usu�rio.
		if(!nomeAluno.equals("")) {aluno.setNome(nomeAluno); alterado = true;}
		if(!nomeCurso.equals("")) {aluno.setCurso(nomeCurso); alterado = true;}
		if(!nomeDisciplina.equals("")) {	aluno.definirNomeDisciplina(nomeDisciplina); alterado = true;}
		if(nota != -1) {aluno.definirNotaDisciplina(nota);alterado = true;}
		
		//Exibe mensagem de confirma��o se algum dado foi alterado.
		if(alterado)
			showMessageDialog(null, "Dados alterados com sucesso.", NOME_PROGRAMA + " Alterar", INFORMATION_MESSAGE);
		else
			showMessageDialog(null, "Dados n�o alterados.", NOME_PROGRAMA + " Alterar", INFORMATION_MESSAGE);
	}//alterar()
	
	/*
	 * 		L� o nome do aluno e pesquisa na turma. Se encontrar, exibe os dados. Caso contr�rio exibe
	 * 		aluno n�o cadastrado. Uma mensagem deve solicitar a confirma��o de exclus�o ao usu�rio. Se 
	 * 		a resposta for positiva os dados ser�o exclu�dos do objeto turma, se negativa, a opera��o �
	 * 		cancelada.  
	 */
	private void excluir() {
		//Cria uma refer�ncia para um objeto aluno.
				Aluno aluno = consultar("Alterar");
				
				//Verifica se os dados do aluno foram obtidos.
				if(aluno == null) return;
				
				String resultado = obterDados(aluno);
				//Exibe os dados do aluno e solicita a confirma��o de exclus�o ao usu�rio.
				int resposta = showConfirmDialog(null, resultado + "\n\nDeseja excluir estes dados?", NOME_PROGRAMA + " - Excluir",
																	YES_NO_OPTION,QUESTION_MESSAGE);
				
				//Excluir os dados do aluno se a resposta for positiva.
				switch (resposta) {
				case YES_OPTION:  //Exclui os dados do aluno se a resposta for positiva.
					int posicao = turma.pesquisarAluno(aluno.getNome());
					
					if(posicao != -1){
						turma.removerAluno(posicao);
						showMessageDialog(null, "Dados do aluno exclu�dos com sucesso", NOME_PROGRAMA + " - Excluir", INFORMATION_MESSAGE);
					}
					else
						msgErro("Aluno n�o cadastrado", "Excluir");
				break;
				case NO_OPTION: 	 //Opera��o de exclus�o cancelada pelo usu�rio.
					showMessageDialog(null, "Opera��o de exclus�o cancelada", NOME_PROGRAMA + " - Excluir", INFORMATION_MESSAGE);
				break;
				case CANCEL_OPTION:	  //Usu�rio clicou no bot�o fechar.
					showMessageDialog(null, "Opera��o de exclus�o cancelada", NOME_PROGRAMA + " - Excluir", INFORMATION_MESSAGE);
				break;	
				default:
					break;
				}
				
	}//excluir()
	
	//Exibe um relat�rio com todos os dados cadastrados.
	private void relatorio() {
		//Cria uma �rea de texto com 10 linhas e 20 colunas para exibir o relat�rio.
		JTextArea areaTexto = new JTextArea(10, 50);
		String resultado = "";
		
		//Obt�m os dados de todos os alunos da turma
		for(int indice = 0; indice < turma.getQuantidadeAlunos(); indice++){
			resultado += turma.obterAluno(indice) + "\n";
		}
		
		//Escreve o resultado na area de texto.
		areaTexto.setText(resultado);
		
		//Torna a �rea de texto n�o editavel para o usu�rio n�o poder alterar o relat�rio.
		areaTexto.setEditable(false);
		
		//Exibe o resultado usando uma caixa de texto e um painel de rolagem.JScrolPanel.
		showMessageDialog(null, new JScrollPane(areaTexto), "Relat�rio", INFORMATION_MESSAGE);
	}//relatorio()
	
	//L� o nome do aluno e pesquisa. Caso encontre exibe os dados e retorna a refer�ncia. Caso contr�rio retorna null.
	private Aluno consultar(String modulo) {
		
		/*
		 * 		L� o nome do aluno, pesquisa na turma e caso encontrado, obt�m 	e exibe todos os 
		 * 		dados do aluno na GUI, se n�o, exibe a mensagem:
		 * 				* Aluno(a) n�o cadastrado(a).
		 * 		O par�metro m�dulo deve receber o nome do m�dulo do programa.
		 * 		Este m�todo retorna null se o usu�rio cancelar a opera��o de leitura do nome do
		 * 		aluno, se a opera��o n�o for cancelada ser� retornado a refer�ncia do objeto Aluno.
		 */
		
		String nome;
		Aluno aluno = null;
		int posicao;
		
		//L� o nome do aluno e verifica se o usu�rio cancelou a opera��o de leitura.
		nome = lerString("Nome do(a) Aluno(a): ", "Voc� deve fornecer o nome do(a) Aluno(a)", modulo, false);
		if(nome == null) return null;
		
		//Pesquisa o nome do aluno na turma.
		posicao = turma.pesquisarAluno(nome);
		
		//Se o nome for encontrado obt�m os dados do aluno e exibe caso o m�dulo n�o seja o Alterar.
		if(posicao != -1)
		{
			//Obt�m a refer�ncia do objeto aluno armazenado no ob jeto turma.
			aluno = turma.obterAluno(posicao);
			
			//Obt�m e exibe os dados do aluno na GUI, mas somente se a opera��o for Consultar.
			if(modulo.equalsIgnoreCase("Consultar"))
				showMessageDialog(null, obterDados(aluno), modulo, INFORMATION_MESSAGE);					
		}			
		else
			msgErro("Aluno(a) n�o cadastrado(a).", modulo);
		return aluno;
	}
	
	/*
	 * 	L� e valida uma string literal. Retorna a String lida. Os par�metros s�o:
	 * 		1. prompt: 	o texto a ser exibido na caixa de texto.
	 * 		2. msgErro: 	a mensagem de erro a ser exibida caso o usu�rio forne�a uma string vazia
	 * 							e o par�metro vazia vazia seja false.
	 * 		3. modulo: 	indica o nome do m�dulo do programa que est� usando este m�todo, p.ex:
	 * 							Cadastrar.		
	 * 		4. vazia: 		se for true o m�todo aceitar� string vazia, se false, n�o aceitar�.
	 * 	
	 * Retorna a string lida. Se o usu�rio cancelar a opera��o de leitura ser� retornado null.
	 */
	private String lerString(String prompt, String msgErro, String modulo, boolean vazia) {
		String string = null;
		
		do{
			string = showInputDialog(null, prompt, NOME_PROGRAMA +  modulo, QUESTION_MESSAGE);
			
			//verifica se o Usu�rio clicou no bot�o Cancelar.
			if(string == null) break;
			
			//Verifica se o usu�rio forneceu uma string vazia.
			if (string.equals("") && !vazia)
				showMessageDialog(null, msgErro, NOME_PROGRAMA + modulo,  ERROR_MESSAGE);
		}while(string.equals("") && !vazia);
		return string;
	}//ler String()
	
	/*
	 * 	L� e valida uma string literal. Retorna o n�mero lido. Os par�metros s�o:
	 * 		1. prompt: 	o texto a ser exibido na caixa de texto.
	 * 		2. msgErro: 	a mensagem de erro a ser exibida caso o usu�rio forne�a uma string vazia
	 * 							e o par�metro vazia vazia seja false.
	 * 		3. modulo: 	indica o nome do m�dulo do programa que est� usando este m�todo, p.ex:
	 * 							Cadastrar.		
	 * 		4. vazia: 		se for true o m�todo aceitar� string vazia, se false, n�o aceitar�.
	 * 	
	 * Retorna a string lida convertida em Float. Se o usu�rio cancelar a opera��o de leitura ser� retornado null.
	 * Se vazio for true e o usu�rio n�o digitar nada ser� retornado null.
	 */
	private Float lerNumeroReal(String prompt, String msgErro, String modulo, boolean vazio) {
		String valor = null;
		do{
			valor = showInputDialog(null, prompt, NOME_PROGRAMA + modulo, QUESTION_MESSAGE);
			
			//verifica se o Usu�rio clicou no bot�o Cancelar.
			if(valor == null) return null;
			
			//Verifica se o usu�rio forneceu uma string vazia.
			if (valor.equals("") && !vazio)
				showMessageDialog(null, msgErro, NOME_PROGRAMA + modulo,  ERROR_MESSAGE);
		}while(valor.equals("") && !vazio);
		
		//converter a string lida para float e retorna.
		if(!valor.equals(""))
			return Float.parseFloat(valor);
		return -1F;
	}//ler lerNumeroReal()
	
	private void msgErro(String msg, String modulo) {
		showMessageDialog(null, msg, modulo, ERROR_MESSAGE);		
	}

	//Obt�m os dados do aluno armazenados no par�metro aluno.
	private String obterDados(Aluno aluno){
		//Exibe os dados do aluno na GUI somente se a opera��o n�o for excluir.
		return "ID: " + aluno.ID + "\nNome: " + aluno.getNome() + "\nCurso: " +
				aluno.getCurso() + "\nDisciplina: " + aluno.obterNomeDisciplina() +
				String.format("\nNota: %1.1f", aluno.obterNotaDisciplina());
		
	}
}//class ControleDeNotas
