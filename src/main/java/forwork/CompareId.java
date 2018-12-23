package forwork;

import org.apache.log4j.Logger;

/**
 *  class which implement interface Compare
 */
public class CompareId implements Compare {
    private static final Logger log = Logger.getLogger(CompareId.class);
    /**
     * realizes metod for comparation
     * @param p   Person with fields
     * @param value value for comparison
     * @return  0 if ==, 1 if p > value, elst -1
     */
    @Override
    public int CompareTo(Person p, Person value) {
        log.debug("compare Person1: " + p.getId() + " with Person2:" + value.getId() + " by Id");
        return ( p.getId() > value.getId() ? 1 : (p.getId() ==  value.getId() ?  0 : -1) );
    }
}
