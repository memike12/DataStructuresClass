import java.util.*;
import java.io.*;

/** Contains a main method to find the closest Google server from
 * a file of ping data.
 */
class FindGoogle {

  /** Returns true if the given server name ends in 1e100.net. */
  public static boolean isGoogle(String host) {
    return host.endsWith(".1e100.net");
  }

  // The stored graph that you want to search
  private PingGraph G;

  /** Constructs a new PingGraph from the given file and saves it for
   * later searching.
   */
  public FindGoogle(String pingsFile) {
    // NOTE: This is already written for you. Should require no changes.

    Scanner pingsIn = null;
    try { pingsIn = new Scanner(new File(pingsFile)); }
    catch (FileNotFoundException ee) {
      System.err.println("File " + pingsFile + " not found; aborting.");
      System.exit(2);
    }

    this.G = new PingGraph();
    while (pingsIn.hasNext()) {
      this.G.addEdge(new PingEdge(
          pingsIn.next(), 
          pingsIn.next(), 
          pingsIn.nextFloat()
      ));
    }
    pingsIn.close();
  }

  /** Performs a search in the pings graph from the given source.
   * The name of the closest Google destination, as well as the
   * time to that destination, are printed.
   */
  public void search(String source) {
    ////////////////////////////////////////////////////////////////////
    // TODO You have to write Dijkstra's algortihm here!!             //
    // Tips:                                                          // 
    // * You will need a minimum-priority queue. You can use          //
    //   java.util.PriorityQueue, or modify the TimeHeap from HW 10   //
    //   to make it a minimum-heap.                                   //
    // * You will need to remember which vertices have been visited.  //
    //   That may involve another data structure, such as a map from  //
    //   strings to booleans.                                         //
    // * Whenever you "visit" a vertex, call the isGoogle helper      //
    //   method to tell whether it ends in 1e100.net. If so, stop the //
    //   search immediately and print out the result.                 //
    // * If the search ends without finding any google server, you    //
    //   have to print out "unreachable".                             //
    ////////////////////////////////////////////////////////////////////
		if(!G.allVerticies.containsKey(source)){
			System.out.println("unreachable");
			return;
		}
		PriorityQueue<tuple> fringe = new PriorityQueue<tuple>();
		List<PingEdge> neighbors = G.neighbors(source);
		float latency = 0;
		tuple start = new tuple(G.allVerticies.get(source), null, latency);
		fringe.add(start);
		while(fringe.size() > 0){
			//pops off the first thing in the fringe
			tuple uu = fringe.poll();
                        //if its google, print it out and exit
			if(isGoogle(uu.thisVertex.print())){
				System.out.println(G.allVerticies.get(uu).print() + " " + latency);
				break;
			}
                        //if it hasn't been visited mark it visited and add the neighbors to the fringe
                        //this next line is what I wasn't able to figure out... or that's what my error message tells me anyways
			if( G.allVerticies.get(uu.thisVertex).visited != true){
				G.allVerticies.get(uu.thisVertex).visited = true;
				for(int x = 0; x < neighbors.size(); x++){
					latency =+ neighbors.get(x).getLatency();
					tuple next = new tuple(G.allVerticies.get(neighbors.get(x)), uu.thisVertex, latency);
					fringe.add(next);
				}
			}
		}
    //System.out.println("unreachable");
  }

  /** This program will read in pings data from a file,
   * then prompt for searches to perform.
   */
  public static void main(String[] args) {
    // NOTE: This is already written for you. Should require no changes.

    if (args.length != 1) {
      System.err.println("Need 1 command-line argument for the pings file.");
      System.exit(1);
    }

    // Read in the graph and save it
    FindGoogle finder = new FindGoogle(args[0]);

    // Prompt for searches to perform
    Scanner searchRequests = new Scanner(System.in);
    System.err.print("Enter starting hostname, or CTRL-D to quit: ");
    while (searchRequests.hasNext()) {
      String source = searchRequests.next();
      finder.search(source);
      System.err.print("Enter starting hostname, or CTRL-D to quit: ");
    }
  }
}
