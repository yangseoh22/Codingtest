import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nlist = new int[n];
        
        for (int i=0;i<n;i++){
            nlist[i]=sc.nextInt();
        }
        int res = sc.nextInt();
        int x= 0;
        for (int i=0;i<n;i++){
            if(nlist[i]==res){
                x++;
            }
        }
        System.out.println(x);
    }
}