/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatudpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Aimone Bonanima
 */
public class ReceiveFromServerAndPrint implements Runnable {
    DatagramSocket socket;

    ReceiveFromServerAndPrint (DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[100];
        String received;
        DatagramPacket serverDatagram;
        

        try {
            // Costruisco il datagram per ricevere i pacchetti inviati dal server
            serverDatagram = new DatagramPacket(buffer, buffer.length);
            // fino a quando il main non interrompe il thread rimango in ascolto 
            while (!Thread.interrupted()){
                socket.receive(serverDatagram);  //attendo il prossimo pacchetto da server
                //converto in string il messaggio contenuto nel buffer
                received = new String(serverDatagram.getData(), 0, serverDatagram.getLength(), "ISO-8859-1");
                //e quindi scrivo su schermo il messaggio appena ricevuto
                System.out.println(received);
                //scrivo anche il prompt nel caso utente voglia digitare un altro messaggio da inviare
                System.out.print("> ");
            }

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ReceiveFromServerAndPrint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReceiveFromServerAndPrint.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
