public class Apple extends Sphere {

  private int numberOrdered;
  private double totalAppleCost;

  public double getTotalCost () {
    return this.totalAppleCost = Information.appleCost * this.numberOrdered;
  }

  public Apple (int userEntered, double diameter) {
    super( userEntered, diameter );
    this.numberOrdered = userEntered;
  }

  public String toString() {
    return super.toString() + "\n";
  }
}
