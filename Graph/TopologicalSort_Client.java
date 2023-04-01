package Graph;

public class TopologicalSort_Client {

	public static void main(String[] args) {
		Topological_Sort ts=new Topological_Sort(6);
		ts.addedge(1, 2);
		ts.addedge(3, 1);
		ts.addedge(3, 2);
		ts.addedge(2, 4);
		ts.addedge(4, 5);
		ts.addedge(4, 6);
		ts.addedge(6, 4);
		ts.addedge(5, 6);
		ts.topologicalSort();
		System.out.println();
		System.out.println(ts.isCycle());
	}

}
