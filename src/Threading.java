import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Threading {

    @Test
    public void test(){
        ExecutorService pool = Executors.newFixedThreadPool(10);

            for(int i=0; i<100; i++){
                pool.execute(new Handler());
            }
    }

    class Handler implements Runnable{

        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep((int)Math.random()*10000);
//                System.out.println(Math.random() + " slept and wokeup");
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
