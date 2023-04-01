package Graph;
import java.util.ArrayList;
import java.util.HashMap;
public class BellMan_fordAlgorithm{
	HashMap<Integer,HashMap<Integer,Integer>> map;
	public BellMan_fordAlgorithm(int v){
		map=new HashMap<>();
		for(int i=1;i<=v;i++){
			map.put(i, new HashMap<>());
		}
	}
	public void addedge(int v1,int v2,int cost){
		map.get(v1).put(v2, cost);
	}
	public class PairEdge{
		int v1;
		int v2;
		int cost;
		public PairEdge(int v1,int v2,int cost) {
			this.v1=v1;
			this.v2=v2;
			this.cost=cost;
		}
	}
	public void Bellmanford(){
		ArrayList<PairEdge> aList=new ArrayList<>();
		for(int key:map.keySet()){
			for(int neigh:map.get(key).keySet()) {
				aList.add(new PairEdge(key, neigh, map.get(key).get(neigh)));
			}
		}
		// distance wrt cost 
		int[] dsc=new int[map.size()+1];
		for(int i=2;i<dsc.length;i++) {
			dsc[i]=1000000;// add karna ka baad overflow na ho jaya isliya integer.MAX_VALUE nahi la raha haya.
		}
		// relax v-1 times
		int f=0;
		for(int i=1;i<=map.size();i++) {
		for(PairEdge p:aList){
			int v1=p.v1;
			int v2=p.v2;
			int oldcost=dsc[v2];
			int newcost=p.cost+dsc[v1];
			if(i==map.size() && oldcost>newcost) {
				System.out.println("neigative wt cycle prsent in graph");
				f=1;
				break;
			}
			if(oldcost>newcost){
				dsc[v2]=newcost;
			}
		}
		}

		if(f==0) {
		for(int i=1;i<dsc.length;i++) {
			System.out.print(dsc[i]+" ");
		}
		}
	}
	public static void main(String[] args) {
//		BellMan_fordAlgorithm  bf=new BellMan_fordAlgorithm(5);
//		bf.addedge(1, 2, 8);
//		bf.addedge(1, 4, 5);
//		bf.addedge(1, 3, 4);
//		bf.addedge(2, 5, 2);
//		bf.addedge(5, 2, 1);
//		bf.addedge(4, 5, 4);
//		bf.addedge(3, 4, -3);
//		bf.Bellmanford();
		
		// for checking -ve weight cycle
		BellMan_fordAlgorithm  bf=new BellMan_fordAlgorithm(4);
		bf.addedge(1, 2, 1);
		bf.addedge(2, 3, 3);
		bf.addedge(3, 4, 2);
		bf.addedge(4, 2, -6);
		bf.Bellmanford();
	}
}
