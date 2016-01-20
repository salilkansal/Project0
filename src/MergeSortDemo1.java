//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Random;
//
//
//class MergeSort<T extends Comparable<T>> {
//    private T arr[];
//
//    public MergeSort(T[] arr) {
//        this.arr = arr;
//    }
//
//    public T[] getArr() {
//        return arr;
//    }
//
//    void mergesort(int first, int last) {
//        if (first < last) {
//            int middle = (first + last) / 2;
//            //System.out.println("middle = " + middle);
//            mergesort(first, middle);
//            mergesort(middle + 1, last);
//            //System.out.println("Calling Merge");
//            merge(first, middle, last);
//        }
//    }
//
//    private void merge(int first, int middle, int last) {
//        ArrayList<T> list = new ArrayList<>();
//       // int aux[] = new int[arr.length];
//        int leftpos, leftend, rightpos, rightend, auxpos, auxend;
//        leftpos = first;
//        leftend = middle;
//        rightpos = middle + 1;
//        rightend = last;
//        //auxpos = first;
////        System.out.println("leftpos = " + leftpos);
////        System.out.println("leftend = " + leftend);
////        System.out.println("rightpos = " + rightpos);
////        System.out.println("rightend = " + rightend);
//        //System.out.println("auxpos = " + auxpos);
//        while ((leftpos <= leftend) && (rightpos <= rightend)) {
//            if (arr[leftpos].compareTo(arr[rightpos])<0){    //arr[leftpos] <= arr[rightpos]) {
//                list.add(arr[leftpos]);
//                //aux[auxpos] = arr[leftpos];
//                leftpos++;
//            } else {
//                list.add(arr[rightpos]);
//                //aux[auxpos] = arr[rightpos];
//                rightpos++;
//            }
//        }
//        if (leftpos > leftend) {
//            for (int k = rightpos; k <= rightend; k++) {
//                list.add(arr[k]);
//                //aux[auxpos] = arr[k];
//            }
//        } else {
//            for (int k = leftpos; k <= leftend; k++) {
//                list.add(arr[k]);
//               // aux[auxpos] = arr[k];
//               // auxpos++;
//            }
//        }
//        //System.out.println(list);
//       // System.out.println(Arrays.toString(aux));
//        //System.out.println("Main Array");
//        //System.out.println(Arrays.toString(arr));
//        for (int k = first; k <= last; k++) {
//            arr[k] = list.remove(0);
//        }
//
//
//    }
//}
//
//
//public class MergeSortDemo1 {
//    public static void main(String args[]) {
//        Integer a[] = {2, 6, 1, 10, 12, 20, 34, 25};
//        MergeSort<Integer> m1 = new MergeSort<>(a);
//        System.out.println("unsorted array" + Arrays.toString(a));
//        m1.mergesort(0, a.length-1);
//        System.out.println("sorted array" + Arrays.toString(m1.getArr()));
//
//        String s[]={"C","W","A","D","Z","B"};
//        MergeSort<String> m2= new MergeSort<>(s);
//        System.out.println("unsorted string" + Arrays.toString(s));
//        m2.mergesort(0, s.length-1);
//        System.out.println("sorted string" + Arrays.toString(m2.getArr()));
//
//
//
//
//    }
//}
//
