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
public class Client {
    public static void main(String[] args){
      try{
        
            Socket socket=new Socket("192.168.56.1",5555);
            /*Creating input and output streams */
            DataInputStream inStream=new DataInputStream(socket.getInputStream());
            DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
            /* Print Client Started */
            System.out.println("Client Started...");

            /* Send MESSAGE */
            String clientMessage="Sensor_Reading_2",serverMessage="";
             System.out.println("Sensor reading is :  Sensor_Reading_1");
            System.out.println("Message Sent...");
            outStream.writeUTF(clientMessage);
            outStream.flush();    
            outStream.close();
            outStream.close();
            socket.close();
  }catch(IOException e){
    System.out.println(e);
  }
  }
}
