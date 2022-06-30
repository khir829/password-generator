import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean flag;
		int i = 0;
		String o = null;
		Scanner scan = new Scanner(System.in);
		/*
		 * The program will loop until the user decides to terminate it by entering 'No'
		 * at the end. The program will do the following:
		 * 
		 * 1- The the length of the password is first determined by the user.
		 * 
		 * 2- The use of capital letters in the password is determined by the user.
		 * 
		 * 3- The use of numbers in the password is determined by the user.
		 * 
		 * 4- The use of special characters in the password is determined by the user.
		 * 
		 * 5- The randomly generated password is output.
		 * 
		 * 6- The program will prompt the user to continue making more passwords or
		 * terminate the program.
		 * 
		 */
		do {

			do { // Length of the password is determined
				try {
					Scanner scanner1 = new Scanner(System.in);
					System.out.print("Enter a password length that is 4 or more characters: ");
					i = scanner1.nextInt();
					if (i < 4) {
						System.out.print("Input value is less than 4. ");
					}
					flag = false;
				} catch (Exception e) {
					System.out.print("Enter only integer values. ");
					flag = true;
				}

			} while (flag || i < 4);

			Builder builder = new Builder(i + 1);

			do { // The use of capital letters in the password is determined

				String affirm;
				Scanner scanner2 = new Scanner(System.in);
				System.out.print("Is a capital letter required in your password? Y/N: ");
				affirm = scanner2.nextLine();
				affirm = affirm.toLowerCase();
				if (affirm.equals("y") || affirm.equals("yes")) {
					builder.setUpper();
					flag = false;
				} else if (affirm.equals("n") || affirm.equals("no")) {
					flag = false;
				} else {
					System.out.print("Please enter Yes or No. ");
					flag = true;
				}
			} while (flag);

			do { // The use of numbers in the password is determined
				String affirm;
				Scanner scanner3 = new Scanner(System.in);
				System.out.print("Is a number required in your password? Y/N: ");
				affirm = scanner3.nextLine();
				affirm = affirm.toLowerCase();
				if (affirm.equals("y") || affirm.equals("yes")) {
					builder.setNumber();
					flag = false;
				} else if (affirm.equals("n") || affirm.equals("no")) {
					flag = false;
				} else {
					System.out.print("Please enter Yes or No. ");
					flag = true;
				}
			} while (flag);

			do { // The use of special characters in the password is determined
				String affirm;
				Scanner scanner4 = new Scanner(System.in);
				System.out.print("Is a special character required in your password? Y/N: ");
				affirm = scanner4.nextLine();
				affirm = affirm.toLowerCase();
				if (affirm.equals("y") || affirm.equals("yes")) {
					builder.setSpecial();
					flag = false;
				} else if (affirm.equals("n") || affirm.equals("no")) {
					flag = false;
				} else {
					System.out.print("Please enter Yes or No. ");
					flag = true;
				}
			} while (flag);

			// Generate password and prompt user to continue generating passwords or quit
			Password password = new Password(builder);
			System.out.println("This is your generated password: " + password.getPasswordFinal());
			System.out.print("\nPress Enter to generate another password or enter 'No' to terminate program: ");
			o = scan.nextLine();
			o = o.toLowerCase();
			System.out.println();
		} while (o instanceof String && !o.equals("no"));

	}
}
