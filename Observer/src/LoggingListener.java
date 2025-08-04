import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class LoggingListener implements EventListener {
    private String logFilename;
    private String message;

    public LoggingListener(String logFilename, String message) {
        this.logFilename = logFilename;
        this.message = message;
    }

    @Override
    public void update(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilename, true))) {
            writer.write(String.format(message, filename));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}