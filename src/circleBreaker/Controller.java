package circleBreaker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener, Runnable {
  private Model model;
  private View view;
  private Thread gameLoop;

  public Controller() {
    model = new Model();
    view = new View(model);
    view.addKeyListener(this);
    view.setFocusable(true);
    gameLoop = new Thread(this);
    gameLoop.start();
  }

  public View getView() {
    return view;
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    model.processKeyPress(e);
  }

  @Override
  public void run() {
    while (true) {
      model.update();
      view.repaint();

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
