package forsort;

import forwork.Compare;
import forwork.Person;
import org.apache.log4j.Logger;

/**
 * Class which implements {@link SortMetod}
 * Use ensertion method for sort
 * @author Kisa Alexandr
 * @version 0.1
 */
public class SortMetodInsertion implements SortMetod {
    private static final Logger log = Logger.getLogger(SortMetodInsertion.class);
    /**
     * Ensertion method for sort
     * @param arr   array with elem Person {@link Person}
     * @param size  size of array   {@link forwork.RepositorArray#lengthA}
     * @param comp  comparator {@link Compare}
     */
    @Override
    public void sort(Person[] arr, int size, Compare comp) {
        //System.out.println(SortMetodInsertion.class.getName());
        log.info("sort Repository with Insertion by " + comp.toString());
        for (int i=1;i<size;i++){
            for (int j=i;j>0 && (comp.CompareTo(arr[j-1],arr[j] )>0 );j--){
                Person p = arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=p;
            }
        }
    }
}
