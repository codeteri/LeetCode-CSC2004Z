package CHALLENGE3UCT;
public class ShipDetails {
  // a ship has details a1 b1 c1 x1 y1

  private double a = 0.0;
  private double b = 0.0;
  private double c = 0.0;
  private double x = 0.0;
  private double y = 0.0;
  private double x_intersect = 0.0;
  private double y_intersect = 0.0; 

  public ShipDetails(double newA,double newB, double newC, double newX, double newY){
    this.a = newA;
    this.b = newB;
    this.c = newC;
    this.x = newX;
    this.y = newY;
  }

  public String intersect(ShipDetails otherShip) {
    String intersectionPoint = "(0.0, 0.0)";

    // Calculate intersection coordinates
    double x_intersect = ((this.b * otherShip.c - otherShip.b * this.c) / (this.a * otherShip.b - otherShip.a * this.b));
    double y_intersect = ((otherShip.a * this.c - this.a * otherShip.c) / (this.a * otherShip.b - otherShip.a * this.b));

    // Update intersect coordinates for both ships
    this.x_intersect = x_intersect;
    this.y_intersect = y_intersect;
    otherShip.x_intersect = x_intersect;
    otherShip.y_intersect = y_intersect;

    intersectionPoint = "(" + String.format("%.1f", x_intersect) + ", " + String.format("%.1f", y_intersect) + ")";
    return intersectionPoint;
}

  public double distance() {
      double distance = Math.sqrt(Math.pow((x - x_intersect), 2) + Math.pow((y - y_intersect), 2));
      return distance;
  }
}