import java.util.Scanner;

/** 
* 14563 : 완전수, 부족수, 과잉수 구하기 
* https://www.acmicpc.net/problem/14563
*/

public class Wanjeonsu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] array = new int[n];
		for(int i=0; i<array.length; i++) {
			array[i] = scan.nextInt();
		}
		
		for(int num : array) {
			System.out.println(dis(num));
		}
	}
	/**
	 * 
	 * 부족수(Deficient)
	 * 완전수(Perfect)
	 * 과잉수(Abundant)
	 * 
	 * */
	public static String dis(int num) {
		
    //주의 할 것! 문제에는 나오지 않았지만 1은 부족수
		 if (num == 1) return "Deficient";

		
		int[] list = new int[num/2];
		int listCnt = 0;
		
		for(int i=2; i<=num/2; i++) {
			if(num%i == 0) { 
				list[listCnt++] = i;
			}
		}
		
		int sum = 1;
		for (Integer listNum : list) {
			sum += listNum;
		}
		
		if(sum == num) return "Perfect";
		else if(sum > num) return "Abundant";
		else return "Deficient";
	}
}
