package pcd.lab01.hello;

public class Main {

	public static void main(String[] args) throws Exception {

		log("Hello from the main thread");

		// it's important to know the number of threads to maximize the performance using all the hardware resources we have
		log("Number of processors: " + Runtime.getRuntime().availableProcessors());
		
		log("Launching new threads...");

		var myThreadOne = new MyThread("ThreadOne");

		//unico metodo a disposizione per lanciare il thread
		myThreadOne.start();

		var myThreadTwo = new Thread(new MyRunnable("ThreadTwo"));
		myThreadTwo.start();		
		
		var t0 = System.currentTimeMillis();
		
		log("Threads spawned at: " + t0);
		
		log("Waiting for their termination.");

		/* launch also a clock thread, showing time elapsed */
		var clock = new SimpleClock(1000);
		clock.start();
		
		/* main thread blocks until the other threads terminate */
		//	prima forma di sincronizzazione tra thread
		myThreadOne.join();
		myThreadTwo.join();

		/* Notify clock to stop (deferred cancellation) -- "stop" method is deprecated */
		
		clock.notifyStop();
		
		var t1 = System.currentTimeMillis();
		log("Completed at " + t1 + " (" + (t1 - t0) + " secs)");
		
	}

	private static void log(String msg) {
		System.out.println("[ " + System.currentTimeMillis() +   " ][ " + Thread.currentThread().getName()+ " ] " + msg); 
	}
	
}
