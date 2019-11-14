/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatudpclient;

/**
 *
 * @author aimonebonanima.marco
 */
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

/**
 *
 * @author aimonebonanima.marco
 */
public class Gui2 extends JFrame implements ActionListener {
    
    JPanel pDati = new JPanel(new GridLayout(8,2));
    JLabel JTitolo = new JLabel("Chat");
    JLabel JUser = new JLabel("scrvi qui");
    JLabel JSpazio = new JLabel("");
    JTextField JUserName = new JTextField ("");
    JButton JSave = new JButton("Start");
    JButton JInvio = new JButton("Invio");
    JTextArea JAreaChat = new JTextArea ("");
    public Gui2() 
    { 
        this.setVisible(true);
        this.setLayout(new GridLayout(2, 3));
        
        this.add(pDati);
        this.add(JTitolo);
        this.add(JSpazio);
        this.add(JUser);
        this.add(JUserName);
        this.add(JSave);

        
        this.setSize(650, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
        
    }
    
}