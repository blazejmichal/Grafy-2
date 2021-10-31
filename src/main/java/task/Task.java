package task;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task implements PointSorter {

  private List<Point> points = Lists.newArrayList();
  private List<Point> pointsSortedByX = Lists.newArrayList();
  private List<Point> pointsSortedByY = Lists.newArrayList();
  private Integer middleIndexAmongSortedByX;
  private Point middlePointAmongSortedByX;
  private List<Point> s1SortedByX = Lists.newArrayList();
  private List<Point> s2SortedByX = Lists.newArrayList();
  private List<Point> s1SortedByY = Lists.newLinkedList();
  private List<Point> s2SortedByY = Lists.newLinkedList();
  // moje lowest_s1
  private ClosestPoints closestPointsInS1;
  // moje lowest_s2
  private ClosestPoints closestPointsInS2;
  private Double lowestDistanceInS1AndS2;
  // czy napewno tak to nazwac?
  private List<Point> s3LeftHalf = Lists.newLinkedList();
  // czy napewno tak to nazwac?
  private List<Point> s3RightHalf = Lists.newLinkedList();
  private ClosestPoints closestPointsInS3;
  private ClosestPoints closestPointsInS3LeftToRight;
  private ClosestPoints closestPointsInS3RightToLeft;
  private ClosestPoints result;

  public Task(List<Point> points) {
    this.points = points;
    this.run();
  }

  public void run() {

    try {
      this.validateInput();
      this.handleCornerCase();
      this.pointsSortedByX = new ArrayList<>(this.points);
      this.pointsSortedByY = new ArrayList<>(this.points);
      this.sortByX(this.pointsSortedByX);
      this.sortByY(this.pointsSortedByY);
      this.findMiddleIndexAmongSortedByX();
      this.findMiddlePointAmongSortedByX();
      this.fillS1SortedByX();
      this.fillS2SortedByX();
      this.fillS1SortedByY();
      this.fillS2SortedByY();
      this.closestPointsInS1 = this.findClosestPoints(this.s1SortedByX);
      this.closestPointsInS2 = this.findClosestPoints(this.s2SortedByX);
      this.findLowestDistanceInS1AndS2();
      this.fillS3(
          this.s1SortedByY,
          this.s3LeftHalf
      );
      this.fillS3(
          this.s2SortedByY,
          this.s3RightHalf
      );
      if (this.s3LeftHalf.size() > 0 && this.s3RightHalf.size() > 0) {
        this.closestPointsInS3LeftToRight = this.findClosestPointsInS3FromHalfToHalf(
            this.s3LeftHalf,
            this.s3RightHalf
        );
        this.closestPointsInS3RightToLeft = this.findClosestPointsInS3FromHalfToHalf(
            this.s3RightHalf,
            this.s3LeftHalf
        );
      }
      this.findClosestPointsInS3();
      this.findResult();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

  public void validateInput() throws Exception {

    if (this.points.size() < 2) {
      throw new Exception("Invalid input");
    }
  }

  public void findMiddleIndexAmongSortedByX() {

    this.middleIndexAmongSortedByX = this.pointsSortedByX.size() / 2;
  }

  public void findMiddlePointAmongSortedByX() {

    this.middlePointAmongSortedByX = this.pointsSortedByX.get(this.middleIndexAmongSortedByX);
  }

  public void fillS1SortedByX() {

    List<Point> pointsForFilling = this.pointsSortedByX.subList(
        0,
        this.middleIndexAmongSortedByX
    );
    this.s1SortedByX.addAll(pointsForFilling);
  }

  public void fillS2SortedByX() {

    List<Point> pointsForFilling = this.pointsSortedByX.subList(
        this.middleIndexAmongSortedByX,
        this.pointsSortedByX.size()
    );
    this.s2SortedByX.addAll(pointsForFilling);
  }

  public void fillS1SortedByY() {

    List<Point> pointsForFilling = this.pointsSortedByY
        .stream()
        .filter(point -> this.compare(point, this.middlePointAmongSortedByX))
        .collect(Collectors.toList());
    this.s1SortedByY.addAll(pointsForFilling);
  }

  public void fillS2SortedByY() {

    List<Point> pointsForFilling = Lists.newArrayList(this.pointsSortedByY);
    pointsForFilling.removeAll(this.s1SortedByY);
    this.s2SortedByY.addAll(pointsForFilling);
  }

  public Boolean compare(
      Point left,
      Point right
  ) {

    if ((left.getX() < right.getX()) || (left.getX() == right.getX()
        && left.getY() < right.getY())) {
      return true;
    } else if (left.getX() > right.getX() || (left.getX() == right.getX()
        && left.getY() > right.getY())) {
      return false;
    } else {
      return true;
    }
  }

  public ClosestPoints findClosestPoints(List<Point> points) {

    List<ClosestPoints> pointDistances = Lists.newLinkedList();
    for (int i = 0; i < points.size(); i++) {
      for (int j = 0; j < points.size(); j++) {
        if (i != j) {
          Double iterationDistance = this.calculateDistance(points.get(i), points.get(j));
          ClosestPoints iterationResult = new ClosestPoints(
              points.get(i),
              points.get(j),
              iterationDistance
          );
          pointDistances.add(iterationResult);
        }
      }
    }
    ClosestPoints result = pointDistances
        .stream()
        .min(Comparator.comparing(ClosestPoints::getDistance))
        .orElse(null);

    return result;
  }

  public Double calculateDistance(
      Point left,
      Point right
  ) {

    Double result = Math.sqrt(
        Math.pow(right.getX() - left.getX(), 2) + Math.pow(right.getY() - left.getY(), 2));

    return result;
  }

  public void findLowestDistanceInS1AndS2() {

    if (this.closestPointsInS1 != null && this.closestPointsInS2 != null) {
      this.lowestDistanceInS1AndS2 = Math.min(
          this.closestPointsInS1.getDistance(),
          this.closestPointsInS2.getDistance()
      );
    } else if (this.closestPointsInS1 == null && this.closestPointsInS2 == null) {
      this.lowestDistanceInS1AndS2 = Double.MIN_VALUE;
    } else if (this.closestPointsInS1 == null) {
      this.lowestDistanceInS1AndS2 = this.closestPointsInS2.getDistance();
    } else {
      this.lowestDistanceInS1AndS2 = this.closestPointsInS1.getDistance();
    }
  }

  public void fillS3(
      List<Point> source,
      List<Point> target
  ) {

    Double difference = 0d;
    for (Point point : source) {
      difference = this.middlePointAmongSortedByX.getX() - point.getX();
      difference = Math.abs(difference);
      if (difference <= this.lowestDistanceInS1AndS2) {
        target.add(point);
      }
    }
  }

  public void findClosestPointsInS3() {

    if (this.closestPointsInS3LeftToRight == null && this.closestPointsInS3RightToLeft == null) {
      this.closestPointsInS3 = null;
    } else if (this.closestPointsInS3LeftToRight == null) {
      this.closestPointsInS3 = this.closestPointsInS3RightToLeft;
    } else if (this.closestPointsInS3RightToLeft == null) {
      this.closestPointsInS3 = this.closestPointsInS3LeftToRight;
    } else {
      this.closestPointsInS3 =
          this.closestPointsInS3LeftToRight.getDistance()
              >= this.closestPointsInS3RightToLeft.getDistance() ?
              this.closestPointsInS3LeftToRight
              : this.closestPointsInS3RightToLeft;
    }
  }

  public ClosestPoints findClosestPointsInS3FromHalfToHalf(
      List<Point> firstPointList,
      List<Point> secondPointList
  ) {

    if (this.lowestDistanceInS1AndS2 == null) {
      return null;
    }
    ClosestPoints closestPoints = new ClosestPoints();
    closestPoints.setDistance(this.lowestDistanceInS1AndS2);
    int compared = 0;
    for (int i = 0; i < firstPointList.size(); i++) {
      Point point1 = firstPointList.get(i);
      for (int j = 0; j < 4; j++) {
        if (j == secondPointList.size()) {
          break;
        }
        Point point2 = secondPointList.get(j);
        if ((point1.getY() - point2.getY() <= 0) && (point2.getY() - point1.getY()
            <= this.lowestDistanceInS1AndS2)) {
          compared++;
          if (this.calculateDistance(point1, point2) <= closestPoints.getDistance()) {
            closestPoints.setDistance(this.calculateDistance(point1, point2));
            closestPoints.setFirst(point1);
            closestPoints.setSecond(point2);
          }
        }
      }
      if(!point1.getId().equals(this.middlePointAmongSortedByX.getId())){
        if (this.calculateDistance(point1, this.middlePointAmongSortedByX) <= closestPoints.getDistance()) {
          closestPoints.setDistance(this.calculateDistance(point1, this.middlePointAmongSortedByX));
          closestPoints.setFirst(point1);
          closestPoints.setSecond(this.middlePointAmongSortedByX);
        }
      }
    }
    if (compared == 0) {
      return null;
    }
    return closestPoints;
  }

  public void findResult() {

    List<ClosestPoints> closestPoints = Lists.newArrayList(
        this.closestPointsInS1,
        this.closestPointsInS2,
        this.closestPointsInS3
    );
    closestPoints.removeAll(Collections.singleton(null));
    this.result = closestPoints
        .stream()
        .min(Comparator.comparing(ClosestPoints::getDistance))
        .orElse(null);
  }

  public void handleCornerCase() throws Exception {

    List<ClosestPoints> pointsToVerify = Lists.newLinkedList();
    if (this.points.size() == 3 || this.points.size() == 2) {
      for (int i = 0; i < this.points.size() - 1; i++) {
        ClosestPoints iterationResult = new ClosestPoints(
            this.points.get(i),
            this.points.get(i + 1),
            this.calculateDistance(this.points.get(i), this.points.get(i + 1))
        );
        pointsToVerify.add(iterationResult);
      }
      ClosestPoints iterationResult = new ClosestPoints(
          this.points.get(0),
          this.points.get(this.points.size() - 1),
          this.calculateDistance(
              this.points.get(0),
              this.points.get(this.points.size() - 1)
          )
      );
      pointsToVerify.add(iterationResult);
      this.result = pointsToVerify
          .stream()
          .min(Comparator.comparing(ClosestPoints::getDistance))
          .get();
      throw new Exception("Handled corner case");
    }
  }

}