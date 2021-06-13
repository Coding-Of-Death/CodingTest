import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                s1 = s1.toLowerCase();
                s2 = s2.toLowerCase();
                
                String h1 = s1.split("[0-9]")[0];
                String h2 = s2.split("[0-9]")[0];
                
                s1 = s1.replace(h1, "");
                s2 = s2.replace(h2, "");
                
                int comparenum = h1.compareTo(h2);
                if(comparenum == 0){
                    String num1 = "";
                    
                    for(int i = 0; i < s1.length(); i++){
                        if(!(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') || i > 5)
                            break;
                        num1 += s1.charAt(i);
                    }
                    
                    String num2 = "";
                    
                    for(int i = 0; i < s2.length(); i++){
                        if(!(s2.charAt(i) >= '0' && s2.charAt(i) <= '9') || i > 5)
                            break;
                        num2 += s2.charAt(i);
                    }
                    
                    return Integer.parseInt(num1) - Integer.parseInt(num2);
                    
                } else{
                    return comparenum;
                }
            }
        });
        
        
        
        return files;
    }
}
