import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("This program encrypts and decrypts messages " +
				"using the Caesar Cipher.");
		System.out.print("Would you like to encode or decode a message?  ");
		String option = in.nextLine().toLowerCase();

		if (option.equals("encode") || option.equals("decode")) {
			System.out.printf("Enter a string to %s:  ", option);
			String message = in.nextLine().toLowerCase();
			iterateMessage(message, option);
		} else {
			System.out.println("Invalid input, options are \"encode\" " +
					"and \"decode\"");
		}

		in.close();
	} // void main(String[] args)

	public static void iterateMessage(String message, String option) {
		int start;
		char[] newMessage = new char[message.length()];

		// Iterate through letters within message
		for (int key = 0; key < 26; key++) {
			System.out.printf("%d:  ", key);
			for (int index = 0; index < message.length(); index++) {
				// set keyChar according to position within message
				start = message.charAt(index) - 'a';

				if (start < 0 || start > 25) {
					System.out.println("Message must contain only lowercase " +
							"characters.");
					return;
				} else if (option.equals("encode")) {
					//System.out.printf("%c", encode(start, keyChar));
					newMessage[index] = encode(start, key);
				} else if (option.equals("decode")) {
					//System.out.printf("%c", decode(start, keyChar));
					newMessage[index] = decode(start, key);
				} else {
					System.out.println("Error, incorrect option. " +
							"Terminating...");
					return;
				} // if/else
			}
			System.out.println(new String(newMessage));
		}
	} // void iterateMessage(String message, String key, String option)

	public static char encode(int start, int key) {
		int endToInt = (start + key) % 26;
		return (char) (endToInt + 'a');
	} // encode(int start, int keyChar)

	public static char decode(int start, int key) {
		int endToInt = (start - key);
		if (endToInt < 0)
			endToInt += 26;
		return (char) (endToInt + 'a');
	} // encode(int start, int keyChar)

} // class CaesarCipher
