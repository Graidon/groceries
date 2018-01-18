public class Orange extends Sphere {
  //Instance variables, assigned in Zero Argument Constructor
  private int numberOrdered; //Needed for cascading problem solution
  private double totalOrangeCost;

  //Zero Argument Constructor

  //Getters and Setters Methods
  //Getters: instance Variable cannot be changed by outside class or program
  public double getTotalCost () { //returning appleCost from Zero Argument Constructor
    return this.totalOrangeCost = Information.orangeCost * this.numberOrdered; //
  } //End of getTotalCost

  //Processor Methods

  //multi-argument Constructor
  public Orange (int userEntered, double diameter) {
    super( userEntered, diameter);
    this.numberOrdered = userEntered;
  } //End of ApplesOrdered multi-argument constructor

  //toString() for Printing Results of Class to Console
  public String toString() { //For JOptionPane and Println
    return super.toString() + "\n";
  } //End of toString()

} //End of Orange Class
