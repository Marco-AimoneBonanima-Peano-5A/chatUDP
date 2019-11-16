/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverudpchat;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aimonebonanima.marco
 */
public class ServerUDPEcho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int c;
        Thread thread;
        try {
            
            // TODO code application logic here
            UDPEcho echoServer= new UDPEcho(1077);
            thread= new Thread(echoServer);
            //echoServer.start();
            thread.start();
            c=System.in.read();
            //echoServer.interrupt();
            thread.interrupt();
            //echoServer.join();
            thread.join();
            System.out.println("sono il main");
//          for(;;){
//              
//          }
        } catch (SocketException ex) {
            Logger.getLogger(ServerUDPEcho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
