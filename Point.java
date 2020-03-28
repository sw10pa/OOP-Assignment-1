public class Point {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point other) {
		x = other.x;
		y = other.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Point shiftedPoint(double dx, double dy) {
		return new Point(x + dx, y + dy);
	}

	public double distance(Point other) {
		double dx = Math.abs(x - other.x);
		double dy = Math.abs(y - other.y);
		return Math.sqrt(dx * dx + dy * dy);
	}

	public String toString() {
		return x + " " + y;
	}

	public boolean equals(Object object) {
		if (!(object instanceof Point)) return false;
		Point other = (Point)object;
		return (other.x == x && other.y == y);
	}

}
