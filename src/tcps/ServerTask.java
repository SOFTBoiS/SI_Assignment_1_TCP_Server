package tcps;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTask implements Runnable {

    public ServerTask(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);
    private ServerSocket serverSocket;

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
