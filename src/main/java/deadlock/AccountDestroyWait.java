package deadlock;

/**
 * 死锁 破坏等待条件，一次性申请所有账户-账户类
 */
public class AccountDestroyWait {
    // 账户余额
    private int balance;

    private AccountAllocator accountAllocator = new AccountAllocator();

    public void transfer(AccountDestroyWait target) {
        //没申请到一直等待
        while (!accountAllocator.apply(this, target)) {

        }
        //申请到了执行加锁
        try {
            synchronized (this) {
                synchronized (target) {
                    this.balance -= 100;
                    target.balance += 100;
                }
            }
        } catch (Exception e) {
            accountAllocator.free(this, target);
        }


    }
}
