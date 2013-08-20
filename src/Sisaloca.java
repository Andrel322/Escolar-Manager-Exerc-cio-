import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Sisaloca implements SisalocaIF{
	
	private List <Professor> professores = new LinkedList <Professor>();
	private List <Aluno> alunos = new LinkedList <Aluno>();
	private List <Disciplina> disciplinas = new LinkedList <Disciplina>();
	
	public void cadastraProfessor (String nome, String matricula) throws ProfessorJaExisteException{
		for(Professor a: professores){
			if(a.getNome().equals(nome) && a.getMatricula().equals(matricula)){
				throw new ProfessorJaExisteException("O Professor ja existe");
			}
		}
		Professor professor = new Professor (nome,matricula);
		professores.add(professor);
	}
	
	public void cadastraAluno(String nome, String matricula) throws AlunoJaExisteException{
		for(Aluno a: alunos){
			if(a.getNome().equals(nome) && a.getMatricula().equals(matricula)){
				throw new AlunoJaExisteException("O Aluno ja existe");
			}
		}
		Aluno aluno = new Aluno (nome,matricula);
		alunos.add(aluno);
	}
	
	public void removeProfessor(String matricula) throws ProfessorInexistenteException{
		boolean remove = false;
		for(Professor a: professores){
			if(a.getMatricula().equals(matricula)){
				professores.remove(a);
				remove = true;
				break;
			}	
		} 
		if(remove == false){
			throw new ProfessorInexistenteException ("O Professor não existe com essa matricula");
		}
	
	}
	
	public List < Professor > pesquisaProfessorPeloNome(String nome){
		List <Professor> pesquisaProfessor = new LinkedList <Professor>();
		for(Professor p: professores){
			if(p.getNome().indexOf(nome)!=-1){
				pesquisaProfessor.add(p);
			}
		}
		return pesquisaProfessor;
	}
	public Professor pesquisaProfessorPelaMatricula(String matricula) throws ProfessorInexistenteException{
		for(Professor p: professores){
			if(p.getMatricula().equals(matricula)){
				return p;
			}
		} throw new ProfessorInexistenteException ("O Professor não existe com essa matricula");
		
	}
	
	public List < Aluno > pesquisaAlunoPeloNome(String nome){
		List <Aluno> pesquisaAluno = new LinkedList <Aluno>();
		for(Aluno a: alunos){
			if(a.getNome().indexOf(nome)!=-1){
				pesquisaAluno.add(a);
			}
		}
		return pesquisaAluno;
	}
	
	public Aluno pesquisaAlunoPelaMatricula(String matricula) throws AlunoInexistenteException{
		for(Aluno a: alunos){
			if(a.getMatricula().equals(matricula)){
				return a;
			}
		}
		throw new AlunoInexistenteException ("O Aluno não existe com essa matricula");
	}
	
	public void removeAluno(String matricula) throws AlunoInexistenteException{
		boolean remove = false;
		for(Aluno a: alunos){
			if(a.getMatricula().equals(matricula)){
				alunos.remove(a);
				remove = true; 
				break;
			}	
		} 
		if(remove == false){
		throw new AlunoInexistenteException ("O Aluno não existe com essa matricula");
		}
	}
	
	public void adicionaDisciplina(String nome, String codigo) throws DisciplinaJaExisteException{
		for(Disciplina d: disciplinas){
			if(d.getNome().equals(nome) && d.getCodigo().equals(codigo)){
				throw new DisciplinaJaExisteException ("A Disciplina ja existe");
			}
		}
		Disciplina disciplina = new Disciplina (nome, codigo);
		disciplinas.add(disciplina);
	}
	
	public void removeDisciplina(String codigo) throws DisciplinaInexistenteException{
		boolean remove = false;
		for(Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigo)){
				disciplinas.remove(d);
				remove = true;
				break;
			}
		}
		if(remove == false){
			throw new DisciplinaInexistenteException ("Disciplina inexistente com esse codigo");
		}
	}
	
	public Disciplina pesquisaDisciplina(String codigo) throws DisciplinaInexistenteException{
		for (Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigo)){
				return d;
			}
		}
		throw new DisciplinaInexistenteException ("Disciplina inexistente com esse codigo");
	}
	
	public void adicionaTurma(String codigoDisciplina, int numTurma) throws DisciplinaInexistenteException, TurmaJaExisteException{
		boolean remove = false;
		for(Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigoDisciplina)){
				d.adicionaTurma(numTurma);
				remove = true;
				break;
			}
		}
		if(remove == false){
			throw new DisciplinaInexistenteException ("Disciplina inexistente com esse codigo");
		}
	}
	
	public void removeTurma(String codigoDisciplina, int numTurma) throws DisciplinaInexistenteException{
		boolean remove = false;
		for(Disciplina d: disciplinas){
			if(d.getCodigo().equals(codigoDisciplina)){
				d.removeTurma(numTurma);
				remove = true;
				break;
			}
		}
		if(remove == false){
			throw new DisciplinaInexistenteException ("Disciplina inexistente com esse codigo");
		}
	}
	
	public void cadastraNivelDeInteresseDeProfessorPorDisciplina(String matriculaProf,String codDisciplina, int nivelPreferencia) throws PreferenciaInvalidaException, ProfessorInexistenteException, DisciplinaInexistenteException {
		Professor prof = this.pesquisaProfessorPelaMatricula(matriculaProf);
		Disciplina dis = this.pesquisaDisciplina(codDisciplina);
		prof.adicionaPreferenciaDisciplina(dis, nivelPreferencia);
	}
	
	public List <Disciplina> consultaDisciplinasPorPreferenciaPorProfessor(String matriculaProfessor, int nivelPreferencia) throws ProfessorInexistenteException, PreferenciaInvalidaException{
		Professor prof = pesquisaProfessorPelaMatricula(matriculaProfessor);
		List <Disciplina> disciplinasPorPreferencia = prof.getDisciplinasPreferidasComNivel(nivelPreferencia);
		return disciplinasPorPreferencia;
	}
	
	public List <Professor> obterListaDeProfessores(){
		return professores;
	}
	
	public List <Disciplina> obterListaDeDisciplinas(){
		return disciplinas;
	}
	
	public void carregarProfessoresDeArquivo(String nomeArquivo)throws ProfessorJaExisteException, IOException{
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String nomeProf = null;
			do {
				nomeProf = leitor.readLine(); // lê a próxima linha do arquivo, nome do professor
				if (nomeProf != null){
                                    String matriculaProf = leitor.readLine(); //Lê a próxima linha do arquivo, matrícula do professor
				    this.cadastraProfessor(nomeProf, matriculaProf);
                               }
			} while(nomeProf != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}
	}
	
	public void carregarDisciplinasDeArquivo(String nomeArquivo) throws DisciplinaJaExisteException, IOException{
		BufferedReader leitor = null;
		try{
			leitor = new BufferedReader (new FileReader (nomeArquivo));
			String nomeDiscp = null;
			do{
				nomeDiscp = leitor.readLine();
				if(nomeDiscp != null){
					String codigoDisc = leitor.readLine();
					adicionaDisciplina(nomeDiscp, codigoDisc);
				}
			}while (nomeDiscp != null);
		} finally{
			if(leitor != null){
				leitor.close();
			}
		}
	}
	public void gravarProfessoresEmArquivo(String nomeArquivo) throws  IOException{
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter (new FileWriter(nomeArquivo));
			for(Professor professor: professores){
				gravador.write(professor.getNome()+"\n");
				gravador.write(professor.getMatricula()+"\n");
			}
		}finally{
			if(gravador!=null){
				gravador.close();
			}
		}
	}
	public void gravarDisciplinasEmArquivo(String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Disciplina disciplina: this.disciplinas){
				gravador.write(disciplina.getNome()+"\n");
				gravador.write(disciplina.getCodigo()+"\n");
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	public void gravarTurmasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException{
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Disciplina disciplina: this.disciplinas){
				gravador.write(disciplina.getCodigo()+"\n");
				gravador.write(disciplina.getTurmas().size()+"\n");
				for (int k=0; k< disciplina.getTurmas().size(); k++){
					Turma t = disciplina.getTurmas().get(k);
					gravador.write(t.getNumero()+"\n");
				}
			}
		}finally{
			if(gravador != null){
				gravador.close();
			}
		}
	}
	
	public void carregarTurmasDeDisciplinasEmArquivo(String nomeArquivo) throws IOException, DisciplinaInexistenteException, TurmaJaExisteException{
		BufferedReader leitor = null;
		try{
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String CodDisc = null;
			do{
				CodDisc = leitor.readLine();
				if(CodDisc != null){
					int numTurma = Integer.parseInt(leitor.readLine());
					for(int n=0; n < numTurma; n++){
						int t =Integer.parseInt(leitor.readLine());
						this.adicionaTurma(CodDisc,t);
					}	
				}
			}while(CodDisc != null);
		}finally{
			if(leitor != null){
				leitor.close();
			}
		}
	}
	
	public void imprimeProfessoresEDisciplinas(){
		for(Professor p: professores){
			System.out.println("Professor: " + p.toString());
		}
		for(Disciplina d: disciplinas){
			System.out.println("Disciplina: " + d.toString());
		}
	}
	
	public void gravaInteressesDeProfessoresPorDisciplinasEmArquivo(String nomeArquivo) throws  IOException{
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter (new FileWriter(nomeArquivo));
			for(Professor p : professores){
				gravador.write(p.getMatricula()+"\n");
				gravador.write(p.getTextoPreferenciasDisciplinasComCodigo()+"\n");
			}
		}finally{
			if(gravador != null){
				gravador.close();
			}
		}
	}
	
 	public void carregaInteressesDeProfessoresPorDisciplinasDeArquivo(String nomeArquivo) throws PreferenciaInvalidaException, ProfessorInexistenteException, DisciplinaInexistenteException, IOException{
 		BufferedReader leitor = null;
 		try{
 			leitor = new BufferedReader (new FileReader(nomeArquivo));
 			String codProfe = null;
 			do{
 				codProfe = leitor.readLine();
 				if(codProfe != null){
 					Professor prof = pesquisaProfessorPelaMatricula (codProfe);
 					for(int n=1; n<=4; n++){
 						String intereseDiscip = leitor.readLine();
 						List <String> codigos = leListaDeCodigosDeDisciplinasDeLinha (intereseDiscip);
 						for(String cod : codigos){
 							if(cod != null){
 								Disciplina disc = pesquisaDisciplina (cod);
 								prof.adicionaPreferenciaDisciplina(disc, n);
 							}
 						}
 					}
 				} 
 			}while(codProfe != null);
 			
 		}finally{
 			if(leitor != null){
 				leitor.close();
 			}
 		}
 	}
 	
 	private List <String> leListaDeCodigosDeDisciplinasDeLinha(String linha){
		List <String> codigos = new LinkedList<String>();
		StringTokenizer tokenizer = new StringTokenizer(linha,":");
		String nivelPreferencia = tokenizer.nextToken();//parte antes dos :
		if (tokenizer.hasMoreTokens()){ // Se tiver algo depois dos :
			String listaCodigos = tokenizer.nextToken(); // parte depois dos :
			System.out.println("listaCodigos:"+listaCodigos);
			StringTokenizer tokenizerVirgula = new StringTokenizer(listaCodigos,",");
			while (tokenizerVirgula.hasMoreTokens()){
				String codigo = tokenizerVirgula.nextToken();
				codigos.add(codigo);
			}
		}
		return codigos;
	}
}