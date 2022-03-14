import java.io.IOException;
import java.util.Random;

public class Main {

    public static Random randomNumGenerator= new Random();

    public static void main(String[] args) throws IOException {

        PointList[] pointArrayList= new PointList[20];
        Hash hasher= new Hash();

        /**
         * Create an array of points and randomly(using java's random integer generator) generate their values
         */
        Point[] pointsArray= new Point[32];
        for(int i= 0; i< pointsArray.length; i++) {
            pointsArray[i]= new Point(randomNumGenerator.nextInt(Point.N_MAX), randomNumGenerator.nextInt(Point.N_MAX));
            System.out.println(pointsArray[i].toString());
        }

        /**
         * Insert values from the point-array into the array of point-lists
         */
        for(int i= 0; i< pointsArray.length; i++) {
            int position= Hash.calculatePositionInArray(pointsArray[i], pointArrayList.length);
            hasher.addPointToArrayList(pointArrayList, position, pointsArray[i]);
        }

        /**
         * Create a new point and add it in the array of point-lists.
         * Check correctness of searching function. If it works correctly it should be able to find the point that was inserted just now.
         */
        Point p= new Point(randomNumGenerator.nextInt(Point.N_MAX), randomNumGenerator.nextInt(Point.N_MAX));
        System.out.println(p.toString());

        hasher.addPointToArrayList(pointArrayList, Hash.calculatePositionInArray(p, pointArrayList.length), p);
        for(int j= 0; j< pointArrayList.length; j++) {
            System.out.println(j);
            if(pointArrayList[j]== null) continue;
            if(pointArrayList[j].search(p)) {
                System.out.println("Comparisons made: " + Statistics.getNumberOfComparisons());
                break;
            }
        }

        /*=============================================================================================================*/
        PointSaver saver= new PointSaver();
        saver.saveArrayOfPoints(pointsArray);

        /*=============================================================================================================*/

        PointList pasd= saver.loadPointsToPointList(saver.DataFile);

    }
}
