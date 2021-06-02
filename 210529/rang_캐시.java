// 1. cashSize = 0 인 경우
// 2. cashSize에 존재하는 city가 다시 불려나온 경우 위치를 최신으로 갱신

import java.util.*;


class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        int time = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city : cities) {
            if (cache.contains(city.toLowerCase())) {
                cache.remove(city.toLowerCase());   // 최근으로 위치갱신
                time++;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
                time += 5;
            }
            cache.offer(city.toLowerCase());
        }
        
        return time;
    }
}
