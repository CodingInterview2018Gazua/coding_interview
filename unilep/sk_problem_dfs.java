package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {


	private static int N;
	private static Set<List<Integer>> ans = new HashSet<>();
	private static List<Integer> list = new ArrayList<>();
	private static int listSize;
	private static int MAX = 100;
	private static boolean[] visit = new boolean[MAX*2+1];
	
	
	public static void dfs(int idx, int sum, List<Integer> currentList) {
		if(currentList.size() > N) return;
		if(sum == 0 && currentList.size() == N) {
			ans.add(new ArrayList<>(currentList));
			return;
		}
		
		for(int i=idx; i<listSize; i++) {
			int k = list.get(i);
			if(visit[k + MAX]) continue;
			currentList.add(k);
			visit[k + MAX] = true;
			dfs(i+1, sum + k, currentList);
			currentList.remove(currentList.size() - 1);
			visit[k + MAX] = false;
		}
		
	}
	
	public static void main(String[] args) {
		N = 4;
		for(int i=-N+1; i<N; i++) {
			list.add(i);
		}
		list.addAll(list);
		listSize = list.size();
		
		dfs(0, 0, new ArrayList<>());
		
		for(List<Integer> answer : ans) {
			System.out.println(answer);
		}
		
	}

}