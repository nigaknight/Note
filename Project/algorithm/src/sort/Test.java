package sort;

import sort.quickSort.QuickSort;

/**
 * @author nigaknight
 * @time 2019/9/18
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums={1,5,8,32,456,33,12,22};
/*        new BubbleSort().bubbleSort(nums);*/
/*        new InsertSort().insertSort(nums);*/
/*        new SelectSort().selectSort(nums);*/
/*        new MergeSort().mergeSort(nums);*/
        new QuickSort().quickSort(nums);
/*        new HeapSort().heapSort(nums);*/
        for (int num:nums){
            System.out.println(num);
        }
    }
}
