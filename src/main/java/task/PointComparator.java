package task;

public interface PointComparator {

  public default int compareByX(
      Point p1,
      Point p2
  ) {

    if ((p1.getX() < p2.getX()) || (p1.getX() == p2.getX() && p1.getY() < p2.getY())) {
      return -1;
    } else if (p1.getX() > p2.getX()) {
      return 1;
    } else {
      return 0;
    }
  }

  public default int compareByY(
      Point p1,
      Point p2
  ) {
    if ((p1.getY() < p2.getY()) || (p1.getY() == p2.getY() && p1.getX() < p2.getX())) {
      return -1;
    } else if (p1.getY() > p2.getY()) {
      return 1;
    } else {
      return 0;
    }
  }

}
