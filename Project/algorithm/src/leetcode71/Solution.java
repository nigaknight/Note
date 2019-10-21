package leetcode71;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue=new LinkedList<>();
        int index1=0;
        int index2=0;
        for (int i=1;i<path.length();i++){
            String temp="";
            if (i==path.length()-1){
                temp=path.substring(index1+1);
            }
            if (path.charAt(i)=='/'){
                index2=i;
                temp=path.substring(index1+1,index2);
            }
            if (temp.equals(".")){
                index1=index2;
                continue;
            }
            if (temp.equals("..")){
                queue.pollLast();
            } else if (!temp.equals("")){
                queue.offer(temp);
            }
            index1=index2;
        }
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            sb.append("/").append(queue.poll());
        }
        String res=sb.toString();
        return res.equals("")?"/":res;
    }
}
