package 网易雷火;

import java.util.*;

/**
 * @author nigaknight
 * @time 2019/9/15
 * 长方形n*m
 * 起点坐标 x_start y_start 终点坐标 x_end y_end
 * 障碍坐标dp[][]
 * dp[i][j]=dp[i-1][j]+dp[i][j-1]
 *
 * 参数：起点、终点、障碍、结果字符串
 **/
public class Main {
    static List<String> res=new ArrayList<>();
    public static void main(String[] args) {
        int n=3;
        int m=3;
        int x_start=0;
        int y_start=0;
        int x_end=3;
        int y_end=3;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,0);
        map.put(1,1);
        map.put(2,2);
        backtrace(x_start,y_start,x_end,y_end,map,new StringBuilder());
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }
    public static void backtrace(int x_start,int y_start,int x_end,int y_end,Map<Integer,Integer> map,StringBuilder sb){
        sb.append("("+x_start+","+y_start+")");
        if (x_start>x_end||y_start>y_end){
            return;
        }
        if (x_start==x_end&&y_start==y_end){
            res.add(sb.toString());
            return;
        }
        if (!map.containsKey(x_start+1)||(map.containsKey(x_start+1)&&map.get(x_start+1)!=y_start)){
            backtrace(x_start+1,y_start,x_end,y_end,map,sb);
            sb.delete(sb.length()-5,sb.length());
        }
        if (!map.containsKey(x_start)||(map.containsKey(x_start)&&map.get(x_start)!=y_start+1)){
            backtrace(x_start,y_start+1,x_end,y_end,map,sb);
            sb.delete(sb.length()-5,sb.length());
        }
    }
}
