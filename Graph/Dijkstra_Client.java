package Graph;

import java.util.Scanner;

public class Dijkstra_Client {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		
		Dijkstra_Algo dAlgo=new Dijkstra_Algo(v);
//		dAlgo.addedge(1, 4, 1);
//		dAlgo.addedge(1, 2, 2);
//		dAlgo.addedge(2, 3, 2);
//		dAlgo.addedge(3, 4, 5);
//		dAlgo.addedge(4, 5, 8);
//		dAlgo.addedge(5, 6, 2);
//		dAlgo.addedge(5, 7, 3);
//		dAlgo.addedge(6, 7, 4);
		for(int i=0;i<e;i++) {
			int src=sc.nextInt();
			int des=sc.nextInt();
			int cost=sc.nextInt();
			dAlgo.addedge(src, des, cost);
		}
		dAlgo.Dijkstra();
	}

}
