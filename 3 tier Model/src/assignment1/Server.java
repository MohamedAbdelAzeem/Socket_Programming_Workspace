/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.*;
import java.net.*;


/**
 *
 * @author Mohamed AbdelAZeem
 */
public class Server {
      public static void main(String[] args) throws IOException {
        
        try {
            
            
            ServerSocket server1 = new ServerSocket(1234);
             System.out.println("Server Started ....");
             
            int counter = 0 ;
             String clientMessage="", serverMessage="";
            while(true)
            {
                Socket Client = server1.accept();
                counter++;
                 System.out.println(" >> " + "Computer No:" + counter + " started!");
                 
                 
                
                
                 //Create a thread for the new client
                Server_IntermediateHandler ComputerThread = new Server_IntermediateHandler(Client,counter);
                ComputerThread.start();   
          
       
            } 
        } catch (IOException iOException) {
            System.out.println("Server susbended...");
             System.out.println(iOException.getMessage());
        }
    }
}
