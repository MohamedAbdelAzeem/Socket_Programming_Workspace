/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
/**
 *
 * @author Mohamed AbdelAZeem
 */
public class Server_IntermediateHandler extends Thread{
    
      Socket serverClient;
    /* Variable to hold Client number */
    int clientNo;
      /* */
   Server_IntermediateHandler(Socket inSocket,int counter){
      serverClient = inSocket;
      clientNo=counter;
    }
    
   public void run()  {
       try{
       
                DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
                DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
          
                String ComputerMessage= "";
                
                
                
                
                ComputerMessage=inStream.readUTF();
                if(ComputerMessage.equals("Connect to server"))
                {
                 System.out.println("Client connected");
                 outStream.writeUTF("Server Connected");
                 outStream.flush();
                }
                ComputerMessage=inStream.readUTF();
                if(ComputerMessage.equals("Request Recommendation"))
                {
                 System.out.println("Client Requests Recommendation..");
                 outStream.writeUTF("Get Needed Data");
                 outStream.flush();
                }
                 ComputerMessage=inStream.readUTF();
                if(ComputerMessage.equals("Sensor_Reading_2"))
                {
                 System.out.println("Sensor reading : Sensor_Reading_2 ");
                 outStream.writeUTF("Road Recommendation");
                 outStream.flush();
                }
                ComputerMessage=inStream.readUTF();
                if(ComputerMessage.equals("Close Connection"))
                {
                    System.out.println("Closing Connection...");
                    outStream.writeUTF("Closed");
                    outStream.flush();
              
                 
                    inStream.close();
                    outStream.close();
                    serverClient.close();
                }
       } catch(IOException e){
             System.out.println("Thread:" + clientNo +"  Susbended");
           
            System.out.println(e);
       }
   } 
}
