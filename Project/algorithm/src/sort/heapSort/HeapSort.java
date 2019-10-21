package sort.heapSort;

/**
 * @author nigaknight
 * @time 2019/9/18
 **/
public class HeapSort {
    public void heapSort(int[] array){
        for (int i=(array.length-2)/2;i>=0;i--){
            heapAdjust(array,i,array.length);
        }
        for (int i=array.length-1;i>=0;i--){
            int temp=array[i];
            array[i]=array[0];
            array[0]=temp;
            heapAdjust(array,0,i);
        }
    }
    public void heapAdjust(int[] array,int parentIndex,int length){
        int childIndex=parentIndex*2+1;
        while (childIndex<length){
            if (childIndex+1<length&&array[childIndex+1]>array[childIndex]){
                childIndex=childIndex+1;
            }
            if (array[childIndex]<=array[parentIndex]){
                break;
            }
            int temp=array[childIndex];
            array[childIndex]=array[parentIndex];
            array[parentIndex]=temp;
            parentIndex=childIndex;
            childIndex=parentIndex*2+1;
        }
    }
}
