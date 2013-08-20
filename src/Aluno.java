public class Aluno extends Pessoa{
	public Aluno (String nome, String matricula){
		super(nome,matricula);
	}
	
	public Aluno (){
		super ("Sem nome" , "000");
	}
	
	public String getDescricao (){
		return " Nome: " + super.getNome() + " matricula: " + super.getMatricula();
	}
	
	public String toString (){
		return getDescricao(); 
	}
}