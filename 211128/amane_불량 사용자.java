import java.util.*;
import java.util.regex.Pattern;

class Solution {
    static ArrayList<ArrayList<String>> ban = new ArrayList<>();
	static HashSet<HashSet<String>> sets = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        for(String s : banned_id) {
        	String tmp = s.replace('*', '.');
        	ArrayList<String> list = new ArrayList<>();
        	
        	for(String id : user_id) {
        		boolean flag = Pattern.matches(tmp, id);
        		
        		if(flag)	list.add(id);
        	}
        	
        	ban.add(list);
        }
        
        dfs(new HashSet<String>(), 0, ban.size());
       
        return sets.size();
    }
    
    static void dfs(HashSet<String> set, int depth, int size) {
    	if(depth == size) {
    		sets.add(new HashSet<>(set));
    		return;
    	}
    	
    	for(String id : ban.get(depth)) {
    		if(!set.contains(id)) {
    			set.add(id);
    			dfs(set, depth + 1, size);
    			set.remove(id);
    		}
    	}
    }
}
