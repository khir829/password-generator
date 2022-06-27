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
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter a password length that is 4 or more characters: ");
					i = sc.nextInt();
					if (i < 4) {
						System.out.print("Input value is less than 4. ");
					}
					flag = false;
				} catch (Exception e) {
					System.out.print("Enter only integer values. ");
					flag = true;
				}

			} while (flag || i < 4);

			Password password = new Password(i + 1);
			System.out.println("This is your generated password: " + password.getPasswordFinal());
			System.out.print("\nPress Enter to generate another password or enter 'No' to terminate program: ");
			o = scan.nextLine();
			o = o.toLowerCase();
			System.out.println();
		} while (o instanceof String && !o.equals("no"));

	}
}
