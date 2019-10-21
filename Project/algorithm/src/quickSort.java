/**
 * @author nigaknight
 * @time 2019/9/25
 **/
public class quickSort {
    public static void main(String[] args) {
        int[] array={3,5,8,22,55,23,98,4342,43};
        new quickSort().quicksort(array);
        for (int num:array){
            System.out.println(num);
        }
    }
    public void quicksort(int[] array){
        sort(array,0,array.length-1);
    }
    public void sort(int[] array,int l,int r){
        if (l<r){
            int m=quick(array,l,r);
            sort(array,l,m-1);
            sort(array,m+1,r);
        }
    }
    public int quick(int[] array,int l,int r){
        int k=l;
        for (int i=l+1;i<=r;i++){
            if (array[i]<array[l]){
                k++;
                swap(array,k,i);
            }
        }
        swap(array,k,l);
        return k;
    }
    public void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
