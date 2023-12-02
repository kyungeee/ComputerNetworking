import server.SimpleObjectServer.DrawPoint;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        Container container = frame.getContentPane();
        JPanel panel = new JPanel(new GridLayout(0,2));
        JTextField x = new JTextField();
        JTextField y = new JTextField();
        panel.add(x);
        panel.add(y);
        container.add(BorderLayout.NORTH, panel);

        JButton button = new JButton("SEND");
        container.add(button);

        try {
            Socket s = new Socket("117.16.243.99", 5503);
            ObjectOutputStream oos =
                    new ObjectOutputStream(s.getOutputStream());
            button.addActionListener((e) -> send(oos, x.getText(), y.getText()));
            frame.setVisible(true);
        } catch (IOException ignore) {}
    }

    private static void send(ObjectOutputStream oos, String x, String y) {
        try {
            int a = Integer.parseInt(x);
            int b = Integer.parseInt(y);
            System.out.printf("%d %d\n", a, b);
            DrawPoint dp = new DrawPoint(a, b);
            oos.writeObject(dp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

