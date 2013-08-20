public class Turma {
	
	private int numero;
	private Disciplina disciplina;
	
	public Turma(Disciplina disciplina, int numero) {
		this.numero = numero;
		this.disciplina = disciplina;
	}

	public int getNumero (){
		return numero;
	}
	
	public void setNumero (int numero){
		this.numero = numero;
	}
	
	public Disciplina getDisciplina (){
		return disciplina;
	}
	
	public void setDisciplina (Disciplina disciplina){
		this.disciplina = disciplina;
	}
	
	public String toString (){
		String txt = "Numero: " + getNumero();
		return txt;
	}
}
