class Application {
    public void config() {
        Editor editor = new Editor();

        LoggingListener logger = new LoggingListener(
                "log.txt",
                "Someone has opened the file: %s"
        );
        editor.events.subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener(
                "admin@example.com",
                "Someone has changed the file: %s"
        );
        editor.events.subscribe("save", emailAlerts);

        editor.openFile("example.txt");
        editor.saveFile();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.config();
    }
}