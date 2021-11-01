/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Mohamed AbdelAZeem
 */

public class Intermediate_ClientHandler extends Thread {
    
    Socket serverClient;
    /* Variable to hold Client number */
    int clientNo;
    
    /* */
   Intermediate_ClientHandler(Socket inSocket,int counter){
      serverClient = inSocket;
      clientNo=counter;
    }
    
   public void run()  {
       try{
           DataInputStream inClientStream = new DataInputStream(serverClient.getInputStream());
          // DataOutputStream outClientStream = new DataOutputStream(serverClient.getOutputStream());
           String inClientMessage="", outClientMessage="";
           
           
             InetAddress ia = InetAddress.getLocalHost();  
           /*Intiating connection with the server*/
           Socket socket=new Socket("localhost",1234);
           DataInputStream inServerStream = new DataInputStream(socket.getInputStream());
           DataOutputStream outServerStream = new DataOutputStream(socket.getOutputStream());
            String inServerMessage="", outServerMessage="";
           
    
          
            /*Read form client */
            inClientMessage=inClientStream.readUTF();
             System.out.println(inClientMessage +" from Sensor: "  + clientNo);
            /*Write to the server */
                
            outServerStream.writeUTF("Connect to server");
            outServerStream.flush();
             
             outServerMessage = inServerStream.readUTF();
             if(outServerMessage.equals("Server Connected"))
             {
                 System.out.println("Server connected");
                 outServerStream.writeUTF("Request Recommendation");
                 outServerStream.flush();
             }
              outServerMessage = inServerStream.readUTF();
            if(outServerMessage.equals("Get Needed Data"))
             {
                 outServerStream.writeUTF(inClientMessage);
                 outServerStream.flush();
             }
              outServerMessage = inServerStream.readUTF();
            if(outServerMessage.equals("Road Recommendation"))
             {
                  System.out.println("Road Recommendation is received.");
                    outServerStream.writeUTF("Close Connection");
                 outServerStream.flush();
             }
              outServerMessage = inServerStream.readUTF();
            if(outServerMessage.equals("Closed"))
             {
                    System.out.println("Connection Closed");
                    outServerStream.writeUTF("Close Connection");
                    outServerStream.flush();
              
                    
                    inClientStream.close();
                    inServerStream.close();
                    outServerStream.close();
                    socket.close();
             }  
             
             
           
         
 
            
          
            
       } catch(IOException e){
             System.out.println("Thread:" + clientNo +"  Susbended");
           
            System.out.println(e);
       }
   }
}
