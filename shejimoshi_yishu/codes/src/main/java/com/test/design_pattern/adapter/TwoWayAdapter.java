package com.test.design_pattern.adapter;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class TwoWayAdapter {
}
interface QuickSort2{
    int[] quickSort(int[] arr);
}

class Adapter implements ScoreOperation,QuickSort2{
    private ScoreOperation scoreOperation;
    private QuickSort quickSort;

    private Adapter(ScoreOperation operation,QuickSort sort){
        this.scoreOperation= operation;
        this.quickSort=sort;
    }

    public int[] sort(int[] arr) {
        //do some stuff
        return this.quickSort.quickSort(arr);
    }

    public int search(int[] arr, int v) {
        return 0;
    }

    public int[] quickSort(int[] arr) {
        //do some stuff
        return this.scoreOperation.sort(arr);
    }
}

