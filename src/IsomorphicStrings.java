import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


public class IsomorphicStrings {
	
	public static void main(String[] args){
		System.out.println(isIsomorphic("egg","bee"));
	}

	public static Boolean isIsomorphic(String s , String t){
		
		HashMap<String, Integer> sMap = new HashMap<String, Integer>();
		HashMap<String, Integer> tMap = new HashMap<String, Integer>();
		
		for(int i=0;i<s.length();i++){
			if(sMap.get(s.substring(i, i))!=-1){
				Integer val = sMap.get(s.substring(i, i));
				sMap.put(s.substring(i, i), val+1);
			}else{
				sMap.put(s.substring(i, i), 1);
			}
		}
		
		for(int i=0;i<t.length();i++){
			if(tMap.get(s.substring(i, i))!=-1){
				Integer val = tMap.get(t.substring(i, i));
				tMap.put(t.substring(i, i), val+1);
			}else{
				tMap.put(t.substring(i, i), 1);
			}
		}
		
		
		ArrayList<Integer> sArray = (ArrayList<Integer>) sMap.values();
		ArrayList<Integer> tArray = (ArrayList<Integer>) tMap.values();
		
		Collections.sort(sArray);
		Collections.sort(tArray);
		if(sArray.size()!=tArray.size()){
			return false;
		}
		for(int i=0;i<sArray.size();i++){
			if(!sArray.get(i).equals(tArray.get(i))){
				return false;
			}
		}
		return true;
	}
}
