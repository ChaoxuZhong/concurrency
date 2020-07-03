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
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    // 这里的返回必须新建一个对象，因为不新建对象集合可以在外面被更改
    public synchronized List<BigInteger> getPrimes() {
        return new ArrayList<BigInteger>(primes);
    }
}
