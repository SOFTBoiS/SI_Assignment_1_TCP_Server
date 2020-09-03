package tcps;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Dora Di
 * 
 * 1. Create a server socket and bind it to a specific port number
 * 2. Listen for a connection from the client and accept it. This results in a client socket, created on the server, for the connection.
 * 3. Read data from the client via an InputStream obtained from the client socket
 * 4. Send data to the client via the client socket’s OutputStream.
 * 5. Close the connection with the client.
 * 
 * The steps 3 and 4 can be repeated many times depending on the protocol agreed between the server and the client.
 */

public class TCPS 
{
    public static final int PORT = 6666;
    public static Socket openSocket = null;         // Server communicates with the client
    
    public static void startServer() throws UnknownHostException, IOException
    {
        var serverSocket = new ServerSocket(PORT);
        var serverTask = new ServerTask(serverSocket);
        var serverThread = new Thread(serverTask);
        serverThread.start();
    }

    public static void main(String[] args) throws IOException 
    {       
        try
        {
            startServer();
        }
        catch(Exception e)
        {
            System.out.println(" Connection fails: " + e); 
        }

    }
}