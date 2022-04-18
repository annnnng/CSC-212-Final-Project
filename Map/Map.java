import com.google.common.graph.*;

/**
 * Class to store place and exit as a graph using Guava ValueGraph
 *
 * @author Anh Nguyen
 * @author Sabrina Hatch
 * @author Pratima Naroula
 * @version Spring 2022
 */
class Map {

	public static void main(String[] args) {
    ImmutableGraph<String> myGraph = GraphBuilder.directed()
      .<String>immutable()
      .putEdge("Bass", "McConnell")
      .putEdge("McConnell", "Sabin-Reed")
      .putEdge("Sabin-Reed", "Burton")
      .putEdge("Burton", "Sabin-Reed")
      .build();

    System.out.println(myGraph);
  }
}