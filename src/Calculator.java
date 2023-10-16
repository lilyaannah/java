import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private JPanel buttonPanel;
    private JButton zeroButton, oneButton, twoButton, threeButton, fourButton,
            fiveButton, sixButton, sevenButton, eightButton, nineButton, plusButton,
            minusButton, timesButton, divideButton, equalsButton, dotButton,
            clearButton, sqrtButton, squareButton;
    private JTextField display;

    private double firstNumber, secondNumber, result;
    private String operation;

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        zeroButton = new JButton("0");
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        timesButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        dotButton = new JButton(".");
        clearButton = new JButton("C");
        sqrtButton = new JButton("sqrt");
        squareButton = new JButton("x^2");

        zeroButton.addActionListener(this);
        oneButton.addActionListener(this);
        twoButton.addActionListener(this);
        threeButton.addActionListener(this);
        fourButton.addActionListener(this);
        fiveButton.addActionListener(this);
        sixButton.addActionListener(this);
        sevenButton.addActionListener(this);
        eightButton.addActionListener(this);
        nineButton.addActionListener(this);
        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        timesButton.addActionListener(this);
        divideButton.addActionListener(this);
        equalsButton.addActionListener(this);
        dotButton.addActionListener(this);
        clearButton.addActionListener(this);
        sqrtButton.addActionListener(this);
        squareButton.addActionListener(this);

        buttonPanel = new JPanel(new GridLayout(5, 4));
        buttonPanel.add(clearButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(sevenButton);
        buttonPanel.add(eightButton);
        buttonPanel.add(nineButton);
        buttonPanel.add(timesButton);
        buttonPanel.add(fourButton);
        buttonPanel.add(fiveButton);
        buttonPanel.add(sixButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(oneButton);
        buttonPanel.add(twoButton);
        buttonPanel.add(threeButton);
        buttonPanel.add(plusButton);
        buttonPanel.add(zeroButton);
        buttonPanel.add(dotButton);
        buttonPanel.add(equalsButton);

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);}

        public void actionPerformed (ActionEvent e){
            if (e.getSource() == zeroButton) {
                display.setText(display.getText() + "0");
            } else if (e.getSource() == oneButton) {
                display.setText(display.getText() + "1");
            } else if (e.getSource() == twoButton) {
                display.setText(display.getText() + "2");
            } else if (e.getSource() == threeButton) {
                display.setText(display.getText() + "3");
            } else if (e.getSource() == fourButton) {
                display.setText(display.getText() + "4");
            } else if (e.getSource() == fiveButton) {
                display.setText(display.getText() + "5");
            } else if (e.getSource() == sixButton) {
                display.setText(display.getText() + "6");
            } else if (e.getSource() == sevenButton) {
                display.setText(display.getText() + "7");
            } else if (e.getSource() == eightButton) {
                display.setText(display.getText() + "8");
            } else if (e.getSource() == nineButton) {
                display.setText(display.getText() + "9");
            } else if (e.getSource() == plusButton) {
                firstNumber = Double.parseDouble(display.getText());
                operation = "+";
                display.setText("");
            } else if (e.getSource() == minusButton) {
                firstNumber = Double.parseDouble(display.getText());
                operation = "-";
                display.setText("");
            } else if (e.getSource() == timesButton) {
                firstNumber = Double.parseDouble(display.getText());
                operation = "*";
                display.setText("");
            } else if (e.getSource() == divideButton) {
                firstNumber = Double.parseDouble(display.getText());
                operation = "/";
                display.setText("");
            } else if (e.getSource() == equalsButton) {
                secondNumber = Double.parseDouble(display.getText());
                if (operation.equals("+")) {
                    result = firstNumber + secondNumber;
                } else if (operation.equals("-")) {
                    result = firstNumber - secondNumber;
                } else if (operation.equals("*")) {
                    result = firstNumber * secondNumber;
                } else if (operation.equals("/")) {
                    result = firstNumber / secondNumber;
                }
                display.setText(Double.toString(result));
                operation = "";
            } else if (e.getSource() == clearButton) {
                display.setText("");
                firstNumber = 0;
                secondNumber = 0;
                result = 0;
                operation = "";
            } else if (e.getSource() == squareButton) {
                double number = Double.parseDouble(display.getText());
                result = number * number;
                display.setText(Double.toString(result));
            } else if (e.getSource() == sqrtButton) {
                double number = Double.parseDouble(display.getText());
                result = Math.sqrt(number);
                display.setText(Double.toString(result));
            }
        }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}