import java.util.*;

/** A graph of ping delays throughout a network.
 * Each node label is a domain name such as www.usna.edu,
 * and each edge weight is the latency in that transmission,
 * as a floating-point value for the number of milliseconds.
 */
public class PingGraph {
  
  // TODO: Your data structure to store the edges should be a
  // field of the class defined here.
  // I recommend a Map from Strings to Vertex objects, where
  // each Vertex contains a list of outgoing edges.
  // (You will need to create the Vertex class yourself!)
	public TreeMap<String, Vertex> allVerticies;

  /** Constructor for a new, empty graph. */
  public PingGraph() {
    // TODO initialize your fields
	  allVerticies = new TreeMap<String, Vertex>();
  }

  /** Adds a new edge, and possibly new vertices, to the graph. */
  public void addEdge(PingEdge ee) {
    // TODO check if the edge's vertices are in the data structure.
    // If not, you might have to add one or both vertices.
    // Then of course you have to add that edge to the appropriate
    // list in your adjacency list.
	  Vertex fromVertex = new Vertex(ee.getSource());
	  Vertex toVertex = new Vertex(ee.getDest());
	  
	  //If the source vertex isn't in the Tree map, add it
	  if( !allVerticies.containsKey(ee.getSource())){ 
		  allVerticies.put(fromVertex.getName(), fromVertex);
	  }
	  
	  //If the destination vertex isn't in the Tree map, add it
	  if( !allVerticies.containsKey(ee.getDest())){
		  allVerticies.put(toVertex.getName(), toVertex);
	  }
	  //I dont know if this will work. It may need to change the TreeMap instance of the vertex
	  ((Vertex)allVerticies.get(ee.getSource())).addEdgeOut(ee);
	  //fromVertex.addEdgeOut(toVertex);
  }

  /** Gets all edges that have the given source. */
  public List<PingEdge> neighbors(String source) {
    // TODO look up the source vertex and return a list of outgoing edges.
	if(!allVerticies.containsKey(source))
			return null;
	return ((Vertex) allVerticies.get(source)).outList();
  }
}
