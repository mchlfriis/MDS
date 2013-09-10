package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.Protocol;

public class TCPClient {
	

    public static void main(String args[])  {
        try {
        	InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = Protocol.serverPort;
            
            String command = Protocol.GET;
            
            Socket socket = new Socket(serverAddress, serverPort);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF(command);
            dos.flush();
            
            DataInputStream dis = new DataInputStream(socket.getInputStream()); //Waits for server response
              
            String response = dis.readUTF();
            System.out.println(response);
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getMessage());
        } 
        
        
    }
}