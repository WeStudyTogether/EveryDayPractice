package snake;

import javax.swing.JFrame;

/**
* @author Guangyao Gou
* @date 2020/56/08 22:56:17
* @ClassName Mysnake.java
* @Description 类描述
*/

public class Mysnake {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 900, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MPanel());
        
        frame.setVisible(true);
    }

}
