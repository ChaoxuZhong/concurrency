package basis;

public class SafeCalc {
    static long value = 0l;

    public long getValue() {
        return value;
    }

    synchronized static void addOne() {
        value++;
    }

    synchronized void add10k() {
        for (int i = 0; i < 10000000; i++) {
            value++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SafeCalc safeCalc = new SafeCalc();
        Thread t1 = new Thread(() -> safeCalc.add10k());
        Thread t2 =  new Thread(() -> safeCalc.add10k());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(safeCalc.getValue());

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                safeCalc.addOne();
            }
        });
        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                safeCalc.addOne();
            }
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(safeCalc.getValue());

    }
}
