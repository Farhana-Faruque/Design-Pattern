public class ChatMediatorDemo {
    public static void main(String[] args) {
        PrivateChatMediator privateMediator = new ConcretePrivateChatMediator();
        GroupChatMediator groupMediator = new ConcreteGroupChatMediator();

        User sadia = new User("Sadia", privateMediator, groupMediator);
        User mushfiq = new User("Mushfiq", privateMediator, groupMediator);
        User noshin = new User("Noshin", privateMediator, groupMediator);
        User mahfuj = new User("Mahfuj", privateMediator, groupMediator);

        System.out.println("Private Chat:");
        mushfiq.sendPrivateMessage(sadia, "Hi Sadia, how are you?");
        sadia.sendPrivateMessage(mushfiq, "Hey Mushfiq, I'm good!");

        System.out.println("\nGroup Chat:");
        groupMediator.createGroup("15th batch");
        groupMediator.addUserToGroup(sadia, "15th batch");
        groupMediator.addUserToGroup(noshin, "15th batch");
        groupMediator.addUserToGroup(mahfuj, "15th batch");

        noshin.sendGroupMessage("15th batch", "Hello everyone!");
        mahfuj.sendGroupMessage("15th batch", "Hi group!");

        mushfiq.sendGroupMessage("15th batch", "Trying to send to Group1");
    }
}