import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TimeTracker {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean running;

    public void start() {
        if (!running) {
            startTime = LocalDateTime.now();
            running = true;
            System.out.println("Timer started at: " + startTime);
        } else {
            System.out.println("Timer is already running!");
        }
    }

    public void stop() {
        if (running) {
            endTime = LocalDateTime.now();
            running = false;
            System.out.println("Timer stopped at: " + endTime);
        } else {
            System.out.println("Timer is not running!");
        }
    }

    public void getElapsedTime() {
        if (startTime == null) {
            System.out.println("Timer has not been started yet!");
            return;
        }
        LocalDateTime end = running ? LocalDateTime.now() : endTime;
        Duration duration = Duration.between(startTime, end);
        System.out.println("Elapsed time: " + duration.toMinutes() + " minutes " + duration.toSecondsPart() + " seconds");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeTracker tracker = new TimeTracker();
        
        while (true) {
            System.out.println("Enter command (start, stop, check, exit): ");
            String command = scanner.nextLine().trim().toLowerCase();
            
            switch (command) {
                case "start":
                    tracker.start();
                    break;
                case "stop":
                    tracker.stop();
                    break;
                case "check":
                    tracker.getElapsedTime();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }
}
