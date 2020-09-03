package tcps;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask implements Runnable {
    private final Socket clientSocket;

    public ClientTask(Socket clientSocket) {
        this.clientSocket = clientSocket;
        System.out.println("New connection: " + clientSocket);
    }

    @Override
    public void run() {
        try {

            String request, response;
            // two I/O streams attached to the server socket:
            Scanner in;         // Scanner is the incoming stream (requests from a client)
            PrintWriter out;    // PrintWriter is the outcoming stream (the response of the server)
            in = new Scanner(clientSocket.getInputStream());
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            // Parameter true ensures automatic flushing of the output buffer

            // Server keeps listening for request and reading data from the Client,
            // until the Client sends "stop" requests
            while(in.hasNextLine())
            {
                request = in.nextLine();

                if(request.equals("stop"))
                {
                    out.println("Good bye, client!");
                    System.out.println("Log: " + request + " client!");
                    break;
                }
                else
                {
                    // server responses
                    response = new StringBuilder(request).reverse().toString();
                    out.println(response);
                    // Log response on the server's console, too
                    System.out.println("Log: " + response);
                }
            }
            try {
                clientSocket.close();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        } catch (IOException ioEx){
            ioEx.printStackTrace();
        } finally {
            System.out.println("Connection closed by client: " + clientSocket.toString());
        }

    }
}
