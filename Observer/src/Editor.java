class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager();
    }

    public void openFile(String path) {
        this.file = new File(path);
        events.notify("open", file.getName());
    }

    public void saveFile() {
        if (file != null) {
            System.out.println("Writing to file: " + file.getName());
            events.notify("save", file.getName());
        }
    }
}