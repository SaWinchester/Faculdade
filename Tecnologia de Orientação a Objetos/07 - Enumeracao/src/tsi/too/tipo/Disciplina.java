package tsi.too.tipo;

public enum Disciplina {
	BIO(),
	MAT("Matem�tica", 100),
	LP("Linguagem de Programa��o", 4, 80),
	SO("Sistemas Operacionais", 2, 100),
	LPV("Linguagem de Programa��o Visual", 4, 60),
	TOO("Tecnologia de Orienta��o a Objetos", 4, 120);
	
	private String nome;
	private int creditos, cargaHoraria; 
	
	private Disciplina() { }
	
	private Disciplina(String nome, int cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}

	private Disciplina(String nome, int creditos, int cargaHoraria) {
		this.nome = nome;
		this.creditos = creditos;
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public  String toString() {
		return "Mat�ria: " + nome + ", Cr�ditos: " + creditos + ", Carga hor�ria: " + cargaHoraria;
	}
}//enum Disciplina
