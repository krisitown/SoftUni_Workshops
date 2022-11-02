package org.example.multithreading;

public class MyRunnable implements Runnable {
    private String message;
    private Long time;

    public MyRunnable(String message, Long time) {
        this.message = message;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(message);
    }
}
