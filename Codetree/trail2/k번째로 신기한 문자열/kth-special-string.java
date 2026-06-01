import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        String T = sc.next();
        List<String> arr = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            String str = sc.next();
            
            if(str.startsWith(T)) {  // T가 포함되어 있다면
                arr.add(str);
            }
        }
        
        Collections.sort(arr);
        System.out.println(arr.get(K-1));
    }

}
