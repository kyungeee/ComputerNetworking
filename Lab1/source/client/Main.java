import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            // 소켓 연결
            Socket socket = new Socket("117.16.243.99", 5500);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            String str = br.readLine();
            System.out.println(str);
        } catch (IOException e) {
            System.out.println("연결 끊김!");
        }
    }
}