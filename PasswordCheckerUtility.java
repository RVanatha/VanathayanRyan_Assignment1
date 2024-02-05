import java.util.ArrayList;

public class PasswordCheckerUtility {

	private static final int B = 0;
	private static final int A = 0;

	//Constructor
	public PasswordCheckerUtility() {
		
	}
	
	//Methods
	
	//Tests whether there is a 3 character sequence in the password. If so it throws InvalidSequenceException, otherwise returns true
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException{
		
		for(int i = 0; i < password.length() - 2; i++) {
			
			char current = password.charAt(i);
			char nextChar = password.charAt(i + 1);
			char afterNext = password.charAt(i + 2);
			
			if(current == nextChar && nextChar == afterNext) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	//Tests whether the password is valid, then tests if it is weak(under 10 characters). Returns false if not valid
	public static boolean isWeakPassword​(String password) throws WeakPasswordException{
		
		try {
			if(isValidPassword​(password)){
				
					if(password.length() <= 9)
						throw new WeakPasswordException();
			}
		}catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | 
				InvalidSequenceException | NoSpecialCharacterException e) {
		
			System.out.println(e.getMessage());
		}
		return false;	
		
	}
	
	//Tests whether the password is valid length. If it is less than 6 characters it will throw LengthException
	public static boolean isValidLength​(String password) throws LengthException{
		
		if(password.length() >= 6)
			return true;
		else 
			throw new LengthException();
	}
	
	//Tests whether password contains an upper case character. If not it will throw NoUpperAlphaException
	public static boolean hasUpperAlpha​(String password) throws NoUpperAlphaException{
		
		for(int i = 0; i < password.length();i++) {
			
			if(password.charAt(i) == password.toUpperCase().charAt(i))
				return true;
			
		}
		throw new NoUpperAlphaException();
	}

	//Tests whether password contains an special character. If not it will throw NoSpecialCharacterException
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException{
		
		for(int i = 0; i < password.length();i++) {
			
			if(!Character.isLetterOrDigit(password.charAt(i)) && !Character.isSpaceChar(password.charAt(i)))
				return true;
		}
		throw new NoSpecialCharacterException();
	}

	//Tests whether password contains an lower case character. If not it will throw NoLowerAlphaException
	public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException{
		
		for(int i = 0; i < password.length(); i++) {
		
			if(Character.isLowerCase(password.charAt(i)))
				return true;
		}
		throw new NoLowerAlphaException();
		
	}

	//Tests whether password contains a digit. If not it will throw NoDigitException
	public static boolean hasDigit​(String password) throws NoDigitException{
		
		for(int i = 0; i < password.length(); i++) {
			
			if(Character.isDigit(password.charAt(i)))
				return true;
		}
		throw new NoDigitException();
		
	}
	
	//Tests whether password contains between 6 to 9 characters. If not it will return false
	public static boolean hasBetweenSixAndNineChars​(String password) {
	
		if(password.length() >= 6 && password.length() <= 9)
			return true;
		else 
			return false;
	}

	//Tests whether password is the same as passwordConfirm. If not it will return false
	public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm) {
		
		if(password.length() != passwordConfirm.length())
			return false;
		
		for(int i = 0; i < password.length(); i++) {
			
			if(password.charAt(i) != passwordConfirm.charAt(i))
				return false;
		}
		
		return true;
	}

	//Tests whether password is the same as passwordConfirm. If not it will throw UnmatchedException
	public static void comparePasswords​(String password, String passwordConfirm) throws UnmatchedException {
		
		if(password.length() != passwordConfirm.length())
			throw new UnmatchedException();
		
		for(int i = 0; i < password.length(); i++) {
			
			if(password.charAt(i) != passwordConfirm.charAt(i))
				throw new UnmatchedException();
		}
		
	}
	
	//Tests whether password is valid and passes all the methods without any exception being thrown
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
	                                                       NoDigitException, InvalidSequenceException, NoSpecialCharacterException{
		
		if(!isValidLength​(password))
			return false;
		
		if(!hasUpperAlpha​(password))
			return false;
		
		if(!hasLowerAlpha​(password))
			return false;
		
		if(!hasDigit​(password))
			return false;
		
		if(!NoSameCharInSequence​(password))
			return false;
		
		if(!hasSpecialChar​(password))
			return false;
		
		return true;
	}
	                                                              
	//Puts all the invalid passwords in the passwords arrayList into a new arrayList along with the exception. The invalid arrayList is then returned
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords){
		
		ArrayList<String> invalid = new ArrayList<String>();
		
		for(int i = 0; i < passwords.size(); i++) {
			
			try {
				
				isValidPassword​(passwords.get(i));
				
			}catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | 
					InvalidSequenceException | NoSpecialCharacterException e) {
				
				invalid.add(passwords.get(i) +" "+ e.getMessage());
			}
				
		}
		
		return invalid;
	}	

	
}
