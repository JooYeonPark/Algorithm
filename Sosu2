import java.util.Scanner;

/** 
 * 
 * 2581 : 소수
 * https://www.acmicpc.net/problem/2581
 * 
 * */

public class Sosu2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int start = scan.nextInt();
		int end = scan.nextInt();
		int sum = 0;
		int min = 100000000;
		int cnt = 0; //소수의 갯수
		
		for(int num=start; num<=end; num++) {
			if(dis(num) == true) { 
				sum += num;
				if(num < min) { min = num; }
				++cnt;
			}
		}
		
		if(cnt == 0) {
			System.out.println("-1");
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	
	public static boolean dis(int num) {
		if(num == 1) { return false; }
		
		for(int i=2; i<num; i++) {
			if(num%i == 0) { return false; }
		}
		
		return true;
	}
}
