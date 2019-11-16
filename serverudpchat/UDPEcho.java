/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverudpchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aimonebonanima.marco
 */

//utilizzo la classe Clients per memorizzare indirizzo e porta dei clients che si collegano al server
//questo poi mi servira' per poter inviare i messaggi ricevuti da un client a tutti i client connessi
class Clients {
    InetAddress addr;
    int port;
    
    public Clients(InetAddress addr, int port) {
        this.addr = addr;
        this.port = port;
    }
}

//modifico la classe UDPecho usata dal server echo per uso con la chat
public class UDPEcho implements Runnable {

    private DatagramSocket socket;
    Clients client = new Clients(InetAddress.getByName("0.0.0.0"), 0);


    public UDPEcho(int port) throws SocketException, UnknownHostException {
        //avvio il socket per ricevere pacchetti inviati dai vari client
        socket = new DatagramSocket(port);
    }

    public void run() {
        DatagramPacket answer; //datagram usato per creare il pacchetto di risposta
        byte[] buffer = new byte[8192]; //buffer per contenere il messaggio ricevuto o da inviare
        // creo un un datagramma UDP usando il buffer come contenitore per i messaggi
        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        //uso hashmap per memorizzare i vari client connessi al server
        HashMap<String, Clients> clients = new HashMap<String, Clients>();
        //creo un clientID formato da indirizzo e porta IP trasformati in stringa
        String clientID;
        //la stringa con il messaggio ricevuto
        String message;
        
        while (!Thread.interrupted()){
            try {
                socket.receive(request); //mi metto in attesa di ricevere pacchetto da un clinet
                client.addr = request.getAddress(); //e memorizzo indirizzo
                client.port = request.getPort();    //e porta
                //genero quindi il clientID del client cha ha inviato il pacchetto appena ricevuto
                clientID = client.addr.getHostAddress() + client.port;
                System.out.println(clientID);
                //verifico se il client e' gia' conosciuto o se e' la prima volta che invia un pacchetto
                if(clients.get(clientID) == null) {
                    //nel caso sia la prima volta lo inserisco nella lista
                    clients.put(clientID, new Clients(client.addr, client.port)); 
                }
                System.out.println(clients);
                message = new String(request.getData(), 0, request.getLength(), "ISO-8859-1");
                if(message == "quit") {
                    //client si e' rimosso da chat, lo rimuovo da lista dei client connessi
                    clients.remove(clientID);
                }

                //invio il messaggio ricevuto a tutti i client connessi al server
                for(Clients clnt: clients.values()) {
                    // costruisco il datagram di risposta usando il messaggio appena ricevuto e inviandolo a ogni client connesso
                    answer = new DatagramPacket(request.getData(), request.getLength(), clnt.addr, clnt.port);
                    socket.send(answer);
                }
            } catch (IOException ex) {
                Logger.getLogger(UDPEcho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
