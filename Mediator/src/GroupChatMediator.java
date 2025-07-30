interface GroupChatMediator {
    void sendGroupMessage(User sender, String groupID, String message);
    void createGroup(String groupID);
    void addUserToGroup(User user, String groupID);
}