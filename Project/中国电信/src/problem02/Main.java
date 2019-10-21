package problem02;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author nigaknight
 * @time 2019/9/10
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i=0;i<n;i++){
            int num=scanner.nextInt();
            insert(num);
        }
        double res = GetMedian();
        System.out.println(res);
    }


    static TreeMap treeMap=new TreeMap<Integer,Integer>();
    public static void insert(Integer num){
        if (treeMap.containsKey(num)){
            int sum=(Integer) treeMap.get(num);
            treeMap.replace(num,sum,sum+1);
        } else {
            treeMap.put(num,1);
        }
    }

    public static Double GetMedian(){
        int size=treeMap.size();
        Map.Entry entry=treeMap.firstEntry();
        int i=(int) entry.getValue();
        int mid=(size+1)/2;
        while (i<mid){
            entry=treeMap.higherEntry(entry.getKey());
            i+=(int)entry.getValue();
        }
        if (size%2==0&&i==mid){
            return ((int)entry.getKey()*1.0+(int)treeMap.higherEntry(entry.getKey()).getKey()*1.0)/2;
        }
        return (int)entry.getKey()*1.0;
    }
}
