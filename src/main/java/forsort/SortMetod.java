package forsort;

import forwork.Compare;
import forwork.Person;

/**
 * Interface for sort {@link forwork.RepositorArray}
 * @author Kisa Alexandr
 * @version 1.0
 */
public interface SortMetod {
    /**
     * Method for sort array {@link forwork.RepositorArray}
     * @param arr   array with elem Person {@link Person}
     * @param size  size of array   {@link forwork.RepositorArray#lengthA}
     * @param comp  comparator {@link Compare}
     */
    public void sort(Person[] arr, int size, Compare comp);
}
