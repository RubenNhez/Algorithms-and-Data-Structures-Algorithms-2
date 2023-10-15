import org.xml.sax.helpers.ParserAdapter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array;
    public int heap_size;

    public Heap(int size) {
        for (int i = 0; i < size; i++) {
            array.add(0);
            heap_size++;
        }
    }

    public Heap(List<Integer> source) {
        this(source, false);
        System.out.println();

    }


    public Heap(List<Integer> source, boolean incremental) {

        this.array = new ArrayList<Integer>(source.size());


        if(incremental) {
            heap_size = 0;
            for (Integer integer : source) {
                insert(integer);
            }
            heap_size = array.size();
        }
        else {

            heap_size = 0;
            this.array = new ArrayList<>(source.size());
            array.addAll(source);
            buildMaxHeap();
            heap_size = array.size();
        }
    }

    public static int parent(int index) {

        return (index-1) / 2;
    }
    public static int left(int index) {
        return  (2*index + 1);
    }
    public static int right(int index) {
        return  (2*index + 2);
    }
    
    public void maxHeapify(int root) {
        int left = left(root);
        int right = right(root);
        int largest = root;

        if(left < heap_size && array.get(left) > array.get(largest)){
            largest = left;
        }

        if(right < heap_size && array.get(right) > array.get(largest)) {
            largest = right;
        }

        if(largest != root) {
            int temporary = array.get(root);

            array.set(root,array.get(largest));

            array.set(largest,temporary);

            maxHeapify(largest);

        }
    }
    public void buildMaxHeap() {
        int middle = (heap_size/2) - 1;
        for (int i = middle; i == 0 ; i--) {
            maxHeapify(i);
        }
    }
    public void insert(Integer k) {
        int pos = heap_size;
        array.add(pos,k);
        heap_size++;
        while(pos > 0 && array.get(parent(pos)) < array.get(pos)) {
            swap(array.get(parent(pos)),array.get(pos));
            pos = array.get(parent(pos));
        }

    }
    public Integer maximum() {
        if(array.size() == 0) {
            return -1;
        }else {
            return array.get(0);
        }

    }
    public Integer extractMax() {
        int extract = array.get(0);
        array.set(0, array.get(array.size() - 1));
        heap_size = heap_size-1;
        maxHeapify(0);
        return extract;
    }

    public void swap(int a, int b){

        int temp = a;
        a = b;
        b = temp;

    }


}
