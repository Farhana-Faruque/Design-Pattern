public class DatabaseProxy implements Database {
    private RealDatabase realDatabase = new RealDatabase();
    private String userRole;

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void query(String sql) {
        if (userRole.equalsIgnoreCase("admin")) {
            System.out.print("[Admin] ");
            realDatabase.query(sql);
        } else {
            System.out.println("[Guest] Access denied for query: " + sql);
        }
    }
}