
import java.io.*;
import java.net.Socket;

public class ChatClient {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    public ChatClient(String server, int port) throws IOException {

        socket = new Socket(server, port);

        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(
                socket.getOutputStream(), true);
    }

    public String readMessage() throws IOException {
        return in.readLine();
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void close() throws IOException {
        socket.close();
    }
}
