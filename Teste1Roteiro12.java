import java.io.File;


public class Teste1Roteiro12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SisalocaIF sistema = new Sisaloca();
		try {
			sistema.carregarProfessoresDeArquivo("professores.txt");
			//cadastro de disciplinas pelo arquivo
			sistema.carregarDisciplinasDeArquivo("disciplinas.txt");
			//Verificação da quantidade de disciplinas e professores no sistema
			if (sistema.obterListaDeDisciplinas().size() == 2 &&
					sistema.obterListaDeProfessores().size()==2){
				System.out.println("OK: 2 disciplinas e 2 professores encontrados");
			}
			
			sistema.cadastraProfessor("Manoel", "001");
			sistema.adicionaDisciplina("Estrutura de Dados", "444");
			
			sistema.adicionaTurma("444", 1);
			sistema.adicionaTurma("444", 2);
		
			if (sistema.obterListaDeDisciplinas().size() == 3 &&
					sistema.obterListaDeProfessores().size()==3){
				System.out.println("OK: 3 disciplinas e 3 professores encontrados no sistema");
			}
			
			sistema.cadastraNivelDeInteresseDeProfessorPorDisciplina("123", "333", Professor.PREF_P1);
			sistema.cadastraNivelDeInteresseDeProfessorPorDisciplina("123", "222", Professor.PREF_P1);			
			sistema.cadastraNivelDeInteresseDeProfessorPorDisciplina("444", "333", Professor.PREF_P1);			
			sistema.cadastraNivelDeInteresseDeProfessorPorDisciplina("444", "222", Professor.PREF_P2);			
			
			
			sistema.gravarDisciplinasEmArquivo("disciplinas2.txt");
			sistema.gravarProfessoresEmArquivo("professores2.txt");
			sistema.gravarTurmasDeDisciplinasEmArquivo("turmas2.txt");
			sistema.gravaInteressesDeProfessoresPorDisciplinasEmArquivo("preferencias2.txt");
			
			File arquivoDisciplinas = new File("disciplinas2.txt");
			File arquivoProfessores = new File("professores2.txt");
			File arquivoTurmas = new File("turmas2.txt");
			File arquivoPrefs = new File("preferencias2.txt");
			
			if (arquivoDisciplinas.exists() && arquivoProfessores.exists()
					&& arquivoTurmas.exists() && arquivoPrefs.exists()){
				System.out.println("OK - sistema testado. Arquivos novos criados");
			} else {
				System.out.println("ERRO: Arquivos não foram criados");
			}
			
		} catch (Exception e) {// Todas as exceções que podem acontecer são subtipos
			                   // de exception. Como o tratamento é o mesmo para todas, 
							   // podemos fazer assim:
			System.out.println("ERRO: Exceção não esperada:"+e.getMessage());
			e.printStackTrace();
		}
	}

}