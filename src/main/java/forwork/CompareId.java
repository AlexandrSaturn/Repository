package forwork;

/**
 *  class which implement interface Compare
 */
public class CompareId implements Compare {
    /**
     * realizes metod for comparation
     * @param p   Person with fields
     * @param value value for comparison
     * @return  0 if ==, 1 if p > value, elst -1
     */
    @Override
    public int CompareTo(Person p, Person value) {
        return ( p.getId() > value.getId() ? 1 : (p.getId() ==  value.getId() ?  0 : -1) );
    }
}
