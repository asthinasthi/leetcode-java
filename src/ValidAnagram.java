

public class ValidAnagram {
	static String t  = "";
	static String s = "";
	
public static void main(String[] args) {
	System.out.println(isAnagram(s, t));
}

public static boolean isAnagram(String s, String t) {
	if(s.isEmpty() && t.isEmpty())
		return true;
	int[] store1 = new int['z' +1];
	int[] store2 = new int['z' + 1];
    generateMap(store1, s);
    generateMap(store2, t);
    for(int c: store1){
    	if((store1[c]!= store2[c]) == true) //Not an anagram
    		return false;
    }
  return true;

}

public static void generateMap(int[] store , String s){
    for(char c : s.toCharArray()){
    	store[c]++;
    }
}

}