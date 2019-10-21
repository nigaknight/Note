import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/23
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String substring = s.substring(0, s.length() - 25);
        int index=0;
        int index2=0;
        for (int i=0;i<substring.length();i++){
            char c=substring.charAt(i);
            if (c>='a'&&c<='z'||c>='A'&&c<='Z'){
                if (index==0){
                    index=i;
                }
                index2=i;
            }
        }
        String res = substring.substring(index, index2 + 1);
        System.out.println(res);
    }
}
