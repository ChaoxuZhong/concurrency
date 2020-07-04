package cancel;

import com.alibaba.fastjson.JSON;

import java.math.BigInteger;
import java.util.List;

/**
 * 使用素数生成器
 */
public class TestPrimeGenerator {

    /**
     * 启动一个素数生成器线程，在1s后结束
     * @return
     */
    public List<BigInteger> aSecondOfPrime() {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        new Thread(primeGenerator).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            primeGenerator.cancel();
        }
        return primeGenerator.getPrimes();
    }

    /**
     * 两个线程同时run一个线程生成器
     * @return
     */
    public List<BigInteger> twoThreadPrime() {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        new Thread(primeGenerator).start();
        new Thread(primeGenerator).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            primeGenerator.cancel();
        }
        List<BigInteger> result =  primeGenerator.getPrimes();
        result = null;
        return primeGenerator.getPrimes();
    }



    public static void main(String[] args) {
        // 单线程 get方法加sync隐式锁测试
//        TestPrimeGenerator testPrimeGenerator = new TestPrimeGenerator();
//        List<BigInteger> primes = testPrimeGenerator.aSecondOfPrime();
//        System.out.println(JSON.toJSON(primes));

        // 多线程 1 get方法加sync隐式锁测试
        TestPrimeGenerator testPrimeGenerator = new TestPrimeGenerator();
        List<BigInteger> primes = testPrimeGenerator.twoThreadPrime();
        System.out.println(JSON.toJSON(primes));


    }


}
