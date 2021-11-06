package task;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Point {

  private UUID id = UUID.randomUUID();
  private Double x;
  private Double y;

  public Point(Double x, Double y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return String.format(
        "(%s, %s)",
        this.x,
        this.y
    );
  }

}
