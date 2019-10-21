package sort.insertSort;

/**
 * @author nigaknight
 * @time 2019/9/18
 **/
public class InsertSort {
    public void insertSort(int[] array){
        for (int i=1;i<array.length;i++){
            int temp=array[i];
            int j;
            for (j=i-1;j>=0&&array[j]>temp;j--){
                array[j+1]=array[j];
            }
            array[j+1]=temp;
        }
    }
}
