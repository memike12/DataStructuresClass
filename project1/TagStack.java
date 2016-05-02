public class TagStack implements Stack<Tag>{
    private int size = 0;
    private int length = 5;
    private int placeHolder = 0;
    Tag[] tagArr = new Tag[length];
    
    public int size(){
	return size;
    }

    public void push(Tag element){
	if (size == length-1){
	    length = length*2;
	    Tag[] newTagArr = new Tag[length];
	    for(int ii=0; ii<= size; ii++)
		newTagArr[ii] = tagArr[ii];
	    tagArr = newTagArr;
	}
	tagArr[size] = element;
	size++;
    }

    public Tag pop(){
	Tag temp = tagArr[this.size-1];
	tagArr[this.size-1] = null;
	this.size--;	
	return temp;
    }

    public Tag peek(){
	return tagArr[this.size-1];
    }
}
