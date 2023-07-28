package 机考准备.面试专用.第一次;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread {


    public static void main(String[] args) {
        AtomicInteger at = new AtomicInteger();
        Thread t3 = new Thread(() -> {
            while (true) {
                at.getAndIncrement();
                System.out.println("t3->" + at.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        t3.start();
        Thread t4 = new Thread(() -> {
            while (true) {
                at.getAndIncrement();
                System.out.println("t4->" + at.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        t4.start();


        Thread t1 = new Thread(() -> {
            while (true) {
                at.getAndDecrement();
                System.out.println("t1->" + at.get());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        t1.start();
        Thread t2 = new Thread(() -> {
            while (true) {
                at.getAndDecrement();
                System.out.println("t2->" + at.get());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        t2.start();


    }
}
