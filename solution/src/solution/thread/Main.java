package solution.thread;

class Counter {
    public static int count = 0;
}

class AddCount extends Thread {
    @Override
    public void run() {
        synchronized (Counter.class) {
            for (int i = 0; i < 10000; i++) {
                Counter.count += 1;
            }
        }
    }
}

class DecCount extends Thread {
    @Override
    public void run() {
        synchronized (Counter.class) {
            for(int i =0;i<10000;i++) {
                Counter.count -= 1;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AddCount addCount = new AddCount();
        DecCount decCount = new DecCount();
        addCount.start();
        decCount.start();
        addCount.join();
        decCount.join();
        System.out.println(Counter.count);
    }
}
