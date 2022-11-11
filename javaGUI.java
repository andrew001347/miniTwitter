import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JTextArea;
import javax.swing.tree.*;

import java.awt.*;
import java.awt.event.*;

public class javaGUI extends JFrame implements ActionListener
{
    
    int count = 0;

    DefaultMutableTreeNode myRoot, parent, child, node;
    JTree tree;
    Container container;
    JButton add, remove;
    JPanel buttonsPanel;
    TreePath treePath;
    int index;

    javaGUI()
    {
    /* 
    myRoot = new DefaultMutableTreeNode("Root");
    JTree myTree = new JTree(myRoot);
    this.add(myTree);
    myTree.setBounds(5,10,380,290);

    parent = new DefaultMutableTreeNode("3560");

    child = new DefaultMutableTreeNode("Andrew");
    parent.add(child);

    child = new DefaultMutableTreeNode("Kim");
    parent.add(child);

    myRoot.add(parent);

    parent = new DefaultMutableTreeNode("3010");

    child = new DefaultMutableTreeNode("Michael");
    parent.add(child);

    myRoot.add(parent);
*/

super("JTree Event Demo");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myRoot = new DefaultMutableTreeNode("Root");

        parent = new DefaultMutableTreeNode("3560");

        child = new DefaultMutableTreeNode("Andrew");
        parent.add(child);

        child = new DefaultMutableTreeNode("Kim");
        parent.add(child);

        myRoot.add(parent);

        parent = new DefaultMutableTreeNode("3110");

        child = new DefaultMutableTreeNode("Mike");
        parent.add(child);

        myRoot.add(parent);

        tree = new JTree(myRoot);

        add = new JButton("Add");
        add.addActionListener(this);
        remove = new JButton("Remove");
        remove.addActionListener(this);

        buttonsPanel = new JPanel();
        buttonsPanel.add(add);
        buttonsPanel.add(remove);


    /* JButton userButton = new JButton("Add User");
    userButton.setBounds(600, 10,180,30);
    
    remove = new JButton("Remove");
        remove.addActionListener(this);
         add = new JButton("Add User/Group");
    add.setBounds(400, 10,180,30); 
*/


        add = new JButton("Add");
        add.setBounds(400, 10,180,30); 
        add.addActionListener(this);

        
        remove = new JButton("Remove");
        remove.addActionListener(this);
        remove.setBounds(600, 10,180,30);

        buttonsPanel = new JPanel();
        buttonsPanel.add(add);
        buttonsPanel.add(remove);
   

    JTextArea nameGroup= new JTextArea();  
    nameGroup.setBounds(400, 50,180,30);

    JButton groupButton = new JButton("Add Group");
    groupButton.setBounds(600, 50,180,30);
    groupButton.addActionListener(e-> System.out.println("Add Group Button"));



    JButton openUserView = new JButton("Open User View");
    openUserView.setBounds(400, 100,180,30);
    openUserView.addActionListener(e->new userGUI());

    JButton deleteUser = new JButton("Open User View");
    deleteUser.setBounds(600, 100,180,30);
    deleteUser.addActionListener(e->new userGUI());

    JButton userTotalButton = new JButton("View User Total");
    userTotalButton.setBounds(400, 240,180,30);
    userTotalButton.addActionListener(e-> System.out.println("User Total Button."));


    JButton groupTotalButton = new JButton("View Group Total");
    groupTotalButton.setBounds(600, 240,180,30);
    groupTotalButton.addActionListener(e-> System.out.println("Group Total Button."));


    JButton showMessbutton = new JButton("Show Total Messages");
    showMessbutton.setBounds(400, 280,180,30);
    showMessbutton.addActionListener(e-> System.out.println("Show Message Button."));

    JButton showPosPer = new JButton("Show Positive Percentage");
    showPosPer.setBounds(600, 280,180,30);
    showPosPer.addActionListener(e-> System.out.println("Show Percentage Button."));



    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);

    this.setTitle("Mini Twitter");
    this.setSize(800,350);
    this.setVisible(true);

   
    this.add(add);
    this.add(remove);
    this.add(openUserView);
    this.add(groupTotalButton);


    this.add(userTotalButton);
    this.add(groupTotalButton);

    this.add(showMessbutton);
    this.add(showPosPer);

        /*

        Testing:
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        JButton userButton = new JButton("Add User");
        JButton groupButton = new JButton("Add Group");
        
        JButton userTotalButton = new JButton("View User Total");
        JButton groupTotalButton = new JButton("View Group Total");
        JButton showMessbutton = new JButton("Show Total Messages");
        JButton showPosPer = new JButton("Show Positive Percentage");
        
        panel.setLayout(new GroupLayout());



        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(350,350,300,350));
        

        this.add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Mini Twitter");
        this.pack();
        this.setLocationRelativeTo(null);

        button = new JButton();
        button.setBounds(50,50,50,50);
        button.addActionListener(this);

        this.add(new JButton("Add User"));
        this.setVisible(true);


        JPanel addUser = new JPanel();
        JPanel addGroup = new JPanel();
        JPanel openUserView = new JPanel();
        JPanel showUserTotal = new JPanel();
        JPanel showGroupTotal = new JPanel();
        JPanel showMessTotal= new JPanel();
        JPanel showPosPer= new JPanel();


         * ImageIcon image = newImageIcon(.png); will get your new icon
         * frame.setIconImage(image.getImage()); and replace it.
         * 
         * frame.getContentPane().setBackground(Color.blue);
         * frame.getContentPane().setBackground(new( Color(123,50,250)); can also use numbers
         */

    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == add)
         {
            DefaultMutableTreeNode SelectedNode;

            treePath = tree.getSelectionPath();
            SelectedNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            index = SelectedNode.getIndex(SelectedNode) + 1;

            String NodeStr = JOptionPane.showInputDialog(this,"Enter a User/Group Name", "User/Group Name",JOptionPane.QUESTION_MESSAGE);

            node = new DefaultMutableTreeNode(NodeStr);
            SelectedNode.insert(node, index);
            tree.updateUI();
        } 
        else if (e.getSource() == remove) 
        {
            int val = JOptionPane.showConfirmDialog(buttonsPanel,"Delete User/Group Name?");
            if (val == 0) 
            {
                DefaultMutableTreeNode SelectedNode;

                treePath = tree.getSelectionPath();
                SelectedNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
                if (SelectedNode.isLeaf()) 
                {
                    parent = (DefaultMutableTreeNode) SelectedNode.getParent();
                    parent.remove(SelectedNode);
                    tree.updateUI();
                } 
                else 
                {
                    JOptionPane.showMessageDialog(this, "Unable to Remove");
                }
            }
        }

    }
    
}
