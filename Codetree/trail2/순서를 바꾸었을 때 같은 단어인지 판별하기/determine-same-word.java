import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        
        boolean result = solve(word1, word2);
        System.out.println(result? "Yes" : "No");
    }

    private static boolean solve(String word1, String word2) {
        
        if(word1.length() != word2.length()) return false;
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        Arrays.sort(w1);
        Arrays.sort(w2);
        
        for(int i=0; i<w1.length; i++) {
            if(w1[i] != w2[i]) {
                return false;
            }
        }
        
        return true;
    }

}
