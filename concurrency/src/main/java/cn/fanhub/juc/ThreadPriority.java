package cn.fanhub.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程的优先级
 * @author chengfan
 * @date 2018-2-4 14:43:30
 */
public class ThreadPriority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "iamThread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("job priority: " + job.priority + ", count: " + job.jobCount);
        }
    }

    /**
     *
     job priority: 1, count: 2116886
     job priority: 1, count: 2127109
     job priority: 1, count: 2130715
     job priority: 1, count: 2078835
     job priority: 1, count: 2106367
     job priority: 10, count: 2110669
     job priority: 10, count: 2118724
     job priority: 10, count: 2115553
     job priority: 10, count: 2131437
     job priority: 10, count: 2112180
     */

    static class Job implements Runnable {

        private int priority;
        private long jobCount;
        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}