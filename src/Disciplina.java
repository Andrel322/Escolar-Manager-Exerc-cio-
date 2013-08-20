import java.util.LinkedList;
import java.util.List;

public class Disciplina {
	
	private String nome;
	private String codigo;
	private List <Turma> turmas;
	
	public Disciplina (String nome, String codigo){
		this.nome = nome;
		this.codigo = codigo;
		turmas = new LinkedList <Turma>();
	}
	
	public String getNome (){
		return nome;
	}
	
	public void setNome (String nome){
		this.nome = nome;
	}
	
	public String getCodigo (){
		return codigo;
	}
	
	public void setCodigo (String codigo){
		this.codigo = codigo;
	}
	
	public List <Turma> getTurmas (){
		return turmas;
	}
	
	public void adicionaTurma(int numero) throws TurmaJaExisteException {
		for (Turma t: this.turmas){
			if (t.getNumero() == numero){
				throw new TurmaJaExisteException("Já existe a turma de número:"+numero);
			}
		}
		//Caso não lance a exceção, ele adiciona a nova turma assim:
		Turma t = new Turma(this, numero);
		this.turmas.add(t);
	}
	
	public void removeTurma(int numero){
		for (Turma t: this.turmas){
			if (t.getNumero() == numero){
				this.turmas.remove(t);
				break;
			}
		}
	}
	
	public String toString (){
		String txt = "Nome: " + getNome() + " Codigo: " + getCodigo() + "\n";
		txt += "Turmas :" + getDescricaoDasTurmas();
		return txt;
	}
	
	public String getDescricaoDasTurmas (){
		String codTurmas = "";
		for(int n = 0; n < getTurmas().size(); n++){
			Turma t = turmas.get(n);
			codTurmas += t.toString();
			if(n != turmas.size()-1){
				codTurmas += ", ";
			}
		}
		return codTurmas;
	}
}
