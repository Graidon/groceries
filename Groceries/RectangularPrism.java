public class RectangularPrism extends ShoppingCart {

  private double diameter;
  private int numberOrdered;

  private static final double pi = 22/7;
  private final double radius;
  private double singleSphereVolume;
  private double singleSphereCubeVolume;
  private int spheresPerRow;
  private int spheresPerFlat;
  private int spheresPerBox;

  private int numBoxes;
  private int numFlats;
  private int numRows;

  private int sphereNumberCalculated;
  private int sphereLeftover;

  public Sphere (int userEntered, double diameter1) {

     super();

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
         " full row(s) on last flat, " + this.sphereLeftover + " apples in last row.";
}

} //
