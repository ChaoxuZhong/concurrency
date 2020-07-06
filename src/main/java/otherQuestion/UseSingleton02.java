package otherQuestion;

public class UseSingleton02 {
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

    public static void main(String[] args) {
//        System.out.println(new UseSingleton02().getSingleton());
//        System.out.println(new UseSingleton01().getSingleton());
        new UseSingleton02().setFalse();
        System.out.println(new UseSingleton02().getCheckExec());
        System.out.println(new UseSingleton01().getCheckExec());
        System.out.println(new UseSingleton02().getCheckExec());
        System.out.println(new UseSingleton01().getCheckExec());

        System.out.println(new UseSingleton02().getSingleton());
        System.out.println(new UseSingleton01().getSingleton());
        System.out.println(new UseSingleton02().getSingleton());
        System.out.println(new UseSingleton01().getSingleton());
    }
}
