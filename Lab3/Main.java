import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        println("hello world");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        JTextArea chatArea = new JTextArea();
        chatArea.setLineWrap(true);
        chatArea.setEnabled(false);
        JScrollPane chatPane = new JScrollPane(chatArea);
        container.add(chatPane, BorderLayout.CENTER);

        JTextField messageField = new JTextField();
        JButton sendButton = new JButton("SEND");
        JPanel actionPanel = new JPanel(new BorderLayout());
        actionPanel.add(messageField, BorderLayout.CENTER);
        actionPanel.add(sendButton, BorderLayout.EAST);
        container.add(actionPanel, BorderLayout.SOUTH);

        Socket s = new Socket("117.16.243.99", 5502);
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        messageField.addActionListener(e -> sendMessage(messageField, pw));
        sendButton.addActionListener(e -> sendMessage(messageField, pw));

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        new Thread(() -> br.lines().forEach((line) -> {
            chatArea.append(line + '\n');
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        })).start();

        frame.setVisible(true);
    }

    private static void println(String string) {
    }

    private static void sendMessage(JTextField messageField, PrintWriter pw) {
        pw.println(messageField.getText());
        messageField.setText("");
        messageField.requestFocus();
    }
}