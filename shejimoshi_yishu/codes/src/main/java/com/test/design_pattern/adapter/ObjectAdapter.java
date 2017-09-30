package com.test.design_pattern.adapter;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class ObjectAdapter {
}

interface ScoreOperation{
    int[] sort(int[] arr);//排序
    int search(int[] arr, int v);//查找
}

class QuickSort{
    public int[] quickSort(int[] arr){
        System.out.println("快速排序算法排序");
        return null;
    }
}

class BinnarySearch{
    public int binSearch(int[] arr,int v){
        System.out.println("二分查找");
        return 0;
    }
}

class OperationAdapter implements ScoreOperation{
    private QuickSort sort;
    private BinnarySearch search;
    public OperationAdapter(){
        this.sort=new QuickSort();
        this.search=new BinnarySearch();
    }
    public int[] sort(int[] arr) {
        return this.sort.quickSort(arr);
    }

    public int search(int[] arr, int v) {
        return this.search.binSearch(arr,v);
    }
}

class Client{
    public static void main(String[] args) {
        int[] arr={1,2,3};
        OperationAdapter adapter=new OperationAdapter();
        adapter.sort(arr);
        adapter.search(arr,2);

    }
}
