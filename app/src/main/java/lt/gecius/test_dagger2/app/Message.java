package lt.gecius.test_dagger2.app;


public class Message {

    public final String stringMsg;
    private final MyDependency mMyDependency;

    public Message(final String stringMsg, MyDependency myDependency) {
        this.stringMsg = stringMsg;
        mMyDependency = myDependency;
    }

    @Override
    public String toString() {
        return "Message{" +
                "stringMsg='" + stringMsg + '\'' +
                ", mMyDependency=" + mMyDependency +
                '}';
    }
}
