package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class 按序打印 {

    private AtomicInteger firstFlag = new AtomicInteger(0);
    private AtomicInteger secondFlag = new AtomicInteger(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstFlag.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(firstFlag.get() != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondFlag.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(secondFlag.get() != 1) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {

    }
}
