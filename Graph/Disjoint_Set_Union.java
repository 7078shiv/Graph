package Graph;

import java.util.HashMap;
import java.util.Map;

import Graph.Kruskal_Algorithm.EdgePair;
// it is a data structure
public class Disjoint_Set_Union{
	public class Node{
		int val;
		int rank;
		Node parent;
		Node(){
		}
		Node(int val,int rank){
			this.val=val;
			this.rank=rank;
		
		}
	}
	Map<Integer,Node> map=new HashMap<>();
	public void createset(int v ){
		Node nn=new Node(v,0);
		nn.parent=nn;
		map.put(v, nn);
	}
	// find method to find which set it belongs
	// representative element ka val return karaga
	public int find(int v){
		// v ka corresponding which node ya magayga
		Node nn=map.get(v);
		Node nn1=find(nn);
		return nn1.val;
	}
	// representative element ka address return karaga
	private Node find(Node nn) {
		if(nn.parent==nn){
			return nn;
		}
// path compression
// add edge directly 
// jo bhi represen ele hay usko kahi yaad kar lo
		Node pp= find(nn.parent);
		nn.parent=pp;
		return pp;
	}
	public void union(int v1,int v2){
		Node n1=map.get(v1);
		Node n2=map.get(v2);
		Node rn1=find(n1);
		Node rn2=find(n2);
		if(rn1.rank==rn2.rank){
			rn1.parent=rn2;
			rn2.rank=rn2.rank+1;
		}
		else if(rn1.rank>rn2.rank) {
			rn2.parent=rn1;
		}
		else {
			rn1.parent=rn2;
		}
	}
}
