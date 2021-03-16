package solution.thread.waitNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<Thread>();

        for(int i = 0; i< 5;i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Integer task = q.getTask();
                        System.out.println("get: " + task);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("add: " + i);
                q.addTask(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }
    }
}
class TaskQueue {
    Queue<Integer> taskQueue = new LinkedList<>();

    public synchronized void addTask(Integer num) {
        this.taskQueue.add(num);
        this.notifyAll();
    }

    public synchronized Integer getTask() throws InterruptedException {
        while (taskQueue.isEmpty()) {
            this.wait();
        }
        return taskQueue.remove();
    }
}
