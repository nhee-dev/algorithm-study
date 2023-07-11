package boj;
import java.io.*;
import java.util.*;

public class BOJ_11723_집합_S5 {
	enum op {add, remove, check, toggle, all, empty}
	static boolean[] arr;
	static StringBuilder sb;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N  = Integer.parseInt(br.readLine());		
		arr = new boolean[21];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			String op = st.nextToken();
			int x = 0;
			if(!op.equals("all") && !op.equals("empty"))
			x = Integer.parseInt(st.nextToken());
			switch(op) {
			case "add": add(x); break;
			case "remove": remove(x); break;
			case "check": check(x); break;
			case "toggle": toggle(x); break;
			case "all": all(); break;
			case "empty": empty(); break;
			}			
		}
		
		System.out.println(sb.toString());
	}
	
	static void add(int x){
		if(!arr[x]) {
			arr[x] = true;
		}
	}
	
	static void remove(int x) {
		if(arr[x]) {
			arr[x] = false;
		}
	}
	
	static void check(int x) {		
		result = arr[x] ? 1 : 0;
		sb.append(result+"\n");
	}
	
	static void toggle(int x) {
		if(arr[x]) {
			arr[x] = false;
		}else {
			arr[x] = true;
		}
	}
	
	static void all() {
		for(int i = 1; i < 21; i++) {
			arr[i] = true;
		}
	}
	
	static void empty() {
		arr = new boolean[21];
	}
	
	
}
