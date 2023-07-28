package 机考准备.面试专用.一面;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread2 {


    public static void main(String[] args) {
        AtomicInteger at = new AtomicInteger();
        AtomicInteger threadId = new AtomicInteger();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new ThreadFactory() {
            @Override public Thread newThread(Runnable r) {
                while (true) {
                    Thread thread = new Thread(r);
                    thread.setName("t" + threadId);
                    return thread;
                }
            }

        });
        threadPoolExecutor.execute(new Runnable() {
            @Override public void run() {
                while (true) {
                    at.getAndIncrement();
                    System.out.println(at.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override public void run() {
                while (true) {
                    at.getAndIncrement();
                    System.out.println(at.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override public void run() {
                while (true) {
                    at.getAndDecrement();
                    System.out.println(at.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override public void run() {
                while (true) {
                    at.getAndDecrement();
                    System.out.println(at.get());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


    }
}
