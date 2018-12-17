package forwork;

/**
 *  interface for compare
 *
 */

public interface Compare {
    /**
     * compare
     * @param p   Person with fields
     * @param value value for comparison
     * @return  0 if ==, 1 if p > value, elst -1
     */
    public int CompareTo (Person p, Person value);
        }
