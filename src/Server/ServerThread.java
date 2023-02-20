package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
  private final Server server;
  private final Socket sock;

  public ServerThread(Server server, Socket sock) throws IOException {
    this.server = server;
    this.sock = sock;
  }


  public void run() {
    try {
      Scanner scan = new Scanner(this.sock.getInputStream());
      if (scan.next().equals("IP")) {
        this.server.newServerThreadAtPort(Integer.parseInt(scan.next()));
      }
      this.server.add(scan.next());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
