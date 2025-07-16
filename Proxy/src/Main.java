public class Main {
    public static void main(String[] args) {
        Database adminDb = new DatabaseProxy("admin");
        adminDb.query("SELECT * FROM users");

        Database guestDb = new DatabaseProxy("guest");
        guestDb.query("SELECT * FROM users");
    }
}