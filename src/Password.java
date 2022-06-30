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
			int posLow = random.nextInt(lowerCaseLetters.length());
			pass.add(lowerCaseLetters.substring(posLow, posLow + 1));
		}

		if (builder.isUpper()) {
			int posUp = random.nextInt(capitalCaseLetters.length());
			pass.add(capitalCaseLetters.substring(posUp, posUp + 1));
		}
		if (builder.isNumber()) {
			int posNumber = random.nextInt(numbers.length());
			pass.add(numbers.substring(posNumber, posNumber + 1));
		}
		if (builder.isSpecial()) {
			int posSpecial = random.nextInt(specialCharacters.length());
			pass.add(specialCharacters.substring(posSpecial, posSpecial + 1));
		}

		for (String s : pass) {
			sb.append(s);
		}
		passwordFinal = sb.toString();
	}

	public String getPasswordFinal() {
		return passwordFinal;
	}

}
