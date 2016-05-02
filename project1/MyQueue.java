public class MyQueue<T> implements Queue<T> {
    private Node first = null;
    private Node last = null;
    private int size = 0;
    public int size(){
	return size;
    }
    public void enqueue(T element){
	if(this.size == 0){
	    first  = new Node(element);
	    last = new Node(element);
	    size++;
	}
	else if(this.size == 1){
	    last = new Node(element);
	    first.next = last;
	    size++;
	}
	else{
	    Node temp = new Node(element);
	    last.next = temp;
	    last = temp;
	    size++;
	}
    }
    public T dequeue(){
	if(size == 0)
	    throw new stackException("The queue is empty");
	Node temp = this.first;
	if(size == 1) {
	    first = null;
	    last = null;
	}
	
	else {
	    this.first = this.first.next;
	}
	size--;
	return (T)temp.data;
    }
    public T peek(){
	if(size == 0)
	    throw new stackException("The queue is empty");
	else
	    return (T)first.data;
	
    }
    public MyQueue duplicate(Tag dupTag){
	if (dupTag.isOpen()){
	    /*this.enqueue(dupTag);*/
	    Tag newClose = new Tag(dupTag.getName(), false, true);
	    this.enqueue((T)newClose);
	}
	else{
	    Tag newOpen = new Tag(dupTag.getName(), true, false);
	    this.enqueue((T)newOpen);
	    this.enqueue((T)dupTag);
	}
	return this;
    }
}

