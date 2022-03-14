public class PointList {
    private int numberOfEntries; //Number of entries existing in this List
    private PointNode headOfList;
    private PointNode tailOfList;
    private static Statistics statistics;

    /**
     * Simple constructor method for this List. Requires nothing and creates a list with no values in it
     */
    public PointList() {
        this.numberOfEntries= 0;
        this.headOfList= null;
        this.tailOfList= null;
        statistics.resetStatistics();
    }

    /**
     * Constructor method for creating a list with a given point. Point will be both head and tail of the list.
     * @param p The point to enter in the list.
     */
    public PointList(Point p) {
        PointNode n= new PointNode(p, null); //Create a new node of Point p
        this.headOfList= n;
        this.tailOfList= n;
        this.numberOfEntries++;
        statistics.resetStatistics();
    }

    /**
     * Insert a point in the list
     */
    public void insert(Point p) {
        if(this.numberOfEntries== 0) {
            PointNode firstNode= new PointNode(p, null);
            this.headOfList= firstNode;
            this.tailOfList= firstNode;
            this.numberOfEntries++;
            return;
        }

        PointNode newNode= new PointNode(p, null);
        this.tailOfList.setNext(newNode);
        this.setTailOfList(newNode);
        this.numberOfEntries++;
        System.out.println("Point successfully inserted in the list");
    }

    /**
     * Search the list for the given Point.
     *Requires: A point to search for
     */
    public boolean search(Point p) {
        if(this.numberOfEntries== 0) {System.err.println("List is empty"); return false;}
        PointNode searchedNode= this.headOfList;
        for(int i= 0; i< numberOfEntries; i++) {
            if(searchedNode.getPoint().equalsWithStatistics(p)) {System.out.println("Point found"); return true;}
            else searchedNode= searchedNode.getNext();
        }
        System.out.println("Point doesn't exist in this list");
        return false;
    }

    /**
     * Sets the tail of the list to the given Node
     * @param pn New tail of the list
     */
    public void setTailOfList(PointNode pn) {
        this.tailOfList= pn;
    }

    /**
     *
     * @return The tail of the list
     */
    public PointNode getTail() {
        return this.tailOfList;
    }

    /**
     *
     * @return The head of the list
     */
    public PointNode getHead() {
        return this.headOfList;
    }

    /**
     *
     * @return The number of entries of the list
     */
    public int getNumberOfEntries() {
        return this.numberOfEntries;
    }
}
