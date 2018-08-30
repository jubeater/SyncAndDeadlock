public class FixMemoryConsistencyExample {
	public static void main(String[] args) {
		final Outputter outputter = new Outputter();
		new Thread(){
			@Override
			public void run() {
				outputter.output("TianlinZhang");
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				outputter.output("AamirKhan");
			}
		}.start();
	}
}
class Outputter {
	public  synchronized void output(String name) {

		for (int i = 0;i < name.length();i++) {
			System.out.print(name.charAt(i));
			try 
			{
			    Thread.sleep(1);
			} 
			catch(InterruptedException e)
			{

			}
		}
	}
}
