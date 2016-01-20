import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;


class MergeSort<T extends Comparable<? super T>> {

    private T array[];

    public MergeSort(T[] array) {
        this.array = array;
    }

    public T[] getArr() {
        return array;
    }

    //The mergeSort method. This method calls itself recursively for left half and right half of array
    public void mergeSort(int low, int high) {
        if (low >= high) return; //if its only one element then simply return.
        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high); //merge method to merge two sorted arrays into one sorted array.

    }

    private void merge(int low, int mid, int high) {
        ArrayDeque<T> auxList = new ArrayDeque<>(); //using ArrayDeque to add elements at the end.
        int arr1ptr, arr1end, arr2ptr, arr2end;
        arr1ptr = low;
        arr1end = mid;
        arr2ptr = mid + 1;
        arr2end = high;
        while ((arr1ptr <= arr1end) && (arr2ptr <= arr2end)) { //loop till anyone of the arrays become empty.
            if (array[arr1ptr].compareTo(array[arr2ptr]) < 0) { //comparing the elements of two arrays and adding it to the aux list.
                auxList.add(array[arr1ptr++]);
            } else {
                auxList.add(array[arr2ptr++]);
            }
        }
        //adding rest of the elements left in the two arrays to the aux list.
        if (arr1ptr > arr1end) {
            for (int k = arr2ptr; k <= arr2end; k++) {
                auxList.add(array[k]);
            }
        } else {
            for (int k = arr1ptr; k <= arr1end; k++) {
                auxList.add(array[k]);
            }
        }
        //copy aux list back to the main array.
        for (int k = low; k <= high; k++) {
            array[k] = auxList.removeFirst(); //using arrayList will be expensive here as while removing the first element, rest
            //of the elements will have to be shifted together.
        }


    }

}

class HeapSort<T extends Comparable<? super T>>{

    PriorityQueue<T> priorityQueue;

    public HeapSort(ArrayList<T> arrayList) {
        priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(arrayList);
    }

    public PriorityQueue<T> getPriorityQueue() {
        return priorityQueue;
    }

    public void heapSort(){

    }
}



public class SortDemo {

    public static void main(String args[]) {
        //System.out.println("Generating Random Numbers");
        //Integer[] testArr = new Integer[1000000];
        ArrayList<Integer> arrayList = new ArrayList<>();

        //Random random = new Random();
        for (int i = 0; i < arrayList.size(); i++) {
            //testArr[i] = random.nextInt(9999);
            arrayList.add(-i);
        }
        //System.out.println("Random Numbers Generated");
        System.out.println(arrayList);

//        MergeSort<Integer> m1 = new MergeSort<>(testArr);
//        //System.out.println("Unsorted Array: "+ Arrays.toString(m1.getArr()));
//        Long starttime = System.currentTimeMillis();
//        m1.mergeSort(0, testArr.length - 1);
//        Long endtime = System.currentTimeMillis();
//        System.out.println("Total Time Taken by Merge Sort: " + (endtime - starttime) + " ms");
//        //System.out.println("Sorted Array: "+Arrays.toString(m1.getArr()));

        HeapSort<Integer> heapSort = new HeapSort<>(arrayList);
        System.out.println(heapSort.getPriorityQueue());

    }
}

