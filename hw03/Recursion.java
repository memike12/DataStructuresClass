/* This is really a linked list class for a linked list of Strings.
 * No loops allowed in these parts!
 * 
 * I got guidence from Kieren Dziallo and worked with Emily Phillips 
 * 
 * 
 */
public class Recursion {

  // Class for the links in the linked list.
  // No getters and setters necessary because the fields are public.
  private class Node {
    public String data;
    public Node next;

    public Node(String data) {
      this.data = data;
      next = null;
    }
  }

  // Pointer to the first Node
  private Node first;

  public Recursion() {
    first = null;
  }

  // Adds an element to the front of the linked list.  No recursion required.
  public void addToFront(String element) {
	  Node newFirst = new Node(element);
	  newFirst.next = first;
	  first = newFirst;
	  return;
  }

  // Prints the data of the lists, in order.
  // You'll need a helper method, which I have started for you below.
  public void printInOrder() {
	  printInOrder(first);
  }

  // Helper method
  private void printInOrder(Node node) {
	  if (node == null) return;
	  else System.out.println(node.data);
	  printInOrder(node.next);
	  return;
  }

  // Prints the list in reverse order, last node first.
  public void printInReverseOrder() {
	  printInReverseOrder(first);
  }

  // Helper method
  private void printInReverseOrder(Node node) {
	  if (node == null) return;
	  else printInReverseOrder(node.next);
	  System.out.println(node.data);
	  return;
  }

  // Gets the longest word in the list.
  // If more than one word is tied for the longest,
  // you should return the FIRST one.
  public String longest() {
	  return longest(first);
  }

  // Helper method
  private String longest(Node node) {
	  String contender;
	  if (node.next == null) return node.data;
	  else 
		  contender = longest(node.next);
	  if (contender.length() > node.data.length()) return contender;
	  else return node.data;
  }

  // Gets the contents of the i-th node, counting from 0.
  public String get(int i) {
	  return get(first, i);
  }

  // Helper method
  private String get(Node node, int i) {
	  if (i == 0) return node.data;
	  else return get(node.next, i-1);
  }

  // Remove the i-th node and its data.
  public void remove(int i) {
	  remove(first, i);
  }

  // Helper method
  public void remove(Node node, int i) {
	  if (node.next == null) return;
	  else if (i == 0) first = node.next;
	  else if (i == 1) node.next = node.next.next;
	  else remove(node.next, i-1);
  }
}
