package task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClosestPoints {

  private Point first;
  private Point second;
  private Double distance;

}
