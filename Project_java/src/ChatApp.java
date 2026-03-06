import java.awt.Button;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.TextField;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatApp extends Application {

    private TextArea chatArea;
    private TextField inputField;
    private Button sendButton;
    private ChatClient client;

    @Override
    public void start(Stage stage) {

        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        inputField = new TextField();
        inputField.setPromptText("Type your message...");

        sendButton = new Button("Send");

        HBox bottomBox = new HBox(10, inputField, sendButton);
        bottomBox.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setCenter(chatArea);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("JavaFX Chat Client");
        stage.setScene(scene);
        stage.show();

        try {
            client = new ChatClient("localhost", 59001);
        } catch (Exception e) {
            chatArea.appendText("Could not connect to server.\n");
            return;
        }

        startListening();

        sendButton.setOnAction(e -> sendMessage());
        inputField.setOnAction(e -> sendMessage());

        stage.setOnCloseRequest(e -> {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
    private void sendMessage() {

        String message = inputField.getText().trim();

        if (!message.isEmpty()) {
            client.sendMessage(message);
            inputField.clear();
        }
    }
    private void startListening() {

        Thread listener = new Thread(() -> {
            try {
                String line;
                while ((line = client.readMessage()) != null) {
                    String msg = line;
                    Platform.runLater(() ->
                        chatArea.appendText(msg + "\n")
                    );
                }
            } catch (Exception e) {

                Platform.runLater(() ->
                    chatArea.appendText("Disconnected from server.\n")
                );
            }
        });

        listener.setDaemon(true);
        listener.start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}



