import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Snake extends JLabel {
    
    public Square sHead = new Square();
    public Food sfood = new Food();
    
    public Random random = null;
    
    public ArrayList<Square> List = new ArrayList<Square>();
    
    public Timer sTimer = null; // belli zaman aralıklarında belli bir fonksiyonu çağırmak için bir araç
    int timer = 100;
    
    public Snake() {
        
        random = new Random(System.currentTimeMillis());
        addKeyListener(new KeyboardControl());
        setFocusable(true); // tuş bilgisini hangi pencerenin alacağını belirlyor

        sTimer = new Timer(timer, new TimerControl());
        sTimer.start();
        
        List.add(sHead);
        for (int i = 1; i < 5; i++) {
            moreSquare();
        }
        add(sHead);
        add(sfood);
        
    }
    
    public void moreSquare() {
        Square square = List.get(List.size() - 1).AddSquare();
        List.add(square);
        add(square);
    }
    
    public void addFood() {
        int witdh = getWidth() - sfood.fWidth-60;
        int height = getHeight() - sfood.fWidth-60;
        
        int PosX = (20+Math.abs(random.nextInt())) % witdh;
        int PosY = (20+Math.abs(random.nextInt())) % height;
        
        PosX=PosX-(PosX%20);
        PosY=PosY-(PosY%20);
        
        for (int i = 0; i < List.size(); i++) {
            if ((PosX==List.get(i).getX())&&(PosY==List.get(i).getY())) {
                addFood();
                return;
            }
        }
        
        sfood.setPosition(PosX, PosY);
    }
    
    public void allMove() {
        sHead.move();
        for (int i = List.size() - 1; i > 0; i--) {
            
            Square first = List.get(i - 1);
            Square second = List.get(i);
            
            second.move();
            
            second.sDirection = first.sDirection;
        }
    }
    
    public boolean GameOver() {
        
        if (sHead.getX() <= 15) {
            return true;
        }
        if (sHead.getX() + sHead.sWidth >= getWidth() - 15) {
            return true;
        }
        if (sHead.getY() <= 15) {
            return true;
        }
        if (sHead.getY() + sHead.sWidth >= getHeight() - 15) {
            return true;
        }
        
        for (int i = 1; i < List.size(); i++) {
            int X = List.get(i).getX();
            int Y = List.get(i).getY();
            
            int mX = sHead.getX();
            int mY = sHead.getY();
            
            if ((mX == X) && (mY == Y)) {
                return true;
            }
        }
        
        if ((sfood.getX()==sHead.getX())&&(sfood.getY()==sHead.getY())) {
            moreSquare();
            addFood();
        }
        
        return false;
    }
    
    class TimerControl implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            allMove();
            if (GameOver()) {
                moreSquare();
                sTimer.stop();
            }
        }
        
    }
    
    class KeyboardControl implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (sHead.sDirection != Direction.right) {
                    sHead.sDirection = Direction.left;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (sHead.sDirection != Direction.left) {
                    sHead.sDirection = Direction.right;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (sHead.sDirection != Direction.down) {
                    sHead.sDirection = Direction.up;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (sHead.sDirection != Direction.up) {
                    sHead.sDirection = Direction.down;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                int i = 2;
                if (i%2==0) {
                    sTimer.stop();
                    i++;
                }
                else if (i%2==1) {
                    sTimer.start();
                    i++;
                }
                
            }
            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        Graphics2D g2 = (Graphics2D) g;
        
        Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(40));
        
        g2.draw(rect);
    }
    
}
