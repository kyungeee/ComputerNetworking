package server;

import java.io.Serial;
import java.io.Serializable;

public class SimpleObjectServer {
    public static class DrawPoint implements Serializable {
        @Serial
        private static final long serialVersionUID = 123412341234L;
        private final int x;
        private final int y;

        public DrawPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
