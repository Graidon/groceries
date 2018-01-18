import java.util.Scanner; //Must import this
import javax.swing.JOptionPane;

public class Information {

  //Instance variables from Recieving Departement
  public static final double appleCost = 1.3465;
  public static final double appleDiameter = 7.2;
  public static final double orangeCost = 2.315468;
  public static final double orangeDiameter = 7.2;
  public static final double chocolateBoxCost = 6.1235874;
  public static final double chocolateBoxWidth = 5;
  public static final double chocolateBoxLength = 5;
  public static final double chocolateBoxHeight = 5;
  //All values statistically verified with Normal Distribution
  //Easy caliper or ruler measures

  //Instance Variables from Box Company
  //Variables about the box to pack Spheres in, conversion from inches
  public static final double box1Width = 1.5 * 12 * 2.54; //Traditional math definition (smallest in 2D)
  public static final double box1Length = 2.0 * 12 * 2.54; //Traditional math definition (longest in 2D)
  public static final double box1Height = 1 * 12 * 2.54; //Traditional math definition (3D Dimension)


  public static String printMoney (double money) {
    String pM = String.format ("$%.2f", money);
    System.out.println("Current Money output is " + pM);
    return pM;
  }

  public static double checkDoubleEntry (String userNumber) {
    userNumber = userNumber.trim(); //User enters SPACES before or after, debugging
    double preAuth = 0.0; //Default value for pre-authroization amount from User
    double preAuth_double = 0.0; //Declare and Assign for Try-Catch
    try {
        preAuth_double = Double.parseDouble(userNumber);
    }
    catch (NumberFormatException ne1) {
        System.out.println ("User has failed first attempt at entering Pre-authorization");
        String preAuth_userNumber2 = JOptionPane.showInputDialog ("Please " +
                "enter a dolars and cents value\n" +
                "For example: \' 14.50 \'");
        try {
          preAuth_double = Double.parseDouble(preAuth_userNumber2);
        }
        catch (NumberFormatException ne2) {
          System.out.println ("User failed a second attempt for Pre-authorization");
          JOptionPane.showMessageDialog (null, "Please restart the program", "" +
                      "Second Attempt Failed", JOptionPane.ERROR_MESSAGE);
          System.exit(0);
        }
    }
  return preAuth = preAuth_double;
  }

  public static int checkIntEntry (String userNumber1) {
    userNumber1 = userNumber1.trim(); //User enters SPACES before or after, debugging
    String userNumber2 = new String(); //Creating new String Object different than numbers
    userNumber2 = ""; //need to assign for IF inside Try-Catch
    int item_int = 0; //default value for fruit
    double item_double = 0.0; //used to catch user entry if value has a decimal
    try { //note: once a line fails, rest of try will not run b/c line needs "catching"
        item_double = Double.parseDouble(userNumber1);
        //If parseDouble fails, user probably entered a string
        //If parseDouble passes, user probably entered an integer
        item_double = 0.0; //reset this value and further test userNumber1
    }
    catch (NumberFormatException ne3) {
        System.out.println ("User has failed first attempt at entering item number");
        userNumber2 = JOptionPane.showInputDialog ("Please enter how many " +
                "whole items.\nFor example: \' 3 \'");
        try {
          item_double = Double.parseDouble(userNumber2);
          userNumber1 = userNumber2;
          item_double = 0.0; //reset this value and further test userNumber1
        }
        catch (NumberFormatException ne4) {
          System.out.println ("User failed a second attempt for " +
                             "an integer value of items.");
          JOptionPane.showMessageDialog (null, "Please restart the program and " +
                     "enter a whole number of items, as a whole number.", "ERROR " +
                     "MESSAGE", JOptionPane.ERROR_MESSAGE);
          System.exit(0);
        }
    }
    try {
      System.out.println ("User entered a double or int for number of items.");
      item_int = Integer.parseInt(userNumber1);
      //If parseInt fails, user probably entered a decimal
      System.out.println ("User entered an int for number of items.");
    }
    catch (NumberFormatException ne6) {
      System.out.println ("User entered a decimal value for the number of items.");
      userNumber2 = JOptionPane.showInputDialog ("It seems you have entered " +
              " a decimal number.\nPlease enter a number of whole items.\n" +
              "For example: \' 3 \'");
      try {
        item_int = Integer.parseInt(userNumber2);
        item_double = 0.0;
      }
      catch (NumberFormatException ne7) {
        System.out.println ("User failed a second attempt for " +
                           "the whole number of items.");
        JOptionPane.showMessageDialog (null, "Please restart the program and " +
                   "enter a whole number of items, as a whole number.", "ERROR " +
                   "MESSAGE", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
      }
    }

    System.out.println ("Tracking Variables of Procedure for debugging");
    //Output all the variales to check values and reset if necessary
    System.out.println (item_int);
    System.out.println (item_double);
    System.out.println (userNumber1);
    System.out.println (userNumber2);
    return item_int;
  }

  public static Boolean checkZeroEntry(double zero) {
    Boolean zeroB; //Declaration
    if ( zero == Math.abs(0.0) ) {
      zeroB = true;
    } else {
      zeroB = false;
    }
  return zeroB;
  }

  public static Boolean checkLessZeroEntry (double lessThanZero) {
    Boolean zeroB; //Declaration
    if ( lessThanZero < Math.abs(0.0) ) {
      zeroB = true;
    } else {
      zeroB = false;
    }
  return zeroB;
  }

} // End of Information Class
