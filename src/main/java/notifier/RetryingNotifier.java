package notifier;

public class RetryingNotifier implements Notifier {

    private final Notifier wrapped;
    private final int maxRetries;

    public RetryingNotifier(Notifier wrapped, int maxRetries) {
        this.wrapped = wrapped;
        this.maxRetries = maxRetries;
    }

    @Override
    public void send(String message) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                attempts++;
                wrapped.send(message);
                return;
            } catch (Exception e) {
                if (attempts >= maxRetries) {
                    throw new RuntimeException("Failed after " + maxRetries + " attempts", e);
                }
            }
        }
    }
}
