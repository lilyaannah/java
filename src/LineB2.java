import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LineB2 extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        int  y1=10,y2=200, x1=100, x2=100;
        while(x2<200){
            g.drawLine(x2, y1, x1, y2);
            x2+=5;
            x1-=10;
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Line B2-3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.add(new LineB2());
        frame.setVisible(true);
    }
}