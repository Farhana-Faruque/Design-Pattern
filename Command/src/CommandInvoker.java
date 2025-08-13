import java.util.concurrent.*;

class CommandInvoker {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<?> executeCommandWithCancel(Command command) {
        FutureTask<?> futureTask = new FutureTask<>(() -> {
            Thread.sleep(5000); // 5-second delay
            command.execute();
        }, null);
        executor.submit(futureTask);
        return futureTask;
    }

    public void executeCommand(Command command) {
        FutureTask<?> futureTask = new FutureTask<>(() -> {
            Thread.sleep(5000); // 5-second delay
            command.execute();
        }, null);
        executor.submit(futureTask);
        try {
            futureTask.get(); // Wait for completion
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Command execution interrupted.");
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}