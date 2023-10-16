import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapesDrawing extends JFrame {
    private final JCheckBox sphereCheckBox;
    private final JCheckBox coneCheckBox;
    private final JCheckBox torusCheckBox;
    private final JCheckBox icosahedronCheckBox;
    private final JCheckBox tetrahedron;
    private final JCheckBox octahedron;
    private final JCheckBox hexagon;
    private final JCheckBox dodecahedron;
    private final GeometryPanel geometryPanel;

    public ShapesDrawing() {
        setTitle("Отображение геометрических фигур");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание компонентов GUI
        sphereCheckBox = new JCheckBox("Сфера");
        coneCheckBox = new JCheckBox("Конус (с гранями и без)");
        torusCheckBox = new JCheckBox("Тор");
        icosahedronCheckBox=new JCheckBox("Икосаэдр");
        tetrahedron=new JCheckBox("Тетраэдр");
        octahedron=new JCheckBox("Октаэдр");
        hexagon=new JCheckBox("Гексаэдр");
        dodecahedron=new JCheckBox("Додекаэдр");

        JButton drawButton = new JButton("Отобразить");

        JPanel checkboxPanel = new JPanel();
        checkboxPanel.add(sphereCheckBox);
        checkboxPanel.add(coneCheckBox);
        checkboxPanel.add(torusCheckBox);
        checkboxPanel.add(icosahedronCheckBox);
        checkboxPanel.add(tetrahedron);
        checkboxPanel.add(octahedron);
        checkboxPanel.add(hexagon);
        checkboxPanel.add(dodecahedron);

        geometryPanel = new GeometryPanel();

        getContentPane().setLayout(new BorderLayout(4,2));
        getContentPane().add(checkboxPanel, BorderLayout.NORTH);
        getContentPane().add(geometryPanel, BorderLayout.CENTER);
        getContentPane().add(drawButton, BorderLayout.SOUTH);

        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                geometryPanel.setDrawSphere(sphereCheckBox.isSelected());
                geometryPanel.setDrawCone(coneCheckBox.isSelected());
                geometryPanel.setDrawTorus(torusCheckBox.isSelected());
                geometryPanel.setDrawIcosahedron(icosahedronCheckBox.isSelected());
                geometryPanel.setDrawTetrahedron(tetrahedron.isSelected());
                geometryPanel.setDrawOctahedron(octahedron.isSelected());
                geometryPanel.setHexahedron(hexagon.isSelected());
                geometryPanel.setDrawDodecahedron(dodecahedron.isSelected());

                geometryPanel.repaint();
            }
        }); }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ShapesDrawing app = new ShapesDrawing();
                app.setVisible(true);}   });   }
}

class GeometryPanel extends JPanel {
    private boolean drawSphere;
    private boolean drawCone;
    private boolean drawTorus;
    private boolean drawIcosahedron;
    private boolean drawTetrahedron;
    private boolean drawOctahedron;
    private boolean drawHexagon;
    private boolean drawDodecahedron;

    public GeometryPanel() {
        drawSphere = false;
        drawCone = false;
        drawTorus = false;
        drawIcosahedron = false;
        drawTetrahedron = false;
        drawOctahedron = false;
        drawHexagon = false;
        drawDodecahedron = false;
    }
    public void setDrawSphere(boolean drawSphere) {this.drawSphere = drawSphere;}
    public void setDrawCone(boolean drawCone) {this.drawCone = drawCone;}
    public void setDrawTorus(boolean drawTorus) {this.drawTorus = drawTorus;}
    public void setDrawIcosahedron(boolean drawIcosahedron) {this.drawIcosahedron = drawIcosahedron;}
    public void setDrawTetrahedron(boolean drawTetrahedron) {this.drawTetrahedron = drawTetrahedron;}
    public void setDrawOctahedron(boolean drawOctahedron) {this.drawOctahedron = drawOctahedron;}
    public void setHexahedron(boolean drawHexagon) { this.drawHexagon = drawHexagon; }
    public void setDrawDodecahedron(boolean drawDodecahedron) { this.drawDodecahedron = drawDodecahedron; }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        drawGrid(g, width, height);
        if (drawSphere) { drawSphere(g, width, height); }
        if (drawCone) { drawCone(g, width, height); }
        if (drawTorus) { drawTorus(g, width, height); }
        if (drawIcosahedron) { drawIcosahedron(g, width, height); }
        if (drawTetrahedron) { drawTetrahedron(g, width, height); }
        if (drawOctahedron) { drawOctahedron(g, width, height); }
        if (drawHexagon) { drawHexagon(g, width, height); }
        if (drawDodecahedron) {drawDodecahedron(g, width, height); } }

    private void drawGrid(Graphics g, int width, int height) {
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Montserrat", Font.BOLD, 11));
        int len = 50;
        for (int x = len; x < width - len; x += len) {
            g.drawLine(x, len, x, height - len);
            g.drawString(String.valueOf(x), x - 10, 20);
        }
        for (int y = len; y < height - len; y += len) {
            g.drawLine(len, y, width - len, y);
            g.drawString(String.valueOf(y), 2, y + 2);
        } }
    private void drawSphere(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Вычисляем радиус сферы
        int radius = Math.min(400, 400) / 3;

        // Вычисляем координаты центра сферы
        int centerX = 180;
        int centerY = 170;

        Color sphere = new Color(204, 210, 217);
        g2d.setColor(Color.gray);
        g2d.fillArc(130, 280, radius + 100, radius - 100, 170, 320);//shadow
        // Рисуем сферу
        g2d.setColor(sphere);
        {
            g2d.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        }
        g2d.setColor(Color.black);
        g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        g2d.drawArc(centerX - radius, 130, radius * 2, radius - 50, 0, 180);
        g2d.drawArc(centerX - radius, 130, radius * 2, radius - 50, 0, 180);
        g2d.drawArc(centerX - radius, 130, radius * 2, radius - 50, 0, 180);
        g2d.drawArc(centerX - radius, 130, radius * 2, radius - 50, 0, 180);
        g2d.setColor(Color.black);

        g2d.drawArc(155, 38, radius - 100, radius * 2, 90, 190);
        g2d.drawArc(155, 38, radius - 100, radius * 2, 90, 190);
        g2d.drawArc(155, 38, radius - 100, radius * 2, 90, 190);
        g2d.drawArc(155, 38, radius - 100, radius * 2, 90, 190); }
    private void drawCone(Graphics g, int width, int height) {
        Graphics2D cone = (Graphics2D) g;
        cone.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        cone.setColor(Color.black);
        cone.drawOval(320, 200, 200, 50);

        cone.setColor(Color.black);
        int[] PointXT1 = {420, 320, 420};
        int[] PointYT1 = {50, 225, 225};
        cone.drawPolygon(PointXT1, PointYT1, 3);

        int[] PointXT2 = {420, 320,520};
        int[] PointYT2 = {50, 225, 225};
        cone.drawPolygon(PointXT2, PointYT2, 3);

        cone.drawLine(420, 50, 370, 245);
        cone.drawLine(420, 50, 470, 245);
        cone.drawLine(420, 50, 370, 205);
        cone.drawLine(420, 50, 470, 205);

        int[] PointX = {450, 490, 590, 660, 625, 525};
        int[] PointY ={500, 550, 565, 535 ,485, 460};
        //cone.fillPolygon(PointX,PointY,5);
        cone.setColor(Color.black);{cone.drawPolygon(PointX,PointY,6);}
Color newColor=new Color(235,104,186,50);
        cone.setColor(newColor);{
    int[] PointX1 = {600, 450, 490};
    int[] PointY1 = {300, 500, 550};
        cone.fillPolygon(PointX1, PointY1, 3);
        cone.setColor(Color.black);{cone.drawPolygon(PointX1, PointY1, 3);}}
        Color blueColor=new Color(10,240,182,50);
        cone.setColor(blueColor);{
        int[] PointX2 = {600, 490, 590};
        int[] PointY2 = {300, 550, 565};
        cone.fillPolygon(PointX2, PointY2, 3);
            cone.setColor(Color.black);{cone.drawPolygon(PointX2, PointY2, 3);}}
        Color yelColor=new Color(255,237,25,50);
        cone.setColor(yelColor);{
        int[] PointX3 = {600, 590, 660};
        int[] PointY3 = {300, 565, 535};
        cone.fillPolygon(PointX3, PointY3, 3);
            cone.setColor(Color.black);{cone.drawPolygon(PointX3, PointY3, 3);}}
        int[] PointX4 = {600, 660, 625};
        int[] PointY4 = {300, 535, 485};
        cone.drawPolygon(PointX4, PointY4, 3);

        int[] PointX5 = {600, 625, 525};
        int[] PointY5 = {300, 485, 460};
        cone.drawPolygon(PointX5, PointY5, 3); }

    private void drawTorus(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        g2d.drawOval(135, 430, 180, 80);
       // g2d.drawOval(125, 430, 200, 80);
        g2d.drawOval(50, 380, 350, 180);

        g2d.drawOval(100, 390, 250, 120);//

        g2d.drawArc(50, 435, 85, 70, 0, 180);
        g2d.drawArc(50, 435, 85, 70, 0, 180);
        g2d.drawArc(315, 435, 85, 70, 0, 180);
        g2d.drawArc(315, 435, 85, 70, 0, 180); }
    private void drawIcosahedron(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color lightBlue=new Color(122,180,227);
        g2d.setColor(lightBlue);{
        int[] PointXT1 = {600, 650, 700};
        int[] PointYT1 = {125, 200, 125};
        g2d.fillPolygon(PointXT1, PointYT1, 3);
        int[] PointXT2 = {600, 650, 560};
        int[] PointYT2 = {125, 200, 190};
        g2d.fillPolygon(PointXT2, PointYT2, 3);
            int[] PointXT4 = {600, 660, 700};
            int[] PointYT4 = {125, 60, 125};
            g2d.fillPolygon(PointXT4, PointYT4, 3);
            g2d.setColor(Color.black);{
                g2d.drawPolygon(PointXT1, PointYT1, 3);
                g2d.drawPolygon(PointXT1, PointYT1, 3);
                g2d.drawPolygon(PointXT4, PointYT4, 3);}}

        Color greyBlue=new Color(77,136,204);
        g2d.setColor(greyBlue);{
            int[] PointXT3 = {600, 590, 560};
            int[] PointYT3 = {125, 100, 190};
            g2d.fillPolygon(PointXT3, PointYT3, 3);
            int[] PointXT5 = {600, 590, 660};
            int[] PointYT5 = {125, 100, 60};
            g2d.fillPolygon(PointXT5, PointYT5, 3);
            int[] PointXT6 = {740, 650, 700};
            int[] PointYT6 = {190, 200, 125};
            g2d.fillPolygon(PointXT6, PointYT6, 3);
            int[] PointXT9 = {660, 750, 700};
            int[] PointYT9 = {60, 100, 125};
            g2d.fillPolygon(PointXT9, PointYT9, 3);
            int[] PointXT10 = {740, 750, 700};
            int[] PointYT10 = {190, 100, 125};
            g2d.fillPolygon(PointXT10, PointYT10, 3);
        g2d.setColor(Color.black);{
                g2d.drawPolygon(PointXT3, PointYT3, 3);
                g2d.drawPolygon(PointXT5, PointYT5, 3);
                g2d.drawPolygon(PointXT6, PointYT6, 3);
                g2d.drawPolygon(PointXT9, PointYT9, 3);
                g2d.drawPolygon(PointXT10, PointYT10, 3);}}

        Color darkBlue=new Color(0,63,136);
        g2d.setColor(darkBlue);{
        int[] PointXT7 = {740, 650, 660};
        int[] PointYT7 = {190, 200, 240};
        g2d.fillPolygon(PointXT7, PointYT7, 3);

        int[] PointXT8 = {560, 650, 660};
        int[] PointYT8 = {190, 200, 240};
        g2d.fillPolygon(PointXT8, PointYT8, 3);
        g2d.setColor(Color.black);{
            g2d.drawPolygon(PointXT7, PointYT7, 3);
            g2d.drawPolygon(PointXT8, PointYT8, 3); }}  }
    private void drawTetrahedron(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color darkyellow=new Color(180,96,12);
            g2d.setColor(darkyellow);{
        int[] PointXT1 = {750, 750, 825};
        int[] PointYT1 = {300, 500, 400};
        g2d.fillPolygon(PointXT1,PointYT1,3);
            g2d.setColor(Color.black);{
            g2d.drawPolygon(PointXT1,PointYT1,3);}}
        Color greyyellow=new Color(221,174,44);
        g2d.setColor(greyyellow);{
        int[] PointXT2 = {925, 750, 825};
        int[] PointYT2 = {400, 500, 400};
        g2d.fillPolygon(PointXT2,PointYT2,3);
            g2d.setColor(Color.black);{
                g2d.drawPolygon(PointXT2,PointYT2,3);} }
        Color lightyellow=new Color(217,209,93);
        g2d.setColor(lightyellow);{
        int[] PointXT3 = {925, 750, 825};
        int[] PointYT3 = {400, 300, 400};
        g2d.fillPolygon(PointXT3,PointYT3,3);
            g2d.setColor(Color.black);{
                g2d.drawPolygon(PointXT3,PointYT3,3);}} }
    private void drawOctahedron(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color lightblue=new Color(245,241,247);
        g2d.setColor(lightblue);{
        int[] PointXT1 = {1025, 1015, 950};
        int[] PointYT1 ={350, 440, 425};
        g2d.fillPolygon(PointXT1,PointYT1,3);
        g2d.setColor(Color.black);{g2d.drawPolygon(PointXT1,PointYT1,3);}}
        Color greyblue=new Color(203,200,200);
        g2d.setColor(greyblue);{
        int[] PointXT2 = {1025, 1015, 1085};
        int[] PointYT2 ={350, 440, 425};
        g2d.fillPolygon(PointXT2,PointYT2,3);
            int[] PointXT4 = {1025, 1015, 1085};
            int[] PointYT4 ={500, 440, 425};
            g2d.fillPolygon(PointXT4,PointYT4,3);
            g2d.setColor(Color.black);{
                g2d.drawPolygon(PointXT2,PointYT2,3);
                g2d.drawPolygon(PointXT4,PointYT4,3);}}
        Color darkblue=new Color(166,166,166);
        g2d.setColor(darkblue);{
        int[] PointXT3 = {950, 1025, 1015};
        int[] PointYT3 ={425, 500, 440};
        g2d.fillPolygon(PointXT3,PointYT3,3);
            g2d.setColor(Color.black);{g2d.drawPolygon(PointXT3,PointYT3,3);}}}

    private void drawHexagon(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color lightcyan=new Color(22,245,220);
        g2d.setColor(lightcyan);{
        int[] PointXT1 = {800, 800, 875, 875};
        int[] PointYT1 ={150, 250, 275, 175};
        g2d.fillPolygon(PointXT1,PointYT1,4);
            g2d.setColor(Color.black);{g2d.drawPolygon(PointXT1,PointYT1,4);}
        }
        Color greycyan=new Color(6,198,176);
        g2d.setColor(greycyan);{
        int[] PointXT2 = {875, 875, 950, 950};
        int[] PointYT2 ={275, 175, 150, 250};
        g2d.fillPolygon(PointXT2,PointYT2,4);
            g2d.setColor(Color.black);{g2d.drawPolygon(PointXT2,PointYT2,4);}}
        Color darkcyan=new Color(6,198,176);
        g2d.setColor(darkcyan);{
        int[] PointXT3 = {800, 875, 950, 875};
        int[] PointYT3 ={150, 175, 150, 125};
        g2d.fillPolygon(PointXT3,PointYT3,4);
            g2d.setColor(Color.black);{g2d.drawPolygon(PointXT3,PointYT3,4);} } }
    private void drawDodecahedron(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color lightpurple=new Color(177,93,236);
        g2d.setColor(lightpurple);{
        int[] PointX = {1010, 1060, 1150, 1140, 1050};
        int[] PointY ={210, 155, 200, 290 ,300};
        g2d.fillPolygon(PointX,PointY,5);
            g2d.setColor(Color.black);{g2d.drawPolygon(PointX,PointY,5);}}
        Color greypurple=new Color(127,54,177);
        g2d.setColor(greypurple);{
        int[] PointX1 = {1010, 1060, 1060, 1025, 975};
        int[] PointY1 ={210, 155, 120, 140 ,210};
        g2d.fillPolygon(PointX1,PointY1,5);

        int[] PointX2 = {1060, 1060, 1150, 1200, 1150};
        int[] PointY2 ={155, 120, 140, 180 ,200};
        g2d.fillPolygon(PointX2,PointY2,5);

        int[] PointX3 = {1150, 1200, 1210, 1175, 1140};
        int[] PointY3 ={ 200,   180, 245,  310 , 290};
        g2d.fillPolygon(PointX3,PointY3,5);
            g2d.setColor(Color.black);{
                g2d.drawPolygon(PointX1,PointY1,5);
                g2d.drawPolygon(PointX2,PointY2,5);
                g2d.drawPolygon(PointX3,PointY3,5); }}
        Color darkpurple=new Color(106,0,179);
        g2d.setColor(darkpurple);{
        int[] PointX4= {1050, 1140, 1175, 1110, 1040};
        int[] PointY4 ={ 300,   290, 310,  325 , 320};
        g2d.fillPolygon(PointX4,PointY4,5);

        int[] PointX5= {1040, 1050, 1010, 975, 975};
        int[] PointY5 ={ 320,   300, 210,  210 , 275};
        g2d.fillPolygon(PointX5,PointY5,5);
            g2d.setColor(Color.black);{
                g2d.drawPolygon(PointX4,PointY4,5);
                g2d.drawPolygon(PointX5,PointY5,5);
            }} }
}
