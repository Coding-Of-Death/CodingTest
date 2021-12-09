import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int heightDiff = y - x;
        if (heightDiff <= 2) {
            System.out.println(heightDiff);
            
        } else {
            int n = 0;
            while ((long)n*n < heightDiff) {
                ++n;
            }
            
            if (heightDiff > n*n-n) {
                System.out.println(2*n-1);
            } else {
                System.out.println(2*n-2);
            }
        }
    }
}
