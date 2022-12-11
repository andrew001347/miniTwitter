import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.tree.*;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.awt.*;
import java.awt.event.*;

public class javaGUI extends JFrame implements ActionListener
{
    DefaultMutableTreeNode root, parent, child;
    DefaultMutableTreeNode node;
    JTree tree;
    java.awt.Container container;
    JButton add, remove, userTotal,userView,groupTotal,messTotal,duplicate,lastUpdated;
    JPanel buttonsPanel;
    TreePath treePath;
    int index;
    int count =3;
    ArrayList<DefaultMutableTreeNode> userList = new ArrayList<>();

    javaGUI()
    {
        super("Mini Java");


    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode root_data = new DefaultMutableTreeNode();
        parent = new DefaultMutableTreeNode("3560");
        DefaultMutableTreeNode parent_data = new DefaultMutableTreeNode();
        

        child = new DefaultMutableTreeNode("Andrew");
        DefaultMutableTreeNode child_data = new DefaultMutableTreeNode();
        String[] times = new String[3];
        //index 1 = createdtime
        //index 2 = updatedTime
        times[0] = "Root";
        times[1] = String.valueOf(System.currentTimeMillis());
        times[2] = String.valueOf(System.currentTimeMillis());

        String[] times2 = new String[3];
        //index 1 = createdtime
        //index 2 = updatedTime
        times2[0] = "3650";
        times2[1] = String.valueOf(System.currentTimeMillis());
        times2[2] = String.valueOf(System.currentTimeMillis());

        String[] times3 = new String[3];
        //index 1 = createdtime
        //index 2 = updatedTime
        times3[0] = "Andrew";
        times3[1] = String.valueOf(System.currentTimeMillis());
        times3[2] = String.valueOf(System.currentTimeMillis());
        System.out.println(times);
        userList = new ArrayList<>();
        root_data.setUserObject(times);
        parent_data.setUserObject(times2);
        child_data.setUserObject(times3);
        userList.add(parent_data);
        userList.add(root_data);
        userList.add(child_data);


        parent.add(child);

        root.add(parent);

        tree = new JTree(root);

        add = new JButton("Add User/Group");
        add.addActionListener(this);

        duplicate = new JButton("Duplicates?");
        duplicate.addActionListener(this);

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

        lastUpdated = new JButton("Last Updated User");
        lastUpdated.addActionListener(this);
        


        buttonsPanel = new JPanel();
        buttonsPanel.add(add);
        buttonsPanel.add(duplicate);

        buttonsPanel.add(remove);
        buttonsPanel.add(userTotal);
        buttonsPanel.add(userView);
        buttonsPanel.add(groupTotal);
        buttonsPanel.add(messTotal);  

        buttonsPanel.add(lastUpdated);


        container = getContentPane();
        container.add(new JScrollPane(tree));
        container.add(buttonsPanel, BorderLayout.SOUTH);


        setSize(1000, 350);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    
        if (ae.getSource() == add)
         {

            count++;
            DefaultMutableTreeNode SelectedNode;


            treePath = tree.getSelectionPath();
            SelectedNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            index = SelectedNode.getIndex(SelectedNode) + 1;

            String NodeStr = JOptionPane.showInputDialog(this,"Enter a User/Group Name", "User/Group Name",JOptionPane.QUESTION_MESSAGE);

            node = new DefaultMutableTreeNode(NodeStr);
            DefaultMutableTreeNode node_data = new DefaultMutableTreeNode();
            String[] times = new String[3];
            //index 0 = createdtime
            //index 1 = updatedTime
            times[0] = NodeStr;
            times[1] = String.valueOf(System.currentTimeMillis());
            times[2] = String.valueOf(System.currentTimeMillis());
            node_data.setUserObject(times);
            userList.add(node_data);

            SelectedNode.insert(node, index);


            tree.updateUI();
        } 
        else if (ae.getSource() == duplicate) 
        {
            HashSet<String> uniqueUsers = new HashSet<>();
            Enumeration<TreeNode> e = root.depthFirstEnumeration();
            boolean valid = true;
            while (e.hasMoreElements())
             {
              TreeNode node = e.nextElement();
              if(uniqueUsers.contains(node.toString()) || node.toString().contains(" ") || node.toString().length() == 0)
              {
                  JOptionPane.showMessageDialog(this, "Duplicates Found");
                  valid = false;
                  break;
              }
              else {
                uniqueUsers.add(node.toString());
              }
            } 
            if (valid) {
            JOptionPane.showMessageDialog(this, "No duplicates");
            }

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
            for (int i = 0; i < tree.getRowCount(); i++)
            {
                tree.expandRow(i);
            }
            JOptionPane.showMessageDialog(this, "Number of Users: " + parent.getChildCount());
           
        }

        
        else if (ae.getSource() == userView) 
        {
            new userGUI();
        }

        
        else if (ae.getSource() == groupTotal) 
        {
            for (int i = 0; i < tree.getRowCount(); i++)
            {
                tree.expandRow(i);
            }
            JOptionPane.showMessageDialog(this, "Number of Groups: " + parent.getChildCount());

        }


        else if (ae.getSource() == messTotal) 
        {
            JOptionPane.showMessageDialog(this, "Number of Messages: 1");

        }  


        else if (ae.getSource() == lastUpdated) 
        {
            Enumeration<TreeNode> e = root.depthFirstEnumeration();
            String lastUpdatedUser = "";
            long lastUpdatedTime = -1;
            for (int i = 0; i < userList.size(); i++)
             {
            //   TreeNode node = e.nextElement();
            //   String name = node.toString();
            //   DefaultMutableTreeNode defaultNode = (DefaultMutableTreeNode) node;
              //Object obj = defaultNode.getUserObject();
              //long[] times = (long[]) obj;
              //System.out.println(times[1]);
              Object obj = userList.get(i).getUserObject();
              String[] data = (String[]) obj;
              System.out.println(data[0]);
              System.out.println(data[1]);
              long updatedtime = Long.parseLong(data[2]);
              if (updatedtime > lastUpdatedTime) {
                lastUpdatedUser = data[0];
                lastUpdatedTime = updatedtime;
              }
            } 
            JOptionPane.showMessageDialog(this, "Last updated user: " + lastUpdatedUser);
            

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