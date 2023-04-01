//package Graph;
import java.util.*;
public class _01MSTOptimised {
	// asa component banaoga jissa zero connected
	static TreeSet<Integer>[] arr;
	static TreeSet<Integer> set;
	public static void main(String[] args) {
		int ans=0;
		set=new TreeSet<>();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		arr=new TreeSet[n];
		for(int i=0;i<n;i++) {
			arr[i]=new TreeSet<>();  
		}
		for(int i=0;i<m;i++){
			int a=sc.nextInt()-1;
			int b=sc.nextInt()-1;
			arr[a].add(b);
			arr[b].add(a);
		}
//		for(TreeSet<Integer> a:arr) {
//			//System.out.println(a);
//		}
		for(int i=0;i<n;i++){
			set.add(i);
		}
		for(int i=0;i<n;i++){
			if(set.remove(i)){
				ans++;
				dfs(i);
			}
		}
		System.out.println(ans-1);
	}
	private static void dfs(int x) {
		List<Integer> ll=new ArrayList<>();
		for(int i:set) {
			if(!arr[x].contains(i)) {
				ll.add(i);
			}
		}
		for(int i:ll) {
			set.remove(i);
		}
		for(int i:ll) {
			dfs(i);
		}
		//System.out.println(ans);
	}
	
	
}
