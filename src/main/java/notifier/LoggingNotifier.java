package notifier;

public class LoggingNotifier implements Notifier {

    private final Notifier wrapped;

    public LoggingNotifier(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String message) {
        System.out.println("[LOG] Before sending: " + message);
        wrapped.send(message);
        System.out.println("[LOG] After sending: " + message);
    }
}
