package calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Guangyao Gou
 * @date 2020/58/13 11:58:30
 * @ClassName CalculatorFrame.java
 * @Description 类描述
 */

public class CalculatorFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    JPanel panel;
    JTextArea t1, t2;

    public CalculatorFrame() {
        super("计算器");

        setMainFrame();
        setJpanel();
        setJTextArea();
        setJButtonArea();

    }

    private void setJButtonArea() {
        addButton("7", 33, 28, 20, 178);
        addButton("8", 33, 28, 58, 178);
        addButton("9", 33, 28, 96, 178);
        addButton("/", 33, 28, 134, 178);
        addButton("%", 33, 28, 172, 178);
        
        addButton("4", 33, 28, 20, 210);
        addButton("5", 33, 28, 58, 210);
        addButton("6", 33, 28, 96, 210);
        addButton("*", 33, 28, 134, 210);
        addButton("1/x", 33, 28, 172, 210);
        
        addButton("1", 33, 28, 20, 242);
        addButton("2", 33, 28, 58, 242);
        addButton("3", 33, 28, 96, 242);
        addButton("-", 33, 28, 134, 242);
        
        addButton("0", 71, 28, 20, 274);
        addButton(".", 33, 28, 96, 274);
        addButton("+", 33, 28, 134, 274);
        
        addButton("=", 33, 60, 172, 242);
    }

    double m, n;
    String k;
    boolean flag = true, flag2 = false;
    
    private void addButton(String string, int i, int j, int x, int y) {
        final Button b = new Button(string);
        b.setLocation(x, y);
        b.setSize(i, j);
        b.setFont(new Font("标楷体", Font.BOLD, 15));
        b.setBackground(Color.BLUE);
        setForeground(Color.DARK_GRAY);
        b.addMouseListener(new MouseAdapter() {
            private void counts() {
               
                if(t1.getText().equals("")&&(b.getActionCommand().equals("+")||
                        b.getActionCommand().equals("-")||
                        b.getActionCommand().equals("*")||
                        b.getActionCommand().equals("/")||
                        b.getActionCommand().equals("%")||
                        b.getActionCommand().equals("1/x")||
                        b.getActionCommand().equals("="))) {
                    
                }
                
                else if(t1.getText().equals(".")&&(b.getActionCommand().equals("+")||
                        b.getActionCommand().equals("-")||
                        b.getActionCommand().equals("*")||
                        b.getActionCommand().equals("/")||
                        b.getActionCommand().equals("%")||
                        b.getActionCommand().equals("1/x")||
                        b.getActionCommand().equals("="))) {
                    
                }
                
                else if(b.getActionCommand().equals("+")||
                        b.getActionCommand().equals("-")||
                        b.getActionCommand().equals("*")||
                        b.getActionCommand().equals("/")||
                        b.getActionCommand().equals("%")||
                        b.getActionCommand().equals("1/x")) {
                    if (flag2 = true)
                        flag2 = false;
                    if(flag) {
                        n = new Double(t1.getText()).doubleValue();
                        flag = false;
                    }
                }
            }
            public void mousePressed(MouseEvent e) {
                counts();
            }
        });
    }

    private void setJTextArea() {
        t1 = new JTextArea("0", 3, 20);
        t1.setBackground(Color.lightGray);
        t1.setSize(180, 50);
        t1.setFont(new Font("标楷体", Font.BOLD, 15));
        t1.setLocation(20, 60);
        t1.setEditable(false);
        this.add(t1);
        t2 = new JTextArea("Made By GGY", 3, 20);
        t2.setBackground(Color.BLUE);
        t2.setSize(180, 25);
        t2.setFont(new Font("标楷体", Font.BOLD, 16));
        t2.setForeground(Color.darkGray);
        t2.setLocation(20, 130);
        t2.setEditable(false);
        this.add(t2);

    }

    private void setJpanel() {
        panel = new JPanel();
        this.add(panel);
    }

    @SuppressWarnings("static-access")
    private void setMainFrame() {
        this.setLayout(null);
        this.setSize(220, 310);
        this.setVisible(true);
        this.setLocation(310, 340);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

}
