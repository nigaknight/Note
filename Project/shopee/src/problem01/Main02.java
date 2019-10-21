package problem01;

import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/14
 **/
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        boolean toUpperCase=false;
        StringBuilder sb=new StringBuilder();
        String[] temp=new String[s.length()];
        for (int i=0;i<s.length();i++) {
            if (Character.isLetter(s.charAt(i))) {
                if (sb.length()==0){
                    toUpperCase=false;
                }
                if (toUpperCase) {
                    temp[i] = new String(Character.toString(s.charAt(i))).toUpperCase();
                    sb.append(temp[i]);
                    toUpperCase = false;
                } else {
                    temp[i] = new String(Character.toString(s.charAt(i))).toLowerCase();
                    sb.append(temp[i]);
                    toUpperCase = false;
                }
            } else if (Character.isDigit(s.charAt(i))) {
                temp[i] = new String(Character.toString(s.charAt(i)));
                sb.append(temp[i]);
                toUpperCase = false;
            } else {
                toUpperCase = true;
            }
        }
        System.out.println(sb);
    }
}
