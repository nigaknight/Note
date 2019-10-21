package YY;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author nigaknight
 * @time 2019/9/9
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (char i : set){
            if (set.size() == 1 && i == '0'){
                stringBuilder.append(i);
                break;
            }
            if (count == 0 && i == '0'){
                continue;
            }
            stringBuilder.append(i);
            count++;
        }
        System.out.println(stringBuilder.toString());
    }
}
