package Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


public class Prism {
	public class PrismPair{
		int vtx;
		int acqv;
		int cost;
		public PrismPair(int vtx,int acqv,int cost){
			this.vtx=vtx;
			this.acqv=acqv;
			this.cost=cost;
		}
		@Override
		public String toString() {
			return this.vtx+" "+this.acqv+" "+this.cost;
		}
		
	}
	HashMap<Integer,HashMap<Integer,Integer>> map;
	 public Prism(int v)
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
	public void prismAlgo() {
		PriorityQueue<PrismPair> pq=new PriorityQueue<>(new Comparator<PrismPair>() {

			@Override
			public int compare(PrismPair o1, PrismPair o2) {
				// TODO Auto-generated method stub
				return o1.cost-o2.cost;
			}
		});
		Set<Integer> visited=new HashSet<>();
		pq.add(new PrismPair(1, 1, 0));
		int minc=0;
		while(!pq.isEmpty()) {
			PrismPair rv=pq.poll();
			if(visited.contains(rv.vtx)) {
				continue;
			}
			visited.add(rv.vtx);
			minc+=rv.cost;
			System.out.println(rv);
			for(int neigh:map.get(rv.vtx).keySet()) {
				if(!visited.contains(neigh)) {
					pq.add(new PrismPair(neigh,rv.vtx,map.get(rv.vtx).get(neigh)));
				}
			}
		}
		System.out.println(minc);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Prism p=new Prism(n);
		int m=sc.nextInt();
		for(int i=0;i<m;i++){
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int cost=sc.nextInt();
			p.addedge(v1, v2, cost);
		}
		p.prismAlgo();
	}
}
