package forsort;

import forwork.Compare;
import forwork.Person;

/**
 * Class which implements {@link SortMetod}
 * Use bubble method for sort
 * @author Kisa Alexandr
 * @version 0.1
 */

public class SortMetodBubble implements SortMetod {

    /**
     * Eeeeeee, booooy bubble method for sort
     * @param arr   array with elem Person {@link Person}
     * @param size  size of array   {@link forwork.RepositorArray#lengthA}
     * @param comp  comparator {@link Compare}
     */
    @Override
    public void sort(Person[] arr, int size, Compare comp) {

        System.out.println('\n'+SortMetodBubble.class.getName()+'\n');

        for (int i=0; i<size-1;i++){
            for (int j=i+1;j<size;j++)
                if (comp.CompareTo(arr[i],arr[j]) > 0 ){
                    Person p = arr[i];
                    arr[i] = arr[j];
                    arr[j] = p;
                }
        }
    }
}
