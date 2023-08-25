import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;

class MyFrame extends JFrame {
    
    MyFrame() {       // this constructor of the class Frame will create a Frame (Ch 1)

        // JFrame frame = new JFrame();    // creates frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // permanently closes window instead of hiding ( Other operations are hide, DO_NOTHING_ON_CLOSE)
        
        this.setTitle("Amogus");     // sets title
        this.setResizable(false);      // stops resizing
        this.setSize(420, 420);      // sets size
        
        ImageIcon icon= new ImageIcon("logo.png");  // creates icon
        this.setIconImage(icon.getImage());       // sets icon
        
        this.setVisible(true);      // makes frame visible
        this.getContentPane().setBackground(new Color(100,65,164));      //changes background color
    }
}

public class frame {
    public static void main(String args[]) {

    new MyFrame();  // instance

    }
}