import java.util.LinkedList;

class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        if(cacheSize == 0)  answer = 5 * cities.length;
        
        else{
            for(int i = 0; i < cities.length; i++){
                String city = cities[i].toLowerCase();
                
                if(cache.remove(city)){
                    answer++;
                    
                } else{
                    if(cache.size() == cacheSize)
                        cache.removeLast();
        
                    answer += 5;
                }
                
                cache.addFirst(city);
            }
            
        }
        return answer;
    }
}
