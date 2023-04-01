package Graph;

public class Graph_Client {
	public static void main(String[] args) {
		Graph graph=new Graph(7);
		graph.addEdge(1, 4, 6);
		graph.addEdge(1, 2, 10);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, 5);
		graph.addEdge(4, 5, 1);
		graph.addEdge(5, 6, 4);
		graph.addEdge(7, 5, 2);
		graph.addEdge(6, 7, 3);
		graph.display();
		System.out.println(graph.haspath(1, 9));
		System.out.println("all paths from src to des");
		graph.printpath(1, 6);
		System.out.println("BFS Traversa;");
		graph.BFS(1);
		System.out.println();
		System.out.println("DFS Traversa;");
		graph.DFS(1);
		System.out.println();
		System.out.println("BFT Traversa;");// breath first traversal
		graph.BFT();
		System.out.println();
		System.out.println("DFT Traversa;");// depth first traversal
		graph.DFT();
		System.out.println(graph.iscycle());
	}
}
