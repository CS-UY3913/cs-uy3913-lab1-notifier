package notifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeNotifier implements Notifier {

    private final List<Notifier> notifiers;

    public CompositeNotifier(Notifier... notifiers) {
        this.notifiers = new ArrayList<>(Arrays.asList(notifiers));
    }

    @Override
    public void send(String message) {
        for (Notifier notifier : notifiers) {
            notifier.send(message);
        }
    }
}
