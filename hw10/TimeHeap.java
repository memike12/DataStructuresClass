import java.util.*;

/** A max heap of times, with associated names for each time value. */
public class TimeHeap {
  /** A single (time,name) entry in the heap.
   * Note that when you are doing heap operations, you will be comparing
   * the "time" field in each entry.
   */
  private class Entry {
    public long time;
    public String name;
    public Entry(long time, String name) {
      this.time = time;
      this.name = name;
    }
  }

  // TODO: An array or ArrayList to store your heap
  // Perhaps you also want to store the size?
  ArrayList<Entry> arr;

  /** Creates a new, empty heap. */
  public TimeHeap() {
    // TODO: initialize your heap with size 0
    // (hint: the array or arraylist should NOT be empty!)
	  arr = new ArrayList<Entry>(0);
	  arr.add(null);
  }

  /** Returns the number of entries in the heap */
  public int size() {
	  return arr.size()-1;
  }

  /** Inserts a new time and corresponding name to the heap. 
   * You can assume the name is not null. */
  public void insert(long time, String name) {
	  arr.add(new Entry(time, name));
	  this.bubbleUp(size()+1);
  }

  
  public void printAll(){
	  for( int x = 1; x < size()+1; x++){
		  System.out.println(arr.get(x).name + " " + arr.get(x).time);
	  }
  }
  
  
  public void heapify(ArrayList<Entry> arr){
	  // if the new thing is bigger than the thing indexed at the floor of its index/2
	  for(int x = size() ; x > 0; x--){
		   this.bubbleDown();
	  }
  }
  
  public void bubbleDown(){
	  int index = 1;
	  boolean leftChild = false;
	  int biggerChildIndex;
	  if(index*2 < size()+1 && arr.get(index*2) !=null)
		  leftChild = true;
	  while(leftChild){
		  biggerChildIndex  = index*2;
		  if(index*2+1 < size()+1 && arr.get((index*2)+1) != null){
			  if(arr.get((index*2)+1).time > arr.get(index*2).time){
				  biggerChildIndex = index*2+1;
			  }
		  }
		  if(arr.get(biggerChildIndex).time > arr.get(index).time){
			  arr.set(biggerChildIndex, arr.set(index, arr.get(biggerChildIndex)));
		  }
		  else break;
		  index = biggerChildIndex;
		  if(index*2 < size()+1 && arr.get(index*2) != null)
			  leftChild = true;
		  else
			  leftChild = false;
	  }
	  
  }
  
  public void bubbleUp(int index){
	  index--;
	  while(index > 1 && (arr.get(index).time  > arr.get((int)Math.floor(index/2)).time)){
		  arr.set(index, arr.set((int)Math.floor(index/2), arr.get(index)));
		  index = (int)Math.floor(index/2);
	  } 
  }
  
  /** Removes the entry with the largest time, and returns the
   * corresponding name.
   */
  public String removeMax() {
	  String biggest;
	  if (size() < 1) 
		  throw new NoSuchElementException("heap is empty");
	  if(arr.size() > 2){
		  biggest = arr.set(1, arr.remove(size())).name;
		  this.bubbleDown();
	  }
	  else {
		  biggest = arr.remove(size()).name;
	  }
	  return biggest;
    
  }
}
