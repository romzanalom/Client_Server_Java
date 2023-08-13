package com.mycompany.calculator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

     public static void main(String args[]) throws IOException{
        ServerSocket handshake = new ServerSocket (5566);
        System.out.println("Server connected at " + handshake.getLocalPort());
        System.out.println("Server is connecting\n");
        System.out.println("Wait for the client\n");
        while(true){
         Socket com_socket = handshake.accept();
         System.out.println("A new client is connected "+ com_socket);
         DataOutputStream dos = new DataOutputStream(com_socket.getOutputStream());
         DataInputStream dis = new DataInputStream(com_socket.getInputStream());
         System.out.println("A new thread is assigning");
         Thread new_tunnel = new ClientHandler(com_socket, dis, dos);
         new_tunnel.start();
         
        }
    }
}
