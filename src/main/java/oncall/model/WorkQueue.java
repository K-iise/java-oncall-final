package oncall.model;

import java.util.List;

public class WorkQueue {
    private final List<String> workers;
    private int index = 0;
    private String deferredWorker = null;

    public WorkQueue(List<String> workers) {
        this.workers = workers;
    }

    public String getNextWorker(String lastWorker) {
        if (deferredWorker != null) {
            String worker = deferredWorker;
            deferredWorker = null;
            return worker;
        }

        String next = workers.get(index);

        if (next.equals(lastWorker)) {
            index = (index + 1) % workers.size();
            deferredWorker = next;
            next = workers.get(index);
        }
        index = (index + 1) % workers.size();
        return next;
    }
}
