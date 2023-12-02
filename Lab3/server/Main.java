import server.*;
import java.util.Vector;
public class Main {
    public static void main(String[] args) {
        Thread threadAdviceServer = new Thread(()-> new SimpleAdviceServer().go());
        Thread threadTransferServer = new Thread(() -> new SimpleTransferServer().go());
        Thread threadChatServer = new Thread(()-> new SimpleChatServer().go());

        Vector<Thread> threads = new Vector<>();
        threads.add(threadAdviceServer);
        threads.add(threadTransferServer);
        threads.add(threadChatServer);

        for (Thread thread : threads) {
            thread.start();
        }

        while (true) ;
    }
}
