import java.util.ArrayList;
import java.util.List;



public class Vertex  {
	
	List<PingEdge> outList = new ArrayList<PingEdge>();
	String VertexName;
	boolean visited = false;
	
	public Vertex(String Name){
		this.VertexName = Name;
	}
	
	public void addEdgeOut(PingEdge goingTo){
		outList.add(goingTo);
	}
	
	public String getName(){
		return this.VertexName;
	}
	
	public List<PingEdge> outList(){
		return outList;
	}
	public String print(){
		return VertexName;
	}
	
	 
}
