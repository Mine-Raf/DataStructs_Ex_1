public class Hash {
    public Hash() {

    }

    /**
     * Calculate the position  for the placement of the point in an array of size arraySize
     * @param x x value of the given Point
     * @param y y value of the given Point
     * @param arraySize size of the array used
     * @return position for placement in the array
     */
    public static int calculatePositionInArray(int x, int y, int arraySize) {
        int position= (x*Point.N_MAX+ y)% arraySize;
        System.out.println(position);
        return position;
    }

    /**
     * Calculate the position  for the placement of the point in an array of size arraySize
     * @param point Point to calculate the position for
     * @param arraySize size of the array used
     * @return position for placement in the array
     */
    public static int calculatePositionInArray(Point point, int arraySize) {
        int position= (int)( (long)point.getX()*Point.N_MAX+ point.getY())% arraySize;
        System.out.println("position: " + position);
        return position;
    }

    /**
     * Add a point to the given array of linked lists in the given position
     * @param arrayList The array List to add the given point
     * @param positionInList Position in the array/ Calculated with calculatePositionInArray
     * @param point The point to add
     */
    public void addPointToArrayList(PointList[] arrayList, int positionInList, Point point) {
        if(arrayList[positionInList]== null) {
            arrayList[positionInList]= new PointList(point);
            System.out.println("Point successfully added to the list");
        }
        else {
            arrayList[positionInList].insert(point);
        }
    }

    public boolean searchInArrayList(PointList[] list, Point point) {
        PointNode nodeUnderCheck;
        for(int i= 0; i< list.length; i++) {
            if(list[i]== null) continue;
            else {
                nodeUnderCheck= list[i].getHead();
                while(nodeUnderCheck!= null) {
                    if(nodeUnderCheck.getPoint().equals(point)) {return true;}
                    else {
                        nodeUnderCheck= nodeUnderCheck.getNext();
                    }
                }
            }
        }
        System.err.println("Point doesn't exist in this array list!");
        return false;
    }
}
