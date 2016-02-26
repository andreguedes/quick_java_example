public class ThreadComRunnable implements Runnable {
	
	private Thread thread = null;
	
	public ThreadComRunnable(String threadName) {
		if (threadName == null) {
			thread = new Thread(this, threadName);
		}
	}

	public void start() {
		thread.start();
	}
	
	@Override
	public void run() {
		
	}

}
