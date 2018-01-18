public class Chocolate extends RectangularPrism {

  private int numberOrdered;
  private double totalChocolateCost;

  public double getTotalCost () {
    return this.totalChocolateCost = Information.chocolateCost * this.numberOrdered;
  }

  public Apple (int userEntered, double diameter) {
    super( userEntered, diameter );
    this.numberOrdered = userEntered;
  }

  public String toString() {
    return super.toString() + "\n";
  }
}
