package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Collections;

public class HeapSort <T extends Comparable<T>> implements ISort<T> {
    private Object temp;
    private ArrayList heapsort;
    private Comparable k;



   /*private void heapify(ArrayList<T> arr,int size,  int i)
    {
        int largest = i; // Initialize largest as root
        int l = (2*i) ; // left = 2*i
        int r = (2*i + 1); // right = 2*i +1

        if (l < arr.size() && arr.get(l).compareTo(arr.get(largest))>0) {
            largest = l;
        }
        if (r < arr.size()&& arr.get(r) .compareTo(arr.get(largest))>0) {
            largest = r;
        }
        if (largest != i)
        {
            Collections.swap(arr,i,largest);

            heapify(arr,arr.size(), largest);
        }
    }*/
    @Override
    public IHeap<T> heapSort(ArrayList<T> unordered) {
        if(unordered==null||unordered.size()==0) {
            IHeap<T> N=new Heap<T>();
            return N;
        }
         Heap<T> h=new Heap();
         h.build(unordered);
        int limit =unordered.size()-1 ;
        while (h.size()>0){
            unordered.set(limit,h.extract());
            limit--;

        }
     h.setLastPosititon(unordered.size());
        return h;
    }
    @Override
    public void sortSlow(ArrayList<T> unordered) {
        //Bubble sort...
        if(unordered==null) {
            return;
        }
        for(int i = 0;i<unordered.size()-1;i++){
            for(int j = i+1;j<unordered.size();j++){
                if((unordered.get(i).compareTo(unordered.get(j)))>=1){
                    Collections.swap(unordered, i, j);
                }
            }
        }
    }
    @Override
    public void sortFast(ArrayList<T> unordered) {
        if(unordered==null) {
            return;
        }
        doMergeSort( unordered);

    }
    private void doMergeSort(ArrayList<T> numbers){
        int middle;
        ArrayList<T> left = new ArrayList<>();
        ArrayList<T> right = new ArrayList<>();

        if (numbers.size() > 1) {
            middle = numbers.size() / 2;
            // copy the left half of numbers into left.
            for (int i = 0; i < middle; i++)
                left.add(numbers.get(i));

            //copy the right half of numbers into right.
            for (int j = middle; j < numbers.size(); j++)
                right.add(numbers.get(j));

            doMergeSort(left);
            doMergeSort(right);

            merge(numbers, left, right);
        }
    }

    private  void merge(ArrayList<T> numbers, ArrayList<T> left, ArrayList<T> right){
        //set up a temporary arraylist to build the merge list
        ArrayList<T> temp = new ArrayList<>();

        //set up index values for merging the two lists
        int numbersIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) .compareTo(right.get(rightIndex) )<0) {
                numbers.set(numbersIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                numbers.set(numbersIndex, right.get(rightIndex));
                rightIndex++;
            }
            numbersIndex++;
        }

        int tempIndex = 0;
        if (leftIndex >= left.size()) {
            temp =  right;
            tempIndex = rightIndex;
        }
        else {
            temp = left;
            tempIndex = leftIndex;
        }

        for (int i = tempIndex; i < temp.size(); i++) {
            numbers.set(numbersIndex, temp.get(i));
            numbersIndex++;
        }
    }
}
