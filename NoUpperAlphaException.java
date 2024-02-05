public class NoUpperAlphaException extends Exception{

	public NoUpperAlphaException() {
		super("The password must be at least 6 characters long");
	}
	
}
