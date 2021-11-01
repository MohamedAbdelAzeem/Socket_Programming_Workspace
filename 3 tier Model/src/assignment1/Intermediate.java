/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mohamed AbdelAZeem
 */
public class Intermediate {
      public static void main(String[] args) throws IOException {
        
        try {
            
            int counter = 0 ;
            ServerSocket server1 = new ServerSocket(5555);
             System.out.println("Intermediate Started ....");
             
                    
            while(true)
            {
                //accepting new client if available
                Socket Client = server1.accept();
                counter++;
                System.out.println(" >> " + "Sensor No:" + counter + " started!");
                
                //Create a thread for the new client
                Intermediate_ClientHandler ClientThread = new Intermediate_ClientHandler(Client,counter);
                ClientThread.start();   
            }
           
        } catch (IOException iOException) {
              System.out.println("Intermediate: Susbended");
             System.out.println(iOException.getMessage());
        }
      
       
       
       
        
    }
}
