import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;


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


class HeapSort<T extends Comparable<T>>{
    private PriorityQueue<T> pq = new PriorityQueue<>();
    public HeapSort(ArrayList<T> array){
        pq.addAll(array);
    }

    public PriorityQueue<T> getPq() {
        return pq;
    }

    public ArrayList<T> getSortedArrayList(){
        ArrayList<T> array=new ArrayList<>(pq.size());
        int s=pq.size();
        for (int i=0;i<s;i++)
        {
            array.add(i,pq.poll());
        }
        return array;
    }


}

public class SortDemo {

    public static void main(String args[]) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(-2*i);
        }
        System.out.println(arrayList);

        HeapSort hs = new HeapSort(arrayList);
        System.out.println(hs.getSortedArrayList());

ArrayList<String> str= new ArrayList<>();


    }
}

