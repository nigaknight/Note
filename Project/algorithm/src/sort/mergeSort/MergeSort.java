package sort.mergeSort;

/**
 * @author nigaknight
 * @time 2019/9/18
 **/
public class MergeSort {
    public void mergeSort(int[] array){
        sort(array,0,array.length-1);
    }
    public void sort(int[] array,int l,int r){
        if (l<r){
            int m=l+(r-l)/2;
            sort(array,l,m);
            sort(array,m+1,r);
            merge(array,l,m,r);
        }
    }
    public void merge(int[] array,int l,int m,int r){
        int k1=l;
        int k2=m+1;
        int[] temp_array=new int[r-l+1];
        int i=0;
        while (k1<=m&&k2<=r){
            temp_array[i++]=array[k1]<array[k2]?array[k1++]:array[k2++];
        }
        while (k1<=m){
            temp_array[i++]=array[k1++];
        }
        while (k2<=r){
            temp_array[i++]=array[k2++];
        }
        for (int j=0;j<temp_array.length;j++){
            array[l++]=temp_array[j];
        }
    }
}
