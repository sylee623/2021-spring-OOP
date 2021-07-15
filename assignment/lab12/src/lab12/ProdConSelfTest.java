package lab12;

import java.util.Random;

public class ProdConSelfTest {
	private Buffer buffer = new Buffer(15);
	private Producer producer = new Producer(buffer);
	private Consumer consumer = new Consumer(buffer);
	
	private class Producer extends Thread{
		private final Buffer buffer;
		public Producer(Buffer buffer) {
			this.buffer = buffer;
		}
		public void produce() throws InterruptedException {
			for(int i = 0; i <= buffer.getSize(); i++) {
				Random rand = new Random();
				buffer.add(rand.nextInt(100));
			}
		}
		public void run() {
			try {
				produce();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
	private class Consumer extends Thread{
		private Buffer buffer;
		
		public Consumer(Buffer buffer) {
			this.buffer = buffer;
		}
		
		public void consume() throws InterruptedException{
			for(int i = buffer.getSize(); i > 0; i --) {
				buffer.remove();
			}
		}
		
		public void run() {
			try {
				consume();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startThread() {
		producer.start();
		consumer.start();
	}
}
