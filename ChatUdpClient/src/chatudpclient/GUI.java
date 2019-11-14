/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatudpclient;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author aimonebonanima.marco
 */
public class GUI extends JFrame implements ActionListener, MouseListener  {
    
    JPanel pDati = new JPanel(new GridLayout(8,2));
    JLabel JTitolo = new JLabel("Chat");
    JLabel JUser = new JLabel("Inserisci il tuo username");
    JLabel JSpazio = new JLabel("");
    JTextField JUserName = new JTextField ("");
    JButton JSave = new JButton("Start");
    JButton JInvio = new JButton("Invio");
    JTextArea JAreaChat = new JTextArea ("");
    public GUI() 
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

    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getActionCommand().equals("Aggiungi")){
            try{
                this.JFrame.close();
            }
       } 
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
