import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list;
    static ArrayList<Integer> pSet;
    static String[][] table;
    static boolean[] check;
   
    public int solution(String[][] relation) {
        int answer = 0;
        table = relation;
        check = new boolean[relation[0].length];
        
        list = new ArrayList<>();
        
        for(int i = 1; i <= relation[0].length; i++){
            dfs(0, i);
        }
        
        answer = list.size();
        
        
        return answer;
    }
    
    static void dfs(int depth, int target){
        if(depth == target){
            // 후보키 선정
            pSet = new ArrayList<Integer>();
            
            for(int i = 0; i < check.length; i++){
                if(check[i])
                    pSet.add(i);
            }
            
            //System.out.println(key);
            // --> 유일성, 최소성 판별
            
            boolean flag = false;
            if(checkUnique(pSet)){
                flag = true;
            }
            
            if(flag){
            	boolean isTrue = true;
            	
            	for(int i = 0; i < list.size(); i++) {
            		if(pSet.containsAll(list.get(i))) {
            			isTrue = false;
            			//System.out.println(list.get(i) + " " + key);
            			break;
            		}
            	}
            	
            	if(isTrue) {
            		list.add(pSet);
                    System.out.println(pSet);
            	}
                	
            }
            
            return;
        }
        
        for(int i = 0; i < check.length; i++){
            if(!check[i]){
                check[i] = true;
                dfs(depth + 1, target);
                check[i] = false;
            }
        }
    }
    
    static boolean checkUnique(ArrayList<Integer> list){
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < table.length; i++){
            String tmp = "";
            for(int j = 0; j < list.size(); j++){
                tmp += table[i][list.get(j)];
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            //System.out.println("tmp: " + tmp + "\t value: " + map.get(tmp));
        }
        
        for(String s : map.keySet()){
            if(map.get(s) > 1){
                return false;
            }
                
        }
        return true;
    }
}
