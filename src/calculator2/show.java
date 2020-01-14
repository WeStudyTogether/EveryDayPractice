package calculator2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author Guangyao Gou
 * @date 2020/52/14 19:52:41
 * @ClassName show.java
 * @Description 类描述
 */

public class show extends JFrame {
    private String[] ajm = { "%", "√", "X^2", "1/X", "ce", "c", "<<<", "÷", "7", "8", "9", "*", "4", "5", "6", "－", "1",
            "2", "3", "+", "+/-", "0", ".", "=" };
    private JButton[] Ajm = new JButton[ajm.length];
    public JTextArea t1 = new JTextArea();
    public JTextArea t2 = new JTextArea();
    String str = "", str1 = "";
    double b = 0;
    char ch = 0;

    private void kuangjia() {
        this.setTitle("计算器");
        this.setVisible(true);
        setLayout(null);
        setBounds(1000, 100, 620, 900);

        for (int i = 0; i < ajm.length; i++) {
            Ajm[i] = new JButton(ajm[i]);
        }
        int begin = 0, bend = 250;
        for (int i = 0; i < ajm.length;) {
            int j = 0;
            while (j < 4) {
                Ajm[i].setBounds(begin, bend, 150, 100);
                Ajm[i].setFont(new Font("宋体", Font.BOLD, 45));

                add(Ajm[i]);
                i++;
                j++;
                begin += 150;

            }
            begin = 0;
            bend += 100;
        }
        ;

        for (int i = 8; i < 19; i++) {
            if (i == 11 || i == 15)
                i++;
            Ajm[i].setBackground(Color.white);
        }
        Ajm[21].setBackground(Color.white);

        t1.setFont(new Font("宋体", Font.BOLD, 40));
        add(t1);
        t1.setBounds(0, 0, 600, 100);
        t1.setEditable(false);
        t2.setFont(new Font("宋体", Font.BOLD, 40));
        add(t2);
        t2.setBounds(0, 99, 600, 100);
        t2.setEnabled(false);

//        Ajm[0].addActionListener(new ajm0());   不懂，没用过
        Ajm[1].addActionListener(new ajm1());
//        Ajm[2].addActionListener(new ajm2());
//        Ajm[3].addActionListener(new ajm3());
        Ajm[4].addActionListener(new ajm4());
        Ajm[5].addActionListener(new ajm5());
        Ajm[6].addActionListener(new ajm6());
        Ajm[7].addActionListener(new ajm7());
        Ajm[8].addActionListener(new ajm8());
        Ajm[9].addActionListener(new ajm9());
        Ajm[10].addActionListener(new ajm10());
        Ajm[11].addActionListener(new ajm11());
        Ajm[12].addActionListener(new ajm12());
        Ajm[13].addActionListener(new ajm13());
        Ajm[14].addActionListener(new ajm14());
        Ajm[15].addActionListener(new ajm15());
        Ajm[16].addActionListener(new ajm16());
        Ajm[17].addActionListener(new ajm17());
        Ajm[18].addActionListener(new ajm18());
        Ajm[19].addActionListener(new ajm19());
        Ajm[20].addActionListener(new ajm20());
        Ajm[21].addActionListener(new ajm21());
        Ajm[22].addActionListener(new ajm22());
        Ajm[23].addActionListener(new ajm23());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    class ajm0 implements ActionListener{
//        public void actionPerformed(ActionEvent arg0) {
//
//            if(str1.length()==0)
//            {
//                t1.setText("0");
//                t2.setText("0");
//                str="";
//                return;
//            }//当什么都没有输入直接按的情况    
//        else if(str.length()!=0)
//            {
//            t1.setText(str1);
//            double t=b*b/100;
//            str=String.valueOf(t);
//            t1.setText(str1);
//            t2.setText(str);
//            }//有一定的输入后，即按了运算符号后还没输入值的情况，即对b进行操作
//            //12+12+这时候按下后应当是对24进行操作
//        else {
//            double dd=Double.parseDouble(str);
//            dd=b*dd/100;
//            str=String.valueOf(dd);
//            t1.setText(str1);
//            t2.setText(str);
//        }///否则则是对正使用下对输入值的转变24 变0.24
//        }
//    }    
    class panduan {
        public void pd(char a) {
            if (a == 0) {
                if (str.length() == 0)
                    b = 0;
                else
                    b = Double.parseDouble(str);
            } else {
                switch (a) {
                case 43: {
                    b += Double.parseDouble(str);
                    t2.setText(String.valueOf(b));
                    break;
                }
                case 45: {
                    b -= Double.parseDouble(str);
                    t2.setText(String.valueOf(b));
                    break;
                }
                case 42: {
                    b *= Double.parseDouble(str);
                    t2.setText(String.valueOf(b));
                    break;
                }
                case 47: {
                    double aa = Double.parseDouble(str);
                    if (aa == 0) {
                        t2.setText("除数不能为0");
                        str1 = "";
                        str = "";
                        b = 0;
                        break;
                    }
                    b = b / aa;
                    t2.setText(String.valueOf(b));
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value: " + a);
                }
            }
        }
    }

    class ajm1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (str.length() == 0) {
                t1.setText(str1);
                double t = Math.sqrt(b);
                str = String.valueOf(t);

                t2.setText(str);
            } else {
                double dd = Double.parseDouble(str);
                dd *= dd;
                str = String.valueOf(dd);
                t1.setText(str1);
                t2.setText(str);
            }
        }

    }

    class ajm4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            str = "";
            t2.setText(str);
        }

    }

    class ajm5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            str = "";
            t2.setText(str);
            str1 = "";
            t1.setText(str1);
            b = 0;
            ch = 0;
        }

    }

    class ajm6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (str.length() == 0)
                t2.setText("");

            else {
                char ss[] = str.toCharArray();
                ss[str.length() - 1] = 32;
                str = String.valueOf(ss);
                str = str.trim();
                t2.setText(str);
            }
        }

    }

    class ajm7 extends panduan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            int r = str1.length();
            if (r > 0 && str.length() == 0) {
                char a[] = str1.toCharArray();
                if (a[r - 1] < 48 || a[r - 1] > 57) {
                    a[str1.length()] = 47;
                    str1 = String.valueOf(a);
                    t1.setText(str1);
                    ch = 47;
                    return;
                }
            }

            if (str.length() == 0) {
                str1 = "0";
                t2.setText("0");
            }
            str1 += str + new String("➗");
            t1.setText(str1);
            this.pd(ch);
            ch = 47;
            t1.setText(str1);
            str = "";
        }       
    }

    class ajm8 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 7;
            t2.setText(str);
        }
    }

    class ajm9 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 8;
            t2.setText(str);
        }
    }

    class ajm10 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 9;
            t2.setText(str);
        }
    }

    class ajm11 extends panduan implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            int r;
            r = str1.length();
            if (r > 0 && str.length() == 0) {
                char a[] = str1.toCharArray();
                if (a[r - 1] < 48 || a[r - 1] > 57) {
                    a[str1.length() - 1] = 42;
                    str1 = String.valueOf(a);
                    t1.setText(str1);
                    ch = 42;
                    return;
                }
            }

            if (str.length() == 0) {
                str1 = new String("1");
                t2.setText("0");
                b = 1;
            }
            str1 += str + new String("*");
            t1.setText(str1);
            this.pd(ch);
            ch = 42;
            t1.setText(str1);
            str = "";
        }
    }

    class ajm12 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 4;
            t2.setText(str);
        }
    }

    class ajm13 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 5;
            t2.setText(str);
        }
    }

    class ajm14 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 6;
            t2.setText(str);
        }
    }

    class ajm15 extends panduan implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            int r;
            r = str1.length();
            if (r > 0 && str.length() == 0) {
                char a[] = str1.toCharArray();
                if (a[r - 1] < 48 || a[r - 1] > 57) {
                    a[str1.length() - 1] = 45;
                    str1 = String.valueOf(a);
                    t1.setText(str1);
                    ch = 45;
                    return;
                }
            } //

            if (str.length() == 0) {
                str1 = new String("0");
                t2.setText("0");
            }
            str1 += str + new String("-");
            t1.setText(str1);
            this.pd(ch);
            ch = 45;
            t1.setText(str1);
            str = "";

        }
    }

    class ajm16 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 1;
            t2.setText(str);
        }
    }

    class ajm17 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 2;
            t2.setText(str);
        }
    }

    class ajm18 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 3;
            t2.setText(str);
        }
    }

    class ajm19 extends panduan implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            int r;
            r = str1.length();
            if (r > 0 && str.length() == 0) {
                char a[] = str1.toCharArray();
                if (a[r - 1] < 48 || a[r - 1] > 57) {
                    a[str1.length() - 1] = 43;
                    str1 = String.valueOf(a);
                    t1.setText(str1);
                    ch = 43;
                    return;
                }
            }
            if (str.length() == 0)// 下空
            {
                str1 = new String("0");
                t2.setText("0");
            }
            str1 += str + new String("+");
            t1.setText(str1);
            this.pd(ch);
            ch = 43;
            t1.setText(str1);
            str = "";
        }
    }

    class ajm20 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(str.length() ==0) {
                t1.setText(str1);
                double t = - b;
                str = String.valueOf(t);
                t1.setText(str1);
                t2.setText(str);
            }else {
                double dd  = Double.parseDouble(str);
                str = String.valueOf(dd);
                t1.setText(str1);
                t2.setText(str);
            }
        }
    }
    class ajm21 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += 0;
            t2.setText(str);
        }
    }

    class ajm22 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            str += ".";
            t2.setText(str);
        }
    }
    
    class ajm23 extends panduan implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            if(str1.length()>0 &&str.length() == 0) {
                char[] a = str1.toCharArray();
                if(a[str1.length()-1]<48||a[str1.length()-1]>57) {
                    t1.setText("0");
                    t2.setText(String.valueOf(b));
                    return;
                }
            }
            this.pd(ch);
            t1.setText("0");
            str1="";
            str="";
            ch=0;
        }
    }
    public static void main(String[] args) {
        show s = new show();
        s.kuangjia();
    }
}
