import java.util.*;

class ConcretePrivateChatMediator implements PrivateChatMediator {
    private Map<String, ChatGroup> groups;

    public ConcretePrivateChatMediator() {
        this.groups = new HashMap<>();
    }

    @Override
    public void sendMessage(User sender, User receiver, String message) {
        String groupID = sender.getName() + "-" + receiver.getName();
        if (!groups.containsKey(groupID)) {
            ChatGroup group = new ChatGroup(groupID);
            group.addUser(sender);
            group.addUser(receiver);
            groups.put(groupID, group);
        }
        System.out.println(sender.getName() + " sends private message to " + receiver.getName());
        receiver.receivePrivateMessage(sender, message);
    }
}