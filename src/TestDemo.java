import com.company.MyDeadLock;
import com.company.MyDeadLock2;

public class TestDemo {

    public static void main(String[] args) {
        new Thread(new MyDeadLock2(1)).start();
        new Thread(new MyDeadLock2(0)).start();
    }
}
