package circleBreaker;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;


public class Model {
  private boolean play = false;
  private int score = 0;
  private int totalCircles = 21;
  private int playerX = 310;
  private int ballposX = 120;

  private int ballposY = 350;
  private int ballXdir = -1;
  private int ballYdir = -2;
  private CircleGenerator circleGenerator;

  public Model() {
    circleGenerator = new CircleGenerator(3, 7);
  }

  public void processKeyPress(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (playerX >= 600) {
        playerX = 600; //make sure not to cross the boundary
      } else {
        moveRight();
      }
    }

    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (playerX <= 10) {
        playerX = 10;
      } else {
        moveLeft();
      }
    }

    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      if (!play) {
        play = true;
        ballposX = 120;
        ballposY = 350;
        ballXdir = -1;
        ballYdir = -2;
        playerX = 310;
        score = 0;
        totalCircles = 21;
        circleGenerator = new CircleGenerator(3, 7);
      }
    }

  }

  public void update() {
    if (play) {
      if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
        ballYdir = -ballYdir;
      }

      A:
      for (int i = 0; i < circleGenerator.map.length; i++) {
        for (int j = 0; j < circleGenerator.map[0].length; j++) {
          if (circleGenerator.map[i][j] > 0) {
            int circleX = j * circleGenerator.circleDiameter + 80;
            int circleY = i * circleGenerator.circleDiameter + 50;

            Ellipse2D.Float circle = new Ellipse2D.Float(circleX, circleY, circleGenerator.circleDiameter, circleGenerator.circleDiameter);
            Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);

            if (circle.intersects(ballRect)) {
              circleGenerator.setCircleValue(0, i, j);
              totalCircles--;
              score += 5;

              if (ballposX + 19 <= circle.getX() || ballposX + 1 >= circle.getX() + circle.getWidth()) {
                ballXdir = -ballXdir;
              } else {
                ballYdir = -ballYdir;
              }

              break A;
            }
          }
        }
      }

      ballposX += ballXdir;
      ballposY += ballYdir;

      if (ballposX < 0) {
        ballXdir = -ballXdir;
      }

      if (ballposY < 0) {
        ballYdir = -ballYdir;
      }

      if (ballposX > 670) {
        ballXdir = -ballXdir;
      }
    }
  }

  public void moveRight() {
    play = true;
    playerX += 20;
  }

  public void moveLeft() {
    play = true;
    playerX -= 20;
  }

  public boolean isPlay() {
    return play;
  }

  public int getScore() {
    return score;
  }

  public int getTotalCircles() {
    return totalCircles;
  }

  public int getPlayerX() {
    return playerX;
  }

  public int getBallposX() {
    return ballposX;
  }

  public int getBallposY() {
    return ballposY;
  }

  public CircleGenerator getCircleGenerator() {
    return circleGenerator;
  }

  public void setPlay(boolean play) {
    this.play = play;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setTotalCircles(int totalCircles) {
    this.totalCircles = totalCircles;
  }

  public void setPlayerX(int playerX) {
    this.playerX = playerX;
  }

  public void setBallposX(int ballposX) {
    this.ballposX = ballposX;
  }

  public void setBallposY(int ballposY) {
    this.ballposY = ballposY;
  }

  public void setBallXdir(int ballXdir) {
    this.ballXdir = ballXdir;
  }

  public void setBallYdir(int ballYdir) {
    this.ballYdir = ballYdir;
  }
}
