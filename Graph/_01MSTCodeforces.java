package Graph;

import java.util.*;

public class _01MSTCodeforces {
	static TreeSet[] arr;
	static TreeSet<Integer> visited;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		visited=new TreeSet<>();
		int n=sc.nextInt();
		int m=sc.nextInt();
		arr=new TreeSet[n];
		for(int i=0;i<n;i++) {
			arr[i]=new TreeSet<>();
		}
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr[a-1].add(b-1);
			arr[b-1].add(a-1);
		}
		for(int i=0;i<n;i++) {
			visited.add(i);
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			if(visited.remove(i)) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans-1);
	}
	private static void dfs(int i){
		HashSet<Integer> ss=new HashSet<>();
		for(int ele:visited) {
			if(!arr[i].contains(ele)){
				ss.add(ele);
			}
		}
		for(int ele:ss) {
			visited.remove(ele);
		}
		for(int ele:ss) {
			dfs(ele);
		}
	}
}
