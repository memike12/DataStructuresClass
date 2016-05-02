
public class tuple implements Comparable<tuple>{
	Vertex thisVertex;
	Vertex parentVertex;
	float length;
	
	public tuple(Vertex thisV, Vertex parentV, float length){
		this.thisVertex = thisV;
		this.parentVertex = parentV;
		this.length = length;
	}
	
	 @Override
	  public int compareTo(tuple other) {
	    if( this.length > other.length)
	    	return 1;
	    else if(this.length == other.length)
	    	return 0;
	    else
	    	return -1;
	  }
}
