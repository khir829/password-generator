import java.util.Random;

public class Password {
	private String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	private String specialCharacters = "!@#$";
	private String numbers = "1234567890";
	private Random random = new Random();
	private String passwordFinal;
	StringBuffer sb = new StringBuffer();

	public Password(int length) {
		String[] password = new String[length];

		for (int i = 0; i < length - 1; i += 4) {
			int posLow = random.nextInt(lowerCaseLetters.length());
			password[i] = lowerCaseLetters.substring(posLow, posLow + 1);
		}

		for (int i = 1; i < length - 1; i += 4) {
			int posUp = random.nextInt(capitalCaseLetters.length());
			password[i] = capitalCaseLetters.substring(posUp, posUp + 1);
		}

		for (int i = 2; i < length - 1; i += 4) {
			int posNumber = random.nextInt(numbers.length());
			password[i] = numbers.substring(posNumber, posNumber + 1);
		}

		for (int i = 3; i < length - 1; i += 4) {
			int posSpecial = random.nextInt(specialCharacters.length());
			password[i] = specialCharacters.substring(posSpecial, posSpecial + 1);
		}

		for (int i = 0; i < password.length - 1; i++) {
			sb.append(password[i]);
		}

		passwordFinal = sb.toString();

	}

	public static class Builder {
		private int length;
		private boolean upper = false;
		private boolean number = false;
		private boolean special = false;
		private int numberOfTrue = 0;

		public Builder(int length) {
			this.length = length;
		}

		public Builder addUpper() {
			this.upper = true;
			numberOfTrue++;
			return this;
		}

		public Builder addNumber() {
			this.number = true;
			numberOfTrue++;
			return this;
		}

		public Builder addSpecial() {
			this.special = true;
			numberOfTrue++;
			return this;
		}
	}

	public String getPasswordFinal() {
		return passwordFinal;
	}

}
