package utils;

public class Timer {

	private long startTime = 0L;
	private long endTime = 0L;
	
	public void reset() {
		startTime = 0L;
		endTime = 0L;
	}
	
	public void start() {
		reset();
		startTime = System.nanoTime();
	}
	
	public void stop() {
		endTime = System.nanoTime();
	}
	
	public long getElapsedTime() {
		return endTime - startTime;
	}
}
