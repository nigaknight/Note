package huawei.problem02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/11
 * I am an 20-years out--standing  @ * -stu- dent
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        ArrayList<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if ((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                sb.append(c);
                if (i==s.length()-1){
                    list.add(sb.toString());
                    break;
                }
            } else if (i>0&&i<s.length()-1&&c=='-'){
                char c1=s.charAt(i-1);
                char c2=s.charAt(i+1);
                if (((c1>='0'&&c1<='9')||(c1>='a'&&c1<='z')||(c1>='A'&&c1<='Z'))
                        &&((c2>='0'&&c2<='9')||(c2>='a'&&c2<='z')||(c2>='A'&&c2<='Z'))){
                    sb.append(c);
                } else {
                    list.add(sb.toString());
                    sb=new StringBuilder();
                }
            } else if(!sb.toString().equals("")){
                list.add(sb.toString());
                sb=new StringBuilder();
            }
        }
        for (int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i));
            if (i!=0){
                System.out.print(" ");
            }
        }
    }
}
