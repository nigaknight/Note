package leetcode214;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Solution {
    public static void main(String[] args) {
        String aacecaaa = new Solution().shortestPalindrome("aba");
        System.out.println(aacecaaa);
    }
    public String shortestPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s);
        String revString = sb.reverse().toString();
        String huiwen="";
        int index=-1;
        for (int i=1;i<=s.length();i++){
            System.out.println(s.substring(0,i));
            System.out.println(revString.substring(s.length()-i));
            if (s.substring(0,i).equals(revString.substring(s.length()-i))){
                huiwen=s.substring(0,i);
                index=i;
            }
        }
        if (index>0){
            StringBuilder temp=new StringBuilder(s.substring(index));
            String addString = temp.reverse().toString();
            return addString + s;
        }
        return s;
    }
}
