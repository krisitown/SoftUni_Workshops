package org.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        ThreadA cust = new ThreadA("This is 1st Thread!", 2000L);
        ThreadA cust2 = new ThreadA("This is 2nd Thread!", 3000L);
        ThreadA cust3 = new ThreadA("This is 3rd Thread!", 3000L);
        ThreadA cust4 = new ThreadA("This is 4th Thread!", 3000L);
        List<ThreadA> threads = List.of(cust, cust2, cust3, cust4);

        for (ThreadA thread : threads) {
            //thread.start();
            //thread.join();
        }

        MyRunnable runnableCust = new MyRunnable("This is 1st Runnable!", 3000L);
        MyRunnable runnableCust2 = new MyRunnable("This is 2nd Runnable!", 3000L);
        MyRunnable runnableCust3 = new MyRunnable("This is 3rd Runnable!", 3000L);
        MyRunnable runnableCust4 = new MyRunnable("This is 4th Runnable!", 3000L);
        List<MyRunnable> runnables = List.of(runnableCust, runnableCust2, runnableCust3, runnableCust4);

        ExecutorService tpe = Executors.newFixedThreadPool(3);
        for (MyRunnable runnable : runnables) {
            Future<?> future = tpe.submit(runnable);
        }
    }
}
