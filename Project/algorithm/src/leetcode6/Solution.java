package leetcode6;

/**
 * @author nigaknight
 * @time 2019/10/8
 **/
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        StringBuilder res=new StringBuilder();
        StringBuilder[] sb=new StringBuilder[numRows];
        for (int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder();
        }
        boolean down=true;
        int y=0;
        for (int i=0;i<s.length();i++){
            sb[y].append(s.charAt(i));
            if (down){
                y++;
                if (y==numRows){
                    down=false;
                    y=y-2;
                }
            } else {
                y--;
                if (y==-1){
                    down=true;
                    y=y+2;
                }
            }
        }
        for (int i=0;i<sb.length;i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}
