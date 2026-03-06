
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {

    private static Set<PrintWriter> clientWriters =
            Collections.synchronizedSet(new HashSet<>());

    public static final int PORT = 59001;

    private static class ClientHandler extends Thread {

        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;
            String username = null;

            try {
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(
                        socket.getOutputStream(), true);
                clientWriters.add(writer);

                writer.println("SERVER: Enter your username:");
                username = reader.readLine();

                broadcast("SERVER: " + username + " joined the chat!");
                String message;

                while ((message = reader.readLine()) != null) {

                    broadcast(username + ": " + message);
                }

            } catch (IOException e) {
                System.out.println("Connection error");
            } finally {
                try {
                    if (username != null) {
                        broadcast("SERVER: " + username + " left the chat");
                    }

                    if (writer != null) clientWriters.remove(writer);

                    if (reader != null) reader.close();
                    if (writer != null) writer.close();
                    if (socket != null) socket.close();

                } catch (IOException e) { }
            }
        }
        private void broadcast(String message) {

            synchronized (clientWriters) {

                for (PrintWriter writer : clientWriters) {

                    writer.println(message);
                }
            }
        }
    }
    public static void main(String[] args) {

        System.out.println("Chat Server Running on port " + PORT);
        try (ServerSocket server = new ServerSocket(PORT)) {

            while (true) {

                Socket socket = server.accept();

                System.out.println("New client connected");

                new ClientHandler(socket).start();
            }

        } catch (IOException e) {

            System.out.println("Server error");
        }
    }
}