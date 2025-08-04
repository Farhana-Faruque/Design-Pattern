class Facebook implements SocialNetwork {
    @Override
    public ProfileIterator createFriendsIterator(String profileId) {
        return new FacebookIterator(this, profileId, "friends");
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileId) {
        return new FacebookIterator(this, profileId, "coworkers");
    }

    public Profile[] socialGraphRequest(String profileId, String type) {
        return new Profile[] {
                new Profile("bsse1513@iit.du.ac.bd"),
                new Profile("bsse1503@iit.du.ac.bd"),
                new Profile("bsse1505@iit.du.ac.bd")
        };
    }
}