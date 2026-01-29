package notifier;

public class SmsNotifier implements Notifier {

    private final String phoneNumber;

    public SmsNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        System.out.println("[SMS] Sending to " + phoneNumber + ": " + message);
    }
}
