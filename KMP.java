import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 문제 1786
public class KMP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String text = br.readLine();
		char[] tArr = text.toCharArray();

		String pattern = br.readLine();
		char[] pArr = pattern.toCharArray();

		int[] pi = new int[pArr.length];

		init(pArr, pi);
		List<Integer> result = kmp(tArr,pArr,pi);
		
		System.out.println(result.size());
		for (Integer num : result) {
			System.out.println(num+1);
		}
	}
	
	
	//전처리 과정
	public static void init(char[] pArr, int[] pi) {
		int k = 0;
		for (int i = 1; i < pArr.length; i++) {
			while (k > 0 && pArr[i] != pArr[k]) {
				k = pi[k - 1];
			}
			if (pArr[i] == pArr[k]) {
				pi[i] = ++k;
			}
		}
	}
	
	//kmp 알고리즘 실행
	public static List<Integer> kmp(char[] tArr, char[] pArr, int[] pi) {
		List<Integer> result = new ArrayList<Integer>();
		int k=0;
		for(int i=0; i<tArr.length; i++) {
			while(k>0 && pArr[k]!=tArr[i]){
				k = pi[k-1];
			}
			
			if(tArr[i] == pArr[k]) {
				if(k==pArr.length-1) {
					result.add(i-k);
					k = 0;
				}
				else {
					++k;
				}
			}
		}
		
		return result;
	}

}
