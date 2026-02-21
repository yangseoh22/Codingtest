import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] str = input.toCharArray();
        
        boolean flag = false;
        int idx = str.length-1;
        for(int i=0; i<str.length; i++) {
        	if(str[i]!=str[idx--]) break;
        	
        	if(i==str.length-1) flag = true;
        }
        
        System.out.println(flag? "Yes" : "No");
        
    }
}