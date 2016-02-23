package edu.upc.eetac.dsa.exercises.java;

/**
 * Created by enric on 23/02/2016.
 */
public class Producer {
    private Buffer buffer = null;
    private String line = null;

    public Producer(Buffer buffer, String line) {
        this.buffer = buffer;
        this.line = line;
    }

    @Override
    public void run() {
        char chars[] = line.toCharArray();
        for (char c : chars) {
            buffer.put(c);
            // Uncomment to log what is writing the thread
            // System.out.println(Thread.currentThread().getName() + " writes " + c);
        }
    }
}
