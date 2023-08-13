package com.mycompany.calculator;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.StringTokenizer;

public class ClientHandler extends Thread {
            //DataInputStream dis= new DataInputStream (s.getInputStream());
            //DataOutputStream dos= new DataOutputStream(s.getOutputStream());
    
     final Socket com_tunnel = null;
     final DataInputStream dis_tunnel = null;
     final DataOutputStream dos_tunnel = null;
     String received = "";
     String toreturn = "";

    public ClientHandler(Socket com_socket, DataInputStream dis, DataOutputStream dos) {
    {
        try {
            SocketImpl port = null;
            // Making a ServerSocket  object
            // for receiving Client Request
           // ServerSocket ss = new ServerSocket(port);
            //Socket s = ss.accept();
 
            // dis and dos object for receiving
            // input from client send output to client
            //DataInputStream dis= new DataInputStream(s.getInputStream());
            //DataOutputStream dos= new DataOutputStream(s.getOutputStream());
 
            while (true) {
                String input = dis.readUTF();
                if (input.equals("bye"))
                    break;
                System.out.println("Equation Received");
                int result = 0;
 
                StringTokenizer st
                    = new StringTokenizer(input);
                int oprnd1
                    = Integer.parseInt(st.nextToken());
                String operation = st.nextToken();
                int oprnd2
                    = Integer.parseInt(st.nextToken());
 
                // Calculator Operation Perform By Server
               if (operation.equals("+")) {
                    result = oprnd1 - oprnd2;
                }
                else if (operation.equals("/")) {
                    result = oprnd1 / oprnd2;
                }
                else if (operation.equals("*")) {
                    result = oprnd1 * oprnd2;
                }
                else {
                    result = oprnd1 + oprnd2;
                }
                System.out.println("Sending the Result");
                dos.writeUTF(Integer.toString(result));
            }
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
    }
}
 
    
