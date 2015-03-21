package tsi.too.tipo;

public class Turma {
	/*	
	 * 		Agrega��o de objetos: O objeto da classe Turma possui um objeto array de objetos da classe Aluno.
	 * 		Este relacionamento chamado de relacionamento tem um, � um exemplo de relacionamento 
	 * 		Todo-Parte.
	 * 		
	 * 		Na agrega��o o objeto parte (objeto do tipo Aluno) N�O � criado dentro do objeto todo (objeto do tipo Turma).
	 * 		Portanto, quando o objeto Turma � removido da mem�ria o objeto Aluno N�O ser�	removido da mem�ria. 
	 * 		Na agrega��o, o objeto parte pode ser compartilhado com outros objetos.
	 * 
	 * 		O identificados abaixo � uma refer�ncia para um array de objetos da classe Aluno.
	 */
	private Aluno turma[];
	private int quantidadeAlunos;
	private final int NUMERO_MAXIMO_DE_ALUNOS;
	
	//Cria o objeto Turma com no m�ximo 20 objetos do tipo Aluno.
	public Turma() {
		NUMERO_MAXIMO_DE_ALUNOS = 20;
		turma = new Aluno[NUMERO_MAXIMO_DE_ALUNOS];
	}
	
	//Cria o objeto Turma com a quantidade de refer�ncias de objetos do tipo Aluno passado por par�metro.
	public Turma(int numeroMaximoDeAlunos) {
		NUMERO_MAXIMO_DE_ALUNOS = numeroMaximoDeAlunos;
		turma = new Aluno[NUMERO_MAXIMO_DE_ALUNOS];
	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public int getNUMERO_MAXIMO_DE_ALUNOS() {
		return NUMERO_MAXIMO_DE_ALUNOS;
	}

	public String toString() {
		return "Turma [N�mero de Alunos: " + quantidadeAlunos
				+ ", N�mero M�ximo de Alunos: " + NUMERO_MAXIMO_DE_ALUNOS + "]";
	}
	
	/*
	 * 	Cadastra um Objeto Aluno na Turma. Se a turma estiver cheia n�o cadastra e retorna false, caso
	 * 	contr�rio retorna true.
	 */
	public boolean inserirAluno(Aluno aluno) {
		if(quantidadeAlunos < NUMERO_MAXIMO_DE_ALUNOS)
		{
			turma[quantidadeAlunos++] = aluno;
			return true;
		}
		return false;
	}
	
	/*
	 * Obt�m um objeto Aluno da Turma na posi��o utilizada. Retorna o objeto Aluno da posi��o
	 * se ela for v�lida, caso seja inv�lida retorna null.
	 */
	public Aluno obterAluno(int posicao) {
		return (posicao >= 0 && posicao < quantidadeAlunos) ? turma[posicao] : null;
	}
	
	/*
	 * Pesquisa pelo nome do aluno na turma. Se o nome foi encontrado retorna a posi��o do
	 * Aluno na Turma, se n�o retorna -1.
	 */
	public int pesquisarAluno(String nome) {
		if(quantidadeAlunos == 0) return -1;
		for(int indice = 0; indice < quantidadeAlunos; indice++)
			if(nome.equalsIgnoreCase(turma[indice].getNome()))
				return indice;
		return -1;
	}
	
	/*
	 * 	Remove o objeto Aluno do objeto Turna. Se a posi��o � v�lida o objeto � removido e o m�todo
	 * 	retorna true, caso contr�rio o objeto n�o � removido e o m�todo retorna false. 
	 */
	public boolean removerAluno(int posicao) {
		if(posicao >= 0 && posicao < quantidadeAlunos)
		{
			if(quantidadeAlunos > 1) 
				turma[posicao] = turma[quantidadeAlunos - 1];
			turma[--quantidadeAlunos] = null;
			return true;
		}
		return false;	
	}
}//class Turma
