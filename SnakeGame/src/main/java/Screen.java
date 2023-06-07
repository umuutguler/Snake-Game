
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.tools.Tool;

public class Screen extends JFrame{ // JFrame classından kalıtım alıyor
    
    private int sWidth = 815;
    private int sHeight = 815;
    private static Screen screen = null; // *
    
    Screen(){ // *
     
        setDefaultCloseOperation(EXIT_ON_CLOSE); // pencere kapatıldığında programı sonlandır 
        setResizable(false); // pencerenin boyutu sabit
        setDimension(sWidth, sWidth);
        Snake snake = new Snake();
        add(snake);
        
        
        
        
        
    }
    
    public static Screen bScreen(){  // Screen constructor ını sadece bir kez getirmek için *
        if (screen==null) {
            screen = new Screen();
        }
        return screen;
    }
    
    
    
    public void setDimension( int width, int Height ){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // ekranın ölçülerini alıyoruz ekranın ortasında çıkması için
        
        int PosX = 0;
        int PosY = 0;
        
        if (sWidth+100>dimension.width) {
            sWidth = dimension.width-100;
         }
        if (sHeight+100>dimension.height) {
            sHeight = dimension.height-100;
        }
        
        PosX = (dimension.width-sWidth)/2;
        PosY = (dimension.height-sHeight)/2;
        
        setBounds(PosX, PosY, sWidth, sWidth);
        
    }
    
}
