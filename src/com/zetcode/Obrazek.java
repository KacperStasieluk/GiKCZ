import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers
 
/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame
public class Obrazek extends JFrame {
   // Define constants
   public static final int Szer  = 800;
   public static final int Wys = 800;
 
   // Declare an instance of the drawing canvas,
   // which is an inner class called DrawCanvas extending javax.swing.JPanel.
   private DrawCanvas plotno;
 
   // Constructor to set up the GUI components and event handlers
   public Obrazek() {
      plotno = new DrawCanvas();    // Construct the drawing canvas
      plotno.setPreferredSize(new Dimension(Szer, Wys));
 
      // Set the Drawing JPanel as the JFrame's content-pane
      Container cp = getContentPane();
      cp.add(plotno);
      // or "setContentPane(canvas);"
 
      setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
      pack();              // Either pack() the components; or setSize()
      //setTitle("......");  // "super" JFrame sets the title
      setVisible(true);    // "super" JFrame show
   }
 
   /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
   private class DrawCanvas extends JPanel {
      // Override paintComponent to perform your own painting
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);     // paint parent's background
         setBackground(Color.WHITE);  // set background color for this JPanel
 
		g.setColor(new Color(134,58,16));
		int x1[] = {40,221,87};
		int y1[] = {56,249,347};
		g.fillPolygon(x1, y1, 3);
		
		g.setColor(new Color(216,127,32));
		int x2[] = {40,221,280};
		int y2[] = {56,249,195};
		g.fillPolygon(x2, y2, 3);
		
		g.setColor(new Color(235,118,3));
		int x3[] = {424,221,280};
		int y3[] = {185,249,195};
		g.fillPolygon(x3, y3, 3);
		
		g.setColor(new Color(218,97,0));
		int x4[] = {222,318,424};
		int y4[] = {249,262,185};
		g.fillPolygon(x4, y4, 3);
		
		g.setColor(new Color(174,49,0));
		int x5[] = {424,318,387};
		int y5[] = {185,262,297};
		g.fillPolygon(x5, y5, 3);
		
		g.setColor(new Color(231,125,21));
		int x6[] = {387,424,464};
		int y6[] = {297,185,248};
		g.fillPolygon(x6, y6, 3);
		
		g.setColor(new Color(228,107,0));
		int x7[] = {464,424,557};
		int y7[] = {248,185,218};
		g.fillPolygon(x7, y7, 3);
		
		g.setColor(new Color(247,138,9));
		int x8[] = {424,557,545};
		int y8[] = {185,218,173};
		g.fillPolygon(x8, y8, 3);
		
		g.setColor(new Color(160,49,0));
		int x9[] = {557,545,758};
		int y9[] = {218,173,65};
		g.fillPolygon(x9, y9, 3);
		
		g.setColor(new Color(186,99,52));
		int x10[] = {557,758,725};
		int y10[] = {218,65,289};
		g.fillPolygon(x10, y10, 3);
		
		g.setColor(new Color(164,75,16));
		int x11[] = {557,725,747};
		int y11[] = {218,289,415};
		g.fillPolygon(x11, y11, 3);
		
		g.setColor(new Color(184,74,0));
		int x12[] = {557,747,582};
		int y12[] = {218,415,360};
		g.fillPolygon(x12, y12, 3);
		
		g.setColor(new Color(225,128,23));
		int x13[] = {747,582,587};
		int y13[] = {415,360,428};
		g.fillPolygon(x13, y13, 3);
		
		g.setColor(new Color(232,144,40));
		int x14[] = {587,747,642,540};
		int y14[] = {428,415,538,494};
		g.fillPolygon(x14, y14, 4);
		
		g.setColor(new Color(182,56,0));
		int x15[] = {642,747,746,675};
		int y15[] = {538,415,545,650};
		g.fillPolygon(x15, y15, 4);
		
		g.setColor(new Color(171,105,57));
		int x16[] = {510,510,642,675};
		int y16[] = {606,707,538,650};
		g.fillPolygon(x16, y16, 4);
		
		g.setColor(new Color(192,145,104));
		int x17[] = {510,510,444,392};
		int y17[] = {606,707,573,641};
		g.fillPolygon(x17, y17, 4);
		
		g.setColor(new Color(80,45,26));
		int x18[] = {392,287,390,507};
		int y18[] = {641,696,670,708};
		g.fillPolygon(x18, y18, 4);
		
		g.setColor(new Color(162,125,88));
		int x19[] = {400,287,390,507};
		int y19[] = {743,696,670,708};
		g.fillPolygon(x19, y19, 4);
		
		g.setColor(new Color(139,108,81));
		int x20[] = {392,287,257,327};
		int y20[] = {641,696,613,575};
		g.fillPolygon(x20, y20, 4);
		
		g.setColor(new Color(156,77,0));
		int x21[] = {72,287,257,140,88};
		int y21[] = {464,696,613,665,590};
		g.fillPolygon(x21, y21, 5);
		
		g.setColor(new Color(190,115,26));
		int x22[] = {72,257,245,192,286,320,160};
		int y22[] = {464,613,494,417,403,263,353};
		g.fillPolygon(x22, y22, 7);
		
		g.setColor(new Color(164,54,0));
		int x23[] = {72,160,320,222,88};
		int y23[] = {464,353,263,250,348};
		g.fillPolygon(x23, y23, 5);
		
		g.setColor(new Color(177,92,17));
		int x24[] = {320,287,321,388,328,256,247};
		int y24[] = {470,404,263,300,572,611,494};
		g.fillPolygon(x24, y24, 7);
		
		g.setColor(new Color(216,137,66));
		int x25[] = {328,388,444};
		int y25[] = {573,300,572};
		g.fillPolygon(x25, y25, 3);
		
		g.setColor(new Color(204,44,51));
		int x26[] = {328,392,444};
		int y26[] = {573,642,572};
		g.fillPolygon(x26, y26, 3);
		
		g.setColor(new Color(212,87,4));
		int x27[] = {640,510,444,392,465,558,588,493,460,536};
		int y27[] = {540,605,571,300,250,217,427,408,475,494};
		g.fillPolygon(x27, y27, 10);
		
		g.setColor(new Color(60,72,12));
		int x28[] = {193,286,320,247};
		int y28[] = {417,404,470,494};
		g.fillPolygon(x28, y28, 4);
		
		g.setColor(new Color(97,110,8));
		int x29[] = {460,492,586,538};
		int y29[] = {473,409,428,493};
		g.fillPolygon(x29, y29, 4);
		
		g.setColor(new Color(30,10,0));
		int x30[] = {286,276,247,251};
		int y30[] = {404,449,492,438};
		g.fillPolygon(x30, y30, 4);
		
		g.setColor(new Color(30,10,0));
		int x31[] = {492,535,536,508};
		int y31[] = {409,444,492,452};
		g.fillPolygon(x31, y31, 4);
		
      }
   }
 
   // The entry main method
   public static void main(String[] args) {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Obrazek(); // Let the constructor do the job
         }
      });
   }
}