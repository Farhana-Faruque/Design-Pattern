import java.util.*;

class ChatGroup {
    private String id;
    private List<User> users;

    public ChatGroup(String id) {
        this.id = id;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public String getId() {
        return id;
    }
}