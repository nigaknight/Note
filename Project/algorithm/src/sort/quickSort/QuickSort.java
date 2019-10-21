package sort.quickSort;

/**
 * @author nigaknight
 * @time 2019/9/18
 **/
public class QuickSort {
    public void quickSort(int[] array){
        quick_Sort(array,0,array.length-1);
    }
    private void quick_Sort(int[] array,int l,int r){
        if (l<r){
            int m=quick(array,l,r);
            quick_Sort(array,l,m-1);
            quick_Sort(array,m+1,r);
        }
    }
    private int quick(int[] array,int l,int r){
        int p=array[l];
        int k=l;
        for (int i=l+1;i<=r;i++){
            if (array[i]<p){
                k++;
                swap(array,k,i);
            }
        }
        swap(array,l,k);
        return k;
    }
    private void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
