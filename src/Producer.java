import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
    
    private LinkedBlockingQueue<String> queue;
    private boolean running;
    
    public Producer(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
        running = true;
    }
    
    // We need to check if the producer thread is
    // Still running, and this method will return
    // the state (running/stopped).
    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        
        // We are adding elements using put() which waits
        // until it can actually insert elements if there is
        // not space in the queue.
        for (int i = 0; i < 1500000000; i++) {
            String element = i + " StringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringStringString";

            try {
                queue.put(element);
                System.out.println("P\tAdding element: " + i);
                
//                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("P Completed.");
        running = false;
    }

}
