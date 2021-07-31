class Solution {
    public long solution(int w, int h) {
        int big = 1, small = 1;
        
        if (w >= h) {
            big = w;
            small = h;
        } else {
            big = h;
            small = w;
        }
        
//         int trash = 0;
//         for (int i = 1; i <= small; i++) {
//             trash += (int)Math.ceil((double) big * i / small) 
//                         - (int)Math.floor((double) big * (i - 1) / small);
//         }
        
//         return (long)big * small - trash;
        
        int trash = (int)Math.ceil((double) big / small);
        
        return (long) (big - trash) * small;
    }
}
