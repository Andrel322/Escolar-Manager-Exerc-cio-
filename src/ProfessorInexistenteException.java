public class ProfessorInexistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorInexistenteException (String msg){
		super(msg);
	}
	
	public ProfessorInexistenteException (){
		super();
	}
}