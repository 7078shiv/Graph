package Graph;

import java.util.*;
public class SnakeAndLadder{
	static class Pair{
		int vtx;
		int cost; 
		public Pair(int v,int c){
			vtx=v;
			cost=c;
		}
	}
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int l=sc.nextInt();
			int s=sc.nextInt();
			Map<Integer,Integer> ladder=new HashMap<>();
			while(l-->0){
				int x=sc.nextInt();
				int y=sc.nextInt();
				ladder.put(x,y);
			}
			Map<Integer,Integer> snake=new HashMap<>();
			while(s-->0){
				int x=sc.nextInt();
				int y=sc.nextInt();
				snake.put(x,y);
			}
			HashMap<Integer,List<Integer>> hm=new HashMap<>();
			for(int i=1;i<=n;i++) {
				hm.put(i, new ArrayList<>());
			}
			for(int i=1;i<=n;i++) {
				if(ladder.containsKey(i)) {
					hm.get(i).add(ladder.get(i));
				}
				else if(snake.containsKey(i)){
					hm.get(i).add(snake.get(i));
				}
				else {
					for(int j=1;j<=6;j++) {
						hm.get(i).add(i+j);
					}
				}
			}
			System.out.println(BFS(hm, n));
		}
		
    }
    public static  int BFS(HashMap<Integer,List<Integer>> hm,int n) {
    	Queue<Pair> qq=new LinkedList<>();
    	HashSet<Integer> visited=new HashSet<>();
    	qq.add(new Pair(1, 0));
    	//int c=0;
    	while(!qq.isEmpty()){
    		Pair rv=qq.poll();
    		if(visited.contains(rv.vtx)){
    			continue;
    		}
    		visited.add(rv.vtx);
    		if(rv.vtx==n) {
    			return rv.cost-1;
    		}
    		for(int neigh:hm.get(rv.vtx)) {
    			if(!visited.contains(neigh)) {
    				qq.add(new Pair(neigh, rv.cost+1));
    			}
    		}
    	}
    	return -1;
    }
}
