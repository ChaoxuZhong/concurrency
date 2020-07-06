package otherQuestion;

public class UseSingleton01 {
    private Singleton singleton = Singleton.getInstance();

    public Singleton getSingleton() {
        return singleton;
    }

    public void setTrue() {
        singleton.resumeCheckExec();
    }

    public void setFalse() {
        singleton.resumeCheckExec();
    }

    public boolean getCheckExec() {
        return singleton.getCheckStatus();
    }
}
