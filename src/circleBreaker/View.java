package circleBreaker;

import javax.swing.*;

import java.awt.*;

public class View extends JPanel {
  private Model model;

  public View(Model model) {
    this.model = model;
  }

  public void paint(Graphics g) {
    // background
    g.setColor(Color.black);
    g.fillRect(1, 1, 692, 592);

    // drawing circles
    model.getCircleGenerator().draw((Graphics2D) g);

    // borders
    g.setColor(Color.white);
    g.fillRect(0, 0, 3, 592);
    g.fillRect(0, 0, 692, 3);
    g.fillRect(691, 0, 3, 592);

    // scores
    g.setColor(Color.blue);
    g.setFont(new Font("arial", Font.BOLD, 25));
    g.drawString("" + model.getScore(), 590, 30);

    // the paddle
    g.setColor(Color.green);
    g.fillRect(model.getPlayerX(), 550, 100, 8);

    // the ball
    g.setColor(Color.yellow);
    g.fillOval(model.getBallposX(), model.getBallposY(), 20, 20);

    if (model.getTotalCircles() <= 0) {
      model.setPlay(false);
      model.setBallXdir(0);
      model.setBallYdir(0);
      g.setColor(Color.RED);
      g.setFont(new Font("serif", Font.BOLD, 30));
      g.drawString("You Won", 260, 300);

      g.setFont(new Font("serif", Font.BOLD, 20));
      g.drawString("Press Enter to Restart", 230, 350);
    }

    if (model.getBallposY() > 570) {
      model.setPlay(false);
      model.setBallXdir(0);
      model.setBallYdir(0);
      g.setColor(Color.RED);
      g.setFont(new Font("serif", Font.BOLD, 30));
      g.drawString("Game Over, Scores: " + model.getScore(), 190, 300);

      g.setFont(new Font("serif", Font.BOLD, 20));
      g.drawString("Press Enter to Restart", 230, 350);
    }

    g.dispose();
  }
}
