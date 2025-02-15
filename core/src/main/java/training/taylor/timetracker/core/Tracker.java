package com.example.timetracker;

import java.time.Duration;
import java.time.Instant;

public class TimeTracker {
    private Instant startTime;
    private Instant endTime;

    public void start() {
        startTime = Instant.now();
        System.out.println("Task started at: " + startTime);
    }

    public void stop() {
        endTime = Instant.now();
        System.out.println("Task ended at: " + endTime);
    }

    public void report() {
        if (startTime == null || endTime == null) {
            System.out.println("Start and Stop the tracker before reporting.");
            return;
        }

        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Total time spent: " + duration.toMillis() + " ms");
    }

    public static void main(String[] args) {
        TimeTracker tracker = new TimeTracker();
        tracker.start();

        // Simulate some work
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        tracker.stop();
        tracker.report();
    }
}
