package circleBreaker;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    JFrame obj = new JFrame();
    Controller controller = new Controller();
    obj.setBounds(10, 10, 700, 600);
    obj.setTitle("Circle Dance");
    obj.setResizable(false);
    obj.setVisible(true);
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    obj.add(controller.getView());
  }
}
