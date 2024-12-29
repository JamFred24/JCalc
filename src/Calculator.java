import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton[] trigButtons = new JButton[8];
    JButton[] expButtons = new JButton[5];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton sinButton, cosButton, tanButton, arcsinButton, arccosButton, arctanButton;
    JButton toRadiansButton, toDegreesButton;
    JButton eButton, expTenButton, logButton, logTenButton, powerButton;
    JPanel panel;
    JPanel trigPanel;

    Font myfont = new Font("Arial", Font.BOLD, 30);
    Font smallfont = new Font("Arial", Font.BOLD, 14);

    double num1=0,num2=0,result=0;
    char operator;
    boolean radians = true;

    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myfont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        sinButton = new JButton("sin()");
        cosButton = new JButton("cos()");
        tanButton = new JButton("tan()");
        arcsinButton = new JButton("asin()");
        arccosButton = new JButton("acos()");
        arctanButton = new JButton("atan()");
        toDegreesButton = new JButton("DEG");
        toRadiansButton = new JButton("RAD");

        eButton = new JButton("e^x");
        expTenButton = new JButton("10^x");
        logButton = new JButton("ln(x)");
        logTenButton = new JButton("log(x)");
        powerButton = new JButton("x^y");


        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        
        trigButtons[0] = sinButton;
        trigButtons[1] = cosButton;
        trigButtons[2] = tanButton;
        trigButtons[3] = arcsinButton;
        trigButtons[4] = arccosButton;
        trigButtons[5] = arctanButton;
        trigButtons[6] = toRadiansButton;
        trigButtons[7] = toDegreesButton;

        expButtons[0] = eButton;
        expButtons[1] = expTenButton;
        expButtons[2] = logButton;
        expButtons[3] = logTenButton;
        expButtons[4] = powerButton;

        for(int i=0; i<5; i++){
            expButtons[i].addActionListener(this);
            expButtons[i].setFont(smallfont);
            expButtons[i].setFocusable(false);
        }


        for(int i=0; i<8; i++) {
            trigButtons[i].addActionListener(this);
            trigButtons[i].setFont(new Font("ARIAL", Font.BOLD, 18));
            trigButtons[i].setFocusable(false);
        }

        for(int i = 0; i<9;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        powerButton.setBounds(275, 430, 75, 50);

        eButton.setBounds(370, 430, 75, 50);
        expTenButton.setBounds(445, 430, 75, 50);
        logButton.setBounds(515, 430, 75, 50);
        logTenButton.setBounds(585, 430, 75, 50);

        trigPanel = new JPanel();
        trigPanel.setBounds(370,100,200,300);
        trigPanel.setLayout(new GridLayout(4,2,10,10));
        trigPanel.add(sinButton);
        trigPanel.add(arcsinButton);
        trigPanel.add(cosButton);
        trigPanel.add(arccosButton);
        trigPanel.add(tanButton);
        trigPanel.add(arctanButton);
        trigPanel.add(toDegreesButton);
        trigPanel.add(toRadiansButton);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(trigPanel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(powerButton);
        frame.add(eButton);
        frame.add(expTenButton);
        frame.add(logButton);
        frame.add(logTenButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i<10;i++) {
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==powerButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        if(e.getSource()==equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case  '^':
                    result = Math.pow(num1, num2);
                    break;

            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clrButton) {
            textField.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1;i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *=-1;
            textField.setText(String.valueOf(temp));
        }

        if(e.getSource() ==sinButton){
            if(radians){
                result = Math.sin(Double.parseDouble(textField.getText()));
                textField.setText(String.valueOf(result));
            }else{
                //Converting to radians if set to degrees
                double temp = Math.toRadians(Double.parseDouble(textField.getText()));
                result = Math.sin(temp);
                textField.setText(String.valueOf(result));
            }
        }
        if(e.getSource()==cosButton){
            if(radians){
                result = Math.cos(Double.parseDouble(textField.getText()));
                textField.setText(String.valueOf(result));
            }else{
                //Converting to radians if set to degrees
                double temp = Math.toRadians(Double.parseDouble(textField.getText()));
                result = Math.cos(temp);
                textField.setText(String.valueOf(result));
            }
        }
        if(e.getSource()==tanButton){
            if(radians){
                result = Math.tan(Double.parseDouble(textField.getText()));
                textField.setText(String.valueOf(result));
            }else{
                //Converting to radians if set to degrees
                double temp = Math.toRadians(Double.parseDouble(textField.getText()));
                result = Math.tan(temp);
                textField.setText(String.valueOf(result));
            }
        }
        if(e.getSource()==arcsinButton){
            if(radians){
                result = Math.asin(Double.parseDouble(textField.getText()));
                textField.setText(String.valueOf(result));
            }else{
                //Converting to degrees if set to radians
                double temp = Math.asin(Double.parseDouble(textField.getText()));
                result = Math.toDegrees(temp);
                textField.setText(String.valueOf(result));
            }
        }
        if(e.getSource()==arccosButton){
            if(radians){
                result = Math.acos(Double.parseDouble(textField.getText()));
                textField.setText(String.valueOf(result));
            }else{
                //Converting to degrees if set to radians
                double temp = Math.acos(Double.parseDouble(textField.getText()));
                result = Math.toDegrees(temp);
                textField.setText(String.valueOf(result));
            }
        }
        if(e.getSource()==arctanButton){
            if(radians){
                result = Math.atan(Double.parseDouble(textField.getText()));
                textField.setText(String.valueOf(result));
            }else{
                //Converting to degrees if set to radians
                double temp = Math.atan(Double.parseDouble(textField.getText()));
                result = Math.toDegrees(temp);
                textField.setText(String.valueOf(result));
            }
        }
        if(e.getSource()==toRadiansButton){
           if(!radians){
               radians = true;
           }
        }
        if(e.getSource()==toDegreesButton){
            if(radians){
                radians = false;
            }
        }
        if(e.getSource()==eButton){
            double temp = Double.parseDouble(textField.getText());
            result = Math.exp(temp);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource()==expTenButton){
            double temp = Double.parseDouble(textField.getText());
            result = Math.pow(10, temp);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource()==logButton){
            double temp = Double.parseDouble(textField.getText());
            result = Math.log(temp);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource()==logTenButton){
            double temp = Double.parseDouble(textField.getText());
            result = Math.log10(temp);
            textField.setText(String.valueOf(result));
        }

    }

}
