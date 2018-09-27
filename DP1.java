import java.util.Scanner;

/*
 * 1149 : https://www.acmicpc.net/problem/1149
 * 참고 사이트 : https://m.blog.naver.com/occidere/220785383050
 */

public class DP1 {
	public static void main(String[] args) {
		
		//입력
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] scanRGB = new int[n+1][3];
		for(int i=1; i<=n; i++) {
			for(int j=0; j<3; j++) {
				scanRGB[i][j] = scan.nextInt();
			}
		}
		
		int[][] DP = new int[n+1][3];
		for(int i=1; i<=n; i++) {
			DP[i][0] = min(DP[i-1][1],DP[i-1][2]) + scanRGB[i][0];  
			DP[i][1] = min(DP[i-1][0],DP[i-1][2]) + scanRGB[i][1];  
			DP[i][2] = min(DP[i-1][0],DP[i-1][1]) + scanRGB[i][2];  
		}
		
		int result = min(min(DP[n][0], DP[n][1]), DP[n][2]);
		System.out.println(result);
	}
	
	public static int min(int num1, int num2) { return num1 < num2 ? num1 : num2; } 
}
