package tsi.too.tipo;

public class Aluno {
	private String nome, curso;
	/*	
	 * 		Composi��o de objetos: O objeto da classe Aluno possui um objeto da classe Disciplina.
	 * 		Este relacionamento chamado de relacionamento tem um, � um exemplo de relacionamento 
	 * 		Todo-Parte.
	 * 		
	 * 		Na composi��o o objeto parte (Disciplina) � criado dentro do objeto todo (objeto do tipo Aluno).
	 * 		Portanto, quando o objeto Aluno � removido da mem�ria o objeto Disciplina tamb�m ser�
	 * 		removido da mem�ria. Eles nascem juntos e morrem juntos. Na composi��o, o objeto parte n�o 
	 * 		pode ser compartilhado com outros objetos.
	 * 		
	 * 		O identificados abaixo � uma refer�ncia para um objeto da classe Disciplina.
	 */
	private Disciplina disciplina; 
	private static int quantidadeAlunos;
	
	//Em Java uma constante � definida usando a palavra reservada final.
	public final int ID;
	
	//Construtor default.
	public Aluno() {
		ID = ++quantidadeAlunos;
		disciplina = new Disciplina();
	}
	
	/*
	 * 		Construtor Sobrecarregado. Inicia as v�riaveis de inst�ncia com os valores
	 * 		nome e curso passados como par�meto.
	 */
	public Aluno(String nome, String curso) {
		this();	//Chama o construtor default para criar o objeto disciplina.
		setNome(nome);
		setCurso(curso);
	}
	
	public Aluno(String nome, String curso, String nomeDisciplina, float notaDisciplina) {
		this();	//Chama o construtor default para criar o objeto disciplina.
		setNome(nome);
		setCurso(curso);
		disciplina.nome = nomeDisciplina;
		disciplina.nota = notaDisciplina;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
		
	public int getMatricula() {
		return ID;
	}
	
	public static int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public String toString() {
		//Chama implicitamente o m�todo toString da classe Disciplina.
		return "Matricula: " + ID + ", Aluno: " + nome + ", Curso: " + curso + ", " + disciplina.toString();
	}
	
	public void definirNomeDisciplina(String nome){
		//Usa o acesso de pacote para acessar diretamente a vari�vel de inst�ncia da classe Disciplina.
		disciplina.nome = nome;
	}
	
	public void definirNotaDisciplina(float nota) {
		//Usa o acesso de pacote para acessar diretamente a vari�vel de inst�ncia da classe Disciplina.
		disciplina.nota = nota;
	}
	
	public String obterNomeDisciplina() {
		return disciplina.nome;
	}
	
	public float obterNotaDisciplina() {
		return disciplina.nota;
	}
	
	/*
	 * Este M�todo � executado pelo coletor de lixo (Garbage Colector) do Java sempre que um objeto
	 * � removido da mem�ria. O problema � que n�o h� garantia de quando o coletor do Java ser� executado.
	 * Quando for executado este m�todo ser� executado, mas como n�o h� garantia de quando isso ocorrer�, n�o
	 * devemos programar nenhuma fun��o que dependa deste mecanismo.
	 */
	protected void finalize() throws Throwable {
		quantidadeAlunos--;
		System.err.printf("Objeto %s Removido da Mem�ria.\n"
				+ "N�mero de Alunos: %d\n",nome,quantidadeAlunos);
	}
	
}//class Aluno

/*
 * 	Esta classe possui acesso de pacote porque n�o � usado nenhum especificador de acesso
 * 	antes da palavra reservada class. Todas as classes de pacote tsi.com.tipo ter�o acesso a esta
 * 	classe.
 */
class Disciplina {
	/*
	 * 	Vari�veis de inst�ncia com acesso de pacote pode ser acessadas diretamente dentro pelas
	 * 	outras classes do mesmo pacote usando a ref�rencia da classe que possui acesso de pacote.
	 */
	String nome;
	float nota;
	
	public Disciplina() {	}

	public Disciplina(String nome, float nota) {
		setNome(nome);;
		setNota(nota);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String toString() {
		return "Disciplina: " + nome + ", Nota: " + String.format("%.1f", nota);
	}
}
