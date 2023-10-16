import java.awt.*;
import javax.swing.*;

public class MusicInstrumentImage extends JPanel {
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Montserrat", Font.BOLD, 11));
        int len = 30;
        for (int x = len; x < getWidth() - len; x += len) {
            g.drawLine(x, len, x, getHeight() - len);
            g.drawString(String.valueOf(x), x - 10, 20);
        }
        for (int y = len; y < getHeight() - len; y += len) {
            g.drawLine(len, y, getWidth() - len, y);
            g.drawString(String.valueOf(y), 2, y + 2);
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color purple = new Color(125,120,199); // темно синий цвет
        Color darkpurple = new Color(166,122,149); // темно синий цвет
        Color blue = new Color(190,189,205); // темно синий цвет
        Color orange1 = new Color(255,182,53);

        g.setColor(orange1) ;{
            g.fillRect(60, 300, 400, 150);
            int[] xPoints3 = {60, 60, 120};
            int[] yPoints3 = {440, 480, 480};
            g.fillPolygon(xPoints3, yPoints3, 3);

            int[] xPoints4 = {460, 460, 390};
            int[] yPoints4 = {440, 480, 480};
            g.fillPolygon(xPoints4, yPoints4, 3);

            g.fillArc(60, 420, 400, 120, 0, -180); // левая дуга
        }

        g.setColor(purple) ;{
            g.fillRect(60, 300, 400, 150);
            int[] xPoints3 = {60, 60, 120};
            int[] yPoints3 = {295, 450, 440};
            g.fillPolygon(xPoints3, yPoints3, 3);

            int[] xPoints4 = {460, 460, 390};
            int[] yPoints4 = {295, 450, 440};
            g.fillPolygon(xPoints4, yPoints4, 3);

            g.fillArc(60, 385, 400, 120, 0, -180); // левая дуга

        }
        g.setColor(darkpurple) ;{
            int[] xPoints = {60, 60, 120};
            int[] yPoints = {300, 330, 330};
            g.fillPolygon(xPoints, yPoints, 3);

            int[] xPoints1 = {460, 460, 390};
            int[] yPoints1 = {300, 330, 330};
            g.fillPolygon(xPoints1, yPoints1, 3);

            g.fillArc(60, 270, 400, 120, 0, -180); // левая дуга
        }
        int[] xPointstar = { 150, 165, 185, 170, 180, 150, 120, 130, 115, 135 };
        int[] yPointstar = { 420, 450, 455, 470, 490, 475, 490, 470, 455, 450 };
        int numPoints = 10;
        g.setColor(Color.red);
        g.fillPolygon(xPointstar, yPointstar, numPoints);
        g.setColor(Color.black);
        g.drawPolygon(xPointstar, yPointstar, numPoints);

        int[] xPointstar1 = { 350, 365, 385, 370, 380, 350, 320, 330, 315, 335 };
        int[] yPointstar1 = { 420,450,455, 470,490, 475, 490,470, 455, 450 };
        int numPoints1 = 10;
        g.setColor(Color.magenta);
        g.fillPolygon(xPointstar1, yPointstar1, numPoints1);
        g.setColor(Color.black);
        g.drawPolygon(xPointstar1, yPointstar1, numPoints1);

        g.setColor(Color.orange) ;{
            int[] xPoints = {60, 60, 120};
            int[] yPoints = {250, 290, 295};
            g.fillPolygon(xPoints, yPoints, 3);

            int[] xPoints1 = {460, 460, 390};
            int[] yPoints1 = {250, 290, 295};
            g.fillPolygon(xPoints1, yPoints1, 3);

            g.fillArc(60, 230, 400, 120, 0, -180); // левая дуга
        }
        g.setColor(purple);
        g.fillArc(60, 180, 400, 140, 0, 360); // левая дуга
        g.setColor(blue);
        g.fillArc(85, 200, 350, 100, 0, 360); // левая дуга
        g.setColor(Color.blue);

        Color brown=new Color(85,39,39);
        g.setColor(brown);{
        g.fillArc(320, 220, 60, 60, 0, 360); // левая дуга
        g.fillRect(340, 240, 250, 10);
        g.fillArc(230, 200, 60, 60, 0, 360); // левая дуга
        g.fillRect(280, 220, 250, 10);}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Music Instrument Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MusicInstrumentImage());
        frame.setSize(550, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}