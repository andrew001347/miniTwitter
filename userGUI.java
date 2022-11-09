import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class userGUI extends JFrame 
{

    JPanel jp = new JPanel();
    JLabel jl = new JLabel();

    JTextField jt = new JTextField(30);
    

    
    JButton followUser = new JButton("Post Message");
    followUser.setBounds();

    JButton jb = new JButton("Post Message");
    jb.setBounds();

    
    public userGUI()
    {
        setTitle(/*userID*/"UserID");
        
        setSize(400,400);


        jp.add(jt);

    
        jt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String input = jt.getText(); 
                jl.setText(input);
            }
        });
        jp.add(jb);

       
        jb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            String input = jt.getText();
            jl.setText(input);
            }
        });

        
        jp.add(jl);
        add(jp);

        setVisible(true);

    }
    
}
