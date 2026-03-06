
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {

    private static final String SERVER = "localhost";
    private static final int PORT = 59001;

    public static void main(String[] args) {

        try {
            Socket socket = new Socket(SERVER, PORT);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);         
            Thread listener = new Thread(() -> {

                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }

                } catch (IOException e) {

                    System.out.println("Disconnected.");
                }
            });

            listener.start();

            while (scanner.hasNextLine()) {

                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("QUIT")) {

                    socket.close();
                    break;
                }

                out.println(message);
            }

        } catch (IOException e) {

            System.out.println("Cannot connect to server");
        }
    }
}
