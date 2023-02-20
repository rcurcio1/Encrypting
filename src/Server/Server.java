package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
  private final int firstPort;
  private final List<String> messages;

  public Server(int firstPort) {
    this.firstPort = firstPort;
    this.messages = new ArrayList<>();
  }


  public void start() throws IOException {
    ServerSocket ss = new ServerSocket(this.firstPort);
    Socket firstSocket = ss.accept();
    Thread firstThread = new ServerThread(this, firstSocket);
    firstThread.start();
  }

  public void newServerThreadAtPort(int port) throws IOException {
    ServerSocket ss = new ServerSocket(this.firstPort);
    Socket newSocket = ss.accept();

    Thread newThread = new ServerThread(this, newSocket);

    newThread.start();
  }

  public void add(String message) {
    this.messages.add(message);
  }

}
