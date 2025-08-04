class Application {
    private SocialNetwork network;
    private SocialSpammer spammer;

    public void config() {
        this.network = new Facebook();
        this.spammer = new SocialSpammer();
    }

    public void sendSpamToFriends(Profile profile) {
        ProfileIterator iterator = network.createFriendsIterator(profile.getEmail());
        spammer.send(iterator, "Very important message");
    }

    public void sendSpamToCoworkers(Profile profile) {
        ProfileIterator iterator = network.createCoworkersIterator(profile.getEmail());
        spammer.send(iterator, "Very important message");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.config();

        Profile userProfile = new Profile("user@example.com");
        app.sendSpamToFriends(userProfile);
        app.sendSpamToCoworkers(userProfile);
    }
}