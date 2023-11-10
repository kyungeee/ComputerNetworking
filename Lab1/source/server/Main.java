import server.*;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Thread threadAdviceServer = new Thread(()-> new SimpleAdviceServer().go());

        Vector<Thread> threads = new Vector<>();
        threads.add(threadAdviceServer);

        for (Thread thread : threads) {
            thread.start();
        }

        while (true) ;
    }
}
