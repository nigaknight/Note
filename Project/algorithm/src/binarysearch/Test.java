package binarysearch;

/**
 * @author nigaknight
 * @time 2019/9/18
 **/
public class Test {
    public int search(int[] array,int target){
        int l=0;
        int r=array.length-1;
        while (l<r){
            int m=l+(r-l)/2;
            if (array[m]<target){
                l=m+1;
            } else {
                r=m;
            }
        }
        if (array[l]==target){
            return l;
        }
        return -1;
    }
}
