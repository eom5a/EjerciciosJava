package edu.upc.eetac.dsa.exercises.java;

/**
 * Created by enric on 23/02/2016.
 */
public class ClassThread extends Thread{
    int counter = 0;
    long last = 0;

    public ClassThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long currentExecution = System.currentTimeMillis();
            long elapsed = (last == 0) ? 0 : currentExecution - last;
            last = currentExecution;
            System.out.println(getName() + " elapsed = " + " ms. [" + (++counter) + "]");
            long sleep = (long)(Math.random() * 2000);
            try {
                Thread.sleep(sleep);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
