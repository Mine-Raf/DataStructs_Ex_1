public class PointNode {
    private Point point;
    private PointNode next;

    public PointNode(Point p, PointNode next) {
        this.point= p;
        this.next= next;
    }

    public void setNext(PointNode next) {
        this.next= next;
    }

    public Point getPoint() {
        return this.point;
    }

    public PointNode getNext() {
        return this.next;
    }
}
