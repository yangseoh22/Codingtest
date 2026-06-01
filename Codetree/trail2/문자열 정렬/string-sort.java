import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for(int i=0; i<chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}