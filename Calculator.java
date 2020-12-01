//package calc;

/**
 * Name of the file: Calculator.java
 * Name: Saman Nabavi
 * Explanation: A simple calculator that recieves two number from the user
 *              and the operation to do on them, then prints the result
 */

import java.util.Scanner;
import java.lang.ArithmeticException;

public class Calculator {

	private Scanner scan; // for getting the input from user
	int choice = 0; // what operation to do
	float num1 = 0, num2 = 0; // user's two numbers



    /**
	 * Name : runTheCalc 
	 * @param : None 
	 * @return : void 
	 * Explanation: Gets the user input
	 * and uses operate method to perform an operation on the inputs
	 */
	public void runTheCalc() {

		while (true) {

			boolean check = this.operationRequest();// user's operator was successfully recieved
			if (check == true) {
				if (choice == 5) { // exit from the program
					break;
				} else {

					System.out.println("Enter your two numbers.");
					try {
						num1 = scan.nextFloat();
						try {
							num2 = scan.nextFloat();
						} catch (Exception e) {
							System.err.println("Wrong input. Try again. \n");
							continue;

						}
					} catch (Exception e) {
						System.err.println("Wrong input. Try again. \n");
						continue;
					}

					float res = this.operate(num1, num2, choice);
					System.out.println("result is: " + res + " \n");

				}

				// break;
			}
		}

	}

	/**
	 * Name : operationRequest 
	 * @param : None
	 * @return : boolean, indicates if user correctly followed the instructions
	 * Explanation: This method resets the settings and ask the user for the which
	 *              operation to do. It catches all wrong inputs. If the user's 
	 *              inputs are correct, it returns True, and False otherwise.
	 */
	public boolean operationRequest() {

		this.resetSettings();
		System.out.println("Please follow the instruction");
		System.out.println("Press 1 for addition");
		System.out.println("Press 2 for subtraction");
		System.out.println("Press 3 for multipication");
		System.out.println("Press 4 for division");
		System.out.println("Press 5 for exit");
		try {
			this.choice = scan.nextInt();
		} catch (Exception e) {

			System.err.println("Wrong Input.");
			System.err.println("Please try again. ");
			System.err.println("");
			this.resetSettings();
			return false;
			// this.operationRequest();

		}
		if (choice > 5) {
			System.err.println("Wrong Input.");
			System.err.println("Please try again. ");
			System.err.println("");
			this.resetSettings();
			return false;
		}

		return true;

	}

	/**
	 * Name: resetSettings
	 * @param : None
	 * @return : void
	 * Explanation: It resets our default values to get the new ones later
	 */
	public void resetSettings() {

		num1 = 0;
		num2 = 0;
		choice = 0;
		scan = new Scanner(System.in);

	}

	/**
	 * Name : operate 
	 * @param num1 : float, first input
	 * @param num2 : float, second input
	 * @param choice : int, indicates the operation
	 * @return : float, the result of the operation
	 */
	public float operate(float num1, float num2, int choice) {

		if (choice == 1) {
			return num1 + num2;
		} else if (choice == 2) {
			return num1 - num2;
		} else if ( choice == 3) {
			return num1 * num2;
		} else {
			return num1 / num2;
		}

	}

	/**
	 * Name: main
	 * @param args : no params needed
	 * @return : void
	 * Explanation : It just new a Calculator object.  
	 */
	public static void main(String[] args) {

		Calculator calc = new Calculator();
        calc.runTheCalc();
		System.out.println("--------DONE--------");

	}

}
