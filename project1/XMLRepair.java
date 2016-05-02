import java.util.Scanner;

public class XMLRepair {
    public static void main(String[] args) {
	TagScanner scan = new TagScanner();
	MyQueue queue = new MyQueue();
	TagStack stack = new TagStack();
	while (scan.hasNext()){
	    Tag nextTag = scan.next();
	    if(nextTag.isOpen()){
		stack.push(nextTag);
		queue.enqueue(nextTag);
	    }
	    else if(nextTag.isClose() && stack.size() == 0){
		queue.duplicate(nextTag);
	    }
	    else if(nextTag.isClose() && nextTag.getName().equals(stack.peek().getName())){
		stack.pop();
		queue.enqueue(nextTag);
	    }
	    else if(nextTag.isClose() && !nextTag.getName().equals(stack.peek().getName())){
		queue.duplicate(stack.pop());
                if(stack.size() == 0)
                    queue.duplicate(nextTag);
		while(stack.size() != 0 && nextTag.isClose() && !nextTag.getName().equals(stack.peek().getName()) && stack.size() != 0){
		    queue.duplicate(stack.pop());
		}
		
	    }
	    else
		queue.duplicate(nextTag);
	}
        while(stack.size() > 0)
	    queue.duplicate(stack.pop());
	System.out.println(queue.size());
	while (queue.size() > 0){
	    System.out.println(queue.dequeue());
	}
    } 
}
