public class ThreadInterferenceExample {
	public static void main(String[] args){
		Counter counter = new Counter();
		new Thread(){
			@Override
			public void run(){
				counter.decrement();
				System.out.println("after the end of decrement thread, the result is :" + counter.value());
			}
		}.start();
		new Thread(){
			@Override
			public void run(){
				try {
					Thread.sleep(1);
				} catch( InterruptedException e) {

				}
				counter.increment();
				System.out.println("after the end of increment thread, the result is :" + counter.value());
			}
		}.start();
	}
}

class Counter{
	private int cnt = 0;

	public void increment(){
		for (int i = 0;i < 5000;i++) {
			try {
				Thread.sleep(1);
			} catch( InterruptedException e) {

			}
			cnt++;
		}
	}
	public void decrement(){
		for (int i = 0;i < 3000;i++) {
			try {
				Thread.sleep(1);
			} catch( InterruptedException e) {

			}
			cnt--;
		}
	}

	public int value() {
		return cnt;
	}
}