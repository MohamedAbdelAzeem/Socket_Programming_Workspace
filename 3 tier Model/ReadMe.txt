to Run this Assignment do the following steps:
1- Run Server.java
2- Run Intermediate.jave
3- Run Client.java


- Server.java represnts Servers that collect data and send recommendation to computers.
- Intermediate.java represensts Computers that collect data and send a request to servers in a thread.
- Client represents Sensors that send some dummy message to computer (Readings) in a thread.

what should happen when run:
Client (sensor) Send message to computer
Computer opens a thread for every sensor to receive that message and start connection with server as in ALP 
server opens a thread for every computer to receive requests and send recommendation 
