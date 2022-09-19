package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String data = br.readLine(); //식
		double[] num = new double[N];
		for(int i=0;i<N;i++) {
			num[i]=Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		double result = 0;
		for(int i=0;i<data.length();i++) {
			if('A'<=data.charAt(i)&&data.charAt(i)<='Z') { //문자이면
				stack.push(num[data.charAt(i)-'A']);
			}
			else {
				if(!stack.isEmpty()) {
					double num2 = stack.pop();
					double num1 = stack.pop();
					
					switch(data.charAt(i)) {
					case '+':
						result = num1+num2;
						stack.push(result);
						continue;
					case '-':
						result = num1-num2;
						stack.push(result);
						continue;
					case '*':
						result = num1*num2;
						stack.push(result);
						continue;
					case'/':
						result = num1/num2;
						stack.push(result);
						continue;
					}
				}
			}
		}
		
		System.out.printf("%.2f",stack.pop());
		
		br.close();
	}

}
