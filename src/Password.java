import java.util.ArrayList;
import java.util.Random;

public class Password {
	private String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	private String specialCharacters = "!@#$";
	private String numbers = "1234567890";
	private Random random = new Random();
	private ArrayList<String> pass = new ArrayList<String>();
	private String passwordFinal;
	private StringBuffer sb = new StringBuffer();

	/**
	 * This constructor takes in a builder class data type and outputs a randomly
	 * generated password
	 * 
	 * @param builder the details of what the password should contain
	 */
	public Password(Builder builder) {

		for (int i = 0; i < builder.getLength() - (1 + builder.getNumberOfTrue()); i++) {
			addToPassword(lowerCaseLetters);
		}

		if (builder.isUpper()) {
			addToPassword(capitalCaseLetters);

		}
		if (builder.isNumber()) {
			addToPassword(numbers);
		}
		if (builder.isSpecial()) {
			addToPassword(specialCharacters);
		}

		for (String s : pass) {
			sb.append(s);
		}
		passwordFinal = sb.toString();
	}

	public void addToPassword(String characters) {
		int pos = random.nextInt(characters.length());
		pass.add(characters.substring(pos, pos + 1));
	}

	public String getPasswordFinal() {
		return passwordFinal;
	}

}
