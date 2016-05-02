public class AlphaMap implements Map<Integer, String> {
 
  private class Node {
    /* TODO
     * What goes in your node depends on what kind of
     * balanced search tree you choose to implement!
     */
	int key;
	String value;
	Node left = null;
	Node right = null;
	int height = 0;	

	public Node(int key, String value){
		this.key = key;
		this.value = value;
	}	
  }
 
  /* TODO
   * You probably want some fields here.
   * How about a root node?
   * How about an int for the current size?
   */
  private Node root = null;
  private int mapSize = 0;

  public AlphaMap() {
    // constructor
  }
 
  private int balance(Node uu){
	int m = -1, n = -1;
	if(uu.right != null) m = uu.right.height;
	if(uu.left != null) n = uu.left.height;
	return m-n;    
  }

  private Node lRotate(Node oldRoot){
    Node newRoot = oldRoot.right;
    Node middle = newRoot.left;
    newRoot.left = oldRoot;
    oldRoot.right = middle;
    return newRoot;
  }

  private Node rRotate(Node oldRoot){
    Node newRoot = oldRoot.left;
    Node middle = newRoot.right;
    newRoot.right = oldRoot;
    oldRoot.left = middle;
    return newRoot;
  }

  @Override
  public int size() {
    return this.mapSize;
  }
 
  @Override
  public String get(Integer key) {
    return getFrom(this.root, key);
  }
 
  private String getFrom(Node uu, int needle) {
    if (uu == null) return null;
    else if (needle < uu.key) return getFrom(uu.left, needle);
    else if (needle > uu.key) return getFrom(uu.right, needle);
    else return uu.value;
  }

  @Override
  public void set(Integer key, String value) {
    this.root = setFrom(this.root, key, value);
  }

  private Node setFrom(Node uu, int key, String value) {
    if (uu==null) {
      if (value == null) return null;
      this.mapSize += 1;
      return new Node(key, value);
    }
    else {
      if (key < uu.key){
         uu.height ++;
	 uu.left = setFrom(uu.left, key, value);
	}
      else if (key > uu.key) {
	 uu.height --;
	 uu.right = setFrom(uu.right, key, value);
	}
      else {
	if (uu.value == null && value != null) ++this.mapSize;
        else if (uu.value != null && value == null) --this.mapSize;
	uu.value = value;
      }
      if(balance(uu) == 2 && balance(uu.right) >= 0) lRotate(uu);      
      if(balance(uu) == -2 && balance(uu.left) <= 0) rRotate(uu);
      if(balance(uu) == 2 && balance(uu.right) == -1) {
        rRotate(uu.right);
        lRotate(uu);
      }
      if(balance(uu) == -2 && balance(uu.left) == 1) {
        lRotate(uu.left);
	rRotate(uu);
      }

      return uu;
    }
  }
}
