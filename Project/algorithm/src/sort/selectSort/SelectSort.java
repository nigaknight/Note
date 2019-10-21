package sort.selectSort;

/**
 * @author nigaknight
 * @time 2019/9/18
 **/
public class SelectSort {
    public void selectSort(int[] array){
        for (int i=0;i<array.length;i++){
            int min=i;
            for (int j=i+1;j<array.length;j++){
                if (array[j]<array[min]){
                    min=j;
                }
            }
            int temp=array[i];
            array[i]=array[min];
            array[min]=temp;
        }
    }
}
