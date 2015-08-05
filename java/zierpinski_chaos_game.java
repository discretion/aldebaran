import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

 /**
  * Class Assignment12 is my solution to CS12J Assignment12.
  *
  * @author Benjamin Hung for CS12J, benjamindavidhung@gmail.com
  */
public class Assignment12 extends JPanel implements ChangeListener {

private BufferedImage img;
private JTextField urlField;
private JSlider pointSizeSlider;
private int iterations = 1;

  public Assignment12() throws Exception {
    super(); // Invoke JPanel's constructor
    img = null;
    pointSizeSlider = new JSlider(1, 100_000);
    pointSizeSlider.setValue(1);
    pointSizeSlider.addChangeListener(this);
    //urlField = new JTextField();
    //urlField.setText("Iterate.");
    //urlField.selectAll();
  }

  /**
   * Invoked when any component for which we are registered as an ChangeListener
   * experiences a ChangeEvent. Get the value of the slider and save it
   * as the new value of variable iterations.
   * @param e a reference to the event that occurred
   */
  @Override
  public void stateChanged(ChangeEvent e) {
    if (e.getSource() == pointSizeSlider) {
      iterations = pointSizeSlider.getValue();
      //System.out.println(iterations);
      repaint(); // Invokes paintComponent(Graphics), among other things
    }
  }

  /**
   * Invoked automatically when this component should be repainted. 
   * Draws a Sierpinski Triangle using the Chaos Game algorithm.
   * @param g actually a reference to a Graphics2D on which you can draw
   */
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g; // The parameter is actually a Graphics2D
    String iterationz = String.valueOf(iterations);
    // BorderLayout will auto-resize this JPanel if the JFrame containing it
    // changes size, so use the getters for width and height in order to
    // accommodate the changes.

    // Clear the canvas
    g2d.clearRect(0, 0, this.getWidth(), this.getHeight());

    // Print the number of iterations to the canvas
    g2d.setColor(new Color(0, 0, 0));
    g2d.drawString(iterationz.toString(), 1, 10);

    // Define the starting points of the image
    final int width = this.getWidth();
    final int height = this.getHeight();
    final int top_x = width / 2;
    final int top_y = 0;
    final int bottomleft_x = 0;
    final int bottomleft_y = height - 1;
    final int bottomright_x = width - 1;
    final int bottomright_y = height - 1;
    int current_x = 0;
    int current_y = 0;
    
    int choice = (int) (Math.random() * 3);
    switch (choice)
    {
      case 0:
        current_x = top_x;
        current_y = top_y;
        break;
      case 1:
        current_x = bottomleft_x;
        current_y = bottomleft_y;
        break;
      case 2:
        current_x = bottomright_x;
        current_y = bottomright_y;
        break;
    }
    //System.out.println("Top: " + top_x + " " + top_y);
    //System.out.println("Bottom Left: " + bottomleft_x + " " + bottomleft_y);
    //System.out.println("Bottom Right: " + bottomright_x + " " + bottomright_y);
    //System.out.println(width + " " + height);
    //System.out.println(choice);
    //System.out.println(current_x + " " + current_y);

    int vertex_x = 0;
    int vertex_y = 0;

    int chachoice = 0;
    for (int i = 0; i < iterations; i++) {
      chachoice = (int) (Math.random() * 3);
      //g2d.setColor(new Color(0, 0, 0, (float) Math.random()));
      g2d.setColor(new Color(0, 0, 0));
      switch (chachoice)
      {
      case 0:
        vertex_x = top_x;
        vertex_y = top_y;
        break;
      case 1:
        vertex_x = bottomleft_x;
        vertex_y = bottomleft_y;
        break;
      case 2:
        vertex_x = bottomright_x;
        vertex_y = bottomright_y;
        break;
      }
      //System.out.println("Current: " + current_x + " " + current_y);
      //System.out.println("Vertex: " + vertex_x + " " +vertex_y);
      if (current_x > vertex_x) {
        current_x = current_x - Math.abs((current_x - vertex_x) / 2);
      }
      else if (current_x < vertex_x) {
      	current_x = current_x + Math.abs((vertex_x - current_x) / 2);
      }
      if (current_y > vertex_y) {
        current_y = current_y - Math.abs((current_y - vertex_y) / 2);
        //System.out.println("Difference of y: current_y - vertex_y");
      }
      else if (current_y < vertex_y) {
        current_y = current_y + Math.abs((vertex_y - current_y) / 2);
        //System.out.println("Difference of y: vertex_y - current_y");
      }
      //System.out.println(chachoice);
      //System.out.println("New Current: " + current_x + " " + current_y);
      g2d.drawLine(current_x, current_y, current_x, current_y);
      //g2d.fillRect((int) (Math.random() * width), (int) (Math.random() * height),
        //  (int) (Math.random() * 50), (int) (Math.random() * 50));
    }
  }

  /** Basic layout etc. for this interface */
  public static void main(String[] args) throws Exception {

    Assignment12 canvas = new Assignment12(); // Also a JPanel

    JFrame window = new JFrame("Assignment 12");
    window.setPreferredSize(new Dimension(800, 600));
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new BorderLayout());
    window.add(canvas, BorderLayout.CENTER);

    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
    //controlPanel.add(canvas.urlField);
    controlPanel.add(canvas.pointSizeSlider);
    window.add(controlPanel, BorderLayout.SOUTH);

    window.pack();
    window.setVisible(true);
  }
}