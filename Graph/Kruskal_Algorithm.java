package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



public class Kruskal_Algorithm {
	HashMap<Integer,HashMap<Integer,Integer>> map;
	public Kruskal_Algorithm(int v) {
		this.map=new HashMap<>();
		for(int i=1;i<=v;i++) {
			map.put(i, new HashMap<>());
		}
	}
	public void addedge(int v1,int v2,int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}
	public class EdgePair{
		int src;
		int des;
		int cost;
		public EdgePair(int src,int des,int cost) {
			this.src=src;
			this.des=des;
			this.cost=cost;
		}
		@Override
		public String toString() {
			return this.src+" - "+this.des+" @ "+this.cost;
		}
	}
	// all pairs store in arrayList
	public ArrayList<EdgePair> getAllEdgePairs(){
		ArrayList<EdgePair> aList=new ArrayList<>();
		for(int key:map.keySet()) {
			for(int neigh:map.get(key).keySet()) {
				EdgePair ePair=new EdgePair(key, neigh, map.get(key).get(neigh));
				aList.add(ePair);
			}
		}
		
		return aList;
	}
	public void kruskalAlgorithm() {
		// 1) jitna vertex utna set banada
		int mincost=0;
		Disjoint_Set_Union ds=new Disjoint_Set_Union();
		for(int k:map.keySet()) {
		ds.createset(k);
		}
		ArrayList<EdgePair> ll=getAllEdgePairs();
		// sort al on the basis of cost
				Collections.sort(ll,new Comparator<EdgePair>() {
					@Override
					public int compare(EdgePair o1,EdgePair o2) {
						return o1.cost-o2.cost;
					}
		});
		for(EdgePair ep:ll){
			int e1=ep.src;
			int e2=ep.des;
			int re1=ds.find(e1);
			int re2=ds.find(e2);
			if(re1==re2) {
				// nothing
			}
			else {
				System.out.println(ep);
				mincost+=ep.cost;
				ds.union(re1,re2);
			}
		}
		System.out.println("min cost is:-");
		System.out.println(mincost);
	}
	public static void main(String[] args) {
		Kruskal_Algorithm ks =new Kruskal_Algorithm(7);
		ks.addedge(1, 4, 2);
		ks.addedge(1, 2, 1);
		ks.addedge(2, 3, 5);
		ks.addedge(3, 4, 6);
		ks.addedge(4, 5, 8);
		ks.addedge(5, 6, 7);
		ks.addedge(6, 7, 4);
		ks.addedge(5, 7, 3);
		ks.kruskalAlgorithm();
	}
}
