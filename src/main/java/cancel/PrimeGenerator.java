package cancel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 可取消的素数生成器
 */
public class PrimeGenerator implements Runnable{
    private final List<BigInteger> primes = new ArrayList<BigInteger>();

    private volatile boolean cancelled;

    public void run() {
        BigInteger p = BigInteger.ONE;
        int i = 0;
        long start = System.currentTimeMillis();
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                i++;
                System.out.println("i:" + p);
                primes.add(p);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }

    // 这里的返回必须新建一个对象，因为不新建对象集合可以在外面被更改
    public List<BigInteger> getPrimes() {
        return new ArrayList<BigInteger>(primes);
    }

    // boolean volatile 修饰不用加锁，happen-before保证可见性
    public void cancel(){
        cancelled = true;
    }
}
