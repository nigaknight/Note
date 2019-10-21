package problem01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/14
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if ((s.charAt(i)>='0'&&s.charAt(i)<='9')||(s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')){
                sb.append(s.charAt(i));
            } else if (!sb.toString().equals("")){
                String ss = sb.toString();
                list.add(ss);
                sb=new StringBuilder();
            }
            if (i==s.length()-1){
                String ss = sb.toString();
                list.add(ss);
            }
        }
        StringBuilder res=new StringBuilder();
        for (int i=0;i<list.size();i++){
            if (i==0){
                res.append(list.get(i).toLowerCase());
                continue;
            }
            String temp=list.get(i);
            if (temp.length()>0){
                String s1 = temp.substring(0, 1).toUpperCase();
                res.append(s1).append(temp.substring(1).toLowerCase());
            }
        }
        System.out.println(res.toString());
    }
}
