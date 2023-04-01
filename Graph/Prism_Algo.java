package Graph;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
public class Prism_Algo {
	HashMap<Integer,HashMap<Integer,Integer>> map;
	 public Prism_Algo(int v)
	 {
		this.map=new HashMap<>();
		for(int i=1;i<=v;i++) {
			map.put(i, new HashMap<>());
		}
	}
	public void addedge(int v1,int v2,int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}
	
	public class pair{
		int vtx;
		int acqvtx;
		int cost;
		pair(int vtx,int acqvtx,int cost){
			this.vtx=vtx;
			this.acqvtx=acqvtx;
			this.cost=cost;
		}
		@Override
		public String toString() {
			return this.vtx+" via "+this.acqvtx+" @ "+this.cost;
		}
	}
	
	public void prims_Algorithm() {
		PriorityQueue<pair> pq=new PriorityQueue<>(new Comparator<pair>() {
			@Override
			public int compare(pair o1,pair o2) {
				return o1.cost-o2.cost;
			}
		});
		Set<Integer> visited=new HashSet<>();
		int c=0;
		for(int vtx:map.keySet()) {
			if(visited.contains(vtx)) {
				continue;
			}
			pq.add(new pair(vtx, vtx, 0));
			while(!pq.isEmpty())
			{
				// remove
				pair rvn=pq.poll();
				// ignore
				if(visited.contains(rvn.vtx)) {
					continue;
				}
				// mark visited
				visited.add(rvn.vtx);
				// selfwork
				c+=rvn.cost;
				System.out.println(rvn);
				// add neighbour
				for(int neigh:map.get(rvn.vtx).keySet()) {
					if(!visited.contains(neigh)){
						pq.add(new pair(neigh, rvn.vtx, map.get(rvn.vtx).get(neigh)));
					}
				}
			}
		}
		// mininmum cost
		System.out.println(c);
	}
	public static void main(String[] args) {
		Prism_Algo p= new Prism_Algo(7);
		p.addedge(1, 4, 60);
		p.addedge(1, 2, 20);
		p.addedge(2, 3, 30);
		p.addedge(3, 4, 10);
		p.addedge(4, 5, 80);
		p.addedge(5, 6, 50);
		p.addedge(6, 7, 40);
		p.addedge(5, 7, 70);
		p.prims_Algorithm();
	}
}
