package pcd.lab01.hello;

public class MyThread extends Thread {

	public MyThread(String myName){
		super(myName);
	}
	
	public void run(){
		log("Hello concurrent world!");
		log("Sleeping for 5 secs...");
		try {
			// os isolate the thread in a queue where it doesn't use machine resources
			Thread.sleep(5000);
			// os move thread in ready queue
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		log("Done.");
	}
	
	private void log(String msg) {
		System.out.println("[ " + System.currentTimeMillis() +   " ][ " + getName()+ " ] " + msg); 
	}
}
