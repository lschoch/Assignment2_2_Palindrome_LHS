import java.util.*;
/**
 * A class to test whether a string of characters is a palindrome. 
 * First, a series of strings is tested and the results are printed. 
 * Then, the user is given the opportunity to enter their own strings 
 * to be tested." Uses the Stack class from java.util. 
 * 
 * @author Lawrence Schoch
 * @version 1.0 CS215 Spring 2022
 */
public class Pallindrome_Tester {

	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		String pal = "";
		String again = "y";
		boolean isPalindrome = true;
		
		System.out.println("  -------- TESTING FOR PALINDROMES --------\n");
		
		String[] testArray = {"po p *", "race car", "```aCC*a   ", "not a palindrome"};
		for (int i = 0; i<testArray.length; i++) {
			isPalindrome = Test(testArray[i]);
			if (isPalindrome) {
				System.out.println(" Yes, that is a palindrome!");
			}
			else {
				System.out.println(" No, that is not a palindrome.");
			}
		}
		
		System.out.print("\n  Try it.");
		
		while (again.toLowerCase().equals("y")) {
			System.out.println(" Enter a palindrome prospect: ");
			pal = scan.nextLine();
			isPalindrome = Test(pal);

			if (isPalindrome) {
				System.out.println(" Yes, that is a palindrome!");
			}
			else {
				System.out.println(" No, that is not a palindrome.");
			}
			System.out.println("  Try again? (Y/N)");
			again = scan.nextLine();
		}// end while
		System.out.println("  Good-bye.");
		scan.close();
	}// end main
	
	/**
	 * Method to test whether the input string is a palindrome.
	 * @param pal The string to be tested.
	 * @return True if the string is a palindrome, False if not.
	 */
	public static boolean Test(String pal) {
		String fs = "";
		boolean isPal = true;
		// Using the Stack class of java.util
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		for (int i=0; i<pal.length(); i++) {
			int n = pal.charAt(i);
			// Accept only upper and lower case letters
			if ((n>=97 && n<=122) || (n>=65 && n<=90)) {
				fs+= pal.charAt(i);
			}
		}
		fs = fs.toLowerCase();
		System.out.print("  Testing \"" + pal + "\" (filtered = \"" + fs + "\"):");
		int len = fs.length();
		for (int i=0; i<len; i++) {
			stack1.push(fs.charAt(i));
			stack2.push(fs.charAt(len-i-1));
		}
		for (int i=0; i<len; i++)
			if (!(stack1.pop().equals(stack2.pop()))) {
				isPal = false;
				break;
			}
		if (!stack1.empty() || !stack2.empty())
			isPal = false;
		return isPal;
	}// end Test
	
}// end class
