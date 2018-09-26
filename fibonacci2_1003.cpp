/* 
  1003 : 재귀+피보나치 https://www.acmicpc.net/problem/1003
*/


#include <stdio.h>
#include <time.h>

static int DP[41]; 

int fibonacci(int n) {
	if(n==0){
		return 0;
	}else if(n==1 || n<0){
		return 1;
	}
	
	if(DP[n]!=0){
		return DP[n];
	}
	else {
        return DP[n] = fibonacci(n-1) + fibonacci(n-2);
    }

		
}

	
int main() {	
	int cnt = 0;
	scanf("%d", &cnt);
	
	//list 입력
	int list[cnt];
	for(int i=0; i<cnt; i++) {
		scanf("%d", &list[i]);
	}
	
  /*
  n  f(n)  0  1
  --------------
  0   0    1  0
  1   1    0  1
  2   1    1  1
  3   2    1  2
  4   3    2  3
  5   5    3  5
  */
  
	for(int i=0; i<cnt; i++) {
		printf( "%d %d\n", fibonacci(list[i]-1), fibonacci(list[i]) );
	}
	
	return 0;
}
