
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JLabel;

public class Food extends JLabel{
    public int fWidth = 20;
    
    

    
    public Food(){
        setPosition(100, 100);
}

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        Graphics2D g2 = (Graphics2D)g;
        
        Ellipse2D ellipse = new Ellipse2D.Double(2, 2, fWidth-4, fWidth-4);
        
        
        
        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(2));
        
        g2.draw(ellipse);
        
        g2.setColor(Color.GREEN);
        
        g2.fill(ellipse);
        
        g2.setColor(Color.RED);
        
        g2.fill(ellipse);
    }
    
    public void setPosition(int x, int y){
        setBounds(x, y, fWidth, fWidth);
    }
}
