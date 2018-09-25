/** 
* 2749 : 피보나치+피사노 https://www.acmicpc.net/problem/2749
* 참고 사이트 : http://nackwon.tistory.com/52
*              http://hellogohn.com/post_one341          
*/

import java.util.Scanner;

public class PisanoPeriod {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long m = scan.nextLong();
		long mod = 1000000;
		
    /*
     1번 참고사이트를 보고 변형함. 피사노 주기를 살펴보면 mod가 2일 때 아래와 같다 
      n       0  1  2  3  4  5  6  7  8
      ---------------------------------
      f(n)    0  1  1  2  3  5  8  13 21
      f(n)%2  0  1  1  0  1  1  0  1  1    
      만일 n=8인 수를 구한다고 하면 8까지 피보나치를 구한 뒤 mod로 나눌 필요 없이
      mod가 2일 때, 
      1) period를 구하고(이 때, p=3)
      2) 그 period만큼의 list를 구해놓은 뒤 (0,1,1)
      1,2번은 전처리 과정
      
      3) 원하는 수(8)을 period로 나눈 뒤(8%3=2) 그 값에 해당하는 list값이 정답(list[2] = 1)
          => 따라서 정답은 1
    */
		
		//전처리과정 - 1,2번
		int period = getPeriod(mod);
		long list[] = new long[period];
		
		list[0] = 0;
		list[1] = 1;
		
		for(int i=2; i<period; i++) {
			list[i] = (list[i-2] + list[i-1])%mod;
		}
		
		// 3번
		int q = (int)(m%period);
		System.out.println(list[q]);
		
	}
	
  //Period 계산
	public static int getPeriod(long m) {
		int period = 0;
		
		long number1 = 1;
		long number2 = 1;
		
		do {
			long tmp = number1;
			number1 = number2;
			number2 = (tmp+number1)%m;
			
			period++;
		}while(!(number1==1 && number2==1));
		
		return period;
	}
	
}
