import java.util.Scanner;

public class Calculator {

  private Scanner scan;
  int choice = 0;
  float num1 = 0, num2 = 0;

  public Calculator() {

    this.runTheCalc();

  }

  public void runTheCalc() {

    
    while(true) {

        boolean check  = this.operationRequest();
        if( check == true ) {
            if( choice == 5 ) {
                break;
            } else {

                System.out.println("Enter your two numbers.");
                try {
                    num1 = scan.nextFloat();
                    try {
                        num2 = scan.nextFloat();
                    } catch( Exception e) {
                        System.err.println("Wrong input. Try again. \n");
                        continue;
                    
                    }
                } catch(Exception e) {
                    System.err.println("Wrong input. Enter again. \n");
                    continue;
                }

                if( num2 == 0 && choice == 4 ) {
                    System.err.println("Cannot divide by zero. Try again. \n");
                    continue;
                }
                float res = this.operate(num1, num2, choice);
                System.out.println("result is: " + res + " \n");
            }
        
            //break;
        }
    }

  }

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
    } catch(Exception e) {

        System.err.println("Wrong Input.");
        System.err.println("Please try again. ");
        System.err.println("");
        this.resetSettings();
        return false;
        //this.operationRequest();

    } 
    if( choice > 5) {
      System.err.println("Wrong Input.");
      System.err.println("Please try again. ");
      System.err.println("");
      this.resetSettings();
      return false;
    }

    return true;
 

  }

  public void resetSettings() {
    
    num1 = 0;
    num2 = 0;
    choice = 0;
    scan = new Scanner(System.in);

  }
  
  public float operate(float num1, float num2, int choice) {

    if( choice == 1 ) { return num1+num2; }
    else if( choice == 2 ) { return num1-num2; }
    else if( choice == 3 ) { return num1*num2; }
    else { return num1/num2; }

  }


  public static void main(String[] args) {

    Calculator calc = new Calculator();
    System.out.println("DONE");
    
  }




}
