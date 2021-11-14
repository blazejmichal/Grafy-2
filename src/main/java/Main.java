import com.google.common.collect.Lists;
import task.Point;
import task.Task;

public class Main {

  public static void main(String[] args) {

    Task task1 = new Task(
        Lists.newArrayList(
            new Point(1d, 1d),
            new Point(1d, 2d),
            new Point(1d, 3d),
            new Point(1d, 4d),
            new Point(1d, 5d),
            new Point(1d, 6d),
            new Point(1d, 7d),
            new Point(1d, 8d),
            new Point(1d, 9d),
            new Point(1d, 10d)
        )
    );

    Task task2 = new Task(
        Lists.newArrayList(
            new Point(1d, 1d),
            new Point(2d, 1d),
            new Point(3d, 1d),
            new Point(4d, 1d),
            new Point(5d, 1d),
            new Point(6d, 1d),
            new Point(7d, 1d),
            new Point(8d, 1d),
            new Point(9d, 1d),
            new Point(10d, 1d)
        )
    );

    Task task3 = new Task(
        Lists.newArrayList(
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d),
            new Point(1d, 1d)
        )
    );

    Task taskPPP = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(70d, 80d),
            new Point(71d, 81d),
            new Point(4d, 5d),
            new Point(7d, 8d),
            new Point(6d, 800d),
            new Point(9d, -800d)
        )
    );
    Task taskPPN = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(70d, 80d),
            new Point(71d, 81d),
            new Point(4d, 5d),
            new Point(7d, 8d),
            new Point(7000000d, 8000000d),
            new Point(6d, 800d),
            new Point(9d, -800d)
        )
    );
    Task taskLLN = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(-70d, -80d),
            new Point(-71d, -81d),
            new Point(4d, 5d),
            new Point(7d, 8d)
        )
    );
    Task taskLLP = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(-70d, 80d),
            new Point(-71d, 81d),
            new Point(4d, 5d),
            new Point(7d, 8d),
            new Point(7000000d, 8000000d)
        )
    );
    Task taskLPN = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(3d, 800d),
            new Point(8d, 800d),
            new Point(4d, 5d),
            new Point(7d, 8d)
        )
    );
    Task taskLPP = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(3d, 800d),
            new Point(8d, 800d),
            new Point(4d, 5d),
            new Point(7d, 8d),
            new Point(7000000d, 8000000d)
        )
    );
    Task taskLSN = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(7d, 8d),
            new Point(4d, 5d),
            new Point(400000d, 500000d)
        )
    );
    Task taskLSP = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(7d, 8d),
            new Point(4d, 5d)
        )
    );
    Task taskPSN = new Task(
        Lists.newArrayList(
            new Point(-90000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(7d, 8d),
            new Point(9d, 5d),
            new Point(400000d, 500000d)
        )
    );
    Task taskPSP = new Task(
        Lists.newArrayList(
            new Point(-90000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(7d, 8d),
            new Point(9d, 5d)
        )
    );
    Task taskSSN = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(7d, 8d),
            new Point(7d, 5d),
            new Point(400000d, 500000d)
        )
    );
    Task taskSSP = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(7d, 8d),
            new Point(7d, 5d)
        )
    );
    Task lewaDalekoRozne = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-10000d, -10001d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(9d, -1d),
            new Point(-8d, 2d),
            new Point(7d, -3d),
            new Point(-6d, 4d),
            new Point(5d, -5d),
            new Point(-4d, 6d),
            new Point(3d, -7d),
            new Point(-2d, 8d),
            new Point(1d, -9d)
        )
    );
    Task prawaDalekoTakiesame = new Task(
        Lists.newArrayList(
            new Point(10000d, 10000d),
            new Point(10000d, 10000d),
            new Point(1000d, 1000d),
            new Point(100d, 100d),
            new Point(-10000d, -10000d),
            new Point(-1000d, -1000d),
            new Point(-100d, -100d),
            new Point(9d, -1d),
            new Point(-8d, 2d),
            new Point(7d, -3d),
            new Point(-6d, 4d),
            new Point(5d, -5d),
            new Point(-4d, 6d),
            new Point(3d, -7d),
            new Point(-2d, 8d),
            new Point(1d, -9d)
        )
    );
    Task trzyPunkty = new Task(
        Lists.newArrayList(
            new Point(100d, 100d),
            new Point(10d, 10d),
            new Point(11d, 12d)
        )
    );
    Task dwaPunkty = new Task(
        Lists.newArrayList(
            new Point(100d, 100d),
            new Point(10d, 10d)
        )
    );
    Task jedenPunkt = new Task(
        Lists.newArrayList(
            new Point(100d, 100d)
        )
    );
    Task zeroPunktow = new Task(
        Lists.newArrayList(
            new Point(100d, 100d)
        )
    );
  }

}