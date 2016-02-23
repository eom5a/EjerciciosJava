package edu.upc.eetac.dsa.exercises.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        public static void main(String[] args) throws InterruptedException {
        ClassThread threadClass = new ClassThread("thread class");
        Thread thread = new Thread(new ClassRunnable(), "runnable class");
        threadClass.start();
        thread.start();

        /**Se espera que se los threads terminen*/
        threadClass.join();
        thread.join();

        System.out.println("FIN.");
    }
    }
}
