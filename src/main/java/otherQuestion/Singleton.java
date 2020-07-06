package otherQuestion;

import java.util.concurrent.atomic.AtomicBoolean;

public class Singleton {
    private static AtomicBoolean checkStatus = new AtomicBoolean(true);
    private Singleton(){}

    public boolean getCheckStatus() {
        return checkStatus.get();
    }

    public void resumeCheckExec() {
        checkStatus.set(true);
    }

    public void rejectCheckExec() {
        checkStatus.set(false);
    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    public static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }

}
