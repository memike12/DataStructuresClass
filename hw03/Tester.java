// main method to test the Recursion class
// NOTE: I WILL do more testing than this!! You should add your own tests!!
public class Tester {
  public static void main(String[] args) {
    Recursion list = new Recursion();
    
    list.addToFront("people");
    list.addToFront("eat");
    list.addToFront("crabs");
    //list.addToFront("peopleslonger");
    //list.addToFront("lesslong");
    //list.addToFront("crabsiswaymorelonger");
    
    list.printInOrder(); // crabs eat people

    System.out.println();
    list.printInReverseOrder(); // people eat crabs

    System.out.println();
    System.out.println(list.get(1)); // eat
    
    System.out.println();
    System.out.println(list.longest()); // people

    System.out.println();
    list.remove(2); // people are removed
    list.printInReverseOrder(); // eat crabs
  }
}
