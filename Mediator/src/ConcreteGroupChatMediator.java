import java.util.*;

class ConcreteGroupChatMediator implements GroupChatMediator {
    private Map<String, ChatGroup> groups;

    public ConcreteGroupChatMediator() {
        this.groups = new HashMap<>();
    }

    @Override
    public void createGroup(String groupID) {
        if (!groups.containsKey(groupID)) {
            groups.put(groupID, new ChatGroup(groupID));
            System.out.println("Group created with ID: " + groupID);
        } else {
            System.out.println("Group with ID: " + groupID + " already exists");
        }
    }

    @Override
    public void addUserToGroup(User user, String groupID) {
        ChatGroup group = groups.get(groupID);
        if (group != null) {
            group.addUser(user);
            user.joinGroup(groupID);
            System.out.println(user.getName() + " added to group: " + groupID);
        } else {
            System.out.println("Group with ID: " + groupID + " does not exist");
        }
    }

    @Override
    public void sendGroupMessage(User sender, String groupID, String message) {
        ChatGroup group = groups.get(groupID);
        if (group != null && sender.isInGroup(groupID)) {
            System.out.println(sender.getName() + " sends message to group " + groupID);
            for (User user : group.getUsers()) {
                if (user != sender) {
                    user.receiveGroupMessage(groupID, message);
                }
            }
        } else {
            System.out.println(sender.getName() + " cannot send message to group " + groupID);
        }
    }
}