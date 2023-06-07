
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;

public class Square extends JLabel{
    
    public int sWidth = 20;
    public int sDirection = Direction.right;
    
    public Square(){
        setBounds(100, 100, sWidth, sWidth);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        Graphics2D g2 = (Graphics2D)g;
        
        Rectangle2D rect = new Rectangle2D.Double(1, 1, getWidth()-2, getHeight()-2);
        
        
        
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(2));
        
        g2.draw(rect);
        
        g2.setColor(Color.GREEN);
        
        g2.fill(rect);
    }
    
    public void goRight(){
        int PosX = getX();
              int PosY = getY();
              
              PosX+=sWidth;
              setBounds(PosX, PosY, sWidth, sWidth);
    }
    public void goLeft(){
        int PosX = getX();
              int PosY = getY();
              
              PosX-=sWidth;
              setBounds(PosX, PosY, sWidth, sWidth);
    }
    public void goUp(){
        int PosX = getX();
              int PosY = getY();
              
              PosY-=sWidth;
              setBounds(PosX, PosY, sWidth, sWidth);
    }
    public void goDown(){
        int PosX = getX();
              int PosY = getY();
              
              PosY+=sWidth;
              setBounds(PosX, PosY, sWidth, sWidth);
    }
    
    public Square AddSquare(){
        Square s = new Square();
        int X = getX();
        int Y = getY();
        s.setBounds(X, Y, sWidth, sWidth);
        
        s.sDirection = -sDirection;
        s.move();
        s.sDirection = sDirection;
        
        return s;
    }
    
    public void move(){
        if (sDirection == Direction.left) {
            goLeft();
        }
        else if (sDirection == Direction.right) {
            goRight();
        }
        else if (sDirection == Direction.up) {
            goUp();
        }
        else if (sDirection == Direction.down) {
            goDown();
        }
}
    
}
