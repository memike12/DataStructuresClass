public class AlphaMap implements Map<Integer,String> {
    private class Node {
      int key;
      String value;
      Node left = null;
      Node right = null;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root = null;

    public AlphaMap() {
        // nothing to do here; head is default assigned to null.
    }

    @Override
        public String get(Integer key) {
        return getFrom(this.root, key);
    }

    private String getFrom(Node uu, int needle) {
        if (uu == null) return null;
        else if (needle == uu.key) return uu.value;
        else if(needle < uu.key) return getFrom(uu.left, needle);
        else return getFrom(uu.right, needle);
    }

    @Override
    public void set(Integer key, String value) {
        root = setBelow(root, key, value);
       
    }

    private Node setBelow(Node uu, int key, String value){
        if(uu == null) return new Node(key, value);
        
        else if(key <= uu.key) 
            uu.left = setBelow(uu.left, key, value);
        else
            uu.right = setBelow(uu.right, key, value);
        return uu;
    }

    @Override
    public int size() {
        int size = sizeFrom(root);
        //throw new UnsupportedOperationException("it's hard to avoid over-counting here!");
        return size;
    }

    private int sizeFrom(Node uu){
        if (uu == null) return 0;
        else return 1 + sizeFrom(uu.right) + sizeFrom (uu.left);
    }
}
