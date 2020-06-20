package basis;


public class Add10k {

    public static void main(String[] args) {
        try {
            System.out.println(Add10k.calc());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 3000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Add10k test = new Add10k();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }
}
