
public class KMP {
	
	public static void main(String[] args) {
		String pattern = "AAACAAAAAC";
		int[] lps = computeLPS(pattern);
		for(int i=0; i < lps.length;i++)
			System.out.println(lps[i]);
	}

	static void findPattern(String pat, String actualString){
		char[] patArray = pat.toCharArray();
		char[] actualArray = actualString.toCharArray();
		int patLength = pat.length();
		int actualStrLength = actualString.length();
		int patIdx = 0;
		int actualIdx = 0;
		int[] lps = computeLPS(pat);
		while(actualIdx < actualStrLength){
			if(patIdx == patLength)
			if(patArray[patIdx] == actualArray[actualIdx]){
				actualIdx++;
				patIdx++;
			} else {
				patIdx = lps[patIdx-1]; 
			}
		}
	}
	
	static int[] computeLPS(String pattern){
		char[] patternsArray = pattern.toCharArray();
		int[] lps = new int[patternsArray.length];
		
		int i = 0;
		int j = 1;
		int lpsMaxSoFar = 0;
		while(j<patternsArray.length){
			if(patternsArray[i] == patternsArray[j]){
				lps[j] = ++lpsMaxSoFar;
				i++;
				j++;
			} else {
				if(i!=0){
					--i;
					--lpsMaxSoFar;
				} else {
					lps[j] = 0;
					j++;
					i=0;
				}
			}
		}
		
		return lps;
		
	}
}
