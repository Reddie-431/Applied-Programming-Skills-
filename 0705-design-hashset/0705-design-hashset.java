class MyHashSet {
    private final boolean[] set;

    public MyHashSet() {
        // Range of key is [0, 10^6], array size 1,000,001 covers all possible keys
        this.set = new boolean[1000001];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}