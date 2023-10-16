import javax.swing.*;
import java.awt.*;

public class VolkswagenLogo extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // нарисовать фон белого цвета
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        Color customColor = new Color(6,42,138); // темно синий цвет

        // нарисовать круг синего цвета в центре
        g2d.setColor(customColor);
        g2d.fillArc(50, 50, 300, 300, 0, 360);
        g2d.setColor(Color.black);
        g2d.drawOval(50, 50, 300, 300);

        // нарисовать серый внутренний круг
        g2d.setColor(Color.white);
        g2d.fillArc(65, 65, 270, 270, 0, 360);
        g2d.setColor(Color.black);
        g2d.drawOval(65, 65, 270, 270);

        g2d.setColor(customColor);
        g2d.fillArc(85, 85, 230, 230, 0, 360);
        g2d.setColor(Color.black);
        g2d.drawOval(85, 85, 230, 230);

        g2d.setColor(customColor);
        g2d.fillArc(110, 85, 180, 180, 67, 45);

        g2d.setColor(customColor);
        g2d.fillArc(110, 135, 180, 180, -67, -45);

        int x11 = 170;   // координата x вершины 1
        int y11 = 295;   // координата y вершины 1
        int x21 = 95;  // координата x вершины 2
        int y21 = 145;  // координата y вершины 2
        int x31 = 85;  // координата x вершины 3
        int y31 = 175;  // координата y вершины 3
        int x41 = 160;    // координата x вершины 4
        int y41 = 320;  // координата y вершины 4
        int[] xPoints1 = {x11, x21, x31, x41};  // координаты x всех вершин
        int[] yPoints1 = {y11, y21, y31, y41};  // координаты y всех вершин
        g2d.setColor(Color.white);  // задаем цвет заливки фигуры
        g2d.fillPolygon(xPoints1, yPoints1, 4);  // рисуем закрашенный параллелограмм

        int x12 = 230;   // координата x вершины 1
        int y12 = 295;   // координата y вершины 1
        int x22 = 305;  // координата x вершины 2
        int y22 = 145;  // координата y вершины 2
        int x32 = 315;  // координата x вершины 3
        int y32 = 175;  // координата y вершины 3
        int x42 = 240;    // координата x вершины 4
        int y42 = 320;  // координата y вершины 4
        int[] xPoints2 = {x12, x22, x32, x42};  // координаты x всех вершин
        int[] yPoints2 = {y12, y22, y32, y42};  // координаты y всех вершин
        g2d.setColor(Color.white);  // задаем цвет заливки фигуры
        g2d.fillPolygon(xPoints2, yPoints2, 4);  // рисуем закрашенный параллелограмм

        int x13 = 250;   // координата x вершины 1
        int y13 = 290;   // координата y вершины 1
        int x23 = 160;  // координата x вершины 2
        int y23 = 75;  // координата y вершины 2
        int x33 = 140;  // координата x вершины 3
        int y33 = 95;  // координата y вершины 3
        int x43 = 240;    // координата x вершины 4
        int y43 = 320;  // координата y вершины 4
        int[] xPoints3 = {x13, x23, x33, x43};  // координаты x всех вершин
        int[] yPoints3 = {y13, y23, y33, y43};  // координаты y всех вершин
        g2d.setColor(Color.white);  // задаем цвет заливки фигуры
        g2d.fillPolygon(xPoints3, yPoints3, 4);  // рисуем закрашенный параллелограмм

        int x14 = 150;   // координата x вершины 1
        int y14 = 290;   // координата y вершины 1
        int x24 = 240;  // координата x вершины 2
        int y24 = 75;  // координата y вершины 2
        int x34 = 260;  // координата x вершины 3
        int y34 = 95;  // координата y вершины 3
        int x44 = 160;    // координата x вершины 4
        int y44 = 320;  // координата y вершины 4
        int[] xPoints4 = {x14, x24, x34, x44};  // координаты x всех вершин
        int[] yPoints4 = {y14, y24, y34, y44};  // координаты y всех вершин
        g2d.setColor(Color.white);  // задаем цвет заливки фигуры
        g2d.fillPolygon(xPoints4, yPoints4, 4);  // рисуем закрашенный параллелограмм

        g.setColor(customColor);
        g.fillRect(180, 195, 40, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Volkswagen Logo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);
        frame.add(new VolkswagenLogo());
        frame.setVisible(true);
    }
}