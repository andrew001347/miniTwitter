import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.tree.*;


import java.awt.*;
import java.awt.event.*;

public class javaGUI extends JFrame implements ActionListener
{
    DefaultMutableTreeNode root, parent, child, node;
    JTree tree;
    java.awt.Container container;
    JButton add, remove, userTotal,userView,groupTotal,messTotal;
    JPanel buttonsPanel;
    TreePath treePath;
    int index;
    int count =3;

    javaGUI()
    {
        super("Mini Java");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root = new DefaultMutableTreeNode("Root");

        parent = new DefaultMutableTreeNode("3560");

        child = new DefaultMutableTreeNode("Andrew");
        parent.add(child);

        child = new DefaultMutableTreeNode("Kim");
        parent.add(child);

        root.add(parent);

        parent = new DefaultMutableTreeNode("3010");

        child = new DefaultMutableTreeNode("Mike");
        parent.add(child);

        root.add(parent);

        tree = new JTree(root);

        add = new JButton("Add User/Group");
        add.addActionListener(this);
        
        remove = new JButton("Remove User/Group");
        add.setBounds(400, 10,180,30); 
        remove.addActionListener(this);
        
        userTotal = new JButton("Total Users");
        userTotal.addActionListener(this);
    
        userView = new JButton("User View");
        userView.addActionListener(this);

        groupTotal = new JButton("Group Total");
        groupTotal.addActionListener(this);

        messTotal = new JButton("Message Total");
        messTotal.addActionListener(this);

        buttonsPanel = new JPanel();
        buttonsPanel.add(add);
        buttonsPanel.add(remove);
        buttonsPanel.add(userTotal);
        buttonsPanel.add(userView);
        buttonsPanel.add(groupTotal);
        buttonsPanel.add(messTotal);

        container = getContentPane();
        container.add(new JScrollPane(tree));
        container.add(buttonsPanel, BorderLayout.SOUTH);

        setSize(800, 350);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        count++;
        if (ae.getSource() == add)
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
        else if (ae.getSource() == remove) 
        {
            count--;
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

        else if (ae.getSource() == userTotal) 
        {
            

        }

        
        else if (ae.getSource() == userView) 
        {
            new userGUI();
        }

        
        else if (ae.getSource() == groupTotal) 
        {

        }


        else if (ae.getSource() == messTotal) 
        {
            

        }


        

    }
    
}


















        /*

        Testing:


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
        this.add(tree);
        add = new JButton("Add");
        add.addActionListener(this);
        remove = new JButton("Remove");
        remove.addActionListener(this);




    /* JButton userButton = new JButton("Add User");
    userButton.setBounds(600, 10,180,30);
    
    remove = new JButton("Remove");
        remove.addActionListener(this);
         add = new JButton("Add User/Group");
    add.setBounds(400, 10,180,30); 

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
        this.add(tree);
        add = new JButton("Add");
        add.addActionListener(this);
        remove = new JButton("Remove");
        remove.addActionListener(this);




    /* JButton userButton = new JButton("Add User");
    userButton.setBounds(600, 10,180,30);
    
    remove = new JButton("Remove");
        remove.addActionListener(this);
         add = new JButton("Add User/Group");
    add.setBounds(400, 10,180,30); 



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
*/