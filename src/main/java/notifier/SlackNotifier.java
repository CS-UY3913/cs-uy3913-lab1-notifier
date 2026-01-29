package notifier;

public class SlackNotifier implements Notifier {

    private final String channelName;

    public SlackNotifier(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void send(String message) {
        System.out.println("[SLACK] Posting to #" + channelName + ": " + message);
    }
}
