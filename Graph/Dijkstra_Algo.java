package Graph;

import java.util.*;

class Dijkstra_pair{
	int vtx;
	String path;
	int cost;
	public Dijkstra_pair(int vtx,String path,int cost) {
		this.vtx=vtx;
		this.path=path;
		this.cost=cost;
	}
	@Override
	public String toString() {
		return this.vtx+" via "+this.path+" @ "+this.cost;
	}
}
public class Dijkstra_Algo {
	Map<Integer,Map<Integer,Integer>> graph=new HashMap<>();
	public Dijkstra_Algo(int v) {
		for(int i=1;i<= v;i++) {
			graph.put(i, new HashMap<>());
		}
	}
	public void addedge(int s,int d,int c) {
		graph.get(s).put(d, c);
		graph.get(d).put(s, c);
	}
	public void Dijkstra() {
		PriorityQueue<Dijkstra_pair> pq=new PriorityQueue<>(new Comparator<Dijkstra_pair>() {
			@Override
			public int compare(Dijkstra_pair o1,Dijkstra_pair o2) {
				return o1.cost-o2.cost;
			}
		});
		Set<Integer> visited=new HashSet<>();
		for(int src:graph.keySet()){
			if(visited.contains(src)){
				continue;
			}
			pq.add(new Dijkstra_pair(src, src+"", 0));
			while(!pq.isEmpty()) {
				// remove
				Dijkstra_pair rv=pq.poll();
				// ignore
				if(visited.contains(rv.vtx)) {
					continue;
				}
				// mark visited
				visited.add(rv.vtx);
				// self work
				System.out.println(rv);
				// add neigh
				for(int neigh:graph.get(rv.vtx).keySet()){
					if(!visited.contains(neigh)) {
						pq.add(new Dijkstra_pair(neigh, rv.path+neigh, rv.cost+graph.get(rv.vtx).get(neigh)));
					}
				}
			}
		}
	}
}
