import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock implements Runnable{
    static final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void run() {
        try{
            while (!Thread.currentThread().isInterrupted()) {
                LocalDateTime now = LocalDateTime.now();
                System.out.println("Current time : "+now.format(format));
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            System.out.println("Clock stopped");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Thread timeThread = new Thread(new DigitalClock());
        timeThread.start();

    }
}
