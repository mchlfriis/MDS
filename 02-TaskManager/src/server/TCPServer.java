package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.Protocol;

public class TCPServer {
	
	
    public static void main(String args[]) {
    	Boolean active = true;
    	try {
	        ServerSocket serverSocket = new ServerSocket(Protocol.serverPort);
	        System.out.println("Server running on port " + Protocol.serverPort);
	        Socket socket = null;
	        while(active){
	        	socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                
                //This just reads the string from the client and return it as output
                String command = dis.readUTF();
                String output  = command;

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                outputStream.writeUTF(output);
                outputStream.flush();
	        }
	        socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error message: " + ex.getMessage());
        }
        


    }
}
