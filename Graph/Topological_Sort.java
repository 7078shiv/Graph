package Graph;
import java.util.*;


public class Topological_Sort {
	Map<Integer,Map<Integer, Integer>> graph;
	public Topological_Sort(int v) {
		this.graph=new HashMap<>();
		for(int i=1;i<=v;i++) {
			graph.put(i, new HashMap<>());
		}
	}
	public void addedge(int v1,int v2){
		graph.get(v1).put(v2, 0);
	}
	public int[] indegree() {
		int[] arr=new int[graph.size()+1];
		for(int ver:graph.keySet()) {
			for(int neigh:graph.get(ver).keySet()) {
				arr[neigh]++;;
			}
		}
		return arr;
	}
	public void topologicalSort() {
		int[] arr=indegree();
		Queue<Integer> qq =new LinkedList<>();
		for(int vtx:graph.keySet()) {
			if(arr[vtx]==0) {
				qq.add(vtx);
			}
		}
		while(!qq.isEmpty()){
			int rv=qq.poll();
			System.out.print(rv);
			for(int nbrs:graph.get(rv).keySet()){
				arr[nbrs]--;
				if(arr[nbrs]==0) {
					qq.add(nbrs);
				}
			}
		}
	}
	// detecting cycle in directed grapg
	public boolean isCycle() {
		int[] arr=indegree();
		int count=0;
		Queue<Integer> qq =new LinkedList<>();
		for(int vtx:graph.keySet()) {
			if(arr[vtx]==0) {
				qq.add(vtx);
			}
		}
		while(!qq.isEmpty()){
			int rv=qq.poll();
			//System.out.print(rv);
			count++;
			for(int nbrs:graph.get(rv).keySet()){
				arr[nbrs]--;
				if(arr[nbrs]==0) {
					qq.add(nbrs);
				}
			}
		}
		return count==graph.size()?false:true;
	}
}
