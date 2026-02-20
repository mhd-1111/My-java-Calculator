import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class Mycalculator implements ActionListener{
    int flag=0;
    String oldvalue,newvalue;
    String expression = "";
    String currentInput = "";
    String pendingFunction = "";
    float result;
    boolean isoperatorclicked=false;
    boolean justCalculated = false;
    float current;

    JFrame jf;
    JLabel displayLabel;
    JPanel displayPanel;
    JPanel buttonPanel;
    JPanel topPanel;
    JPanel numberPanel;
    JPanel operatorPanel;
    JPanel CenterPanel;

    JButton sevenB,eightB,nineB,sixB,fiveB,fourB,oneB,twoB,threeB,dotB,zeroB,equalB,divB,multB,plusB,subB,clearB,backB,sinB,cosB,tanB;
    String lastOperator = "";
    float lastOperand = 0;

    private void styleDisplay(JLabel label) {
        label.setBackground(new Color(30, 30, 30));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 32));
        label.setHorizontalAlignment(JLabel.RIGHT);
        
        label.setPreferredSize(new java.awt.Dimension(0, 70));
        
        label.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createMatteBorder(2,2,4,4,new Color(10,10,10)),
                javax.swing.BorderFactory.createMatteBorder(2,2,2,2,new Color(80,80,80))
            )
        );
    }


    public Mycalculator(){
        jf = new JFrame("calculator");
        jf.setLayout(new BorderLayout(10, 10));

        jf.setLocation(250,150);
        jf.getContentPane().setBackground(new Color(18, 18, 18));

        

        displayPanel=new JPanel(new GridLayout(1,1));
        displayPanel.setBackground(new Color(18,18,18));
        displayPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15,15,10,15));
        
        topPanel = new JPanel(new GridLayout(1,7,10,10));
        topPanel.setBackground(new Color(18,18,18));

        numberPanel = new JPanel(new GridLayout(4,3,10,10));
        numberPanel.setBackground(new Color(18,18,18));

        operatorPanel = new JPanel(new GridLayout(4,1,10,10));
        operatorPanel.setBackground(new Color(18,18,18));

        CenterPanel = new JPanel(new BorderLayout(10,10));
        CenterPanel.setBackground(new Color(18,18,18));

        CenterPanel.add(numberPanel,BorderLayout.CENTER);
        CenterPanel.add(operatorPanel,BorderLayout.EAST);

        buttonPanel=new JPanel(new BorderLayout(10,10));
        buttonPanel.setBackground(new Color(18, 18, 18));
        buttonPanel.add(topPanel,BorderLayout.NORTH);
        buttonPanel.add(CenterPanel,BorderLayout.CENTER);

        jf.add(buttonPanel,BorderLayout.CENTER);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        displayLabel =new JLabel("");
        styleDisplay(displayLabel);

        
        displayPanel.add(displayLabel);

        jf.add(displayPanel,BorderLayout.NORTH);
        jf.add(buttonPanel,BorderLayout.CENTER);
        
        sinB = new JButton("SIN");
        sinB.addActionListener(this);
        styleButton(sinB);
        topPanel.add(sinB);

        cosB = new JButton("COS");
        cosB.addActionListener(this);
        styleButton(cosB);
        topPanel.add(cosB);

        tanB = new JButton("TAN");
        tanB.addActionListener(this);
        styleButton(tanB);
        topPanel.add(tanB);

        sevenB=new JButton("7");
        sevenB.addActionListener(this);
        styleButton(sevenB);
        numberPanel.add(sevenB);


        eightB=new JButton("8");
        eightB.addActionListener(this);
        styleButton(eightB);
        numberPanel.add(eightB);

        
        nineB=new JButton("9");
        nineB.addActionListener(this);
        styleButton(nineB);
        numberPanel.add(nineB);

        
        fourB=new JButton("4");
        fourB.addActionListener(this);
        styleButton(fourB);
        numberPanel.add(fourB);

        
        fiveB=new JButton("5");
        fiveB.addActionListener(this);
        styleButton(fiveB);
        numberPanel.add(fiveB);


        sixB=new JButton("6");
        sixB.addActionListener(this);
        styleButton(sixB);
        numberPanel.add(sixB);


        oneB=new JButton("1");
        oneB.addActionListener(this);
        styleButton(oneB);
        numberPanel.add(oneB);


        twoB=new JButton("2");
        twoB.addActionListener(this);
        styleButton(twoB);
        numberPanel.add(twoB);


        threeB=new JButton("3");
        threeB.addActionListener(this);
        styleButton(threeB);
        numberPanel.add(threeB);


        dotB=new JButton(".");
        dotB.addActionListener(this);
        styleButton(dotB);
        numberPanel.add(dotB);


        zeroB=new JButton("0");
        zeroB.addActionListener(this);
        styleButton(zeroB);
        numberPanel.add(zeroB);


        equalB=new JButton("=");
        equalB.addActionListener(this);
        styleOperatorButton(equalB);
        numberPanel.add(equalB);

        multB=new JButton("*");
        multB.addActionListener(this);
        styleOperatorButton(multB);
        operatorPanel.add(multB);
        

        divB=new JButton("/");
        divB.addActionListener(this);
        styleOperatorButton(divB);
        operatorPanel.add(divB);
        

        subB=new JButton("-");
        subB.addActionListener(this);
        styleOperatorButton(subB);
        operatorPanel.add(subB);
        

        plusB=new JButton("+");
        plusB.addActionListener(this);
        styleOperatorButton(plusB);
        operatorPanel.add(plusB);
        

        clearB=new JButton("AC");
        clearB.addActionListener(this);
        Color acNormal = new Color(180, 50, 50);
        Color acHover = new Color(210, 80, 80);
        clearB.setForeground(Color.WHITE);
        clearB.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        addHoverEffect(clearB, acNormal, acHover);
        topPanel.add(clearB);


        backB=new JButton("C");
        backB.addActionListener(this);
        Color cNormal = new Color(120, 80, 40);
        Color cHover = new Color(150, 100, 60);
        backB.setForeground(Color.WHITE);
        backB.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        addHoverEffect(backB, cNormal, cHover);
        topPanel.add(backB);

        jf.pack();                
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }
    private void styleButton(JButton btn) {
        btn.setPreferredSize(new java.awt.Dimension(90, 60));
        btn.setBackground(new Color(45, 45, 45));
        Color normal = new Color(45, 45, 45);
        Color hover = new Color(65, 65, 65);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        addHoverEffect(btn, normal, hover);
    }

    private void styleOperatorButton(JButton b){
        b.setPreferredSize(new java.awt.Dimension(90, 60));
        b.setBackground(new Color(255, 140, 0)); // orange accent
        Color normal = new Color(255, 140, 0);
        Color hover = new Color(255, 170, 60);

        b.setForeground(Color.BLACK);
        b.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        addHoverEffect(b, normal, hover);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
    }

    private void addHoverEffect(JButton btn, Color normal, Color hover) {

    // Store original 3D border
    Border raisedBorder = javax.swing.BorderFactory.createCompoundBorder(
        javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 4, new Color(15, 15, 15)),
        javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(80, 80, 80))
    );

    // Pressed-in border
    Border pressedBorder = javax.swing.BorderFactory.createMatteBorder(
        4, 4, 2, 2, new Color(15, 15, 15)
    );
    
    

    btn.setBorder(raisedBorder);

    btn.addMouseListener(new java.awt.event.MouseAdapter() {

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            btn.setBackground(hover);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            btn.setBackground(normal);
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            btn.setBorder(pressedBorder);
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            btn.setBorder(raisedBorder); 
        }
    });
}

    public static void main(String[] args){
        new Mycalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sevenB){
            if(justCalculated ){
                expression="";
                currentInput="";
                justCalculated = false;
            }
            expression +="7";
            currentInput += "7";
            displayLabel.setText(expression);
        }
        else if(e.getSource()==eightB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "8";          
            currentInput += "8";
            displayLabel.setText(expression);
    
        }
        else if(e.getSource()==nineB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "9";            
            currentInput += "9";
            displayLabel.setText(expression);

            
        }else if(e.getSource()==fourB){
           if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "4";            
            currentInput += "4";
            displayLabel.setText(expression);
            
        }else if(e.getSource()==fiveB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "5";            
            currentInput += "5";
            displayLabel.setText(expression);

        }else if(e.getSource()==sixB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "6";            
            currentInput += "6";
            displayLabel.setText(expression);

        }else if(e.getSource()==oneB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "1";            
            currentInput += "1";
            displayLabel.setText(expression);

        }else if(e.getSource()==twoB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "2";            
            currentInput += "2";
            displayLabel.setText(expression);
            
        }else if(e.getSource()==threeB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "3";            
            currentInput += "3";
            displayLabel.setText(expression);

        }else if(e.getSource()==dotB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += ".";            
            currentInput += ".";
            displayLabel.setText(expression);
        }else if(e.getSource()==zeroB){
            if (justCalculated) {
                expression = "";
                currentInput="";
                justCalculated = false;
            }

            expression += "0";            
            currentInput += "0";
            displayLabel.setText(expression);

        }else if(e.getSource()==equalB){
            if(!pendingFunction.isEmpty() && !currentInput.isEmpty()){
                double value = Double.parseDouble(currentInput);
                double radians = Math.toRadians(value);
                double result = 0;

                switch (pendingFunction) {
                    case "SIN":
                        result = Math.sin(radians);
                        break;
                    case "COS":
                        result = Math.cos(radians);
                        break;
                    case "TAN":
                        if(value % 180 == 90){
                            displayLabel.setText(" SYNTAX ERROR ");
                            return;
                        }
                        result = Math.tan(radians);
                        break;
                }
                
                if (Math.abs(result) < 1e-10) result = 0;
                result = Double.parseDouble(String.format("%.6f", result));
                displayLabel.setText(String.valueOf(result));
                

                pendingFunction = "";
                currentInput = "";
                justCalculated = true;
                return;
            }
            
            if(justCalculated){
                current=Float.parseFloat(displayLabel.getText());
                if(lastOperator.equals("+")){
                    result=current+lastOperand;
                }else if(lastOperator.equals("-")){
                    result=current-lastOperand;
                }else if(lastOperator.equals("*")){
                    result=current*lastOperand;
                }else if(lastOperator.equals("/")){
                    if(lastOperand==0){
                        displayLabel.setText(" SYNTAX ERROR ");
                        return;
                    }
                    result=current/lastOperand;
                }
                displayLabel.setText(result+"");
                justCalculated = true;
                return;
            
            }
            if(oldvalue == null || oldvalue.isEmpty()){
            return;
            }

            newvalue=currentInput;
            float oldvalueF=Float.parseFloat(oldvalue);
            float newvalueF=Float.parseFloat(newvalue);
            lastOperand=newvalueF;
            if(flag==4){
                result=oldvalueF+newvalueF;
                lastOperator="+";
            }
            else if(flag==2){
                result=oldvalueF*newvalueF;
                lastOperator="*";
            }else if(flag==3){
                result=oldvalueF-newvalueF;
                lastOperator="-";    
            }else if(flag==1){
                if(newvalueF==0){
                    displayLabel.setText(" SYNTAX ERROR ");
                    return;
                }else{
                    result=oldvalueF/newvalueF;
                    lastOperator="/";
                }
            }

            displayLabel.setText(String.valueOf(result));

            expression = String.valueOf(result);
            currentInput=expression;
            justCalculated=true;

        }else if(e.getSource()==divB){
            if(expression.isEmpty()) return;

                flag = 1;
                oldvalue = currentInput;
                currentInput = "";
                expression += "/";
                displayLabel.setText(expression);

        }else if(e.getSource()==multB){
            if(expression.isEmpty()) return;

                flag = 2;
                oldvalue = currentInput;
                currentInput = "";
                expression += "*";
                displayLabel.setText(expression);

        }else if(e.getSource()==subB){
           if(expression.isEmpty()) return;

                flag = 3;
                oldvalue = currentInput;
                currentInput = "";
                expression += "-";
                displayLabel.setText(expression);

        }else if(e.getSource()==plusB){
            if(expression.isEmpty()) return;

                flag = 4;
                oldvalue = currentInput;
                currentInput = "";
                expression += "+";
                displayLabel.setText(expression);                                
        }else if(e.getSource() == sinB){
            pendingFunction = "SIN";
            displayLabel.setText("sin ");
            currentInput = "";
            justCalculated = false;
        }else if(e.getSource()== cosB){
            pendingFunction = "COS";
            displayLabel.setText("cos ");
            currentInput = "";
            justCalculated = false;            
        }else if(e.getSource() == tanB){
            pendingFunction = "TAN";
            displayLabel.setText("tan ");
            currentInput = "";
            justCalculated = false;
        }

        
        else if(e.getSource()==clearB){ // AC
                displayLabel.setText("");
                expression = "";
                currentInput = "";
                oldvalue = "";
                newvalue = "";
                flag = 0;
                isoperatorclicked = false;
                justCalculated=false;
        }else if(e.getSource()==backB){ // C 
            String text = displayLabel.getText();
            if(text.length() > 0){
                displayLabel.setText(text.substring(0, text.length() - 1));
                if(!currentInput.isEmpty()){
                    currentInput = currentInput.substring(0,currentInput.length() -1);
                }
                if(!expression.isEmpty()){
                    expression = expression.substring(0,expression.length() -1);
                }
            }
        }
    }
}                                               