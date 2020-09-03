package tcps;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTask implements Runnable {
    private ServerSocket serverSocket;
    final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);

    public ServerTask(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                var clientSocket = serverSocket.accept();
                clientProcessingPool.submit(new ClientTask(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
