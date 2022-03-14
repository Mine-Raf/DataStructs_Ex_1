import java.util.Objects;

public class Point {
    public static final int N_MAX= 2^18; //Max value of x/y
    private int x;
    private int y;

    /**
     * Constructor of this class. Requires 2 integers, one for variable x and the other for y
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x= x;
        this.y= y;
    }

    /**
     *
     * @return x value of point
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return y value of point
     */
    public int getY() {
        return y;
    }

    /**
     * Check if two points have the same x and y values
     * @param p The point to compare
     * @return True if values are equal, otherwise false
     */
    public boolean equals(Point p) {
        return x == p.x && y == p.y;
    }

    /**
     * Check if two points have the same x and y values and calculate the number of comparisons made
     * @param p The point to compare
     * @return True if values are equal, otherwise false
     */
    public boolean equalsWithStatistics(Point p) {
        return Statistics.increaseNumberOfComparisons() && (x == p.x) && Statistics.increaseNumberOfComparisons() && (y == p.y);
    }

    public String toString() {
        return new String("x:"+ this.x+ " "+ "y:"+ this.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
