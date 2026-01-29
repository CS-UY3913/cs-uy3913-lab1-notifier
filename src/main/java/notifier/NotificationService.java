package notifier;

public class NotificationService {

    private final Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void sendWelcome(String userName) {
        notifier.send("Welcome to CS-UY 3913, " + userName + "!");
    }
}
