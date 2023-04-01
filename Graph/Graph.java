package Graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import HashMap.Mapped_String;
// undirected
public class Graph {
	HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
	public Graph(int v) {
		for(int i=1;i<=v;i++) {
			map.put(i, new HashMap<>());
		}
	}
	public void addEdge(int src,int des,int cost) {
		map.get(src).put(des,cost);
		map.get(des).put(src,cost);
	}
	public boolean containsEdge(int v1,int v2){
		return map.get(v1).containsKey(v2);
	}
	
	public boolean containsvertex(int v1){
		return map.containsKey(v1);
	}
	
	public int noofEdges() {
		int sum=0;
		for(int key:map.keySet()) {
			sum+=map.get(key).size();
		}
		return sum;
	}
	
	public void removeEdge(int v1,int v2) {
		if(containsEdge(v1, v2)) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
		}
	}
	public void removevertex(int v) {
		for(int key:map.get(v).keySet()){
			map.get(key).remove(v);
		}
		map.remove(v);
	}
	public void display() {
		for(int key:map.keySet()){
			System.out.println(key+" "+map.get(key));
		}
	}
	public boolean haspath(int v1,int v2) {
		Set<Integer> set=new HashSet<>();
		return haspath(v1, v2,set);
	}
	public boolean haspath(int v1,int v2,Set<Integer> visited) {
		if(v1==v2) {
			return true;
		}
		visited.add(v1);// to remove cycle
		for(int neigh:map.get(v1).keySet()) {
			if(!visited.contains(neigh)) {
				boolean ans=haspath(neigh, v2,visited);
				if(ans) {
					return ans;
				}
			}
		}
		visited.remove(v1);
		return false;
	}
	public void printpath(int src,int des) {
		Set<Integer> visited =new HashSet<>();
		printpath(src, des,"",visited);
	}
	public void printpath(int src,int des,String ans,Set<Integer> visited) {
		if(src==des) {
			System.out.println(ans+des);
			return;
		}
		visited.add(src);
		for(int neigh:map.get(src).keySet()) {
			if(!visited.contains(neigh)) {
				printpath(neigh, des,ans+src,visited);
			}
		}
		visited.remove(src);
	}
	// BFS
	public  void BFS(int src){
		Set<Integer> visited=new HashSet<>();
		Queue<Integer> qq=new LinkedList<>();
		qq.add(src);
		while(!qq.isEmpty()) {
			int s=qq.poll();
		if(visited.contains(s)) {
			continue;
		}
		visited.add(s);
		System.out.print(s+" ");
		for(int neigh:map.get(s).keySet()){
			if(!visited.contains(neigh)) {
				qq.add(neigh);
			}
		}
		}
	}
	public void DFS(int src) {
		HashSet<Integer> visited=new HashSet<>();
		Stack<Integer> ss=new Stack<>();
		ss.add(src);
		while(!ss.isEmpty()) {
			// remove
			int s=ss.pop();
			// ignore
			if(visited.contains(s)) {
				continue;
			}
			//visited
			visited.add(s);
			//self work
			System.out.print(s+" ");
			// add neighbor
			for(int neigh:map.get(s).keySet()) {
				if(!visited.contains(neigh)) {
					ss.push(neigh);
				}
			}
		}
	}
	public void BFT() {
		HashSet<Integer> visited=new HashSet<>(); 
		Queue<Integer> qq=new LinkedList<>();
		for(int src:map.keySet()) {
		if(visited.contains(src)) {
			continue;
		}
		qq.add(src);
		while(!qq.isEmpty()) {
			int s=qq.poll();
		if(visited.contains(s)) {
			continue;
		}
		visited.add(s);
		System.out.print(s+" ");
		for(int neigh:map.get(s).keySet()){
			if(!visited.contains(neigh)) {
				qq.add(neigh);
			}
		}
		}
	}
}
	public void DFT() {
		HashSet<Integer> visited=new HashSet<>();
		Stack<Integer> ss=new Stack<>();
		for(int src:map.keySet()) {
			if(visited.contains(src)) {
				continue;
			}
		ss.add(src);
		while(!ss.isEmpty()) {
			// remove
			int s=ss.pop();
			// ignore
			if(visited.contains(s)) {
				continue;
			}
			//visited
			visited.add(s);
			//self work
			System.out.print(s+" ");
			// add neighbor
			for(int neigh:map.get(s).keySet()) {
				if(!visited.contains(neigh)) {
					ss.push(neigh);
				}
			}
		}
	}
}
	public  boolean iscycle() {
		HashSet<Integer> visited=new HashSet<>(); 
		Queue<Integer> qq=new LinkedList<>();
		for(int src:map.keySet()) {
		if(visited.contains(src)) {
			continue;
		}
		qq.add(src);
		while(!qq.isEmpty()) {
			int s=qq.poll();
		if(visited.contains(s)) {
			//continue;
			return false;
		}
		visited.add(s);
		//System.out.print(s+" ");
		for(int neigh:map.get(s).keySet()){
			if(!visited.contains(neigh)) {
				qq.add(neigh);
			}
		}
		}
	}
		return true;
	}
}

