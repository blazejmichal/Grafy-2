package task;

import java.util.Collections;
import java.util.List;

public interface PointSorter extends PointComparator {

  public default void sortByX(List<Point> points) {

    Collections.sort(points, this::compareByX);
  }

  public default void sortByY(List<Point> points) {

    Collections.sort(points, this::compareByY);
  }

}
