import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean flag;
		int i = 0;
		String o = null;
		Scanner scan = new Scanner(System.in);

		do {
			do {
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
			Builder builder = new Builder(i);
			do {
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
			do {
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
			do {
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

			Password password = new Password(builder);
			System.out.println("This is your generated password: " + password.getPasswordFinal());
			System.out.print("\nPress Enter to generate another password or enter 'No' to terminate program: ");
			o = scan.nextLine();
			o = o.toLowerCase();
			System.out.println();
		} while (o instanceof String && !o.equals("no"));

	}
}
