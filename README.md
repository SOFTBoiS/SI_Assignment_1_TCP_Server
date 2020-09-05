# TCP_Server
Our proposed solution for the following assignment: https://datsoftlyngby.github.io/soft2020fall/resources/281a1ac6-P2-TCP.html  
Inside the src directory you will find 3 files:  
[TCPS.java](https://github.com/SOFTBoiS/TCP_Server/blob/master/src/tcps/TCPS.java) which contains the main method and the method for starting the server.  
[ServerTask.java](https://github.com/SOFTBoiS/TCP_Server/blob/master/src/tcps/ServerTask.java) A class which implements Runnable and ensures that the server can accept connections in parallel  
[ClientTask.java](https://github.com/SOFTBoiS/TCP_Server/blob/master/src/tcps/ClientTask.java) A class which implements Runnable and ensures that packets from the clients are processed in parallel
