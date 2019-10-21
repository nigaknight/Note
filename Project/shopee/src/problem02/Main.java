package problem02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/14
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        char[] chars = s.toCharArray();
        helper(chars);
    }
    public static void helper(char[] chars){
        int index=0;
        boolean is=false;
        for (int i=chars.length-2;i>=0;i--){
            if (chars[i]>chars[i+1]){
                swap(chars,i,i+1);
                index=i;
                is=true;
                break;
            }
        }
        if (!is){
            System.out.println(0);
            return;
        }
        if (index+1<chars.length){
            Arrays.sort(chars,index+1,chars.length-1);
            reverse(chars,index+1,chars.length-1);
        }
        String res=new String(chars);
        System.out.println(res);
    }
    public static void swap(char[] chars,int a,int b){
        char temp=chars[a];
        chars[a]=chars[b];
        chars[b]=temp;
    }
    public static void reverse(char[] chars,int a,int b){
        if(a<b){
            swap(chars,a,b);
            a++;
            b--;
        }
    }
}
