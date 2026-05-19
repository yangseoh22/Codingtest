import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String text = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String pattern = st.nextToken();

        int result = -1;
        for(int i=0; i<text.length()-pattern.length()+1; i++) {
            String subStr = text.substring(i, i+pattern.length());
            if(subStr.equals(pattern)) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
    }

}
