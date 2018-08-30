public class DeadlockExample {

    public static void main(String[] args) {
        // thread a
        Thread td1 = new Thread(new Runnable() {
            public void run() {
                DeadlockExample.method1();
            }
        });
        // thread b
        Thread td2 = new Thread(new Runnable() {
            public void run() {
                DeadlockExample.method2();
            }
        });

        td1.start();
        td2.start();
    }

    public static void method1() {
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread a trying to get the Integer.class");
            synchronized (Integer.class) {
                System.out.println("thread a get the Integer.class");
            }

        }
    }

    public static void method2() {
        synchronized (Integer.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread b trying to get the String.class");
            synchronized (String.class) {
                System.out.println("thread b get the String.class");
            }

        }
    }

}
