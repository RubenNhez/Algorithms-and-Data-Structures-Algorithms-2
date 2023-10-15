

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;



class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array;
    public int heap_size;
    public int counter = 0;
    public int inplace = 0;

    public Heap(int size) {
        this.heap_size = size;
        counter++;
//        inplace++;
        this.array = new ArrayList<Integer>(size);
        System.out.println();
    }

    public Heap(List<Integer> source) {
        this(source, false);
        System.out.println();
    }
    public Heap(List<Integer> source, boolean incremental) {

        System.out.println();
        this.array = new ArrayList<Integer>(source.size());

        if(incremental){
            heap_size = 0;
            for (int i = 0; i < source.size(); i ++){
                counter++;
//                inplace++;
                this.insert(source.get(i));
            }
            heap_size = array.size();

        }else{
//            heap_size = 0;
            this.array = new ArrayList<Integer>(source.size());
//            System.out.println(source.size());
            for (int i = 0; i < source.size(); i ++){
                counter++;
                inplace++;
//                System.out.println("inserting = " + source.get(i));
                array.add(source.get(i));
                // array.add(source.get(i));
            }
            heap_size = source.size();

            buildMaxHeap();
            for(int i = 0; i < array.size(); i ++){

//                System.out.print(array.get(i) + ", ");
            }
        }
    }
    public static int parent(int index) {
        return (index-1)/2;
    }
    public static int left(int index) {
        return (2*index)+1;
    }

    public static int right(int index) {
        return (2*index)+2;
    }
    public void maxHeapify(int i) {

        int l = left(i);
        int r = right(i);
        int largest = i;
//        inplace+=2;

        counter++;
        if(l < heap_size && array.get(l) > array.get(largest)){
            largest = l;
        }

        if(r < heap_size && array.get(r) > array.get(largest)){
            largest = r;
        }

        if(largest != i){
            inplace+=2;
            int temp = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, temp);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
//        heap_size = array.size();
        int midpoint = (this.heap_size / 2) - 1;
//        System.out.println(this.heap_size);
//        inplace++;

//        System.out.println("size = " + heap_size);
//
//        System.out.println("midpoint = " + midpoint);

        for(int j = midpoint; j >= 0; j--){
            maxHeapify(j);
        }
    }

    public void insert(Integer k) {

        counter++;
//        inplace++;
        // System.out.println("k = " + k);
        array.add(k);
        int i = array.size()-1;
        int parent = parent(i);
        while(i > 0 && array.get(i) > array.get(parent)){
            // System.out.println("testing");
            this.swap(i, parent);
            i = parent;
            parent = parent(i);
        }
    }

    public Integer maximum() {

        if(array.size() == 0){
            return -1;
        }else{
            return array.get(0);
        }
    }

    public Integer extractMax() {

        Integer max = array.get(0);
        array.set(0, array.get(array.size()-1));
        heap_size = heap_size - 1;
        // System.out.println(heap_size);
        maxHeapify(0);
        return max;
    }

    public ArrayList<Integer> sort(){

        buildMaxHeap();

        for(int i = array.size()-1; i >= 0; i--){

            swap(0, i);
//            inplace++;
            heap_size = heap_size - 1;
            maxHeapify(0);

        }

        for(int i = 0; i < array.size(); i ++){
            System.out.print(array.get(i) + ", ");
        }
        return array;
    }



    public void swap(int indexA, int indexB){

        counter++;
//        inplace+=2;
        int temp = array.get(indexA);
        array.set(indexA, array.get(indexB));
        array.set(indexB, temp);

    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(11432);
        int ID = 91552;
//        int ID = 11342;
//        for (int i = 0; i < ID ; i++) {
//            heap.insert(i);
//
//        }
//        System.out.println(heap.counter);
        for (int i = 0; i < ID; i++) {
            arrayList.add(i);
//            hap.buildMaxHeap();
//            heap.heap_size++;
//            heap.inplace++;
        }

        Heap heap = new Heap(arrayList, false);
        System.out.println(heap.inplace);
//        heap.inplace++;
//        System.out.println(heap.inplace);
    }

}

