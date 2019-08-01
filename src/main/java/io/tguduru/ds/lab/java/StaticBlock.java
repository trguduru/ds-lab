package io.tguduru.ds.lab.java;

import java.util.concurrent.TimeUnit;

/**
 * Explains the use of static block
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/20/16.
 */
public class StaticBlock {
    private static long date;

     {
        date = System.currentTimeMillis();
    }

    public long getDate() {
        return date;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadImpl thread = new ThreadImpl();
        thread.run();
        TimeUnit.MILLISECONDS.sleep(1);
        ThreadImpl thread1 = new ThreadImpl();
        thread1.run();

    }

    static class ThreadImpl implements Runnable {
        @Override
        public void run() {
            StaticBlock staticBlock = new StaticBlock();
            System.out.println(Thread.currentThread().getName() + " -- " + staticBlock.getDate());
        }
    }
}
