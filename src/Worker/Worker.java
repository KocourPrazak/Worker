package Worker;

public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError((char) 27 + "[31m" + "Task " + i + " something went wrong!"
                        + (char) 27 + "[0m");
                continue;
            }
            callback.onDone("Task " + i + " is done");
        }
    }
}
