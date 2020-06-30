package deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户分配器
 */
public class AccountAllocator {
    // 保存申请的账户集合：转入+转出账户
    private List<AccountDestroyWait> list = new ArrayList<>();

    // 一次性申请两把锁
    synchronized boolean apply(AccountDestroyWait source, AccountDestroyWait target) {
        // 如果有资源已被申请，返回false
        if (list.contains(source) || list.contains(target)) {
            return false;
        }
        list.add(source);
        list.add(target);
        return true;
    }

    // 释放资源
    synchronized void free(AccountDestroyWait source, AccountDestroyWait target) {
        list.remove(source);
        list.remove(target);
    }


}
