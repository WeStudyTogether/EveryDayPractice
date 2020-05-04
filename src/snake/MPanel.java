package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;




/**
 * @author Guangyao Gou
 * @date 2020/00/08 23:00:21
 * @ClassName MPanel.java
 * @Description 类描述
 */

@SuppressWarnings("serial")
public class MPanel extends JPanel implements KeyListener, ActionListener {
    ImageIcon title;
    ImageIcon body;
    ImageIcon up;
    ImageIcon down;
    ImageIcon left;
    ImageIcon right;
    ImageIcon food;

    int len = 3;
    int score;
    int[] snakex = new int[750];
    int[] snakey = new int[750];
    String fx;
    boolean isStarted = false;
    boolean isDead = false;
    Timer timer = new Timer(100, this);
    int foodx;
    int foody;
    Random rand = new Random();
    
    Clip bgm;

    public MPanel() {
        loadImages();
        loadBGM();
        initSnake();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
        
    }

    private void loadImages() {
        InputStream is;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream("images/title.jpg");
            title = new ImageIcon(ImageIO.read(is));
            is = this.getClass().getClassLoader().getResourceAsStream("images/body.png");
            body = new ImageIcon(ImageIO.read(is));
            is = this.getClass().getClassLoader().getResourceAsStream("images/up.png");
            up = new ImageIcon(ImageIO.read(is));
            is = this.getClass().getClassLoader().getResourceAsStream("images/down.png");
            down = new ImageIcon(ImageIO.read(is));
            is = this.getClass().getClassLoader().getResourceAsStream("images/left.png");
            left = new ImageIcon(ImageIO.read(is));
            is = this.getClass().getClassLoader().getResourceAsStream("images/right.png");
            right = new ImageIcon(ImageIO.read(is));
            is = this.getClass().getClassLoader().getResourceAsStream("images/food.png");
            food = new ImageIcon(ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        title.paintIcon(this, g, 25, 11);

        g.fillRect(25, 75, 850, 600);
        g.setColor(Color.white);
        g.drawString("Length "+len, 750, 35);
        g.drawString("Score "+score, 750, 50);
        
        if (fx == "R")
            right.paintIcon(this, g, snakex[0], snakey[0]);
        else if (fx == "L")
            left.paintIcon(this, g, snakex[0], snakey[0]);
        else if (fx == "U")
            up.paintIcon(this, g, snakex[0], snakey[0]);
        else if (fx == "D")
            down.paintIcon(this, g, snakex[0], snakey[0]);
        for (int i = 1; i < len; i++) {
            body.paintIcon(this, g, snakex[i], snakey[i]);
        }
        
        food.paintIcon(this, g, foodx, foody);

        if (isStarted == false) {
            g.setColor(Color.white);
            g.setFont(new Font("arial", Font.BOLD, 40));
            g.drawString("Press Space to Start", 300, 300);
        }       
        if (isDead) {
            g.setColor(Color.RED);
            g.setFont(new Font("arial", Font.BOLD, 40));
            g.drawString("You Die:Press Space to Restart", 200, 300);
        }

    }

    public void initSnake() {
        len = 3;
        snakex[0] = 100;
        snakex[1] = 75;
        snakex[2] = 50;
        snakey[0] = 100;
        snakey[1] = 100;
        snakey[2] = 100;
        foodx = 25+25*rand.nextInt(34);
        foody = 75+25*rand.nextInt(24);
        fx = "R";
        score = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_SPACE) {
            if (isDead) {
                isDead = false;
                initSnake();
            }
            else
            isStarted = !isStarted;
            repaint();
            if(isStarted)
                playBGM();
            else
                stopBGM();
        }
        else if(keycode == KeyEvent.VK_UP){
            fx = "U";
        }
        else if(keycode == KeyEvent.VK_DOWN){
            fx = "D";
        }
        else if(keycode == KeyEvent.VK_RIGHT){
            fx = "R";
        }
        else if(keycode == KeyEvent.VK_LEFT){
            fx = "L";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(isStarted && !isDead) {
            for(int i = len - 1; i>0; i--) {
                snakex[i] = snakex[i-1];
                snakey[i] = snakey[i-1];
            }       
            
            if (fx=="U") {
                snakey[0] = snakey[0] - 25;
                if(snakey[0] < 75)
                    snakey[0] = 650;
            }
            else if (fx=="D") {
                snakey[0] = snakey[0] + 25;
                if(snakey[0] > 650)
                    snakey[0] = 75;
            }
            else if (fx=="L") {
                snakex[0] = snakex[0] - 25;
                if(snakex[0] < 25)
                    snakex[0] = 850;
            }
            else if (fx=="R") {
                snakex[0] = snakex[0] + 25;
                if(snakex[0] > 850)
                    snakex[0] = 25;
            }            
            
            if(snakex[0]==foodx && snakey[0]==foody) {
                len++;
                score = score + 10;
                foodx = 25 + 25*rand.nextInt(34);
                foody = 75 + 25*rand.nextInt(24);
            }
            for(int i = 1; i < len; i++) {
                if(snakex[0]==snakex[i]&&snakey[0]==snakey[i])
                    isDead = true;
            }
            
            repaint();
        }
        timer.start();
    }
    
    private void loadBGM() {
        try {
            bgm = AudioSystem.getClip();
//            InputStream is = this.getClass().getClassLoader().getResourceAsStream("sound/bgm2.wav");           
            File is = new File("resource/sound/bgm.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            bgm.open(ais);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void playBGM() {
        bgm.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    private void stopBGM() {
        bgm.stop();
    }
    
}
