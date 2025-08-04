class FacebookIterator implements ProfileIterator {
    private Facebook facebook;
    private String profileId;
    private String type;
    private int currentPosition;
    private Profile[] cache;

    public FacebookIterator(Facebook facebook, String profileId, String type) {
        this.facebook = facebook;
        this.profileId = profileId;
        this.type = type;
        this.currentPosition = 0;
        this.cache = null;
    }

    private void lazyInit() {
        if (cache == null) {
            cache = facebook.socialGraphRequest(profileId, type);
        }
    }

    @Override
    public Profile getNext() {
        if (hasMore()) {
            Profile result = cache[currentPosition];
            currentPosition++;
            return result;
        }
        return null;
    }

    @Override
    public boolean hasMore() {
        lazyInit();
        return currentPosition < cache.length;
    }
}