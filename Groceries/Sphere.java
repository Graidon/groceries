public class Sphere extends ShoppingCart {
  //Instance variables, assigned in Zero Argument Constructor
  private double diameter;
  private int numberOrdered;

  private static final double pi = 22/7; //Since FINAL cannot be assigned anywhere else
  //22/7 Histrically used as a value of pi
  //Slightly bigger than real value for error of Sphere not being round
  //Also copy digits from website
  //Also use API
  //https://www.programmableweb.com/api/pi
  //Dealing with Pi: nonterminating, nonrepeating (not a ratio)
  //"How smart is your calculator?"
  private final double radius;
  private double singleSphereVolume;
  private double singleSphereCubeVolume;
  private int spheresPerRow; //Items per row
  private int spheresPerFlat; //Spheres per flat
  private int spheresPerBox; //Spheres per flat
  //Use isometric paper to visualize these calculations

  //Variables for how Spheres are beign packaged
  private int numBoxes; //Adding Number of full boxes needed for shipping
  private int numFlats; //Adding Number of full "flats" needed for shipping
  private int numRows; //Adding Number of full "rows" needed for shipping

  //Variables for boxing Spheres
  private int sphereNumberCalculated; //Needed for cascading problem solution
  private int sphereLeftover; //Needed for cascading problem

  //Zero Argument Constructor

  //Getters and Setters Methods
    //Getters: instance Variable cannot be changed by outside class or program
  //public double getTotalCost () {return totalcost;}

  //Processor Methods

  //Multi-argument Constructor
  public Sphere (int userEntered, double diameter1) {
     //Changing Variables to mimic packing an object
     //Caution: every time an order is called, the order object must deliever the
         //diameter, from appples or oranges
     //Note: perspective is from an object, action is one item at a time which might be confusing
     super();
     //Assigning Instance Variables
     this.numberOrdered = this.sphereNumberCalculated = userEntered;
     this.diameter = diameter1;
     this.radius = this.diameter / 2;
     this.singleSphereVolume = (4/3) * pi * this.radius * this.radius * this.radius;
     this.singleSphereCubeVolume = this.diameter * this.diameter * this.diameter;
     this.spheresPerRow = (int) Information.box1Width / (int) this.diameter; //Items per row
     this.spheresPerFlat = (int) Information.box1Length / (int) this.diameter * this.spheresPerRow; //Spheres per flat
     this.spheresPerBox = (int) Information.box1Height / (int) this.diameter * this.spheresPerFlat; //Spheres per flat
     this.numBoxes = 0;
     this.numFlats = 0;
     this.numRows = 0;
     //Using the Instance Variables
     while (this.sphereNumberCalculated >= this.spheresPerBox) { //Check if we need 1 box or more
       this.numBoxes += 1; //Same as numBoxes = numBoxes +1
       this.sphereNumberCalculated -= this.spheresPerBox; //Same as sphereNumberCalculated = sphereNumberCalculated - spheresPerBox
     } //End of WHILE for Full boxes
     while (this.sphereNumberCalculated >= this.spheresPerFlat) { //Check if we need 1 flat or more
       this.numFlats += 1;
       this.sphereNumberCalculated -= this.spheresPerFlat;
     } //End of WHILE for Full flats
     while (this.sphereNumberCalculated >= this.spheresPerRow) { //Check if we need 1 row or more
       this.numRows += 1;
       this.sphereNumberCalculated -= this.spheresPerRow;
     } //End of WHILE for Full boxes
     this.sphereLeftover = this.sphereNumberCalculated; //Number of spheres left in less than a row
  } //End of Multi-argument Constructor

//toString() for Printing Results of Class to Console
public String toString() {
  return "Boxing Guide: \nNumber Ordered: " + this.numberOrdered + "\n" +
         "Number of Boxes Needed: " + (numBoxes + 1) + "\n" +
         "\tNumber of Full Boxes: " + numBoxes + "\n" +
         "\tGuide for last partial box: " + numFlats + " full flats, " + numRows +
         " full row(s) on last flat, " + this.sphereLeftover + " in last row.";
}

} //End of Sphere Class
