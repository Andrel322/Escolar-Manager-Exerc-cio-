import java.util.LinkedList;
import java.util.List;

public class Professor extends Pessoa{
	
	private List<Disciplina> listaDisciplinasP1; //Disciplinas que o professor tem preferência máxima em ensinar
	private List<Disciplina> listaDisciplinasP2;//Disciplinas que o professor tem um nível P2 de preferência
	private List<Disciplina> listaDisciplinasP3;//Disciplinas que o professor tem um nível P3 de preferência
	private List<Disciplina> listaDisciplinasNP;//Disciplinas que o professor explicitou que não gostaria de ensinar
	public static final int PREF_P1 = 1;
	public static final int PREF_P2 = 2;
	public static final int PREF_P3 = 3;
	public static final int PREF_PN = 4;
	
	public Professor (String nome, String matricula){
		super(nome,matricula);
		listaDisciplinasP1 = new LinkedList <Disciplina>();
		listaDisciplinasP2 = new LinkedList <Disciplina>();
		listaDisciplinasP3 = new LinkedList <Disciplina>();
		listaDisciplinasNP = new LinkedList <Disciplina>();
	}
	
	public Professor (){
		super ("Sem nome" , "000");
	}
	
	public String getDescricao (){
		return " Nome: " + super.getNome() + " matricula: " + super.getMatricula();
	}
	
	 public void adicionaPreferenciaDisciplina(Disciplina d, int nivelPreferencia) throws PreferenciaInvalidaException{
		 if(nivelPreferencia == PREF_P1){
			 listaDisciplinasP1.add(d);
		 }
		 else if(nivelPreferencia == PREF_P2){
			 listaDisciplinasP2.add(d);
		 }
		 else if(nivelPreferencia == PREF_P3){
			 listaDisciplinasP3.add(d);
		 }
		 else if(nivelPreferencia == PREF_P3){
			 listaDisciplinasP3.add(d);
		 }
		 else if(nivelPreferencia == PREF_PN){
			 listaDisciplinasNP.add(d);
		 }
		 else{
			 throw new PreferenciaInvalidaException ("Preferencia Invalida");
		 }
	 }
	 
	 public List<Disciplina> getDisciplinasPreferidasComNivel(int nivelPreferencia) throws PreferenciaInvalidaException{
		 if(nivelPreferencia == PREF_P1){
			return listaDisciplinasP1;
		 }
		 else if(nivelPreferencia == PREF_P2){
			return listaDisciplinasP2;
		 }
		 else if(nivelPreferencia == PREF_P3){
			return listaDisciplinasP3;
		 }
		 else if(nivelPreferencia == PREF_P3){
			return listaDisciplinasP3;
		 }
		 else if(nivelPreferencia == PREF_PN){
			return listaDisciplinasNP;
		 }
		 else{
			 throw new PreferenciaInvalidaException ("Preferencia Invalida");
		 }
	 }
	 
	 public String toString(){
			String txt = getDescricao()+"\n";
			txt+="Disciplinas P1:"+getListaNomesDisciplinas(this.listaDisciplinasP1);		
			txt+="\nDisciplinas P2:"+getListaNomesDisciplinas(this.listaDisciplinasP2);
			txt+="\nDisciplinas P3:"+getListaNomesDisciplinas(this.listaDisciplinasP3);
			txt+="\nDisciplinas NP:"+getListaNomesDisciplinas(this.listaDisciplinasNP);
			return txt;
		}
		
		public String getListaNomesDisciplinas(List <Disciplina> lista){
			String listaNomes="";
			for (int k=0; k< lista.size(); k++){
				Disciplina d  = lista.get(k);
				listaNomes+= d.getNome();
				if (k!= lista.size()-1){
					listaNomes+=",";
				}
			}
			return listaNomes;
		}
		
		public String getTextoPreferenciasDisciplinasComCodigo(){
			
			String listaPreferencias = "P1:";
			Disciplina d;
			for (int p1=0; p1< listaDisciplinasP1.size(); p1++){
				d = listaDisciplinasP1.get(p1);
				listaPreferencias += d.getCodigo();
				if(p1 != listaDisciplinasP1.size() -1){
					listaPreferencias += ",";
				}
			}
			listaPreferencias += "\nP2:";
			for(int p2=0; p2< listaDisciplinasP2.size(); p2++){
				d = listaDisciplinasP2.get(p2);
				listaPreferencias += d.getCodigo();
				if(p2 != listaDisciplinasP2.size()-1){
					listaPreferencias += ",";
				}
			}
			listaPreferencias += "\nP3:";
			for(int p3=0; p3< listaDisciplinasP3.size(); p3++){
				d = listaDisciplinasP3.get(p3);
				listaPreferencias += d.getCodigo();
				if(p3 != listaDisciplinasP3.size()-1){
					listaPreferencias += ",";
				}
			}
			listaPreferencias += "\nNP:";
			for(int np=0; np< listaDisciplinasNP.size(); np++){
				d = listaDisciplinasNP.get(np);
				listaPreferencias += d.getCodigo();
				if(np != listaDisciplinasNP.size()-1){
					listaPreferencias += ",";
				}
			}
			return listaPreferencias;
			
		}
}