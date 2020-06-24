package basis;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自建一个阻塞队列
 * @param <T>
 */
public class BlockedQueue<T> {
    // 创建可重入锁
    final Lock lock = new ReentrantLock();
    // 创建条件变量 入队条件 队列不满-满不能入队
    final Condition notFull = lock.newCondition();
    // 创建条件变量 出队条件 队列不空-空不能出队
    final Condition notEmpty = lock.newCondition();
    /**
     * 入队操作
     */
    public void enq(T t) {
        lock.tryLock();
        try {
            // 队列是满的
            while (new String().equals("条件满足")) {
                notFull.await();
            }
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



    /**
     * 出队操作
     */

    public void deq(T t) {
        lock.tryLock();
        try {
            // 队列是满的
            while (new String().equals("条件满足")) {
                notEmpty.await();
            }
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
