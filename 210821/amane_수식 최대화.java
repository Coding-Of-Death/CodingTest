import java.util.*;

class Solution {
    public long solution(String expression) {
        long max = 0;
        String[][] exp = {{"\\+", "-", "\\*"}, {"\\+", "\\*", "-"},
                          {"-", "\\+", "\\*"}, {"-", "\\*", "\\+"},
                          {"\\*", "\\+", "-"}, {"\\*", "-", "\\+"}};
        
        for(int i = 0; i < exp.length; i++){
            String[] express1 = expression.split(exp[i][0]);
            long answer1 = 0;
            
            //////////////////////////////////////////////////////
            
            for(int j = 0; j < express1.length; j++){
                String[] express2 = express1[j].split(exp[i][1]);
                long answer = 0;
                /****************************************/
                
                for(int k = 0; k < express2.length; k++){
                    
                    String[] express3 = express2[k].split(exp[i][2]);
                    long tmp = Long.parseLong(express3[0]);
                    
                    for(int l = 1; l < express3.length; l++){ 
                        if(exp[i][2] == "\\*"){
                            tmp *= Long.parseLong(express3[l]);
                        } else if (exp[i][2] == "\\+")
                            tmp += Long.parseLong(express3[l]);
                        else
                            tmp -= Long.parseLong(express3[l]);
                        
                        //System.out.println("i: " + i + " exp: " + exp[i][2] + " tmp: " + tmp);
                    }
                    
                    if(k == 0)
                        answer = tmp;
                    else{
                        if(exp[i][1] == "\\*")
                            answer *= tmp;
                        else if (exp[i][1] == "\\+")
                            answer += tmp;
                        else
                            answer -= tmp;
                    }
                    //System.out.println("i: " + i + " exp1: " + exp[i][1] + " answer: " + answer);
                    //System.out.println(answer);
                    /****************************************/
                    
                }
                if(j == 0)
                    answer1 = answer;
                else{
                    if(exp[i][0] == "\\*")
                            answer1 *= answer;
                        else if (exp[i][0] == "\\+")
                            answer1 += answer;
                        else
                            answer1 -= answer;
                }
                //System.out.println("i: " + i + " exp2: " + exp[i][0] + " answer1: " + answer1);
            }
            //System.out.println(answer1);
            
            max = Math.max(max, Math.abs(answer1));
        }
        return max;
    }
}
