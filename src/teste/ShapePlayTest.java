package teste;
import java.awt.*;  
import java.awt.event.*;  
import java.awt.geom.*;  
import javax.swing.*;  
  
public class ShapePlayTest {  
  
   private static void createAndShowUI() {  
      ShapePlayPanel spPanel = new ShapePlayPanel();  
      ShapePlayMouseListener mListener = new ShapePlayMouseListener(spPanel);  
      spPanel.addMouseListener(mListener);  
      spPanel.addMouseMotionListener(mListener);  
      spPanel.addMouseWheelListener(mListener);  
  
      JFrame frame = new JFrame("ShapePlay");  
      frame.getContentPane().add(spPanel);  
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      frame.pack();  
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);  
   }  
  
   public static void main(String[] args) {  
      java.awt.EventQueue.invokeLater(new Runnable() {  
         public void run() {  
            createAndShowUI();  
         }  
      });  
   }  
}  
  
@SuppressWarnings("serial")  
class ShapePlayPanel extends JPanel {  
   private static final float STROKE_SIZE = 2;  
   private Path2D myPath = new Path2D.Double();  
  
   public ShapePlayPanel() {  
      setPreferredSize(new Dimension(400, 400));  
      //myPath.append(new Ellipse2D.Double(30, 30, 100, 100), false);  
      //myPath.append(new Line2D.Double(250, 350, 350, 250), false);  
      //myPath.append(new Line2D.Double(350, 350, 250, 250), false);  
     //aqui é onde a forma geométrica é desenhada...  
      myPath.append(new RoundRectangle2D.Double(230, 30, 100, 100, 10, 10), false);  
  
     
   }  
  
   public void setAffineTransform(AffineTransform at) {  
      myPath.transform(at);  
   }  
  
   public boolean contains(Point p) {  
      return myPath.contains(p);  
   }  
  
   @Override  
   protected void paintComponent(Graphics g) {  
      super.paintComponent(g);  
      Graphics2D g2 = (Graphics2D) g;  
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
  
      g2.setColor(Color.blue);  
      g2.fill(myPath);  
  
      g2.setColor(Color.red);  
      g2.setStroke(new BasicStroke(STROKE_SIZE));  
      g2.draw(myPath);  
   }  
  
}  
  
class ShapePlayMouseListener extends MouseAdapter {  
   private static final double SCALE_RATIO = 10.0 / 9.0;  
   private ShapePlayPanel spPanel;  
   private Point mousePressedPt = null;  
  
   public ShapePlayMouseListener(ShapePlayPanel spPanel) {  
      this.spPanel = spPanel;  
   }  
  
   @Override  
   public void mousePressed(MouseEvent e) {  
      Point p = e.getPoint();  
      mousePressedPt = p;  
   }  
  
   @Override  
   public void mouseReleased(MouseEvent e) {  
      mousePressedPt = null;  
   }  
  
   @Override  
   public void mouseDragged(MouseEvent e) {  
      if (mousePressedPt != null) {  
         Point p = e.getPoint();  
         double tx = p.x - mousePressedPt.x;  
         double ty = p.y - mousePressedPt.y;  
         spPanel.setAffineTransform(new AffineTransform());  
         spPanel.setAffineTransform(AffineTransform.getTranslateInstance(tx, ty));  
         spPanel.repaint();  
  
         mousePressedPt = p;  
      }  
   }  
  
   @Override  
   public void mouseWheelMoved(MouseWheelEvent e) {  
      Point p = e.getPoint();  
      int wheelRotation = e.getWheelRotation();  
  
      // get scale factors based on direction of wheel rotation  
      double sx = (wheelRotation > 0) ? SCALE_RATIO : 1 / SCALE_RATIO;  
      double sy = sx;  
  
      // get translation factors so that expansion is centered at mouse point  
      double tx = p.x * (1 - sx);  
      double ty = p.y * (1 - sy);  
  
      AffineTransform at = AffineTransform.getTranslateInstance(tx, ty);  
      at.scale(sx, sy);  
  
      spPanel.setAffineTransform(at);  
      spPanel.repaint();  
   }  
}  
