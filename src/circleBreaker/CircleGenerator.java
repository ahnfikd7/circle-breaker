package circleBreaker;

import java.awt.*;

public class CircleGenerator {
  public int map[][];
  public int circleDiameter;

  public CircleGenerator(int row, int col) {
    map = new int[row][col];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        map[i][j] = 1;
      }
    }
    circleDiameter = 540 / col;
  }

  public void draw(Graphics2D g) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] > 0) {
          g.setColor((Color.white));
          int x = j * circleDiameter + 80;
          int y = i * circleDiameter + 50;
          g.fillOval(x, y, circleDiameter, circleDiameter);

          g.setStroke(new BasicStroke(3));
          g.setColor(Color.black);
          g.drawOval(x, y, circleDiameter, circleDiameter);
        }
      }
    }
  }

  public void setCircleValue(int value, int row, int col) {
    map[row][col] = value;
  }
}

