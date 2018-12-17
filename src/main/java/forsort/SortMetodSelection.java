package forsort;

import forwork.Compare;
import forwork.Person;

/**
 * Selection method for sort
 */
public class SortMetodSelection implements SortMetod {
    /**
     * Method use selection sort
     * @param arr   array with elem Person {@link Person}
     * @param size  size of array   {@link forwork.RepositorArray#lengthA}
     * @param comp  comparator {@link Compare}
     */
    @Override
    public void sort(Person[] arr, int size, Compare comp) {
        System.out.println(SortMetodSelection.class.getName());
        for (int i=0;i<size-1;i++){
            int minIndex=i;
            for (int j=i+1;j<size;j++){
                if (comp.CompareTo(arr[j],arr[minIndex])<0)
                    minIndex = j;
            }
            Person p = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = p;
        }
    }
}
