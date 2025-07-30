import java.util.*;

class User {
    private String name;
    private PrivateChatMediator privateChatMediator;
    private GroupChatMediator groupChatMediator;
    private Set<String> joinedGroups;

    public User(String name, PrivateChatMediator privateChatMediator, GroupChatMediator groupChatMediator) {
        this.name = name;
        this.privateChatMediator = privateChatMediator;
        this.groupChatMediator = groupChatMediator;
        this.joinedGroups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void joinGroup(String groupID) {
        joinedGroups.add(groupID);
    }

    public boolean isInGroup(String groupID) {
        return joinedGroups.contains(groupID);
    }

    public void sendPrivateMessage(User to, String message) {
        privateChatMediator.sendMessage(this, to, message);
    }

    public void receivePrivateMessage(User from, String message) {
        System.out.println(name + " received private message from " + from.getName() + ": " + message);
    }

    public void sendGroupMessage(String groupID, String message) {
        groupChatMediator.sendGroupMessage(this, groupID, message);
    }

    public void receiveGroupMessage(String groupID, String message) {
        System.out.println(name + " received group message in " + groupID + ": " + message);
    }
}