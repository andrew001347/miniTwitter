import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class javaGUI 
{
    public javaGUI()
    {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(350,350,300,350));
        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Mini Twitter");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setVisible(true);


    }

    public static void main(String [] args)
    {
        new javaGUI();
    }
    
}
