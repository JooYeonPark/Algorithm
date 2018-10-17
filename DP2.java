import java.util.Scanner;

/*
 * 1932번
 */
public class Triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		
		int list[][] = new int[row+2][row+2];
		int DP[][] = new int[row+2][row+2];
		
		for(int i=1; i<=row; i++) {
			for(int j=1; j<i+1; j++) {
				list[i][j] = scan.nextInt();
			}
		}
		
		//DP 구하기
		for(int i=1; i<=row; i++) {
			for(int j=1; j<i+1; j++) {
				DP[i][j] = max(DP[i-1][j-1], DP[i-1][j]) + list[i][j]; 
			}
		}
		
		//결과
		int max = 0;
		for(int i=1; i<=row; i++) {
			int tmpMax = max(DP[row][i-1], DP[row][i]);
			if(max < tmpMax) { max = tmpMax; }
		}
		
		System.out.println(max);
		
		
	}
	public static int max(int a, int b) { return a>b ? a : b;}
}
