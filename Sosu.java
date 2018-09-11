import java.util.Scanner;

/** 
* 1978번 : 소수 구하기 
* https://www.acmicpc.net/problem/1978
*/

public class Sosu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] array = new int[n];

		int result = 0; // 결과 값

		for (int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
		}

		for (int num : array) {
			if (dis(num) == true) {
				++result;
			}
		}

		System.out.println(result);
	}

	public static boolean dis(int num) {
		int j = 0;

		//1 제외
		if (num == 1) {
			return false;
		}
		
		for (j = 2; j < num; j++) {
			if (num % j == 0) {
				return false;
			}
		}

		return true;
	}
}
