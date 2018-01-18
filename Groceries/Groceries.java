import java.util.Scanner; //Must import this
import javax.swing.JOptionPane;

public class Groceries {

   public static void main(String[] args)
   throws NumberFormatException
   {

   //Enter a pre-authorization number, often verified through a credit card
   String preAuth_string1 = JOptionPane.showInputDialog ("Pre-authorization " +
            "for the amount of money you might spend.\nPlease enter only dollars " +
            "and cents, \nFor Example: \'\' 14.50 \'\'");
   //Double preAuth_double = 0.00;
   double preAuth = Information.checkDoubleEntry(preAuth_string1);
   //Checking for Zero value
   Boolean preAuthB = Information.checkZeroEntry (preAuth);
   //Action if Pre-Authorization Amount is zero
   if ( preAuthB == true ) { //Checks to see if the try-catch worked
     System.out.println ("User entered zero $");
     JOptionPane.showMessageDialog (null, "A Pre-authorization amount has not " +
                "been entered. Please correct this issue and restart the " +
                "program.", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
     System.exit(0);
   } else {
     System.out.println ("User entered $" + preAuth);
     JOptionPane.showMessageDialog (null, "I understand you have entered " +
               Information.printMoney(preAuth), "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
   }

   //double orangeCost = 2.315468; //notice the rounding in JOptionPane
   //double chocolateBoxCost = 6.1235874; //notice the rounding in JOptionPane
   System.out.println ("User enters a number of apples");
   String apples_string = JOptionPane.showInputDialog ("Let's fill the box.\n" +
          "Please enter how many whole Apples you would like.\n" +
          "          Apples cost: " + Information.printMoney( Information.appleCost ) +
          " per apple");
  int appleNumber = Information.checkIntEntry(apples_string);
  System.out.println ("User entered: " + appleNumber + " apples.\n");

  System.out.println ("User enters a number of oranges");
  String oranges_string = JOptionPane.showInputDialog ("Please enter how many " +
                          "whole oranges you would like.\n" +
                          "          Oranges cost: " + Information.printMoney(Information.orangeCost) + "" +
                          " per orange");
  int orangeNumber = Information.checkIntEntry(oranges_string);
  System.out.println ("User entered: " + orangeNumber + " orange.\n");

  System.out.println ("User enters a number of boxes of chocolate");
  String chocolate_string = JOptionPane.showInputDialog ("Please enter how many " +
                          "whole boxes of chocolate you would like.\n" +
                          "          Boxes of Chocolate cost: " +
                          Information.printMoney(Information.chocolateBoxCost) +
                          " per box of chocolate");
  int chocolateNumber = Information.checkIntEntry(chocolate_string);
  System.out.println ("User entered: " + chocolateNumber + " chocolate.\n");

  //Calulating Total Cost
  Double moneyLeft = preAuth - ( ( appleNumber * Information.appleCost ) +
         (orangeNumber * Information.orangeCost) + (chocolateNumber * Information.chocolateBoxCost));
  System.out.println ("Pre-authorization is: " + preAuth +
                      "\nMoney Left is: " + moneyLeft);
  //Is there a rounding error? Which variable type takes preference?
  //Integers are automatically casted as doubles or floats
  double totalBill = 0.0; //Compiler error if not Declared and Assigned before IF
  //Check if moneyLeft is <= Zero
  Boolean moneyLeftB = Information.checkLessZeroEntry (moneyLeft);
    //Action if money left over from bill is less than zero
  if ( moneyLeftB == true ) { //Not <= because then you have no change
    JOptionPane.showMessageDialog (null, "I am sorry:\n" +
               "The pre-authoirzation amount entered will not pay for the " +
               "amount of groceries.\nPlease check with your bank and restart " +
               "the program.", "WARNING MESSAGE", JOptionPane.WARNING_MESSAGE);
    System.exit(0);
  } else {
    totalBill = (appleNumber * Information.appleCost ) + (orangeNumber * Information.orangeCost) +
                       (chocolateNumber * Information.chocolateBoxCost);
  }

  //Final Check for Fruit and Choclate Entered by User
  JOptionPane.showMessageDialog (null, "I understand you have entered:\n" +
             appleNumber + " Apples\n" +
             orangeNumber + " Oranges\n" +
             chocolateNumber + " Boxes of Chocolate\n" +
             "\nThe Total Bill for the items is: " + Information.printMoney(totalBill) + "" +
             "", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);

  double diameter = Information.appleDiameter;
  Apple apples1 = new Apple ( appleNumber, diameter ); //Creating object with Apples ordered
  System.out.println(apples1); //Console Apple Order
  System.out.println("The total bill for Apples is: " + Information.printMoney(apples1.getTotalCost() ) );
  diameter = Information.orangeDiameter;
  Orange oranges1 = new Orange (orangeNumber, diameter); //Creating object with Oranges ordered
  System.out.println(oranges1); //Console Apple Order
  System.out.println("The total bill for Oranges is: " + Information.printMoney(oranges1.getTotalCost() ) );

  //Able to make as many object as needed, and see them in console, as needed

  } //End of static void main
} //End of Groceries Class
