class MyHashSet {
    Set<Integer> nm=new HashSet<>();
    public MyHashSet() {
    }
    
    public void add(int key) {
        nm.add(key);
    }
    
    public void remove(int key) {
        nm.remove(key);
    }
    public boolean contains(int key) {
        return nm.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */